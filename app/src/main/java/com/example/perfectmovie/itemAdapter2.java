package com.example.perfectmovie;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Objects;

public class itemAdapter2 extends RecyclerView.Adapter<itemAdapter2.ViewHolder> {

    private Context context;
    private RootExpended list;


    public itemAdapter2(Context context, RootExpended list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Release kino = list.releases.get(position);
        if (!Objects.equals(kino.nameRu, "")){
            holder.tv.setText(kino.nameRu);
        }else {
            holder.tv.setText(kino.nameEn);
        }

        holder.tv2.setText("Дата релиза: " + kino.releaseDate);

        Picasso.with(context).load(kino.posterUrl).into(holder.iv);



    }
    //
    @Override
    public int getItemCount() {
        return list.releases.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView tv;
        ImageView iv;

        TextView tv2;
        private final Context context;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            context = itemView.getContext();

            tv = itemView.findViewById(R.id.item_tv);
            iv = itemView.findViewById(R.id.item_iv);
            tv2 = itemView.findViewById(R.id.dop_tv);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();

                    Release kino = list.releases.get(position);
                    //Toast.makeText(context, Integer.toString(kino.filmId), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(context, InfoActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.putExtra("id", kino.filmId);
//                    intent.putExtra("name", manga.getName());
//                    intent.putExtra("img", manga.getImg());
//                    intent.putExtra("info", manga.getDetail());
//                    intent.putExtra("author", manga.getFio());
//                    intent.putExtra("score", manga.getScore());
                    context.startActivity(intent);
                    MainActivity activity = (MainActivity) context;
                    activity.overridePendingTransition(R.anim.animation,R.anim.anim2);


                }
            });

        }
    }
}
