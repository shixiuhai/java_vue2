package com.markerhub.entity;

import com.baomidou.mybatisplus.annotation.TableField;

import lombok.Data;
import lombok.EqualsAndHashCode;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
@Data
public class BusinessLoan  implements Serializable{

    /**
     * <pre>
     * 
     * </pre>
     */
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
    private Date	startTime;

    /**
     * <pre>
     * 借款结束时间
     * </pre>
     */
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
