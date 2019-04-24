package com.zgcwkj.mapper;

import com.zgcwkj.entity.Srole;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author zgcwkj
 * @since 2019-01-02
 */
public interface SroleMapper extends BaseMapper<Srole> {

    /**
     * 查询数据
     *
     * @param Page
     * @param PageSize
     * @return
     */
    @Select("SELECT roleid,rolename FROM srole WHERE CONCAT(roleid, rolename)LIKE #{likes}")
    public List<Srole> selectDate(@Param("likes") String Like, @Param("BeginDate") String BeginDate, @Param("EndDate") String EndDate);

    /**
     * 查询数据分页
     *
     * @param Page
     * @param PageSize
     * @return
     */
    @Select("SELECT roleid,rolename FROM srole WHERE CONCAT(roleid, rolename)LIKE #{likes} LIMIT #{page},#{pagesize}")
    public List<Srole> selectDatePage(@Param("page") Integer Page, @Param("pagesize") Integer PageSize, @Param("likes") String Like, @Param("BeginDate") String BeginDate, @Param("EndDate") String EndDate);
}