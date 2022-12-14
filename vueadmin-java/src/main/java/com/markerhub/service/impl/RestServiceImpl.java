package com.markerhub.service.impl;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.markerhub.common.exception.RRException;
import com.markerhub.service.RestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;


/**
 * @author lclc
 */
@Service
public class RestServiceImpl implements RestService {

    private static final Logger logger = LoggerFactory.getLogger(RestServiceImpl.class);

    @Autowired
    private final RestTemplate restTemplate;

    @Autowired
    public RestServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public JSONObject postForArray(String url, HttpEntity<Map<String, Object>> requestEntity) {
        JSONObject object = new JSONObject();
        try {
            JSONArray array = this.restTemplate.postForObject(url, requestEntity, JSONArray.class);
            object.put("data", array);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RRException("网络问题，稍后重试");
        }
        return object;
    }

    @Override
    public JSONObject getForObject(String url, Map<String, Object> params) {
        JSONObject object = new JSONObject();
        try {
            JSONObject json = this.restTemplate.getForObject(url, JSONObject.class, params);
            object.put("data", json);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RRException("网络问题，稍后重试");
        }
        return object;
    }

    @Override
    public JSONObject getForArray(String url, Map<String, Object> params) {
        JSONObject object = new JSONObject();
        try {
            JSONArray json = this.restTemplate.getForObject(url, JSONArray.class, params);
            object.put("data", json);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RRException("网络问题，稍后重试");
        }
        return object;
    }

    @Override
    public ResponseEntity<String> postForOEntity(String url, HttpEntity httpEntity) {
        try {
            return this.restTemplate.postForEntity(url, httpEntity,String.class);
        } catch (Exception e) {
            logger.error("error occurred during rest request", e);
            throw new RRException("网络问题，稍后重试");
        }
    }

    @Override
    public JSONObject postForObject(String url, HttpEntity<Map<String, Object>> requestEntity) {
        return postForObject(url, requestEntity, JSONObject.class);
    }

    @Override
    public <T> T postForObject(String url, HttpEntity<Map<String, Object>> requestEntity, Class<T> targetType) {
        try {
            return this.restTemplate.postForObject(url, requestEntity, targetType);
        } catch (Exception e) {
            logger.error("error occurred during rest request", e);
            throw new RRException("网络问题，稍后重试");
        }
    }

    @Override
    public JSONObject postForObjectByHeader(String url, Object param, HttpHeaders header) {
        try {
            HttpEntity httpEntity=new HttpEntity(param,header);
            return this.restTemplate.postForObject(url, httpEntity,JSONObject.class,header);
        } catch (Exception e) {
            logger.error("error occurred during rest request", e);
            throw new RRException("网络问题，稍后重试");
        }
    }
    @Override
    public JSONObject get(String url, Map<String, Object> params) {
        url+="?";
        for (Map.Entry entry:params.entrySet()){
            url+=entry.getKey()+"="+entry.getValue()+"&";
        }
        JSONObject json = this.restTemplate.getForObject(url, JSONObject.class, params);
        return json;
    }

    @Override
    public JSONObject postForParams(String url, Map<String, Object> params) {
        HttpEntity httpEntity=new HttpEntity(params);
        url+="?";
        for (Map.Entry entry:params.entrySet()){
            url+=entry.getKey()+"="+entry.getValue()+"&";
        }
        ResponseEntity<JSONObject> json = this.restTemplate.exchange(url, HttpMethod.POST,httpEntity, JSONObject.class,params);
        return json.getBody();
    }

    @Override
    public JSONObject get(String url, Map<String, Object> params, HttpHeaders header) {
        HttpEntity httpEntity=new HttpEntity(params,header);
        url+="?";
        for (Map.Entry entry:params.entrySet()){
            url+=entry.getKey()+"="+entry.getValue()+"&";
        }
        ResponseEntity<JSONObject> json = this.restTemplate.exchange(url, HttpMethod.GET,httpEntity, JSONObject.class,params);
        return json.getBody();
    }

    @Override
    public <T> T get(String url, Map<String, Object> params, Class<T> t) {
        url+="?";
        for (Map.Entry entry:params.entrySet()){
            url+=entry.getKey()+"="+entry.getValue()+"&";
        }
        T json = this.restTemplate.getForObject(url, t, params);
        return json;
    }
}
