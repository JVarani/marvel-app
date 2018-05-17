package com.example.netpos.marvelapp.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.netpos.marvelapp.R;
import com.example.netpos.marvelapp.model.Character;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.util.List;

public class CharacterListAdapter extends RecyclerView.Adapter<CharacterListAdapter.ViewHolder> {
    private Context context;
    private List<Character> characters;

    public CharacterListAdapter(Context context, List<Character> characters) {
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
