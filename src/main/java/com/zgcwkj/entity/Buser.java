package com.zgcwkj.entity;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author zgcwkj
 * @since 2019-01-02
 */
public class Buser extends Model<Buser> {

    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
	@TableId(value="userid", type= IdType.AUTO)
	private Integer userid;
    /**
     * 角色ID
     */
	private String roleid;
    /**
     * 用户账号
     */
	private String accounts;
    /**
     * 用户密码
     */
	private String password;
    /**
     * 用户名称
     */
	private String name;
    /**
     * 用户邮箱
     */
	private String mail;
    /**
     * 用户手机号
     */
	private String phone;
    /**
     * 用户地址
     */
	private String address;
    /**
     * 用户注册时间
     */
	private Date registrartime;


	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getRoleid() {
		return roleid;
	}

	public void setRoleid(String roleid) {
		this.roleid = roleid;
	}

	public String getAccounts() {
		return accounts;
	}

	public void setAccounts(String accounts) {
		this.accounts = accounts;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getRegistrartime() {
		return registrartime;
	}

	public void setRegistrartime(Date registrartime) {
		this.registrartime = registrartime;
	}

	@Override
	protected Serializable pkVal() {
		return this.userid;
	}

}
