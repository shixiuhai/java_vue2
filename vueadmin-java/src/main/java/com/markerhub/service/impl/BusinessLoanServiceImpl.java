package com.markerhub.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.markerhub.entity.BusinessLoan;
import com.markerhub.mapper.BusinessLoanMapper;
import com.markerhub.service.BusinessLoanService;

// 三个分页相关
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.markerhub.common.utils.PageUtils;
@Service
public class BusinessLoanServiceImpl extends ServiceImpl<BusinessLoanMapper,BusinessLoan> implements BusinessLoanService{
    // Autowired 注入不能在方法里注入
    // @Autowired
    // private BusinessLoanMapper businessLoanMapper;
    
    @Override
    public PageUtils findAllBypage(Integer page,Integer pageSize){

        // 构造一个分页器
        IPage pages = new Page(page,pageSize);
        // 查询出所有数据 使用baseMapper就行
        IPage<BusinessLoan> all = baseMapper.findAllBypage(pages);
        // 封装分页返回数据
        return new PageUtils(all);

    }
    
}
