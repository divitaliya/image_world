package com.example.image_world;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button button;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.play);
        textView = findViewById(R.id.level);
        sharedPreferences = getSharedPreferences("memory",MODE_PRIVATE);
        editor = sharedPreferences.edit();


        if(!sharedPreferences.contains("score"))
        {
            System.out.println("not available");
            editor.putInt("score",200);
            editor.commit();
        }
        else {
            System.out.println("score available");
        }

        int level=sharedPreferences.getInt("level",0);
        System.out.println("currentlevl="+level);
        if(level==0)
        {
            textView.setText(""+(level+1));
        }
        else {
            textView.setText(""+(level+2));
        }

        button.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this,leval1.class);

            if(level==0)
            {
                intent.putExtra("pos",level);
            }
            else {
                intent.putExtra("pos",level+1);
            }

            startActivity(intent);
        });


    }
}