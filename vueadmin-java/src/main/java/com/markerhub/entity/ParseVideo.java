package com.markerhub.entity;
import lombok.Data;
import java.io.Serializable;
// import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

@Data
public class ParseVideo implements Serializable{

    /**
     * <pre>
     * 
     * </pre>
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer	id;

    /**
     * <pre>
     * 三方视频解析链接
     * </pre>
     */
    private String	parseLink;

    /**
     * <pre>
     * 三方解析链接的别称
     * </pre>
     */
    private String	parseName;

    /**
     * <pre>
     * 生成记录时间
     * </pre>
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd") //前端传入
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8") // 后端传出
    private Date	createdTime;




}