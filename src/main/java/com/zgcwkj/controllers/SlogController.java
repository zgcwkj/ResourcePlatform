package com.zgcwkj.controllers;

import java.util.List;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.zgcwkj.entity.Slog;
import com.zgcwkj.service.ISlogService;
import com.zgcwkj.utils.ReturnLayui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 日志控制器
 *
 * @author zgcwkj
 * @since 2019-01-02
 */
@Controller
@RequestMapping("admin/slog")
public class SlogController {

    @Autowired
    ISlogService iSlogService;

    /**
     * 系统日志管理页面
     */
    @RequestMapping(value = {"", "index"}, method = RequestMethod.GET)
    public String index() {
        return "admin/slog/index";
    }

    /**
     * 查询日志
     */
    @ResponseBody
    @RequestMapping(value = {"inquire", "Inquire"}, method = RequestMethod.POST)
    public Object inquire(@RequestParam("page") Integer Page, @RequestParam("pageSize") Integer PageSize, @RequestParam("keyWord") String KeyWord, @RequestParam("beginDate") String BeginDate, @RequestParam("endDate") String EndDate) {
        Page = (Page - 1) * PageSize;

        List<Slog> canteens_p = iSlogService.selectDatePage(Page, PageSize, KeyWord, BeginDate, EndDate);
        List<Slog> canteens_l = iSlogService.selectDate(KeyWord, BeginDate, EndDate);

        ReturnLayui<Slog> returnLayui = new ReturnLayui<Slog>();
        returnLayui.setCode(0);
        returnLayui.setCount(canteens_l.size() + "");
        returnLayui.setData(canteens_p);
        returnLayui.setMsg("");

        return returnLayui;
    }

    /**
     * 删除日志
     */
    @ResponseBody
    @RequestMapping(value = {"delete", "Delete"}, method = RequestMethod.POST)
    public Object delete(@RequestParam("ids") String ids) {
        String[] _ids = ids.split(",");

        int delectRow = 0;// 记录删除的总行数
        for (int i = 0; i < _ids.length; i++) {
            boolean b = iSlogService.delete(new EntityWrapper<Slog>().eq("LogID", _ids[i]));
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
