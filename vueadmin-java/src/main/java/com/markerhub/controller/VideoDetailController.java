package com.markerhub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.markerhub.common.lang.Result;
import com.markerhub.service.VideoDetailService;
import com.markerhub.utils.PageUtils;

@RestController
@RequestMapping("/videoDetail") // 获取某部视频的一页详细信息
public class VideoDetailController {
    @Autowired
    private VideoDetailService videoDetailService;
    @GetMapping("")
    // (@RequestParam(value = "time",required = false) String createtime)
    public Result findAll(@RequestParam(defaultValue = "1") int page,
                          @RequestParam(defaultValue = "10") int size,
                          @RequestParam(required = false) Integer informationId){
            PageUtils all = videoDetailService.findAll(page, size,informationId);
            return Result.succ(all);
        
    }
    
}
