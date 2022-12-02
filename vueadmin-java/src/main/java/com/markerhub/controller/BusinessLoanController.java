package com.markerhub.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.markerhub.common.lang.Result;

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
@RequestMapping("")
public class BusinessLoanController {
    @Autowired
    private BusinessLoanService businessLoanService;
    // 增加 参考 https://blog.csdn.net/qq_15204179/article/details/83472454
    @PostMapping("/save")
    // @PreAuthorize("hasRole('admin')") @RequestParam(name="aa")
    // public Result AddLoan(@RequestBody BusinessLoan businessLoan, @RequestParam MultipartFile pictureFile) {
    public Result AddLoan(@RequestParam MultipartFile pictureFile, @RequestParam String abc) {
        // log.info(pictureFile);
        log.info(abc);
        log.info("成功");
        // log.info(businessLoan.getImage());
        return Result.succ("成功");
        

    }

    // 删除数据

    // 修改数据

    // 删除数据
}
