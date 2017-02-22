package com.example.sbm.settingdate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Day extends AppCompatActivity {

    RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day);

        // RadioGroup の取得
        radioGroup = (RadioGroup) findViewById(R.id.RadioGroup);

        // 指定した ID の RadioButton を選択
        radioGroup.check(R.id.RadioButton1);

        // 選択されている RadioButton の ID を取得
        int Id = radioGroup.getCheckedRadioButtonId();

        // 選択されている RadioButton が変わったときに呼び出されるコールバックを登録
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // 選択されている RadioButton の取得
                RadioButton radioButton = (RadioButton) findViewById(checkedId);

                // RadioButton のテキストを取得
                String text = radioButton.getText().toString();
            }
        });
    }
}
