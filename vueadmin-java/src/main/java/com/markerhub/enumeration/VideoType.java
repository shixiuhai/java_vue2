package com.markerhub.enumeration;


import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum VideoType {
    mj(4,"美剧"),
    hj(5,"韩剧"),
    hy(6,"华语"),
    zy(9,"综艺"),
    dj(10,"电影"),
    dm(11,"动漫");
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
