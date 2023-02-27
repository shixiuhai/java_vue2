package com.markerhub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.AccessType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.markerhub.common.lang.Result;
import com.markerhub.entity.VideoInformation;
import com.markerhub.service.VideoInformationService;
import com.markerhub.utils.PageUtils;
import org.springframework.security.access.prepost.PreAuthorize;

@RestController
@RequestMapping("/videoInformation")
public class VideoInformationController {
    @Autowired
    private VideoInformationService videoInformationService;
    // @PreAuthorize("hasAuthority('sys:manage')")
    // 列表也展示保护
    @GetMapping("")
    public Result findAll(@RequestParam(defaultValue = "1") int page,
                          @RequestParam(defaultValue = "10") int size,
                          @RequestParam(defaultValue = "电影") String type,
                          @RequestParam(defaultValue = "内地") String area ){
        // VideoInformation videoInformation = new VideoInformation();
        PageUtils all = videoInformationService.findAll(page,size,type,area);
        return Result.succ(all);
    }
    
}
