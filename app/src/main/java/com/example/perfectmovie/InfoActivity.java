package com.example.perfectmovie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InfoActivity extends AppCompatActivity {

    Apiinterface apiinterface;

    ProgressBar pr;

    TextView name_tv;
    TextView author_tv;
    TextView ocenka_tv;
    TextView diskr_tv;
    WebView video_tv;
    ImageView img_tv;

    Button btnBack;
    Button btnPodrobnee;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        Bundle arguments = getIntent().getExtras();
        int id = Integer.parseInt(arguments.get("id").toString());

        pr = findViewById(R.id.prog);

        name_tv = findViewById(R.id.name_tv);
        img_tv = findViewById(R.id.item_iv);

        author_tv = findViewById(R.id.author_tv);
        ocenka_tv = findViewById(R.id.ocenka_tv);

        diskr_tv = findViewById(R.id.disk_tv);
        video_tv = findViewById(R.id.videoView);

        btnBack = findViewById(R.id.button);
        btnPodrobnee = findViewById(R.id.button2);




        apiinterface = ServiceBuilder.requestBuilder().create(Apiinterface.class);
        Call<InfoRoot> getList = apiinterface.getFilmInfo(id);

        Call<VideoRoot> getVideo = apiinterface.getVideo(id);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(InfoActivity.this, MainActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.animation,R.anim.anim2);
            }
        });

        btnPodrobnee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(InfoActivity.this, DopInfoActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("id", id);
                startActivity(intent);
                overridePendingTransition(R.anim.animation,R.anim.anim2);
            }
        });


        getVideo.enqueue(new Callback<VideoRoot>() {
            @Override
            public void onResponse(Call<VideoRoot> call, Response<VideoRoot> response) {
                VideoRoot kino = response.body();
                try {
                    video_tv.setWebViewClient(new webViewClient());
                    video_tv.loadUrl(kino.items.get(0).url);
                    video_tv.getSettings().setJavaScriptEnabled(true);
                }catch (Exception e){

                }



            }

            @Override
            public void onFailure(Call<VideoRoot> call, Throwable t) {

            }
        });


        getList.enqueue(new Callback<InfoRoot>() {
            @Override
            public void onResponse(Call<InfoRoot> call, Response<InfoRoot> response) {
                pr.setVisibility(View.INVISIBLE);
                InfoRoot kino = response.body();
                try {
                    name_tv.append(kino.nameRu);
                }catch (Exception e){

                }
                author_tv.append(Integer.toString(kino.year));
                ocenka_tv.append((Double.toString(kino.ratingKinopoisk)));



                try {
                    diskr_tv.append(kino.description);
                }catch (Exception e){

                }

                Picasso.with(InfoActivity.this).load(kino.posterUrl).into(img_tv);
//                Picasso.with(InfoActivity.this).load(kino.).into(img_tv);
            }

            @Override
            public void onFailure(Call<InfoRoot> call, Throwable t) {
                name_tv.setText(t.toString());
            }
        });
        
    }


    class webViewClient extends WebViewClient {
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
        }

        @Override
        public void onPageFinished(WebView view, String url) {

            super.onPageFinished(view, url);
        }
    }
}