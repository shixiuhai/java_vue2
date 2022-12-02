package com.markerhub.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.markerhub.entity.BusinessLoan;
import com.markerhub.mapper.BusinessLoanMapper;
import com.markerhub.service.BusinessLoanService;
@Service
public class BusinessLoanServiceImpl extends ServiceImpl<BusinessLoanMapper,BusinessLoan> implements BusinessLoanService{
    
}
