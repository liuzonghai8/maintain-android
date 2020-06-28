package com.example.maintain.data.code;

import java.util.List;

public class CodeRepository {


    private static CodeDao dao;
    private static  CodeRepository codeRepository=null;

    private CodeRepository(CodeDao dao) {
        this.dao = dao;
    }

    public static synchronized CodeRepository getCodeRepository(){
      if (codeRepository==null) {
          codeRepository = new CodeRepository(dao);
      }
        return codeRepository;
    }
    


    public void addCode(Code...codes){
        dao.saveCode(codes);
    }

    public void editCode(Code ...codes){
        dao.updateCode(codes);
    }

    public void delCode(Code ...codes){
        dao.deleteCode(codes);
    }

    public List<Code> getAllCode(){
        return dao.loadAllCode();
    }

    public List<Code> findCodeWithName(String search){
        return dao.findCodeWithName(search);
    }

}
