package com.markerhub.entity;

import lombok.Data;
import java.io.Serializable;
// import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

@Data
public class VideoDetail implements Serializable{

    /**
     * <pre>
     * 
     * </pre>
     */
    private Long	id;

    /**
     * <pre>
     * 信息表的id
     * </pre>
     */
    private Integer	informationId;

    /**
     * <pre>
     * 视频第几集
     * </pre>
     */
    private Integer	number;

    /**
     * <pre>
     * 视频url
     * </pre>
     */
    private String	url;

    /**
     * <pre>
     * 生成记录时间
     * </pre>
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd") //前端传入
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8") // 后端传出
    private Date	createdTime;




}