package com.example.sbm.settingdate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import static com.example.sbm.settingdate.R.id.textView;

public class Day extends AppCompatActivity {

    RadioGroup radioGroup;
    Button okbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day);

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

                TextView textView = (TextView) findViewById(R.id.textView);
                textView.setText(String.valueOf(text));
            }
        });

        Button okbutton = (Button) findViewById(R.id.okbutton);
        okbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("daydata", textView);
                setResult(RESULT_OK, intent);

                finish();
            }
        });

    }
}
