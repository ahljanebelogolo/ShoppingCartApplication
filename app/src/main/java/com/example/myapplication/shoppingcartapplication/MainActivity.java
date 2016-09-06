package com.example.myapplication.shoppingcartapplication;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity {

    private TextView myContent;
    private ArrayList<ShoppingCart> shoppingList= new ArrayList<ShoppingCart>();
    ShoppingCart shoppingCartAdd = null;
    ListView itemListView;
    private double overAllTotal = 0.00;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.myapplication.shoppingcartapplication.R.layout.activity_main);
        itemListView = (ListView) findViewById(com.example.myapplication.shoppingcartapplication.R.id.listView);
    }

    public void onClickScan(View v)
    {
        try {
            Intent startScannerActivity = new Intent(getApplicationContext(), ScannerActivity.class);
            startActivityForResult(startScannerActivity, 1);
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }


    public void onClickSenSms(View v){

        try{

            Intent smsIntent = new Intent(Intent.ACTION_VIEW);
            smsIntent.setType("vnd.android-dir/mms-sms");
            smsIntent.putExtra("sms_body", messageReturn());
            startActivity(smsIntent);

        }
        catch(Exception e){
            e.printStackTrace();
        }
    }


    private String messageReturn() {

        ShoppingCart temporary = null;

        String message = "";
        for(int i=0; i<shoppingList.size(); i++){
            temporary = shoppingList.get(i);
            message += "Item: " + temporary.getItemName() + System.getProperty("line.separator")
                    + "Quantity: " + temporary.getItemQuantity() + System.getProperty("line.separator")
                    + "Price: " + temporary.getItemPrice() + System.getProperty("line.separator")
                    + "Total Price by item: " + temporary.getItemTotalPrice() + System.getProperty("line.separator") + "\n";

        }
        message += "Total price of all item: " + overAllTotal + "\n";
        return message;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1)
        {
            if(resultCode == RESULT_OK){
                String mydata = data.getStringExtra("myData");
                addToList(mydata);
            }
        }
    }

    public void addToList(String mydata){

        int count = 0;
        ArrayList<String> stringArray = new ArrayList<String>();
        StringTokenizer myTokenizer = new StringTokenizer(mydata,"|||");
        while(myTokenizer.hasMoreTokens()){
            stringArray.add(myTokenizer.nextToken());
        }



        shoppingCartAdd = new ShoppingCart(stringArray.get(0), Integer.parseInt(stringArray.get(1)),
                Double.parseDouble(stringArray.get(2)), Integer.parseInt(stringArray.get(1))
                *Double.parseDouble(stringArray.get(2)));
        shoppingList.add(shoppingCartAdd);

        overAllTotal += Double.parseDouble(String.valueOf(shoppingCartAdd.getItemTotalPrice()));

        ShoppingCartAdapter adapter = new ShoppingCartAdapter(this, com.example.myapplication.shoppingcartapplication.R.layout.list_view, shoppingList);
        itemListView.setAdapter(adapter);


    }








}
