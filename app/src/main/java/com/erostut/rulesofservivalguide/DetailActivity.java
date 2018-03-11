package com.erostut.rulesofservivalguide;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class DetailActivity extends YouTubeBaseActivity {

    Button btnFreeDiamond;
    WebView webview;
    YouTubePlayerView youTubePlayerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        int index = getIntent().getIntExtra("INDEX", 1);
        Log.e("INDEX", index + "");
        btnFreeDiamond = (Button) findViewById(R.id.btn4);
        webview = (WebView) findViewById(R.id.webview);
//        webview.setOnTouchListener(new View.OnTouchListener() {
//            float m_downX;
//            public boolean onTouch(View v, MotionEvent event) {
//
//                if (event.getPointerCount() > 1) {
//                    //Multi touch detected
//                    return true;
//                }
//
//                switch (event.getAction()) {
//                    case MotionEvent.ACTION_DOWN: {
//                        // save the x
//                        m_downX = event.getX();
//                        break;
//                    }
//                    case MotionEvent.ACTION_MOVE:
//                    case MotionEvent.ACTION_CANCEL:
//                    case MotionEvent.ACTION_UP: {
//                        // set x so that it doesn't move
//                        event.setLocation(m_downX, event.getY());
//                        break;
//                    }
//
//                }
//                return false;
//            }
//        });
//        webview.setHorizontalScrollBarEnabled(false);
        switch (index){
            case 1: webview.loadUrl("file:///android_asset/btn1.html"); break;
            case 2: webview.loadUrl("file:///android_asset/btn2.html"); break;
            case 3: webview.loadUrl("file:///android_asset/btn3.html"); break;
        }
        youTubePlayerView = (YouTubePlayerView) findViewById(R.id.youtube_player_view);
        youTubePlayerView.initialize("AIzaSyBos7JL5-UHFXj3YxuS9WxyFgeuU63tYXo", new YouTubePlayer.OnInitializedListener() {

            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                if (!b) {
                    youTubePlayer.setShowFullscreenButton(true);
                    youTubePlayer.cueVideo("nkc4pMkNXZg");
                }
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        });

        //youTubePlayer.loadVideo("nkc4pMkNXZg", 0);
        btnFreeDiamond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://zuneplay.com/gene2/rules-of-survival.html"));
                startActivity(browserIntent);
            }
        });
    }

    @Override
    public void finish() {
        super.finish();
    }
}
