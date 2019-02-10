package com.hdcompany.simpletodo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import static com.hdcompany.simpletodo.MainActivity.ITEM_POSITION;
import static com.hdcompany.simpletodo.MainActivity.ITEM_TEXT;

public class Edit_ItemActivity extends AppCompatActivity {

    //  Track edit text
    EditText etItemText;
    // Position Of edited Item in List
    int position ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit__item);
        // resolve edit text from layout
        etItemText=(EditText)findViewById(R.id.etItemText);
        // set edit  value from intent Extra
        etItemText.setText(getIntent().getStringExtra(ITEM_TEXT));
        // Update position
        position = getIntent().getIntExtra(ITEM_POSITION,0);
        //update the title bar of the activity
        getSupportActionBar().setTitle("Modification");

    }// Handler for save button
    public void onSaveItem(View v ){
        //prepare new intentfor result
        Intent i = new Intent();
        // pass updatee Item as Extra
        i.putExtra(ITEM_TEXT,etItemText.getText().toString());
        //pass the original position as Extra
        i.putExtra(ITEM_POSITION, position);
        //set the intent as the result of the activity
        setResult(RESULT_OK,i);
        // close the activity and  redirect to main
        finish();
    }
}
