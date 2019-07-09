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
                    if (Character.isLetter('T')) { //определяет является буквой
                        Uri uriGeoAddress = Uri.parse("geo:?q=" + stringValue);
                        intentSearch.setData(uriGeoAddress);
                    } else if (Character.isDigit('0')) {  //определяет является цифрой
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
