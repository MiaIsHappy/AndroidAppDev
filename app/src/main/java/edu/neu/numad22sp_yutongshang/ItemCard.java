package edu.neu.numad22sp_yutongshang;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

public class ItemCard implements ItemClickListener {

  //  private final int imageSource;
    private final String itemName;
    private final String itemUrl;
    private final String itemDesc;
    private boolean isChecked;

    //Constructor
    public ItemCard(String itemName, String itemUrl,String itemDesc,boolean isChecked) {
    //    this.imageSource = 0;
        this.itemName = itemName;
        this.itemUrl = itemUrl;
        this.itemDesc = itemDesc;
        this.isChecked = isChecked;

        Log.d("ASDF_3"," name: "+this.itemName+" url: "+ this.itemUrl+" desc: "+this.itemDesc+" ck: "+this.isChecked);
    }

    //Getters for the imageSource, itemName and itemDesc
//    public int getImageSource() {
//        return 0;
//    }

    public String getItemDesc() {
        return itemDesc;
    }

    public String getItemName() {
        return itemName;
    }

    public String getItemUrl() {
        return itemUrl;
    }


    public boolean getStatus() {
        return isChecked;
    }


    @Override
    public void onItemClick(int position) {
        isChecked = !isChecked;
    }

    @Override
    public void onCheckBoxClick(int position) {
        isChecked = !isChecked;
    }

}