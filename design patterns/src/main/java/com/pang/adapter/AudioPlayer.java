package com.pang.adapter;

/**
 * @author pang
 * @version V1.0
 * @ClassName: AudioPlayer
 * @Package com.pang.adapter.tutorial
 * @description:
 * @date 2019/10/9 20:24
 */
public class AudioPlayer implements MediaPlayer {
    MediaAdapter mediaAdapter;

    @Override
    public void play(String fileName) {
        if (fileName.endsWith(".mp3")) {
            System.out.println("播放了.mp3音乐" + fileName);
        }else {
            mediaAdapter=new MediaAdapter(fileName);
            mediaAdapter.play(fileName);
        }
    }
}
