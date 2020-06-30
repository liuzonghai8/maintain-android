package com.example.maintain.data.code;

import java.util.List;

public class CodeRepository {


    private static CodeDao dao;

    private static  CodeRepository codeRepository=null;

    //构造函数
    private CodeRepository(CodeDao dao) {
        this.dao = dao;
    }
   //单例模式
    public static synchronized CodeRepository getCodeRepository(){
      if (codeRepository==null) {
          codeRepository = new CodeRepository(dao);
      }
        return codeRepository;
    }


    //获取全部
    public List<Code> getAllCode(){
        return dao.loadAllCode();
    }

    public List<Code> getCodeWithName(String search){
        return dao.findCodeWithName(search);
    }

    //模糊查询
    public List<Code> getCodeWithNameAndType(String type,String search){
        //TODO 应该是分页
        return dao.findCodeWithNameAndType(type,search);
    }

    public void addCode(Code...codes){
        dao.saveCode(codes);
    }






}
