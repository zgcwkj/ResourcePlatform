package com.zgcwkj.mapper;

import com.zgcwkj.entity.Suser;
import com.zgcwkj.entitys.SuserInSrole;

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
public interface SuserMapper extends BaseMapper<Suser> {

	/**
	 * 查询数据
	 * 
	 * @param Page
	 * @param PageSize
	 * @return
	 */
	@Select("SELECT suser.userid,suser.accounts,suser.name,srole.roleid,srole.rolename FROM suser JOIN srole ON suser.roleid = srole.roleid WHERE CONCAT(accounts, name)LIKE #{likes}")
	public List<SuserInSrole> selectDate(@Param("likes") String Like, @Param("BeginDate") String BeginDate, @Param("EndDate") String EndDate);

	/**
	 * 查询数据分页
	 * 
	 * @param Page
	 * @param PageSize
	 * @return
	 */
	@Select("SELECT suser.userid,suser.accounts,suser.name,srole.roleid,srole.rolename FROM suser JOIN srole ON suser.roleid = srole.roleid WHERE CONCAT(accounts, name)LIKE #{likes} LIMIT #{page},#{pagesize}")
	public List<SuserInSrole> selectDatePage(@Param("page") Integer Page, @Param("pagesize") Integer PageSize, @Param("likes") String Like, @Param("BeginDate") String BeginDate, @Param("EndDate") String EndDate);
}