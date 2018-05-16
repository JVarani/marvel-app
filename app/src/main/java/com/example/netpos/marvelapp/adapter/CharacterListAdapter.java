package com.example.netpos.marvelapp.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.netpos.marvelapp.R;
import com.example.netpos.marvelapp.model.Character;

import java.util.List;

public class CharacterListAdapter extends RecyclerView.Adapter<CharacterListAdapter.ViewHolder>{
    private Context context;
    private List<Character> characters;

    public CharacterListAdapter(Context context, List<Character> characters){
        this.context = context;
        this.characters = characters;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvName;

        ViewHolder(View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
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
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Character character = characters.get(position);
        holder.tvName.setText(character.getName());
    }

    @Override
    public int getItemCount() {
        return characters.size();
    }
}
