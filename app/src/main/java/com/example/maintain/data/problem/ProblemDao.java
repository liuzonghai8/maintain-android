package com.example.maintain.data.problem;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;


import java.util.List;

@Dao
public interface ProblemDao {
    @Insert
   void saveProblem(Problem...problems);
    //列表插入
    @Insert  //(onConflict = OnConflictStrategy.REPLACE)
    void saveAllProblems(List<Problem> problemList);

    @Update
    void updateProblem(Problem...problems);

    @Delete
    void deleteProblem(Problem...problems);
    @Query("DELETE FROM t_problem")
    public void deleteAll();

    //查询所有，按名排序
    @Query("SELECT * FROM t_problem  WHERE problem_name LIKE '0%' ORDER BY id ")
    public LiveData<List<Problem>> loadAllProblem();

    /**
     * 根据关键字查询
     * @param search
     * @return
     */
    @Query("SELECT * FROM t_problem WHERE problem_name  LIKE   :search ")
    public LiveData<List<Problem>> findProblemWithName(String search);


}
