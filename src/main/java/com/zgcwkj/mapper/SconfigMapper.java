package com.zgcwkj.mapper;

import com.zgcwkj.entity.Sconfig;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author zgcwkj
 * @since 2019-01-02
 */
public interface SconfigMapper extends BaseMapper<Sconfig> {

	/**
	 * 查询数据
	 * 
	 * @param Page
	 * @param PageSize
	 * @return
	 */
	@Select("SELECT * FROM sconfig WHERE CONCAT(configname, configinfo)LIKE #{likes}")
	public List<Sconfig> selectDate(@Param("likes") String Like, @Param("BeginDate") String BeginDate, @Param("EndDate") String EndDate);

	/**
	 * 查询数据分页
	 * 
	 * @param Page
	 * @param PageSize
	 * @return
	 */
	@Select("SELECT * FROM sconfig WHERE CONCAT(configname, configinfo)LIKE #{likes} LIMIT #{page},#{pagesize}")
	public List<Sconfig> selectDatePage(@Param("page") Integer Page, @Param("pagesize") Integer PageSize, @Param("likes") String Like, @Param("BeginDate") String BeginDate, @Param("EndDate") String EndDate);
}