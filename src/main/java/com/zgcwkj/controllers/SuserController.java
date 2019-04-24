package com.zgcwkj.controllers;

import java.util.List;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.zgcwkj.entity.Suser;
import com.zgcwkj.entitys.SuserInSrole;
import com.zgcwkj.service.ISroleService;
import com.zgcwkj.service.ISuserService;
import com.zgcwkj.utils.ReturnLayui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 系统用户控制器
 *
 * @author zgcwkj
 * @since 2019-01-02
 */
@Controller
@RequestMapping("admin/suser")
public class SuserController {

    @Autowired
    ISuserService iSuserService;
    @Autowired
    ISroleService iSroleService;

    /**
     * 系统用户管理页面
     */
    @RequestMapping(value = {"", "index"}, method = RequestMethod.GET)
    public String index() {
        return "admin/user/index";
    }

    /**
     * 查询用户
     */
    @ResponseBody
    @RequestMapping(value = {"inquire", "Inquire"}, method = RequestMethod.POST)
    public Object inquire(@RequestParam("page") Integer Page, @RequestParam("pageSize") Integer PageSize, @RequestParam("keyWord") String KeyWord, @RequestParam("beginDate") String BeginDate, @RequestParam("endDate") String EndDate) {
        Page = (Page - 1) * PageSize;

        List<SuserInSrole> canteens_p = iSuserService.selectDatePage(Page, PageSize, KeyWord, BeginDate, EndDate);
        List<SuserInSrole> canteens_l = iSuserService.selectDate(KeyWord, BeginDate, EndDate);

        ReturnLayui<SuserInSrole> returnLayui = new ReturnLayui<SuserInSrole>();
        returnLayui.setCode(0);
        returnLayui.setCount(canteens_l.size() + "");
        returnLayui.setData(canteens_p);
        returnLayui.setMsg("");

        return returnLayui;
    }

    /**
     * 查询角色（绑定下拉框）
     */
    @ResponseBody
    @RequestMapping(value = {"inquireRole", "InquireRole"}, method = RequestMethod.POST)
    public Object inquireRole() {
        return iSroleService.selectList(null);
    }

    /**
     * 新增用户
     */
    @ResponseBody
    @RequestMapping(value = {"insert", "Insert"}, method = RequestMethod.POST)
    public Object insert(@RequestParam("userAccounts") String UserAccounts, @RequestParam("userName") String UserName, @RequestParam("userPassword") String UserPassword, @RequestParam("roleID") String RoleID) {

        Suser suser = new Suser();
        suser.setAccounts(UserAccounts);
        suser.setName(UserName);
        suser.setPassword(UserPassword);
        suser.setRoleid(RoleID);
        boolean status = iSuserService.insert(suser);

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
     * 修改用户
     */
    @ResponseBody
    @RequestMapping(value = {"update", "Update"}, method = RequestMethod.POST)
    public Object update(@RequestParam("userID") String UserID, @RequestParam("userAccounts") String UserAccounts, @RequestParam("userName") String UserName, @RequestParam("userPassword") String UserPassword, @RequestParam("roleID") String RoleID) {
        EntityWrapper<Suser> entityWrapper = new EntityWrapper<Suser>();
        entityWrapper.eq("UserID", UserID);

        Suser suser = new Suser();
        suser.setAccounts(UserAccounts);
        suser.setName(UserName);
        suser.setPassword(UserPassword);
        suser.setRoleid(RoleID);
        boolean status = iSuserService.update(suser, entityWrapper);

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
     * 删除用户
     */
    @ResponseBody
    @RequestMapping(value = {"delete", "Delete"}, method = RequestMethod.POST)
    public Object delete(@RequestParam("ids") String ids) {
        String[] _ids = ids.split(",");

        int delectRow = 0;// 记录删除的总行数
        for (int i = 0; i < _ids.length; i++) {
            boolean b = iSuserService.delete(new EntityWrapper<Suser>().eq("UserID", _ids[i]));
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
