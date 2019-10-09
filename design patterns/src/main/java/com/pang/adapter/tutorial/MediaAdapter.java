package com.pang.adapter.tutorial;

/**
 * @author pang
 * @version V1.0
 * @ClassName: MediaAdapter
 * @Package com.pang.adapter.tutorial
 * @description:
 * @date 2019/10/9 20:27
 */
public class MediaAdapter implements MediaPlayer {
    AdvancedMediaPlayer advancedMediaPlayer;

    public MediaAdapter(String fileName) {
        if (fileName.endsWith(".mp4") || fileName.endsWith(".vlc")) {
            advancedMediaPlayer = new AdvancedAudioPlayer();
        }else{
            System.err.println("适配出错");
        }
    }

    @Override
    public void play(String fileName) {
        if (fileName.endsWith(".mp4")) {
            advancedMediaPlayer.playMp4(fileName);
        } else if (fileName.endsWith(".vlc")) {
            advancedMediaPlayer.playVlc(fileName);
        }
    }
}
