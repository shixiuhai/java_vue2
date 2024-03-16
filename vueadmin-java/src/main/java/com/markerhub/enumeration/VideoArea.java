package com.markerhub.enumeration;


import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum VideoArea {
    nd(1,"内地"),
    hg(2,"韩国"),
    om(3,"欧美"),
    rb(4,"日本");
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

