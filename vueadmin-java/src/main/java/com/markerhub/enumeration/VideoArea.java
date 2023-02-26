package com.markerhub.enumeration;


import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum VideoArea {
    a(1,"内地"),
    b(2,"韩国"),
    c(3,"欧美"),
    d(4,"日本");
    private Integer type;
    private String name;
    // 写一个通过中文名字获取type的方法
    public static Integer getType(String name){
        for(VideoArea videoArea: VideoArea.values()){
            if(videoArea.name.equals(name)){
                return videoArea.type;
            }
        }
        return null;
    }

    
}

