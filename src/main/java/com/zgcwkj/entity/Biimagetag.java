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
public class Biimagetag extends Model<Biimagetag> {

    private static final long serialVersionUID = 1L;

    /**
     * 图片标签ID
     */
	@TableId(value="imagetagid", type= IdType.AUTO)
	private Integer imagetagid;
    /**
     * 图片ID
     */
	private Integer imageid;
    /**
     * 标签ID
     */
	private Integer tagid;


	public Integer getImagetagid() {
		return imagetagid;
	}

	public void setImagetagid(Integer imagetagid) {
		this.imagetagid = imagetagid;
	}

	public Integer getImageid() {
		return imageid;
	}

	public void setImageid(Integer imageid) {
		this.imageid = imageid;
	}

	public Integer getTagid() {
		return tagid;
	}

	public void setTagid(Integer tagid) {
		this.tagid = tagid;
	}

	@Override
	protected Serializable pkVal() {
		return this.imagetagid;
	}

}
