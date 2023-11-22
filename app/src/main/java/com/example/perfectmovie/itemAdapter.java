package com.example.perfectmovie;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

public class itemAdapter extends RecyclerView.Adapter<itemAdapter.ViewHolder> {

    private Context context;
    private Root1 list;


    public itemAdapter(Context context, Root1 list) {
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
        Kino kino = list.items.get(position);
        holder.tv.setText(kino.nameRu);
        holder.tv2.setText("Оценка КиноПоиска: " + Integer.toString((int) kino.ratingKinopoisk));
        Picasso.with(context).load(kino.posterUrl).into(holder.iv);



    }
//
    @Override
    public int getItemCount() {
        return list.items.size();
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

                    Kino kino = list.items.get(position);

                    Intent intent = new Intent(context, InfoActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.putExtra("id", kino.kinopoiskId);
//                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                    intent.putExtra("id", manga.getId());
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
