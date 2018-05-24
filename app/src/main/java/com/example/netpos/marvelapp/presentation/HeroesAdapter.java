package com.example.netpos.marvelapp.presentation;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.netpos.marvelapp.R;
import com.example.netpos.marvelapp.data.model.Character;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.List;

public class HeroesAdapter extends RecyclerView.Adapter<HeroesAdapter.ViewHolder> {
    private Context context;
    private List<Character> characters;

    public HeroesAdapter(Context context, List<Character> characters) {
        this.context = context;
        this.characters = characters;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivCharacter;
        private TextView tvName;
        private TextView tvDescription;
        private ProgressBar pbImage;

        ViewHolder(View itemView) {
            super(itemView);
            ivCharacter = itemView.findViewById(R.id.iv_character);
            tvName = itemView.findViewById(R.id.tvName);
            tvDescription = itemView.findViewById(R.id.tvDescription);
            pbImage = itemView.findViewById(R.id.pb_image);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);

        View listCharacter = inflater.inflate(R.layout.item_list_character_adapter, parent, false);
        return new ViewHolder(listCharacter);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        Character character = characters.get(position);

        holder.pbImage.setVisibility(View.VISIBLE);
        Picasso.with(holder.ivCharacter.getContext()).load(character.getThumbnail().getImage()).into(holder.ivCharacter, new Callback() {
            @Override
            public void onSuccess() {
                holder.pbImage.setVisibility(View.GONE);
            }

            @Override
            public void onError() {

            }
        });

        holder.tvName.setText(character.getName());
        holder.tvDescription.setText(character.getDescription());
    }

    @Override
    public int getItemCount() {
        return characters.size();
    }
}
