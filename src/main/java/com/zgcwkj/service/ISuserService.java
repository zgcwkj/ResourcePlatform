package com.zgcwkj.service;

import com.zgcwkj.entity.Suser;
import com.zgcwkj.entitys.SuserInSrole;

import java.util.List;

import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zgcwkj
 * @since 2019-01-02
 */
public interface ISuserService extends IService<Suser> {

	public List<SuserInSrole> selectDate(String Like, String BeginDate, String EndDate);

	public List<SuserInSrole> selectDatePage(Integer Page, Integer PageSize, String Like, String BeginDate, String EndDate);
}
