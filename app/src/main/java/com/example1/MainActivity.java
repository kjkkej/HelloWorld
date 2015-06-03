package com.example1;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button button1;
    EditText editText1;
    NaraePreference np;
    Button erase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        np = new NaraePreference(this);
        button1 = (Button) findViewById(R.id.button1);
        editText1 = (EditText) findViewById(R.id.editText);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText1.setText("Hellow, world!");
            }
        });
        editText1.setText(np.getValue("data", ""));
        erase = (Button) findViewById(R.id.button2);
        erase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText1.setText("");
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        np.put("data", editText1.getText());
    }
}
