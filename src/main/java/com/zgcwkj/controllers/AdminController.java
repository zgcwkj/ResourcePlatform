package com.zgcwkj.controllers;

import com.zgcwkj.entity.Suser;
import com.zgcwkj.utils.Base64;
import com.zgcwkj.utils.MD5Util;
import com.zgcwkj.utils.ReturnLayui;
import com.zgcwkj.utils.ValidateCode;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * 后台主入口控制器
 *
 * @author zgcwkj
 * @since 2018-12-28
 */
@Controller
@RequestMapping(value = {"", "admin"})
public class AdminController {
    /**
     * 登陆入口
     *
     * @param request  请求
     * @param response 响应
     * @return 模型和视图数据
     */
    @RequestMapping(value = {"", "index", "Index"}, method = RequestMethod.GET)
    public ModelAndView index(HttpServletRequest request, HttpServletResponse response) {
        HttpSession httpSession = request.getSession();

        ModelAndView mAndView = new ModelAndView();
        mAndView.addObject("Accounts", (String) httpSession.getAttribute("accounts"));
        mAndView.addObject("Password", (String) httpSession.getAttribute("password"));
        mAndView.addObject("RememberMe", "true".equals((String) httpSession.getAttribute("remember")) ? "checked" : "");
        mAndView.setViewName("admin/login");

        return mAndView;
    }

    /**
     * 获取验证码
     *
     * @param request  请求
     * @param response 响应
     * @throws IOException 文件处理错误
     */
    @ResponseBody
    @RequestMapping(value = {"validateImage", "ValidateImage"}, method = RequestMethod.GET)
    public void validateImage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        // 生成验证码
        ValidateCode validateCode = new ValidateCode(6);
        String random = validateCode.GetValidate();
        BufferedImage image = validateCode.getImage();

        // 将随机汉字存在session中
        request.getSession().setAttribute("verity", random);
        // 将图形写给浏览器
        response.setContentType("image/jpeg");
        // 发头控制浏览器不要缓存
        response.setDateHeader("expries", -1);
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");
        // 将图片输出给浏览器
        ImageIO.write(image, "jpg", response.getOutputStream());

        System.out.println("验证码：" + random);
    }

    /**
     * 处理登陆请求
     *
     * @param RememberMe 记住密码
     * @param Accounts   账号
     * @param Password   密码
     * @param Captcha    验证码
     * @param request    请求
     * @param response   响应
     * @return 处理结果
     */
    @ResponseBody
    @RequestMapping(value = {"login", "Login"}, method = RequestMethod.POST)
    public Object Login(@RequestParam("rememberMe") String RememberMe, @RequestParam("accounts") String Accounts, @RequestParam("password") String Password, @RequestParam("captcha") String Captcha, HttpServletRequest request, HttpServletResponse response) {
        ReturnLayui<?> returnLayui = new ReturnLayui<>();
        returnLayui.setCode(0);
        returnLayui.setMsg("失败");

        HttpSession httpSession = request.getSession();
        String Verity = (String) httpSession.getAttribute("verity");
        if (Verity != null) {//防止页面的打开方式是不正确
            if (Verity.equals(Captcha.toLowerCase())) {
                Password = new String(Base64.decode(Password));//将密码进行Base64解密
                //==>将账号和密码交由Shiro判断
                UsernamePasswordToken token = new UsernamePasswordToken(Accounts, MD5Util.getMD5(Password));
                Subject subject = SecurityUtils.getSubject();
                try {
                    subject.login(token);//提交给Shiro验证
                    Suser suser = (Suser) subject.getPrincipal();//获取用户信息（有问题）
                    //==>重要的数据存储到Session中
                    httpSession.setAttribute("userID", suser.getUserid());
                    httpSession.setAttribute("roleID", suser.getRoleid());
                    httpSession.setAttribute("userName", suser.getName());
                    if ("true".equals(RememberMe)) {//记住密码功能
                        httpSession.setAttribute("accounts", Accounts);
                        httpSession.setAttribute("password", Password);
                        httpSession.setAttribute("remember", RememberMe);
                    }
                    //==>重要的数据存储到Session中
                    returnLayui.setCode(1);
                    returnLayui.setMsg("登陆成功，马上跳转");
                } catch (Exception e) {
                    returnLayui.setMsg(e.getMessage());
                }
                //==>将账号和密码交由Shiro判断
            } else
                returnLayui.setMsg("您输入的验证码错误");
        }
        return returnLayui;
    }

    /**
     * 后台控制台
     *
     * @param request  请求
     * @param response 响应
     * @return 模型和视图数据
     */
    @RequiresPermissions("admin")
    @RequestMapping(value = {"admin", "Admin"}, method = RequestMethod.GET)
    public ModelAndView Admin(HttpServletRequest request, HttpServletResponse response) {
        HttpSession httpSession = request.getSession();
        String UserName = (String) httpSession.getAttribute("userName");

        String _html = "";
        _html += "<li><a class='J_menuItem' href='/B'><i class='fa fa-image'></i><span class='nav-label'>图库</span></a></li>";
        _html += "<li><a class='J_menuItem' href='/B'><i class='fa fa-image'></i><span class='nav-label'>图片</span></a></li>";
        _html += "<li><a class='J_menuItem' href='/B'><i class='fa fa-user'></i><span class='nav-label'>前台用户</span></a></li>";
        _html += "<li>";
        _html += "<a href='javascript:void(0);'><i class='fa fa-gear'></i><span class='nav-label'>系统设置</span><span class='fa arrow'></span></a>";
        _html += "<ul class='nav nav-second-level'><li><a class='J_menuItem' href='/admin/suser'><i class='fa fa-user'></i><span class='nav-label'>用户管理</span></a></li></ul>";
        _html += "<ul class='nav nav-second-level'><li><a class='J_menuItem' href='/admin/srole'><i class='fa fa-users'></i><span class='nav-label'>角色管理</span></a></li></ul>";
        _html += "<ul class='nav nav-second-level'><li><a class='J_menuItem' href='/admin/sconfig'><i class='fa fa-gear'></i><span class='nav-label'>程序配置</span></a></li></ul>";
        _html += "<ul class='nav nav-second-level'><li><a class='J_menuItem' href='/admin/slog'><i class='fa fa-leaf'></i><span class='nav-label'>系统日志</span></a></li></ul>";
        _html += "</li>";

        ModelAndView mAndView = new ModelAndView();
        mAndView.addObject("MenuHtml", _html);
        mAndView.addObject("UserName", UserName);

        return mAndView;
    }
}