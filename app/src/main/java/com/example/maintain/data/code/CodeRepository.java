package com.example.maintain.data.code;

import android.content.Context;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.maintain.data.AppDatabase;

import java.util.List;

public class CodeRepository {
    private static CodeDao codeDao;
    private static  CodeRepository codeRepository=null;
    private LiveData<List<Code>> allCodes;

    //构造函数
    private CodeRepository(Context context) {
        AppDatabase database= AppDatabase.getDatabase(context.getApplicationContext());
        codeDao=database.getCodeDao();
        allCodes=codeDao.loadAllCode();
    }

    //单例模式
    public static synchronized CodeRepository getCodeRepository(Context context){
      if (codeRepository==null) {
          codeRepository = new CodeRepository(context);
      }
        return codeRepository;
    }

    public LiveData<List<Code>> getAllCodes() {
        return allCodes;
    }

    //添加
    public void addCode(Code...codes){
        new InsertAsyncTask(codeDao).execute(codes);
    }

    //删除
   public void deleteAllCode(){
        new DeleteAllAsyncTask(codeDao).execute();
    }


    //添加
    static class InsertAsyncTask extends AsyncTask<Code,Void,Void> {
        private  CodeDao codeDao;

        public InsertAsyncTask(CodeDao codeDao) {
            this.codeDao = codeDao;
        }

        @Override
        protected Void doInBackground(Code... codes) {
            codeDao.saveCode(codes);
            return null;
        }
    }
    //删除
    static class DeleteAllAsyncTask extends AsyncTask<Void,Void,Void>{
        private  CodeDao codeDao;
        public DeleteAllAsyncTask(CodeDao codeDao) {
            this.codeDao = codeDao;
        }
        @Override
        protected Void doInBackground(Void... voids) {
            codeDao.deleteAll();
            return null;
        }
    }



















//    //获取全部
//    public LiveData<List<Code> >getAllCode(){
//        return dao.loadAllCode();
//    }
//
//    public List<Code> getCodeWithName(String search){
//        return dao.findCodeWithName(search);
//    }
//
//    //模糊查询
//    public List<Code> getCodeWithNameAndType(String type,String search){
//        //TODO 应该是分页
//        return dao.findCodeWithNameAndType(type,search);
//    }
//
//    public void addCode(Code...codes){
//        dao.saveCode(codes);
//    }






}
