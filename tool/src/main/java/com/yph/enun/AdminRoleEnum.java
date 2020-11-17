package com.yph.enun;

/**
 * @author LC
 */
public enum AdminRoleEnum {

    ADMIN_ROLE_REDIS("role")
    ;

    private String cont;


      AdminRoleEnum(String cont){
          this.cont = cont;
    }


    public String getCont() {
        return cont;
    }

    public void setCont(String cont) {
        this.cont = cont;
    }
}
