package com.zgcwkj.service;

import com.zgcwkj.entity.Srole;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zgcwkj
 * @since 2019-01-02
 */
public interface ISroleService extends IService<Srole> {

    public List<Srole> selectDate(String Like, String BeginDate, String EndDate);

    public List<Srole> selectDatePage(Integer Page, Integer PageSize, String Like, String BeginDate, String EndDate);
}
