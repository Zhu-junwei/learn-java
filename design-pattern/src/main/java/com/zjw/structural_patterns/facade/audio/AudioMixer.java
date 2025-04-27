package com.zjw.structural_patterns.facade.audio;

import com.zjw.structural_patterns.facade.video.VideoFile;

import java.io.File;

/**
 * 音频混合器/处理器
 */
public class AudioMixer {
    public File fix(VideoFile result){
        System.out.println("AudioMixer: fixing audio...");
        return new File("tmp");
    }
}