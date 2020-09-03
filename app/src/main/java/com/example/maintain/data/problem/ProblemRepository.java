package com.example.maintain.data.problem;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;

import androidx.lifecycle.LiveData;

import com.example.maintain.data.AppDatabase;

import java.util.List;

public class ProblemRepository {
    private static ProblemDao problemDao;
    private static ProblemRepository problemRepository = null;
    private LiveData<List<Problem>> allProblems;
    //查询的数据
    private LiveData<List<Problem>> searchProblems;

    //构造函数
    private ProblemRepository(Context context) {
        AppDatabase database = AppDatabase.getDatabase(context.getApplicationContext());
        problemDao = database.getProblemDao();
        allProblems = problemDao.loadAllProblem();
    }

    //单例模式
    public static synchronized ProblemRepository getProblemRepository(Context context) {
        if (problemRepository == null) {
            problemRepository = new ProblemRepository(context);
        }
        return problemRepository;
    }

    //获取全部
    public LiveData<List<Problem>> getAllProblems() {
        return allProblems;
    }

    //根据关键字查询
    public List<Problem> getSearchProblem(String search) {
        if (TextUtils.isEmpty(search)) {
            return null;
        }
        try {
            List<Problem> problems = new QueryAsyncTask(problemDao).execute("%"+search + "%").get();
            Log.d("TAG_LOG", "---   --获取的数据--" + problems);
            return problems;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //添加
    public void addProblem(Problem... problems) {
        new InsertAsyncTask(problemDao).execute(problems);
    }

    //删除
    public void deleteAllProblem() {
        new DeleteAllAsyncTask(problemDao).execute();
    }

    //    //查询线程
    static class QueryAsyncTask extends AsyncTask<String, Void, List<Problem>> {
        private ProblemDao problemDao;

        public QueryAsyncTask(ProblemDao problemDao) {
            this.problemDao = problemDao;
        }

        @Override
        protected List<Problem> doInBackground(String... strings) {
            Log.d("TAG_LOG","====传入参数：===="+strings+"  0=="+strings[0]);
            return problemDao.findProblemWithName(strings[0]);
        }
    }


    //添加线程
    static class InsertAsyncTask extends AsyncTask<Problem, Void, Void> {
        private ProblemDao problemDao;

        public InsertAsyncTask(ProblemDao problemDao) {
            this.problemDao = problemDao;
        }

        @Override
        protected Void doInBackground(Problem... problems) {
            problemDao.saveProblem(problems);
            return null;
        }
    }

    //删除线程
    static class DeleteAllAsyncTask extends AsyncTask<Void, Void, Void> {
        private ProblemDao problemDao;

        public DeleteAllAsyncTask(ProblemDao problemDao) {
            this.problemDao = problemDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            problemDao.deleteAll();
            return null;
        }
    }

}
