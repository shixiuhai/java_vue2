package com.markerhub.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.markerhub.common.lang.Result;

import com.markerhub.common.utils.FormateDateUtils;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.markerhub.entity.BusinessLoan;
import lombok.extern.slf4j.Slf4j;

import com.markerhub.service.BusinessLoanService;
@Slf4j
@RestController
@RequestMapping("/loan")
public class BusinessLoanController {
    @Autowired
    private BusinessLoanService businessLoanService;
    // 增加 参考 https://blog.csdn.net/qq_15204179/article/details/83472454
    @PostMapping("/save")
    // @PreAuthorize("hasRole('admin')") @RequestParam(name="aa")
    // public Result AddLoan(@RequestBody BusinessLoan businessLoan, @RequestParam MultipartFile pictureFile) {
    public Result AddLoan(@RequestParam MultipartFile pictureFile, 
                          @RequestParam String image,
                          @RequestParam String brrowerName,
                          @RequestParam String startTime,
                          @RequestParam String endTime,
                          @RequestParam(required = false) String BorrowingPeriod,
                          @RequestParam(required = false) Integer status) {

        // 使用对象接收formdata参数
        BusinessLoan businessLoan = new BusinessLoan();
        businessLoan.setImage(image);
        businessLoan.setBrrowerName(brrowerName);
        businessLoan.setStartTime(FormateDateUtils.paseStringDate(startTime, "yyyy-MM-dd"));
        businessLoan.setEndTime(FormateDateUtils.paseStringDate(endTime, "yyyy-MM-dd"));
        // 计算借款时长
        long days=FormateDateUtils.jdk8DayDiff(startTime, endTime, "yyyy-MM-dd");
        businessLoan.setBorrowingPeriod(String.valueOf(days));
        businessLoanService.save(businessLoan);
        // 保存文件

        // businessLoan.setEndTime(endTime);
        log.info("对象的id是{}",businessLoan.getId());

        // log.info(businessLoan.getImage());
        return Result.succ(businessLoan);
        

    }
    

    // 删除数据

    // 修改数据

    // 删除数据
}
