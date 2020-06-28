package com.example.maintain.data.code;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface CodeDao  {
    @Insert
    void saveCode(Code...codes);

    @Update
    void updateCode(Code...codes);

    @Delete
    void deleteCode(Code ...codes);

    @Query("SELECT * FROM code")
    List<Code> loadAllCode();

    @Query("SELECT * FROM code WHERE code_name LIKE :search")
    List<Code> findCodeWithName(String search);

   @Query("SELECT * FROM code WHERE device_type = :type AND code_name LIKE :search")
   List<Code> findCodeWithNameAndType(String type,String search);
}
