package com.zjw.structural_patterns.facade;

import com.zjw.structural_patterns.facade.video.VideoConversionFacade;

import java.io.File;


public class Demo {
    public static void main(String[] args) {
        VideoConversionFacade converter = new VideoConversionFacade();
        File mp4Video = converter.convertVideo("youtubevideo.ogg", "mp4");
        // ...
    }
}