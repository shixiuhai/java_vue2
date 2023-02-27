package com.markerhub.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.markerhub.entity.VideoInformation;
import com.markerhub.utils.PageUtils;


public interface VideoInformationService extends IService<VideoInformation>{
    public PageUtils findAll(int page, int size,String type,String area);
    
}
