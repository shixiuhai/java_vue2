package com.markerhub.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.markerhub.entity.ParseVideo;
import com.markerhub.utils.PageUtils;

public interface ParseVideoService extends IService<ParseVideo>{
    public PageUtils findAll(int page,int size);
    
}
