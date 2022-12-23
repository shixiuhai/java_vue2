package com.markerhub.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.markerhub.entity.BusinessLoan;
import com.markerhub.common.utils.PageUtils;
public interface BusinessLoanService extends IService<BusinessLoan>{
    // 定义方法 public可以省略
    // public List<BusinessLoan> findAllBypage(Integer page,Integer pageSize);
    PageUtils findAllBypage(Integer page,Integer pageSize);

}
