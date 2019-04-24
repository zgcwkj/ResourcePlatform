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
 * @since 2019-01-04
 */
public class Sroledetail extends Model<Sroledetail> {

    private static final long serialVersionUID = 1L;

    /**
     * 角色明细ID
     */
	@TableId(value="roledetailid", type= IdType.AUTO)
	private Integer roledetailid;
    /**
     * 角色ID
     */
	private Integer roleid;
    /**
     * 菜单ID
     */
	private Integer menuid;
    /**
     * 行为
     */
	private String behavior;


	public Integer getRoledetailid() {
		return roledetailid;
	}

	public void setRoledetailid(Integer roledetailid) {
		this.roledetailid = roledetailid;
	}

	public Integer getRoleid() {
		return roleid;
	}

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	public Integer getMenuid() {
		return menuid;
	}

	public void setMenuid(Integer menuid) {
		this.menuid = menuid;
	}

	public String getBehavior() {
		return behavior;
	}

	public void setBehavior(String behavior) {
		this.behavior = behavior;
	}

	@Override
	protected Serializable pkVal() {
		return this.roledetailid;
	}

}
