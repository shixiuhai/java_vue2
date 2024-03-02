package com.markerhub.common.dto;

import lombok.Data;

@Data
public class Message {
    private String userId;
    private String content;
    private String name;
}
