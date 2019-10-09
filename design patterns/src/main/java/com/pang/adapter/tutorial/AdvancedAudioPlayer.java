package com.pang.adapter.tutorial;

/**
 * @author pang
 * @version V1.0
 * @ClassName: AdvancedAudioPlayer
 * @Package com.pang.adapter.tutorial
 * @description:
 * @date 2019/10/9 20:26
 */
public class AdvancedAudioPlayer implements AdvancedMediaPlayer {
    @Override
    public void playVlc(String fileName) {
        if (fileName.endsWith(".vlc")) {
            System.out.println("播放了.vlc音乐" + fileName);
        } else {
            System.err.println("VLC播放器传入文件格式错误，无法播放" + fileName);
        }
    }

    @Override
    public void playMp4(String fileName) {
        if (fileName.endsWith(".mp4")) {
            System.out.println("播放了.mp4音乐" + fileName);
        } else {
            System.err.println("MP4播放器传入文件格式错误，无法播放" + fileName);
        }
    }
}
