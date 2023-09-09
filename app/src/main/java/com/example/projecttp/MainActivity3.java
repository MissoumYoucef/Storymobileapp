package com.example.projecttp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.projecttp.Histoire.Scène;

import java.util.ArrayList;

public class MainActivity3 extends AppCompatActivity {

    TextView t1;
    ImageView img;
    TextView Contenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        t1=findViewById(R.id.t1);
        img=findViewById(R.id.img1);
        Contenu=findViewById(R.id.t2);
        Scène s = (Scène) getIntent().getSerializableExtra("the_Scene");
        t1.setText(s.getTitre());
        img.setImageResource(s.getImg());
        Contenu.setText(s.getContenu());

    }
}