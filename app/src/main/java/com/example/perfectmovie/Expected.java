package com.example.perfectmovie;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Expected extends Fragment {

    TextView tv;


    Apiinterface apiinterface;
    ProgressBar pr;

    RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_expected, container, false);

        pr = view.findViewById(R.id.prog);
        apiinterface = ServiceBuilder.requestBuilder().create(Apiinterface.class);



        Call<RootExpended> call_Topfilms = apiinterface.getExpectedFilms();

        recyclerView = view.findViewById(R.id.recycler_view);

        call_Topfilms.enqueue(new Callback<RootExpended>() {
            @Override
            public void onResponse(Call<RootExpended> call, Response<RootExpended> response) {
                if (response.isSuccessful()){
                    pr.setVisibility(View.INVISIBLE);
//                    for (Release kino : response.body().releases){
//                        tv.append(kino.nameRu+"\n");
//                    }
                    if (response.isSuccessful()){
                        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                        recyclerView.setHasFixedSize(true);
                        RootExpended list = response.body();
                        itemAdapter2 adapter = new itemAdapter2(getContext(), list);
                        recyclerView.setAdapter(adapter);}

                }else {
                    Toast.makeText(getContext(), response.message(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<RootExpended> call, Throwable t) {
                Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


        return view;
    }
}