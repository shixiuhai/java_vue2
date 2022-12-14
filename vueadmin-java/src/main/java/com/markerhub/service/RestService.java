package com.markerhub.service;

import com.alibaba.fastjson.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

import java.util.Map;


/**
 * @author lclc
 */
public interface RestService {


    JSONObject postForArray(String url, HttpEntity<Map<String, Object>> requestEntity);

    // get常用
    JSONObject get(String url, Map<String, Object> params);

    /**
     * post调用参数放在url里
     * @param url
     * @param params
     * @return
     */
    // post 常用
    JSONObject postForParams(String url, Map<String, Object> params);
    <T> T get(String url, Map<String, Object> params,Class<T> t);

    JSONObject getForObject(String url, Map<String, Object> params);

    JSONObject getForArray(String url, Map<String, Object> params);
    <T> T postForObject(String url, HttpEntity<Map<String, Object>> requestEntity, Class<T> targetType);
    JSONObject postForObject(String url, HttpEntity<Map<String, Object>> requestEntity);

    JSONObject postForObjectByHeader(String url, Object param, HttpHeaders header);

    JSONObject get(String url, Map<String, Object> params, HttpHeaders header);

    ResponseEntity<String> postForOEntity(String url, HttpEntity httpEntity);
}
