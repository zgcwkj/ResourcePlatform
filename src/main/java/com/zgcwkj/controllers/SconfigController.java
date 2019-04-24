package com.zgcwkj.controllers;

import java.util.List;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.zgcwkj.entity.Sconfig;
import com.zgcwkj.service.ISconfigService;
import com.zgcwkj.utils.ReturnLayui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 配置控制器
 *
 * @author zgcwkj
 * @since 2019-01-02
 */
@Controller
@RequestMapping("admin/sconfig")
public class SconfigController {

    @Autowired
    ISconfigService iSconfigService;

    /**
     * 系统配置管理页面
     */
    @RequestMapping(value = {"", "index"}, method = RequestMethod.GET)
    public String index() {
        return "admin/sconfig/index";
    }

    /**
     * 查询配置
     */
    @ResponseBody
    @RequestMapping(value = {"inquire", "Inquire"}, method = RequestMethod.POST)
    public Object inquire(@RequestParam("page") Integer Page, @RequestParam("pageSize") Integer PageSize, @RequestParam("keyWord") String KeyWord, @RequestParam("beginDate") String BeginDate, @RequestParam("endDate") String EndDate) {
        Page = (Page - 1) * PageSize;

        List<Sconfig> canteens_p = iSconfigService.selectDatePage(Page, PageSize, KeyWord, BeginDate, EndDate);
        List<Sconfig> canteens_l = iSconfigService.selectDate(KeyWord, BeginDate, EndDate);

        ReturnLayui<Sconfig> returnLayui = new ReturnLayui<>();
        returnLayui.setCode(0);
        returnLayui.setCount(canteens_l.size() + "");
        returnLayui.setData(canteens_p);
        returnLayui.setMsg("");

        return returnLayui;
    }

    /**
     * 新增配置
     */
    @ResponseBody
    @RequestMapping(value = {"insert", "Insert"}, method = RequestMethod.POST)
    public Object insert(@RequestParam("configName") String ConfigName, @RequestParam("configInfo") String ConfigInfo) {

        Sconfig sconfig = new Sconfig();
        sconfig.setConfigname(ConfigName);
        sconfig.setConfiginfo(ConfigInfo);
        boolean status = iSconfigService.insert(sconfig);

        ReturnLayui<?> returnLayui = new ReturnLayui<>();
        returnLayui.setMsg("操作失败");
        returnLayui.setCode(-1);
        if (status) {
            returnLayui.setMsg("操作成功");
            returnLayui.setCode(1);
        }
        return returnLayui;
    }

    /**
     * 修改配置
     */
    @ResponseBody
    @RequestMapping(value = {"update", "Update"}, method = RequestMethod.POST)
    public Object update(@RequestParam("configID") String ConfigID, @RequestParam("configName") String ConfigName, @RequestParam("configInfo") String ConfigInfo) {
        EntityWrapper<Sconfig> entityWrapper = new EntityWrapper<>();
        entityWrapper.eq("ConfigID", ConfigID);

        Sconfig sconfig = new Sconfig();
        sconfig.setConfigname(ConfigName);
        sconfig.setConfiginfo(ConfigInfo);
        boolean status = iSconfigService.update(sconfig, entityWrapper);

        ReturnLayui<?> returnLayui = new ReturnLayui<>();
        returnLayui.setMsg("操作失败");
        returnLayui.setCode(-1);
        if (status) {
            returnLayui.setMsg("操作成功");
            returnLayui.setCode(1);
        }
        return returnLayui;
    }

    /**
     * 删除配置
     */
    @ResponseBody
    @RequestMapping(value = {"delete", "Delete"}, method = RequestMethod.POST)
    public Object delete(@RequestParam("ids") String ids) {
        String[] _ids = ids.split(",");

        int delectRow = 0;// 记录删除的总行数
        for (int i = 0; i < _ids.length; i++) {
            boolean b = iSconfigService.delete(new EntityWrapper<Sconfig>().eq("ConfigID", _ids[i]));
            if (b) {
                delectRow++;
            }
        }

        ReturnLayui<?> returnLayui = new ReturnLayui<>();
        returnLayui.setMsg("操作失败");
        returnLayui.setCode(-1);
        if (delectRow > 0) {
            returnLayui.setMsg("操作成功");
            returnLayui.setCode(1);
        }
        return returnLayui;
    }
}
