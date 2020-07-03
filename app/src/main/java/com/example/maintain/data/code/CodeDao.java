package com.example.maintain.data.code;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface CodeDao  {
    @Insert
    void saveCode(Code...codes);

    //列表插入
    @Insert  //(onConflict = OnConflictStrategy.REPLACE)
     void saveAllCodes(List<Code> codeList);

    @Update
    void updateCode(Code...codes);

    @Delete
    void deleteCode(Code ...codes);
    @Query("DELETE FROM t_code")
    public void deleteAll();

    //查询所有，按名排序
    @Query("SELECT * FROM t_code  WHERE code_name LIKE '0%' ORDER BY code_name ")
   public LiveData<List<Code>> loadAllCode();

    @Query("SELECT * FROM t_code WHERE code_name  LIKE   :search ")
    public LiveData<List<Code>> findCodeWithName(String search);

    /**
     * 根据 型号、和关键字搜索
     * @param type
     * @param search
     * @return
     */
   @Query("SELECT * FROM t_code WHERE device_type = :type AND code_name LIKE :search ")
   public List<Code> findCodeWithNameAndType(String type,String search);
}
