package com.zgcwkj.service.impl;

import com.zgcwkj.entity.Sconfig;
import com.zgcwkj.mapper.SconfigMapper;
import com.zgcwkj.service.ISconfigService;

import java.util.List;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zgcwkj
 * @since 2019-01-02
 */
@Service
public class SconfigServiceImpl extends ServiceImpl<SconfigMapper, Sconfig> implements ISconfigService {

    @Autowired
    SconfigMapper sconfigMapper;

    @Override
    public List<Sconfig> selectDate(String Like, String BeginDate, String EndDate) {
        Like = "%" + Like + "%";
        if (BeginDate.equals("")) {
            BeginDate = "1970-01-01 00:00:00";
        }
        if (EndDate.equals("")) {
            EndDate = "2999-01-01 00:00:00";
        }
        return sconfigMapper.selectDate(Like, BeginDate, EndDate);
    }

    @Override
    public List<Sconfig> selectDatePage(Integer Page, Integer PageSize, String Like, String BeginDate, String EndDate) {
        Like = "%" + Like + "%";
        if (BeginDate.equals("")) {
            BeginDate = "1970-01-01 00:00:00";
        }
        if (EndDate.equals("")) {
            EndDate = "2999-01-01 00:00:00";
        }
        return sconfigMapper.selectDatePage(Page, PageSize, Like, BeginDate, EndDate);
    }
}
