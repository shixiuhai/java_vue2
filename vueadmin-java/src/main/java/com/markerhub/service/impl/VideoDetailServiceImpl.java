package com.markerhub.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.markerhub.entity.VideoDetail;
import com.markerhub.mapper.VideoDetailMapper;
import com.markerhub.service.VideoDetailService;
import com.markerhub.utils.PageUtils;
import java.util.Objects;

@Service
public class VideoDetailServiceImpl extends ServiceImpl<VideoDetailMapper,VideoDetail> implements VideoDetailService{
    public PageUtils findAll(int page,int size,Integer number){
       IPage<VideoDetail> all =this.page(
            new Page<VideoDetail>(page,size),
            // 通过传递information_id查询视频每集
            new QueryWrapper<VideoDetail>()
                .eq(Objects.nonNull(number),"information_id",number)
        );
        return new PageUtils(all);
    }
    
}
