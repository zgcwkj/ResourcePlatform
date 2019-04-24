package com.zgcwkj.entitys;

public class SuserInSrole {

    /**
     * 用户ID
     */
    private Integer userid;

    /**
     * 用户账号
     */
    private String accounts;

    /**
     * 用户名称
     */
    private String name;

    /**
     * 角色ID
     */
    private String roleid;

    /**
     * 角色名称
     */
    private String rolename;

    /**
     * @return the userid
     */
    public Integer getUserid() {
        return userid;
    }

    /**
     * @return the rolename
     */
    public String getRolename() {
        return rolename;
    }

    /**
     * @param rolename the rolename to set
     */
    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    /**
     * @return the roleid
     */
    public String getRoleid() {
        return roleid;
    }

    /**
     * @param roleid the roleid to set
     */
    public void setRoleid(String roleid) {
        this.roleid = roleid;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the accounts
     */
    public String getAccounts() {
        return accounts;
    }

    /**
     * @param accounts the accounts to set
     */
    public void setAccounts(String accounts) {
        this.accounts = accounts;
    }

    /**
     * @param userid the userid to set
     */
    public void setUserid(Integer userid) {
        this.userid = userid;
    }
}