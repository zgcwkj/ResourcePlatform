package com.zgcwkj.service;

import com.zgcwkj.entity.Sconfig;

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
public interface ISconfigService extends IService<Sconfig> {
	public List<Sconfig> selectDate(String Like, String BeginDate, String EndDate);

	public List<Sconfig> selectDatePage(Integer Page, Integer PageSize, String Like, String BeginDate, String EndDate);
}
