package edu.neu.numad22sp_yutongshang;

import android.content.Intent;
import android.net.Uri;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RviewHolder extends RecyclerView.ViewHolder {
   // public ImageView itemIcon;
    public TextView itemName;
    public TextView itemUrl;
    public TextView itemDesc;
    public CheckBox checkBox;

    public RviewHolder(View itemView) {
        super(itemView);
      //  itemIcon = itemView.findViewById(R.id.item_icon);
        itemName = itemView.findViewById(R.id.item_name);
        itemUrl= itemView.findViewById(R.id.item_url);
        itemDesc = itemView.findViewById(R.id.item_desc);
       // checkBox = itemView.findViewById(R.id.checkbox);

       itemUrl.setMovementMethod(LinkMovementMethod.getInstance());
//       String url = itemUrl.getText().toString();
//       Intent i = new Intent(Intent.ACTION_VIEW);
//       i.setData(Uri.parse(url));
//       startActivity(i);
//
//        itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (listener != null) {
//                    int position = getLayoutPosition();
//                    if (position != RecyclerView.NO_POSITION) {
//
//                        listener.onItemClick(position);
//                    }
//                }
//            }
//        });

//        checkBox.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (listener != null) {
//                    int position = getLayoutPosition();
//                    if (position != RecyclerView.NO_POSITION) {
//                        listener.onCheckBoxClick(position);
//                    }
//                }
//            }
//        });
    }
}
