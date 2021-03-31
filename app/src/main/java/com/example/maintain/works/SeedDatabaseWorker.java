package com.example.maintain.works;


import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import com.example.maintain.data.AppDatabase;
import com.example.maintain.data.code.Code;
import com.example.maintain.data.problem.Problem;
import com.example.maintain.utils.ConvertUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SeedDatabaseWorker extends Worker {

    public SeedDatabaseWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @Override
    public Result doWork() {
        //1、读取json文件
        //Code.json 文件
      String codeJson=  ConvertUtil.JsonConvertToString(getApplicationContext(),"code.json");
      //problem.json 文件
        String problemJson=  ConvertUtil.JsonConvertToString(getApplicationContext(),"problem.json");


        // 2、将json文件转换成类
        List<Code> codes = new Gson().fromJson(codeJson, new TypeToken<List<Code>>(){}.getType());
        List<Problem> problems= new Gson().fromJson(problemJson,new TypeToken<List<Problem>>(){}.getType());
        Log.d("TAG_LOG","===problems:===="+problems.toString());

        //3、插入到数据库中
        AppDatabase database = AppDatabase.getDatabase(getApplicationContext());
        database.getCodeDao().saveAllCodes(codes);
        database.getProblemDao().saveAllProblems(problems);
        Log.d("TAG_LOG", "====SeedDatabaseWorker====success====");

        return Result.success();
    }
}
