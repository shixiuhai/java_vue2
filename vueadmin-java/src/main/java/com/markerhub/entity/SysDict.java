package com.markerhub.entity;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;

@Data
public class SysDict implements Serializable {
    @TableId(value = "id",type = IdType.AUTO)
    private Long id;
    private String dicName;
    private int type;
    private String name;
    private int status;
    @DateTimeFormat(pattern = "yyyy-MM-dd") //前端传入
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8") // 后端传出
    private Date createdTime;

}
