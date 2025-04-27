package com.zjw.structural_patterns.facade.video;

/**
 * 视频文件
 */
public class VideoFile {

    /**
     * 名字
     */
    private String name;

    /**
     * 编码类型
     */
    private String codecType;

    public VideoFile(String name) {
        this.name = name;
        this.codecType = name.substring(name.indexOf(".") + 1);
    }

    public String getCodecType() {
        return codecType;
    }

    public String getName() {
        return name;
    }
}