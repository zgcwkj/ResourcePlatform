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
public class Bigallery extends Model<Bigallery> {

    private static final long serialVersionUID = 1L;

    /**
     * 图库ID
     */
	@TableId(value="galleryid", type= IdType.AUTO)
	private Integer galleryid;
    /**
     * 用户ID
     */
	private Integer userid;
    /**
     * 图库名称
     */
	private String galleryname;
    /**
     * 是否私有
     */
	private Integer isprivate;


	public Integer getGalleryid() {
		return galleryid;
	}

	public void setGalleryid(Integer galleryid) {
		this.galleryid = galleryid;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getGalleryname() {
		return galleryname;
	}

	public void setGalleryname(String galleryname) {
		this.galleryname = galleryname;
	}

	public Integer getIsprivate() {
		return isprivate;
	}

	public void setIsprivate(Integer isprivate) {
		this.isprivate = isprivate;
	}

	@Override
	protected Serializable pkVal() {
		return this.galleryid;
	}

}
