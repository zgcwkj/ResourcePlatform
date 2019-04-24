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
public class Biimage extends Model<Biimage> {

    private static final long serialVersionUID = 1L;

    /**
     * 图片ID
     */
	@TableId(value="imageid", type= IdType.AUTO)
	private Integer imageid;
    /**
     * 图库ID
     */
	private Integer galleryid;
    /**
     * 用户ID
     */
	private Integer userid;
    /**
     * 图片名称
     */
	private String imagename;
    /**
     * 图片备注
     */
	private String imageremark;
    /**
     * 上传时间
     */
	private Date uploadtime;
    /**
     * 图片路径
     */
	private String path;
    /**
     * 是否私有
     */
	private Integer isprivate;


	public Integer getImageid() {
		return imageid;
	}

	public void setImageid(Integer imageid) {
		this.imageid = imageid;
	}

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

	public String getImagename() {
		return imagename;
	}

	public void setImagename(String imagename) {
		this.imagename = imagename;
	}

	public String getImageremark() {
		return imageremark;
	}

	public void setImageremark(String imageremark) {
		this.imageremark = imageremark;
	}

	public Date getUploadtime() {
		return uploadtime;
	}

	public void setUploadtime(Date uploadtime) {
		this.uploadtime = uploadtime;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Integer getIsprivate() {
		return isprivate;
	}

	public void setIsprivate(Integer isprivate) {
		this.isprivate = isprivate;
	}

	@Override
	protected Serializable pkVal() {
		return this.imageid;
	}

}
