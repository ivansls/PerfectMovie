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

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TopFilmsFragment extends Fragment {

    TextView tv;


    Apiinterface apiinterface;
    ProgressBar pr;

    RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_top_films, container, false);

        pr = view.findViewById(R.id.prog);
        apiinterface = ServiceBuilder.requestBuilder().create(Apiinterface.class);

//        tv = view.findViewById(R.id.tv);

        Call<Root1> call_Topfilms = apiinterface.getTopFilms();

        recyclerView = view.findViewById(R.id.recycler_view);

        call_Topfilms.enqueue(new Callback<Root1>() {
            @Override
            public void onResponse(Call<Root1> call, Response<Root1> response) {
                if (response.isSuccessful()){
                    pr.setVisibility(View.INVISIBLE);
//                    for (Kino kino : response.body().items){
//                        tv.append(kino.nameRu+"\n");
//                    }
                    if (response.isSuccessful()){
                        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                        recyclerView.setHasFixedSize(true);
                        Root1 list = response.body();
                        itemAdapter adapter = new itemAdapter(getContext(), list);
                        recyclerView.setAdapter(adapter);}

                }else {
                    Toast.makeText(getContext(), response.message(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Root1> call, Throwable t) {
                Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


        return view;
    }
}