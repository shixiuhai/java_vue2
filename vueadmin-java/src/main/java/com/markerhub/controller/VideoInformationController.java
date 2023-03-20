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
    public Result findAll(@RequestParam(defaultValue = "1",required = false) int page,
                          @RequestParam(defaultValue = "15",required = false) int size,
                          @RequestParam(defaultValue = "",required = false) String typeName,
                          @RequestParam(defaultValue = "",required = false) String areaName,
                          @RequestParam(defaultValue = "",required = false) String videoName ){
        // VideoInformation videoInformation = new VideoInformation();
        PageUtils all = videoInformationService.findAll(page,size,typeName,areaName,videoName);
        return Result.succ(all);
    }
    
}
