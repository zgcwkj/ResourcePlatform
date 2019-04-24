package com.zgcwkj.mapper;

import com.zgcwkj.entity.Slog;

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
public interface SlogMapper extends BaseMapper<Slog> {

	/**
	 * 查询数据
	 * 
	 * @param Page
	 * @param PageSize
	 * @return
	 */
	@Select("SELECT slog.logid,slog.url,slog.parameter,slog.operattime FROM slog WHERE (operattime >= IFNULL(#{BeginDate}, operattime)) AND (operattime <= IFNULL(#{EndDate}, operattime)) AND CONCAT(url, parameter)LIKE #{likes}")
	public List<Slog> selectDate(@Param("likes") String Like, @Param("BeginDate") String BeginDate, @Param("EndDate") String EndDate);

	/**
	 * 查询数据分页
	 * 
	 * @param Page
	 * @param PageSize
	 * @return
	 */
	@Select("SELECT slog.logid,slog.url,slog.parameter,slog.operattime FROM slog WHERE (operattime >= IFNULL(#{BeginDate}, operattime)) AND (operattime <= IFNULL(#{EndDate}, operattime)) AND CONCAT(url, parameter)LIKE #{likes} LIMIT #{page},#{pagesize}")
	public List<Slog> selectDatePage(@Param("page") Integer Page, @Param("pagesize") Integer PageSize, @Param("likes") String Like, @Param("BeginDate") String BeginDate, @Param("EndDate") String EndDate);
}