package com.example.perfectmovie;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DopInfoActivity extends AppCompatActivity {


    Apiinterface apiinterface;
    ProgressBar pr;

    RecyclerView recyclerView;

    Button btn;

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dop_info);


        Bundle arguments = getIntent().getExtras();
        String id = arguments.get("id").toString();


        pr = findViewById(R.id.prog);

        recyclerView = findViewById(R.id.recycler_view);
        apiinterface = ServiceBuilder.requestBuilder().create(Apiinterface.class);

        btn = findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DopInfoActivity.this, InfoActivity.class);
                intent.putExtra("id", id);
                startActivity(intent);
                overridePendingTransition(R.anim.animation,R.anim.anim2);

            }
        });

        tv = findViewById(R.id.tv);

//        itemAdapterAuthor

        Call<ArrayList<AuthorRoot>> call_Author = apiinterface.getAuthor(id);

        call_Author.enqueue(new Callback<ArrayList<AuthorRoot>>() {
            @Override
            public void onResponse(Call<ArrayList<AuthorRoot>> call, Response<ArrayList<AuthorRoot>> response) {
                pr.setVisibility(View.INVISIBLE);
//                for (AuthorRoot au: list) {
//                    tv.append(au.nameRu);
//                }
                recyclerView.setLayoutManager(new LinearLayoutManager(DopInfoActivity.this));
                recyclerView.setHasFixedSize(true);
                ArrayList<AuthorRoot> list = response.body();
                itemAdapterAuthor adapter = new itemAdapterAuthor(DopInfoActivity.this, list);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<ArrayList<AuthorRoot>> call, Throwable t) {
                Toast.makeText(DopInfoActivity.this, "123456", Toast.LENGTH_SHORT).show();
            }
        });


    }
}