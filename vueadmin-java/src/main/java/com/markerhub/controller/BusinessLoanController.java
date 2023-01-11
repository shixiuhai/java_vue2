package com.markerhub.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.markerhub.common.lang.Result;

import com.markerhub.common.utils.FormateDateUtils;
import com.markerhub.common.utils.PageUtils;

import java.io.IOException;
import java.util.Date;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.markerhub.entity.BusinessLoan;
import lombok.extern.slf4j.Slf4j;
import com.markerhub.common.utils.FileUploadUtils;

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
    public Result addLoan(@RequestParam(required =  false) MultipartFile pictureFile, 
                          @RequestParam String brrowerName,
                          @RequestParam String startTime,
                          @RequestParam String endTime,
                          @RequestParam(required = false) String BorrowingPeriod,
                          @RequestParam(required = true,defaultValue = "0") String status) {

        // 使用对象接收formdata参数
        BusinessLoan businessLoan = new BusinessLoan();
        businessLoan.setBrrowerName(brrowerName);
        businessLoan.setStartTime(FormateDateUtils.paseStringDate(startTime, "yyyy-MM-dd"));
        businessLoan.setEndTime(FormateDateUtils.paseStringDate(endTime, "yyyy-MM-dd"));
        businessLoan.setStatus(status);
        // 计算借款时长
        long days=FormateDateUtils.jdk8DayDiff(startTime, endTime, "yyyy-MM-dd");
        businessLoan.setBorrowingPeriod(String.valueOf(days));
        // 保存文件
        String[] exts={"jpg","png","jpeg","PNG","JPEG","conf"};
        try {
            String fileName=FileUploadUtils.setPathName("C:\\Users\\walker\\Desktop\\upload").setAllowedExtension(exts).setMaxSize(10).upload(pictureFile);
            // 设置文件名称
            businessLoan.setImage("C:\\Users\\walker\\Desktop\\upload"+fileName);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return Result.fail("文件上传错误");
        }
        
        businessLoanService.save(businessLoan);
        // businessLoan.setEndTime(endTime);
        log.info("对象的id是{}",businessLoan.getId());

        // log.info(businessLoan.getImage());
        return Result.succ(businessLoan);
        

    }
    
    // 删除数据
    @DeleteMapping("/delete")
    public Result delete(@RequestParam(required = true) String id){
        businessLoanService.removeById(id);
        return Result.succ(id+"删除成功");

    }

    // 修改数据
    @PutMapping("/update")
    public Result update(@RequestParam(required =  false) MultipartFile pictureFile, 
                        @RequestParam String brrowerName,
                        @RequestParam String startTime,
                        @RequestParam String endTime,
                        @RequestParam(required = false) String BorrowingPeriod,
                        @RequestParam(required = true,defaultValue = "0") String status){
                        return Result.succ(status);
    }

    // 查询数据
    @GetMapping("/get")
    public Result getLoan(@RequestParam(required = true) Integer page,
                          @RequestParam(required = true) Integer pageSize){
        log.info("页码{},页码尺寸{}",page,pageSize);
        // page传入实体类
        PageUtils all = businessLoanService.findAllBypage(page, pageSize);
        log.info("借款信息查询成功");

        return Result.succ(all);
    }
}
