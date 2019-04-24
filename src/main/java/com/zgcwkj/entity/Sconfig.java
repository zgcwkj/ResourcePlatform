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
public class Sconfig extends Model<Sconfig> {

    private static final long serialVersionUID = 1L;

    /**
     * 配置ID
     */
	@TableId(value="configid", type= IdType.AUTO)
	private Integer configid;
    /**
     * 配置名称
     */
	private String configname;
    /**
     * 配置信息
     */
	private String configinfo;


	public Integer getConfigid() {
		return configid;
	}

	public void setConfigid(Integer configid) {
		this.configid = configid;
	}

	public String getConfigname() {
		return configname;
	}

	public void setConfigname(String configname) {
		this.configname = configname;
	}

	public String getConfiginfo() {
		return configinfo;
	}

	public void setConfiginfo(String configinfo) {
		this.configinfo = configinfo;
	}

	@Override
	protected Serializable pkVal() {
		return this.configid;
	}

}
