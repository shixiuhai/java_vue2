package com.markerhub.service.impl;

import javax.management.Query;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.markerhub.entity.SysDict;
import com.markerhub.mapper.SysDictMapper;
import com.markerhub.service.SysDictService;
import com.markerhub.utils.PageUtils;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;

// mybatis判断字符串是否为空
import com.baomidou.mybatisplus.core.toolkit.StringUtils;

import java.util.ArrayList;
import java.util.List;
// 原生方法判断对象是否为空
import java.util.Objects;
@Service
public class SysDictServiceImpl extends ServiceImpl<SysDictMapper,SysDict> implements SysDictService{
    public PageUtils find(int page,int size,String dicName){
        IPage<SysDict> all = this.page(
            new Page<SysDict>(page,size),
            new QueryWrapper<SysDict>()
                .eq(!StringUtils.isBlank(dicName),"dic_name",dicName)
                .eq("status",1)
        );
        // all.getRecords().forEach(t->{});
        // 返回实列化一个对象
        return new PageUtils(all);
    }
    
}
