package com.markerhub.service.impl;



import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
// Ipage 和 Page都是mybatisplus的
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.markerhub.entity.VideoInformation;
import com.markerhub.enumeration.VideoArea;
import com.markerhub.enumeration.VideoType;
import com.markerhub.mapper.VideoInformationMapper;
import com.markerhub.service.VideoInformationService;
import com.markerhub.utils.PageUtils;
// 判断对象是否为空
import java.util.Objects;





@Service
public class VideoInformationServiceImpl extends ServiceImpl<VideoInformationMapper,VideoInformation> implements VideoInformationService{
    public PageUtils findAll(int page, int size,String type,String area,String videoName){
        IPage<VideoInformation> all = this.page(
            new Page<VideoInformation>(page,size),
            new QueryWrapper<VideoInformation>()
                .eq(!StringUtils.isBlank(type),"type",VideoType.getType(type))
                .eq(!StringUtils.isBlank(area),"area",VideoArea.getType(area))
                .like(!StringUtils.isBlank(videoName),"video_name",videoName)
            
        );
        return new PageUtils(all);
   
        
    }
    
}
