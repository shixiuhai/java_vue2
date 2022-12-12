package com.markerhub.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.EqualsAndHashCode;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;
@Data
public class BusinessLoan  implements Serializable{

    /**
     * <pre>
     * 
     * </pre>
     */
    @TableId(type= IdType.AUTO)
    private Long	id;

    /**
     * <pre>
     * 图片路径
     * </pre>
     */
    private String	image;

    /**
     * <pre>
     * 借款人姓名
     * </pre>
     */
    private String	brrowerName;

    /**
     * <pre>
     * 借款开始时间
     * </pre>
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    //@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    //@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date	startTime;

    /**
     * <pre>
     * 借款结束时间
     * </pre>
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date	endTime;

    /**
     * <pre>
     * 借款时长
     * </pre>
     */
    private String	BorrowingPeriod;

    /**
     * <pre>
     * 0 借款期中 1 借款逾期 
     * </pre>
     */
    private String	status;




}
