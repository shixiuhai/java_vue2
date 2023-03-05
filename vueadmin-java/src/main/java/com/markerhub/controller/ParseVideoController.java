package com.markerhub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.markerhub.common.lang.Result;
import com.markerhub.service.ParseVideoService;
import com.markerhub.utils.PageUtils;

@RestController
@RequestMapping("/parseVideo")
public class ParseVideoController {
    @Autowired
    ParseVideoService parseVideoService;

    @GetMapping("")
    public Result findAll(@RequestParam(defaultValue = "1") int page,
                          @RequestParam(defaultValue = "10") int size){
                    PageUtils all = parseVideoService.findAll(page, size);

                    return Result.succ(all);

    }
    
}
