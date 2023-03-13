package com.markerhub.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.markerhub.entity.SysDict;
import com.markerhub.utils.PageUtils;

public interface SysDictService extends IService<SysDict>{
    PageUtils find(int page,int size,String dicName);
    
}
