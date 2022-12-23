package com.markerhub.mapper;
import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.markerhub.entity.BusinessLoan;
import java.util.List;
@Mapper
public interface BusinessLoanMapper extends BaseMapper<BusinessLoan> {
    // mapper也需要定义 IPage 实现分页
    IPage<BusinessLoan> findAllBypage(IPage<BusinessLoan> page);

}
