package com.example.projecttp;



import androidx.appcompat.app.AppCompatActivity;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;


import com.example.projecttp.BaseDeDonnes.HistoireAdapter;
import com.example.projecttp.BaseDeDonnes.HistoireFavoriAdapter;
import com.example.projecttp.Histoire.Scène;
import com.example.projecttp.Histoire.histoire;
import java.util.ArrayList;



public class MainActivity extends AppCompatActivity {
    RecyclerView rv,favori_list;
    ImageButton fav;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv=findViewById(R.id.RecyclerView_main);



        //Making LesScènes ArrayList

        ArrayList<Scène> LesScènes=new ArrayList<>();

        for (int i = 1; i < 15; i++) {
            LesScènes.add(new Scène(
                    "Scène"+i,
                    R.drawable.img,
                    "Submitted by sydney2023 on Tue I had the first test in psychology class last week." +
                            "I was quite nervous that day as I really wanted to do well in that subject. I had to" +
                            " write a report about character research which I had done two weeks ago with the class " +
                            "students. The result and graphs about the results had been worked on and finalized the" +
                            " previous week, so I had to interpret the results and write the conclusion about it." +
                            " I think I did alright but as I can notice easily here, I'm quite concerned about my spelling" +
                            " Submitted by sydney2023 on Tue, "+
                            "Submitted by sydney2023 on Tue I had the first test in psychology class last week." +
                            "I was quite nervous that day as I really wanted to do well in that subject. I had to" +
                            " write a report about character research which I had done two weeks ago with the class " +
                            "students. The result and graphs about the results had been worked on and finalized the" +
                            " previous week, so I had to interpret the results and write the conclusion about it." +
                            " I think I did alright but as I can notice easily here, I'm quite concerned about my spelling" +
                            " Submitted by sydney2023 on Tue, " +
                            "Submitted by sydney2023 on Tue I had the first test in psychology class last week." +
                            "I was quite nervous that day as I really wanted to do well in that subject. I had to" +
                            " write a report about character research which I had done two weeks ago with the class " +
                            "students. The result and graphs about the results had been worked on and finalized the" +
                            " previous week, so I had to interpret the results and write the conclusion about it." +
                            " I think I did alright but as I can notice easily here, I'm quite concerned about my spelling" +
                            " Submitted by sydney2023 on Tue, "+
                            "Submitted by sydney2023 on Tue I had the first test in psychology class last week." +
                            "I was quite nervous that day as I really wanted to do well in that subject. I had to" +
                            " write a report about character research which I had done two weeks ago with the class " +
                            "students. The result and graphs about the results had been worked on and finalized the" +
                            " previous week, so I had to interpret the results and write the conclusion about it." +
                            " I think I did alright but as I can notice easily here, I'm quite concerned about my spelling" +
                            " Submitted by sydney2023 on Tue, "+
                            "Submitted by sydney2023 on Tue I had the first test in psychology class last week." +
                            "I was quite nervous that day as I really wanted to do well in that subject. I had to" +
                            " write a report about character research which I had done two weeks ago with the class " +
                            "students. The result and graphs about the results had been worked on and finalized the" +
                            " previous week, so I had to interpret the results and write the conclusion about it." +
                            " I think I did alright but as I can notice easily here, I'm quite concerned about my spelling" +
                            " Submitted by sydney2023 on Tue, "
                    ));
        }

        //Making Histoires ArrayList

        ArrayList<histoire> Histoires=new ArrayList<>();

        int[] images={R.drawable.st,R.drawable.st2,R.drawable.st3,R.drawable.st4,R.drawable.st5};
        String[] Stories={"Little Red Riding Hood","Little Red Riding Hood 2","Little Red Riding Hood 3","Hansel and gretel","Hansel and gretel 2",};



        for (int i = 0; i < 5; i++) {
            Histoires.add(new histoire(Stories[i], images[i],LesScènes));
        }

        HistoireAdapter adapter=new HistoireAdapter(Histoires);
        RecyclerView.LayoutManager lm=new LinearLayoutManager(MainActivity.this);
        rv.setLayoutManager(lm);
        rv.setAdapter(adapter);

        favori_list=findViewById(R.id.favori_list);

        //Making Histoires ArrayList

        ArrayList<histoire> Histoires_favori=new ArrayList<>();

        for (int i = 0; i < 1; i++) {
            Histoires_favori.add(new histoire(Stories[i], images[i],true,LesScènes));
        }

        HistoireFavoriAdapter adapter2=new HistoireFavoriAdapter(Histoires_favori);
        RecyclerView.LayoutManager lm2=new LinearLayoutManager(MainActivity.this,LinearLayoutManager.HORIZONTAL,true);
        favori_list.setLayoutManager(lm2);
        favori_list.setAdapter(adapter2);

        adapter.setHistoires_Favori(Histoires_favori);
        adapter.setHistoireFavories(adapter2);
    }
}