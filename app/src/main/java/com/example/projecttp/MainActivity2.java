package com.example.projecttp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.projecttp.BaseDeDonnes.SceneAdapter;
import com.example.projecttp.Histoire.Scène;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {
    RecyclerView rv2;
    TextView t3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        rv2=findViewById(R.id.RecyclerView_Scene);

        Intent intent = getIntent();
        Bundle args = intent.getBundleExtra("BUNDLE");
        ArrayList<Scène> mylist = (ArrayList<Scène>) args.getSerializable("ARRAYLIST");

        SceneAdapter adapter2=new SceneAdapter(mylist);
        RecyclerView.LayoutManager lm2=new LinearLayoutManager(MainActivity2.this,LinearLayoutManager.HORIZONTAL,false);
        rv2.setHasFixedSize(true);
        rv2.setAdapter(adapter2);
        rv2.setLayoutManager(lm2);
    }
}