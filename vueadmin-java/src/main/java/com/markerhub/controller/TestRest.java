package com.markerhub.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.markerhub.common.lang.Result;

import com.markerhub.common.utils.FormateDateUtils;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.markerhub.entity.BusinessLoan;
import lombok.extern.slf4j.Slf4j;
import com.markerhub.common.utils.FileUploadUtils;

import com.markerhub.service.BusinessLoanService;
import org.springframework.web.bind.annotation.GetMapping;
import com.markerhub.service.RestService;

import com.alibaba.fastjson.JSONObject;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;

import java.io.*;

@Slf4j
@RestController
@RequestMapping("/loan")
public class TestRest {
    @Autowired
    private BusinessLoanService businessLoanService;
    
    @Autowired
    private RestService restService;

    /**
     * @return
     */
    @GetMapping("/testRest")
    public Result test(){
        HttpHeaders httpHeaders = new HttpHeaders();
        // 设置headers类型
        httpHeaders.add("Content-Type","multipart/form-data");
        // get 请求
        MultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
        //MultiValueMap<String, Object> map= new LinkedMultiValueMap<>();
        map.add("pictureFile", "123");
        map.add("brrowerName","小王");
        map.add("startTime","2021-12-01");
        map.add("endTime","2022-12-25");
        String url="http://127.0.0.1:8081/loan/save";
        JSONObject resp=restService.postForObjectByHeader(url, map, httpHeaders);
        //log.info("结果是{}",resp);
        return Result.succ("调用api测试rest成功"+resp);

       
        

        // post 请求

        // put 请求

        // delete 请求


    }

    // public void sendWxMsgToOpenId(String openId, WarnSummary warnSummary, Company company, WxAccount wxAccount) throws Exception{
    //     Map<String,Object> map = new HashMap<>();
    //     map.put("grant_type","client_credential");
    //     map.put("appid",wxAccount.getAppid());
    //     map.put("secret",wxAccount.getSecret());
    //     JSONObject tokenResult = restService.get(apiUrl + "token", map);
    //     String token = tokenResult.getString("access_token");

    //     String tempJson = "{\"touser\":\"\",\"template_id\":\"\",\"url\":\"\",\"data\":{\"first\":{\"value\":\"\",\"color\":\"#FF0000\"},\"keyword1\":{\"value\":\"\",\"color\":\"#FF0000\"},\"keyword2\":{\"value\":\"\",\"color\":\"#FF0000\"},\"keyword3\":{\"value\":\"\",\"color\":\"#FF0000\"},\"keyword4\":{\"value\":\"\",\"color\":\"#FF0000\"},\"keyword5\":{\"value\":\"\",\"color\":\"#FF0000\"},\"remark\":{\"value\":\"\",\"color\":\"#FF0000\"}}}";
    //     JSONObject message = JSONObject.parseObject(tempJson);
    //     message.put("touser",openId);
    //     message.put("template_id",templateId);
    //     if(StringUtils.isNotBlank(warnSummary.getWarnImg())){
    //         message.put("url",sendWarnConfig.picturePath+warnSummary.getWarnImg());
    //     }
    //     if(StringUtils.isNotBlank(warnSummary.getWarnVideo())){
    //         message.put("url",sendWarnConfig.videoPath+warnSummary.getWarnVideo());
    //     }
    //     JSONObject data = message.getJSONObject("data");
    //     data.getJSONObject("first").put("value","");
    //     data.getJSONObject("keyword1").put("value",company.getName());
    //     data.getJSONObject("keyword2").put("value",company.getAddress());
    //     data.getJSONObject("keyword3").put("value",WarnSummaryType.getName(warnSummary.getWarnType())+"告警");
    //     data.getJSONObject("keyword4").put("value",ColorLevelTime.getName(warnSummary.getWarnLevel()));
    //     data.getJSONObject("keyword5").put("value",DateUtils.format(warnSummary.getCreatedTime(),DateUtils.DATE_TIME_PATTERN));
    //     data.getJSONObject("remark").put("value",warnSummary.getDescription());

    //     HttpHeaders httpHeaders = new HttpHeaders();
    //     httpHeaders.add("Content-Type","application/json");
    //     JSONObject sendResult = restService.postForObjectByHeader(apiUrl + "message/template/send?access_token=" + token, message, httpHeaders);
    //     if(!sendResult.getString("errmsg").equals("ok")){
    //         logger.error("微信公众号消息发送失败");
    //     }
    // }

    // 删除数据

    // 修改数据

    // 删除数据
}
   

