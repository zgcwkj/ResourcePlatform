package com.zgcwkj.service;

import com.zgcwkj.entity.Slog;

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
public interface ISlogService extends IService<Slog> {

	public List<Slog> selectDate(String Like, String BeginDate, String EndDate);

	public List<Slog> selectDatePage(Integer Page, Integer PageSize, String Like, String BeginDate, String EndDate);
}
