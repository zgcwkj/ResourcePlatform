package com.zgcwkj.service.impl;

import com.zgcwkj.entity.Suser;
import com.zgcwkj.entitys.SuserInSrole;
import com.zgcwkj.mapper.SuserMapper;
import com.zgcwkj.service.ISuserService;

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
public class SuserServiceImpl extends ServiceImpl<SuserMapper, Suser> implements ISuserService {

    @Autowired
    SuserMapper suserMapper;

    @Override
    public List<SuserInSrole> selectDate(String Like, String BeginDate, String EndDate) {
        Like = "%" + Like + "%";
        if (BeginDate.equals("")) {
            BeginDate = "1970-01-01 00:00:00";
        }
        if (EndDate.equals("")) {
            EndDate = "2999-01-01 00:00:00";
        }
        return suserMapper.selectDate(Like, BeginDate, EndDate);
    }

    @Override
    public List<SuserInSrole> selectDatePage(Integer Page, Integer PageSize, String Like, String BeginDate, String EndDate) {
        Like = "%" + Like + "%";
        if (BeginDate.equals("")) {
            BeginDate = "1970-01-01 00:00:00";
        }
        if (EndDate.equals("")) {
            EndDate = "2999-01-01 00:00:00";
        }
        return suserMapper.selectDatePage(Page, PageSize, Like, BeginDate, EndDate);
    }
}
