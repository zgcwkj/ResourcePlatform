package com.zgcwkj.entity;

import com.baomidou.mybatisplus.enums.IdType;
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
public class Srole extends Model<Srole> {

    private static final long serialVersionUID = 1L;

    /**
     * 角色ID
     */
	@TableId(value="roleid", type= IdType.AUTO)
	private Integer roleid;
    /**
     * 角色名称
     */
	private String rolename;


	public Integer getRoleid() {
		return roleid;
	}

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	@Override
	protected Serializable pkVal() {
		return this.roleid;
	}

}
