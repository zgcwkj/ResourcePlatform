package com.zgcwkj.service.impl;

import com.zgcwkj.entity.Slog;
import com.zgcwkj.mapper.SlogMapper;
import com.zgcwkj.service.ISlogService;

import java.util.List;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author zgcwkj
 * @since 2019-01-02
 */
@Service
public class SlogServiceImpl extends ServiceImpl<SlogMapper, Slog> implements ISlogService {

    @Autowired
    SlogMapper slogMapper;

    @Override
    public List<Slog> selectDate(String Like, String BeginDate, String EndDate) {
        Like = "%" + Like + "%";
        if (BeginDate.equals("")) {
            BeginDate = "1970-01-01 00:00:00";
        }
        if (EndDate.equals("")) {
            EndDate = "2999-01-01 00:00:00";
        }
        return slogMapper.selectDate(Like, BeginDate, EndDate);
    }

    @Override
    public List<Slog> selectDatePage(Integer Page, Integer PageSize, String Like, String BeginDate, String EndDate) {
        Like = "%" + Like + "%";
        if (BeginDate.equals("")) {
            BeginDate = "1970-01-01 00:00:00";
        }
        if (EndDate.equals("")) {
            EndDate = "2999-01-01 00:00:00";
        }
        return slogMapper.selectDatePage(Page, PageSize, Like, BeginDate, EndDate);
    }
}
