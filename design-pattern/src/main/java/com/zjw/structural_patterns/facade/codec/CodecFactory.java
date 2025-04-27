package com.zjw.structural_patterns.facade.codec;

import com.zjw.structural_patterns.facade.video.VideoFile;

/**
 * 编码器工厂
 */
public class CodecFactory {

    /**
     * 根据文件类型获取编码器
     */
    public static Codec extract(VideoFile file) {
        String type = file.getCodecType();
        if (type.equals("mp4")) {
            System.out.println("CodecFactory: extracting mpeg audio...");
            return new MPEG4CompressionCodec();
        }
        else {
            System.out.println("CodecFactory: extracting ogg audio...");
            return new OggCompressionCodec();
        }
    }
}