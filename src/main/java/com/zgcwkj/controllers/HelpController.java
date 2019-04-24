package com.zgcwkj.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 图库控制器
 *
 * @author zgcwkj
 * @since 2019-01-02
 */
@Controller
@RequestMapping(value = "help")
public class HelpController {

    @RequestMapping(value = { "", "index" })
    public String index() {
        return "help/index";
    }
}
