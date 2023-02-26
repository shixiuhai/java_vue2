package com.markerhub.enumeration;


import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum VideoType {
    d(4,"美剧"),
    e(5,"韩剧"),
    f(6,"华语"),
    i(9,"综艺"),
    j(10,"电影"),
    k(11,"动漫");
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
