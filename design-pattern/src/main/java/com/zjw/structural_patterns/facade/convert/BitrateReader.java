package com.zjw.structural_patterns.facade.convert;

import com.zjw.structural_patterns.facade.codec.Codec;
import com.zjw.structural_patterns.facade.video.VideoFile;

/**
 * 比特率读取转换
 */
public class BitrateReader {
    public static VideoFile read(VideoFile file, Codec codec) {
        System.out.println("BitrateReader : reading file...");
        return file;
    }

    public static VideoFile convert(VideoFile buffer, Codec codec) {
        System.out.println("BitrateReader: writing file...");
        return buffer;
    }
}