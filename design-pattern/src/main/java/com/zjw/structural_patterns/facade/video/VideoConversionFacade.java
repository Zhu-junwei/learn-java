package com.zjw.structural_patterns.facade.video;

import com.zjw.structural_patterns.facade.convert.BitrateReader;
import com.zjw.structural_patterns.facade.audio.AudioMixer;
import com.zjw.structural_patterns.facade.codec.Codec;
import com.zjw.structural_patterns.facade.codec.CodecFactory;
import com.zjw.structural_patterns.facade.codec.MPEG4CompressionCodec;
import com.zjw.structural_patterns.facade.codec.OggCompressionCodec;

import java.io.File;

/**
 * 外观模式：视频转换提供的接口
 */
public class VideoConversionFacade {
    public File convertVideo(String fileName, String format) {
        System.out.println("VideoConversionFacade: conversion started.");
        VideoFile file = new VideoFile(fileName);
        Codec sourceCodec = CodecFactory.extract(file);
        Codec destinationCodec;
        if (format.equals("mp4")) {
            destinationCodec = new MPEG4CompressionCodec();
        } else {
            destinationCodec = new OggCompressionCodec();
        }
        VideoFile buffer = BitrateReader.read(file, sourceCodec);
        VideoFile intermediateResult = BitrateReader.convert(buffer, destinationCodec);
        File result = (new AudioMixer()).fix(intermediateResult);
        System.out.println("VideoConversionFacade: conversion completed.");
        return result;
    }
}