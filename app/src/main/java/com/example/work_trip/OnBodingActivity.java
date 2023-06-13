package com.example.work_trip;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaParser;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class OnBodingActivity extends AppCompatActivity {

    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_boding);

        // 노래 재생
        mp = MediaPlayer.create(this, R.raw.busy_music);
        mp.setLooping(false);
        mp.start();

        // 영상 재생
        Uri uri = Uri.parse("android.resource://com.example.work_trip/"+R.raw.busy);
        MediaController mediaController = new MediaController(this);
        VideoView videoView = (VideoView)findViewById(R.id.video_view1);
        videoView.setMediaController(mediaController);
        videoView.setVideoURI(uri);
        videoView.start();

        Button btn = (Button) this.findViewById(R.id.next);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), OnBoding02Activity.class);
                startActivity(intent);
                mp.pause();
                videoView.pause();
                finish();
            }
        });

    }
}