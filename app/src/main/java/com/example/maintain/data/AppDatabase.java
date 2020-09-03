package com.example.maintain.data;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;

import com.example.maintain.data.code.Code;
import com.example.maintain.data.code.CodeDao;
import com.example.maintain.data.problem.Problem;
import com.example.maintain.data.problem.ProblemDao;
import com.example.maintain.works.SeedDatabaseWorker;


@Database(entities = {Code.class, Problem.class}, version = 3 ,exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
     public abstract CodeDao getCodeDao();
     public abstract ProblemDao getProblemDao();
     private static AppDatabase INSTANCE;

     public static synchronized AppDatabase getDatabase(final Context context){
          if (INSTANCE==null){
               INSTANCE= Room.databaseBuilder(context.getApplicationContext(),AppDatabase.class,"maintain_database")
                      .allowMainThreadQueries() //主线程
                        //.fallbackToDestructiveMigration()//删除原来的，覆盖
                       //预加载数据
                       .addCallback(new Callback() {
                            @Override //在第一次创建数据库时将调用
                            public void onCreate(@NonNull SupportSQLiteDatabase db) {
                                 super.onCreate(db);
//                                配置运行任务的方式和时间 只运行一次
                                //SeedDatabaseWorker 将json数据 写入数据库中
                                OneTimeWorkRequest request = new OneTimeWorkRequest.Builder(SeedDatabaseWorker.class).build();
//                                将任务提交给系统
                                 WorkManager.getInstance(context).enqueue(request);
                            }
                       })

                       //.createFromAsset("database/code.json")
                      // .fallbackToDestructiveMigration()//删除原来的，覆盖
                       .build();
               Log.d("TAG_LOG","====database create=instance null=====");
          }
          Log.d("TAG_LOG","====database create======");
          return INSTANCE;
     }


}
