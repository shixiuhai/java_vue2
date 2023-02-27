package com.markerhub.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.markerhub.entity.ParseVideo;
import com.markerhub.mapper.ParseVideoMapper;
import com.markerhub.service.ParseVideoService;
import com.markerhub.utils.PageUtils;

@Service
public class ParseVideoServiceImpl extends ServiceImpl<ParseVideoMapper,ParseVideo> implements ParseVideoService{
    public PageUtils findAll(int page,int size){
        IPage<ParseVideo> all = this.page(
            new Page<ParseVideo>(page,size)
        );
        return new PageUtils(all);
    }
}
