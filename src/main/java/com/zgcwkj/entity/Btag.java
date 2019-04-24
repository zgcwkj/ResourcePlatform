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
public class Btag extends Model<Btag> {

    private static final long serialVersionUID = 1L;

    /**
     * 标签ID
     */
	@TableId(value="tagid", type= IdType.AUTO)
	private Integer tagid;
    /**
     * 标签名称
     */
	private String tagname;


	public Integer getTagid() {
		return tagid;
	}

	public void setTagid(Integer tagid) {
		this.tagid = tagid;
	}

	public String getTagname() {
		return tagname;
	}

	public void setTagname(String tagname) {
		this.tagname = tagname;
	}

	@Override
	protected Serializable pkVal() {
		return this.tagid;
	}

}
