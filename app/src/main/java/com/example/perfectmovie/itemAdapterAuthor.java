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

public class itemAdapterAuthor extends RecyclerView.Adapter<itemAdapterAuthor.ViewHolder> {

    private Context context;
    private ArrayList<AuthorRoot> list;


    public itemAdapterAuthor(Context context, ArrayList<AuthorRoot> list) {
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
        AuthorRoot kino = list.get(position);
        holder.tv2.setText("Должность: " +  kino.professionText);
        Picasso.with(context).load(kino.posterUrl).into(holder.iv);
        if (!Objects.equals(kino.nameRu, "")){
            holder.tv.setText(kino.nameRu);
        }else {
            holder.tv.setText(kino.nameEn);
        }



    }
    //
    @Override
    public int getItemCount() {
        return list.size();
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
//
//                    Kino kino = list.items.get(position);
//                    Toast.makeText(context, Integer.toString(kino.kinopoiskId), Toast.LENGTH_SHORT).show();
//                    Intent intent = new Intent(context, InfoActivity.class);
//                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                    intent.putExtra("id", kino.kinopoiskId);
//                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                    intent.putExtra("id", manga.getId());
//                    intent.putExtra("name", manga.getName());
//                    intent.putExtra("img", manga.getImg());
//                    intent.putExtra("info", manga.getDetail());
//                    intent.putExtra("author", manga.getFio());
//                    intent.putExtra("score", manga.getScore());
//                    context.startActivity(intent);


                }
            });

        }
    }
}
