package com.example.hom7_2_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private final static String TAG = "Intent";
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stringValue = editText.getText().toString();

                Intent intentSearch = new Intent(Intent.ACTION_VIEW);

                if (intentSearch.resolveActivity(getPackageManager()) != null) {
                    char value =0;

                    for (int i = 0; i < stringValue.length(); i++) {
                        value = stringValue.toCharArray()[i];
                    }

                    if (Character.isLetter(value)) { //определяет является буквой
                        Uri uriGeoAddress = Uri.parse("geo:?q=" + stringValue);
                        intentSearch.setData(uriGeoAddress);
                    } else {  //определяет является цифрой
                        Uri uriGeo = Uri.parse("geo:" + stringValue);
                        intentSearch.setData(uriGeo);
                    }
                    startActivity(intentSearch);
                } else {
                    Log.d(TAG, "Browser not found");
                }
            }
        });

    }

    public void initView() {
        button = findViewById(R.id.btn_coordinates);
        editText = findViewById(R.id.edit_coordinates);
    }
}
