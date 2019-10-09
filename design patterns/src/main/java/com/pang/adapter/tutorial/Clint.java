package com.pang.adapter.tutorial;

import org.junit.jupiter.api.Test;

/**
 * @author pang
 * @version V1.0
 * @ClassName: Clint
 * @Package com.pang.adapter.tutorial
 * @description:
 * @date 2019/10/9 20:18
 */
public class Clint {
    @Test
    public void test(){
        AudioPlayer audioPlayer = new AudioPlayer();

        audioPlayer.play( "beyond the horizon.mp3");
        audioPlayer.play( "alone.mp4");
        audioPlayer.play( "far far away.vlc");
        audioPlayer.play("mind me.avi");

    }
}
