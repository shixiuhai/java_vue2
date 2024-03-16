package com.markerhub.enumeration;


import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum VideoType {
    mj(1,"美剧"),
    hj(2,"韩剧"),
    hy(3,"华语"),
    zy(4,"综艺"),
    dj(5,"电影"),
    dm(6,"动漫");
    private Integer type;
    private String name;
    public static Integer getType(String name){
        for(VideoType videoType: VideoType.values()){
            if(videoType.name.equals(name)){
                return videoType.type;
            }
        }
        return null;
    }

    
}
