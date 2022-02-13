package edu.neu.numad22sp_yutongshang;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity3 extends AppCompatActivity {
    //Creating the essential parts needed for a Recycler view to work: RecyclerView, Adapter, LayoutManager
    private ArrayList<ItemCard> itemList = new ArrayList<>();


    private RecyclerView recyclerView;
    private RviewAdapter rviewAdapter;
    private RecyclerView.LayoutManager rLayoutManger;
    private FloatingActionButton fab;

    private static final String KEY_OF_INSTANCE = "KEY_OF_INSTANCE";
    private static final String NUMBER_OF_ITEMS = "NUMBER_OF_ITEMS";



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Log.d("ASDF_x0","createeee");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        init(savedInstanceState);



        fab = findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//
                int pos = 0;
                popUpEditText(pos);
                //Snackbar.make(view, "Successfully Inserted URLs", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();

            }
        });

        //Specify what action a specific gesture performs, in this case swiping right or left deletes the entry
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

          @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                Toast.makeText(edu.neu.numad22sp_yutongshang.MainActivity3.this, "Delete an item", Toast.LENGTH_SHORT).show();
                int position = viewHolder.getLayoutPosition();
                itemList.remove(position);

                rviewAdapter.notifyItemRemoved(position);

            }
        });
        itemTouchHelper.attachToRecyclerView(recyclerView);
    }
    //end of OnCreate
    private void popUpEditText(int position) {
        LayoutInflater factory = LayoutInflater.from(this);
        final View textEntryView = factory.inflate(R.layout.dialog, null);
        final EditText editTextName = (EditText) textEntryView
                .findViewById(R.id.ownername);
        final EditText editTextNumEditText = (EditText) textEntryView
                .findViewById(R.id.ownerphone);
        AlertDialog.Builder ad1 = new AlertDialog.Builder(MainActivity3.this);
        ad1.setTitle("Add New URL ");
//        ad1.setIcon(android.R.drawable.ic_dialog_info);
        ad1.setView(textEntryView);
        ad1.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int i) {


              //  Toast.makeText(getApplicationContext(), "Successfully Added a URL: "+editTextName.getText().toString(), Toast.LENGTH_LONG).show();
                if(ishttpurl(editTextNumEditText.getText().toString())==true)
                {addItem(position, editTextName.getText().toString(),editTextNumEditText.getText().toString());
              Snackbar.make(getWindow().getDecorView().getRootView(), "Successfully Inserted URLs: "+editTextName.getText().toString(), Snackbar.LENGTH_LONG).setAction("Action", null).show();}
                else{
                    Snackbar.make(getWindow().getDecorView().getRootView(), "Invalid Url, Please Check! ", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                }
            }
        });
        ad1.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int i) {
                Snackbar.make(getWindow().getDecorView().getRootView(), "Cancel Adding Urls ", Snackbar.LENGTH_LONG).setAction("Action", null).show();

            }
        });
        ad1.show();
    }// End of popUpEdit Text

