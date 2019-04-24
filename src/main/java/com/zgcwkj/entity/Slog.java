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
public class Slog extends Model<Slog> {

    private static final long serialVersionUID = 1L;

    /**
     * 日志ID
     */
	@TableId(value="logid", type= IdType.AUTO)
	private Integer logid;
    /**
     * 地址
     */
	private String url;
    /**
     * 参数
     */
	private String parameter;
    /**
     * 时间
     */
	private Date operattime;


	public Integer getLogid() {
		return logid;
	}

	public void setLogid(Integer logid) {
		this.logid = logid;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getParameter() {
		return parameter;
	}

	public void setParameter(String parameter) {
		this.parameter = parameter;
	}

	public Date getOperattime() {
		return operattime;
	}

	public void setOperattime(Date operattime) {
		this.operattime = operattime;
	}

	@Override
	protected Serializable pkVal() {
		return this.logid;
	}

}
