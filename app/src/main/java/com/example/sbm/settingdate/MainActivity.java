package com.example.sbm.settingdate;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import static com.example.sbm.settingdate.R.id.textView2;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView mTextView;
    TextView nTextView;
    TextView oTextView;

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = (TextView) findViewById(R.id.textView1);

        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(this);

        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(this);

        nTextView = (TextView) findViewById(textView2);

        oTextView = (TextView) findViewById(textView2);

        Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(this);

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button1) {
            Intent intent1 = new Intent(this, Time.class);
            startActivityForResult(intent1, 0);
        } else if (v.getId() == R.id.button2) {
            Intent intent2 = new Intent(this, Day.class);
            startActivityForResult(intent2, 1);
        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 0) {
            if (resultCode == RESULT_OK) {
                String text = data.getStringExtra("Timedata");
                TextView textView2 = (TextView) findViewById(R.id.textView2);
                textView2.setText(text);
            }
        }else if(requestCode == 1){
            if (resultCode == RESULT_OK) {
                String text = data.getStringExtra("Daydata");
                TextView textView3 = (TextView) findViewById(R.id.textView3);
                textView3.setText(text);
            }
         }
    }

    //protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //if (requestCode == Day) {
            //if (resultCode == RESULT_OK) {
                //String text = data.getStringExtra("Daydata");
                //TextView textView3 = (TextView) findViewById(R.id.textView3);
                //textView3.setText(text);
            //}
        //}
    //}

}
