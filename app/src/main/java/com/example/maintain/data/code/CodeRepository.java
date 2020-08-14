package com.example.maintain.data.code;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;

import androidx.lifecycle.LiveData;

import com.example.maintain.data.AppDatabase;

import java.util.List;

public class CodeRepository {
    private static CodeDao codeDao;
    private static  CodeRepository codeRepository=null;
    private LiveData<List<Code>> allCodes;
    //查询的数据
    private LiveData<List<Code>> searchCodes;

    //构造函数
    private CodeRepository(Context context) {
        AppDatabase database= AppDatabase.getDatabase(context.getApplicationContext());
        codeDao=database.getCodeDao();
        allCodes=codeDao.findCodeWithName("0%");//codeDao.loadAllCode();
       // searchCodes=codeDao.findCodeWithNameAndType("","0000");
    }

    //单例模式
    public static synchronized CodeRepository getCodeRepository(Context context){
      if (codeRepository==null) {
          codeRepository = new CodeRepository(context);
      }
        return codeRepository;
    }

    //获取全部
    public LiveData<List<Code>> getAllCodes() {
        return allCodes;
    }

    //根据关键字查询
    public List<Code> getSearchCodes(String type, String search){
        if (TextUtils.isEmpty(search)){
            return null;
        }
       try {
           List<Code> codes = new QueryAsyncTask(codeDao).execute(type, search + "%").get();
           Log.d("TAG_LOG","---getSearchCodes   --获取的数据--"+codes);
           return codes;
       }catch (Exception e){
           e.printStackTrace();
           return null;
       }

    }


    //添加
    public void addCode(Code...codes){
        new InsertAsyncTask(codeDao).execute(codes);
    }

    //删除
   public void deleteAllCode(){
        new DeleteAllAsyncTask(codeDao).execute();
    }

//    //查询线程
    static class QueryAsyncTask extends AsyncTask<String,Void,List<Code>> {
        private  CodeDao codeDao;
        public QueryAsyncTask(CodeDao codeDao) {
            this.codeDao = codeDao;
        }
        @Override
        protected List<Code> doInBackground(String... strings) {
            Log.d("TAG_LOG","===doInBackground======type:==="+strings[0]+"+++search+++"+strings[1]);
            return codeDao.findCodeWithNameAndType(Integer.valueOf(strings[0]),strings[1]);
        }
    }

    //添加线程
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
    //删除线程
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

}