//    protected void onSaveInstanceState(@NonNull Bundle outState) {
//        int size = itemList == null ? 0 : itemList.size();
//        outState.putInt(NUMBER_OF_ITEMS, size);
//
//        // Need to generate unique key for each item
//        // This is only a possible way to do, please find your own way to generate the key
//        for (int i = 0; i < size; i++) {
//            // put image information id into instance
////            outState.putInt(KEY_OF_INSTANCE + i + "0", itemList.get(i).getImageSource());
//            // put itemName information into instance
//            outState.putString(KEY_OF_INSTANCE + i + "1", itemList.get(i).getItemName());
//            // put itemName information into instance
//            outState.putString(KEY_OF_INSTANCE + i + "2", itemList.get(i).getItemUrl());
//            // put itemDesc information into instance
//            outState.putString(KEY_OF_INSTANCE + i + "3", itemList.get(i).getItemDesc());
//            // put isChecked information into instance
//           // outState.putBoolean(KEY_OF_INSTANCE + i + "4", itemList.get(i).getStatus());
//        }
//        super.onSaveInstanceState(outState);
//    }//End of on Save IsntanceState

    private void init(Bundle savedInstanceState) {
        initialItemData(savedInstanceState);
        createRecyclerView();
    }//end of init

    private void initialItemData(Bundle savedInstanceState) {
        // Not the first time to open this Activity
        if (savedInstanceState != null && savedInstanceState.containsKey(NUMBER_OF_ITEMS)) {
            Log.d("ASDF_xx","item not null");
            if (itemList == null || itemList.size() == 0) {
                int size = savedInstanceState.getInt(NUMBER_OF_ITEMS);
                // Retrieve keys we stored in the instance
                for (int i = 0; i < size; i++) {
//                    Integer imgId = savedInstanceState.getInt(KEY_OF_INSTANCE + i + "0");
                    String itemName = savedInstanceState.getString(KEY_OF_INSTANCE + i + "1");
                    String itemUrl = savedInstanceState.getString(KEY_OF_INSTANCE + i + "2");
                    String itemDesc = savedInstanceState.getString(KEY_OF_INSTANCE + i + "3");
                  //  boolean isChecked = savedInstanceState.getBoolean(KEY_OF_INSTANCE + i + "4");

                    // We need to make sure names such as "XXX(checked)" will not duplicate
                    // Use a tricky way to solve this problem, not the best though
                   // if (isChecked) {
                    //    itemName = itemName.substring(0, itemName.lastIndexOf("("));
                    //}
                    ItemCard itemCard = new ItemCard(itemName, itemUrl, itemDesc);

                    itemList.add(itemCard);
                }
            }
        }
        // The first time to open this Activity
        else {
//            ItemCard item1 = new ItemCard("Google", "https://www.google.com", "Item id: 11111(Generated Randomly)");
//            itemList.add(item1);

        }
    }//initialItemData

    private void createRecyclerView() {
        rLayoutManger = new LinearLayoutManager(this);
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);

        rviewAdapter = new RviewAdapter(itemList);
//        ItemClickListener itemClickListener = new ItemClickListener() {
//            @Override
//            public void onItemClick(int position) {
//                //attributions bond to the item has been changed
//                itemList.get(position).onItemClick(position);
//
//                rviewAdapter.notifyItemChanged(position);
//            }

        //    @Override
//            public void onCheckBoxClick(int position) {
//                //attributions bond to the item has been changed
//                itemList.get(position).onCheckBoxClick(position);
//
//                rviewAdapter.notifyItemChanged(position);
//            }
      //  };
       // rviewAdapter.setOnItemClickListener(itemClickListener);

        recyclerView.setAdapter(rviewAdapter);
        recyclerView.setLayoutManager(rLayoutManger);
        //Log.d("ASDF_x6","created recycle view");
    }//createRecyclerView

    private void addItem(int position, String name, String url) {

        itemList.add(position, new ItemCard( name, url,"Item id: " + Math.abs(new Random().nextInt(100000))));
        Log.d("ASDF_2","pos: "+position+"name: "+name+"url: "+ url);
      //  Toast.makeText(edu.neu.numad22sp_yutongshang.MainActivity3.this, "Added an URL", Toast.LENGTH_SHORT).show();
        rviewAdapter.notifyItemInserted(position);
        Log.d("ASDF_4","tag");

    }//End of addItem

    public static boolean ishttpurl(String url){
        boolean is_url = false;
        //Set Reg Exp
        String regex = "(((https|http)?://)?([a-z0-9]+[.])|(www.))"
                + "\\w+[.|\\/]([a-z0-9]{0,})?[[.]([a-z0-9]{0,})]+((/[\\S&&[^,;\u4E00-\u9FA5]]+)+)?([.][a-z0-9]{0,}+|/?)";
        //Compare
        Pattern pat = Pattern.compile(regex.trim());
        Matcher mat = pat.matcher(url.trim());
        //Check
        is_url = mat.matches();
        if (is_url) {
            is_url = true;
        }
        return is_url;
    }

    }

