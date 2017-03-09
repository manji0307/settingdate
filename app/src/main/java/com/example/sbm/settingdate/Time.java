package com.example.sbm.settingdate;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Time extends AppCompatActivity {

    RadioGroup radioGroup;
    Button okbutton;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);

        textView = (TextView) findViewById(R.id.textView);

        // RadioGroup の取得
        radioGroup = (RadioGroup) findViewById(R.id.RadioGroup);

        // 指定した ID の RadioButton を選択
        //radioGroup.check(R.id.RadioButton1);

        // 選択されている RadioButton の ID を取得
        //int Id = radioGroup.getCheckedRadioButtonId();

        // 選択されている RadioButton が変わったときに呼び出されるコールバックを登録
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // 選択されている RadioButton の取得
                RadioButton radioButton = (RadioButton) findViewById(checkedId);

                // RadioButton のテキストを取得
                String text = radioButton.getText().toString();


                textView.setText(String.valueOf(text));
            }
        });

        Button okbutton = (Button) findViewById(R.id.okbutton);
        okbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //if (textView.getText() == "") {
                //   showAlertDialog();

                //}else {
                Intent intent = new Intent();
                intent.putExtra("Timedata", textView.getText() + "");
                setResult(RESULT_OK, intent);

                finish();
                //}
            }
        });

    }

    /*private void showAlertDialog() {
        // AlertDialog.Builderクラスを使ってAlertDialogの準備をする
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("NG");
        alertDialogBuilder.setMessage("選択されてません！");

        // 肯定ボタンに表示される文字列、押したときのリスナーを設定する
        alertDialogBuilder.setPositiveButton("",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.d("UI_PARTS", "OK");
                    }
                });

        // AlertDialogを作成して表示する
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
    */

}
