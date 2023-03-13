package com.markerhub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.markerhub.common.lang.Result;
import com.markerhub.service.SysDictService;
import com.markerhub.utils.PageUtils;
// RestControler 不需要添加路径
@RestController
@RequestMapping("/sysDict")
public class SysDictController {
    @Autowired
    SysDictService sysDictService;
    // 写一个get接口
    @GetMapping("")
    public Result getDict(@RequestParam(required = true) String dicName){
        PageUtils all = sysDictService.find(1, 10, dicName);
        return Result.succ(all);
    }
    
}
