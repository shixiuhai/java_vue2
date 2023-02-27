package com.markerhub.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.markerhub.entity.VideoDetail;
import com.markerhub.utils.PageUtils;

public interface VideoDetailService extends IService<VideoDetail>{
    public PageUtils findAll(int page,int size);
    
}
