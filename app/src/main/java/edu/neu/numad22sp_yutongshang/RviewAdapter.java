package edu.neu.numad22sp_yutongshang;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RviewAdapter extends RecyclerView.Adapter<RviewHolder> {

    private final ArrayList<ItemCard> itemList;
    private ItemClickListener listener;

    //Constructor
    public RviewAdapter(ArrayList<ItemCard> itemList) {
        this.itemList = itemList;
    }

    public void setOnItemClickListener(ItemClickListener listener) {
        this.listener = listener;
    }

    @Override
    public RviewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card, parent, false);
        return new RviewHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(RviewHolder holder, int position) {
        ItemCard currentItem = itemList.get(position);
        Log.d("ASDF_156", "size "+itemList.size());
        Log.d("ASDF_y2","current item "+currentItem.getItemName());
        Log.d("ASDF_y3","current item "+currentItem.getItemUrl());
        Log.d("ASDF_y4","current item "+holder.itemDesc.getText());
        Log.d("ASDF_y5","current item "+currentItem.getStatus());

    //    holder.itemIcon.setImageResource(currentItem.getImageSource());
        //currentItem could be null? or ItemUrl?
        //Log.d("ASDF_1","current item"+currentItem.toString());
        holder.itemName.setText(currentItem.getItemName());

        holder.itemUrl.setText(currentItem.getItemUrl());

        holder.itemDesc.setText(currentItem.getItemDesc());

        holder.checkBox.setChecked(currentItem.getStatus());
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }
}

