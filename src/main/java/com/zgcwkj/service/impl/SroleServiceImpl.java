package com.zgcwkj.service.impl;

import com.zgcwkj.entity.Srole;
import com.zgcwkj.mapper.SroleMapper;
import com.zgcwkj.service.ISroleService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zgcwkj
 * @since 2019-01-02
 */
@Service
public class SroleServiceImpl extends ServiceImpl<SroleMapper, Srole> implements ISroleService {

    @Autowired
    SroleMapper sroleMapper;

    @Override
    public List<Srole> selectDate(String Like, String BeginDate, String EndDate) {
        Like = "%" + Like + "%";
        if (BeginDate.equals("")) {
            BeginDate = "1970-01-01 00:00:00";
        }
        if (EndDate.equals("")) {
            EndDate = "2999-01-01 00:00:00";
        }
        return sroleMapper.selectDate(Like, BeginDate, EndDate);
    }

    @Override
    public List<Srole> selectDatePage(Integer Page, Integer PageSize, String Like, String BeginDate, String EndDate) {
        Like = "%" + Like + "%";
        if (BeginDate.equals("")) {
            BeginDate = "1970-01-01 00:00:00";
        }
        if (EndDate.equals("")) {
            EndDate = "2999-01-01 00:00:00";
        }
        return sroleMapper.selectDatePage(Page, PageSize, Like, BeginDate, EndDate);
    }
}
