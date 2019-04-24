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
public class Smenu extends Model<Smenu> {

    private static final long serialVersionUID = 1L;

    /**
     * 菜单ID
     */
	@TableId(value="menuid", type= IdType.AUTO)
	private Integer menuid;
    /**
     * 父ID
     */
	private Integer parentid;
    /**
     * 菜单名称
     */
	private String menuname;
    /**
     * 图标Url
     */
	private String icon;
    /**
     * 链接Url
     */
	private String url;
    /**
     * 排序
     */
	private String sort;
    /**
     * 行为
     */
	private String behavior;


	public Integer getMenuid() {
		return menuid;
	}

	public void setMenuid(Integer menuid) {
		this.menuid = menuid;
	}

	public Integer getParentid() {
		return parentid;
	}

	public void setParentid(Integer parentid) {
		this.parentid = parentid;
	}

	public String getMenuname() {
		return menuname;
	}

	public void setMenuname(String menuname) {
		this.menuname = menuname;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getBehavior() {
		return behavior;
	}

	public void setBehavior(String behavior) {
		this.behavior = behavior;
	}

	@Override
	protected Serializable pkVal() {
		return this.menuid;
	}

}
