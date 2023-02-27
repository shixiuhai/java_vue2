package com.markerhub.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.markerhub.entity.VideoDetail;
import com.markerhub.mapper.VideoDetailMapper;
import com.markerhub.service.VideoDetailService;
import com.markerhub.utils.PageUtils;

@Service
public class VideoDetailServiceImpl extends ServiceImpl<VideoDetailMapper,VideoDetail> implements VideoDetailService{
    public PageUtils findAll(int page,int size){
       IPage<VideoDetail> all =this.page(
            new Page<VideoDetail>(page,size)
        );
        return new PageUtils(all);
    }
    
}
