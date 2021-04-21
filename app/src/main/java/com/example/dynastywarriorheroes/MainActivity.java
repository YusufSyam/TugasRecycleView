package com.example.dynastywarriorheroes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<Hero> heroes= new ArrayList<>();
    private ListHeroAdapter.RecycleViewClickListener listener;

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView= findViewById(R.id.rv_hero);
        recyclerView.setHasFixedSize(true);
        heroes.addAll(HeroDataSource.getListData());
        Collections.reverse(heroes);

        onClick();

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ListHeroAdapter adapter= new ListHeroAdapter(heroes, listener);
        recyclerView.setAdapter(adapter);
    }

    private void onClick() {
        listener= new ListHeroAdapter.RecycleViewClickListener() {
            @Override
            public void onClick(View view, int position) {
                Intent intent= new Intent(getApplicationContext(), ProfileActivity.class);
                intent.putExtra("index", (heroes.size()-position-1));
                startActivity(intent);
            }
        };
    }
}