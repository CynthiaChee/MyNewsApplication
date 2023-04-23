package com.example.mynewsapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //Initializing variables

    ConstraintLayout content;
    ImageButton nationalNewsButton, politicsNewsButton, intlNewsButton, celebNewsButton;
    RecyclerView topRecycler;
    ArrayList<MyNewsModel> myNewsModel = new ArrayList<>();
    int[] topStoriesImages = {R.drawable.top_solareclipse, R.drawable.top_negotiation,
        R.drawable.top_climate, R.drawable.top_company, R.drawable.top_football};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Find view by ID
        nationalNewsButton = findViewById(R.id.nationalNews);
        politicsNewsButton = findViewById(R.id.politicsNews);
        intlNewsButton = findViewById(R.id.intlNews);
        celebNewsButton = findViewById(R.id.celebNews);
        content = findViewById(R.id.wholeScreen);
        topRecycler = findViewById(R.id.topStoriesRecyclerView);

        //Adding the images and titles to myNewsModel
        String[] topNewsTitles = getResources().getStringArray(R.array.verticalNewsTitles);
        for(int i = 0; i < topStoriesImages.length; i++)
        {
            myNewsModel.add(new MyNewsModel(topStoriesImages[i], topNewsTitles[i]));
        }

        //Initializing and attaching the adapter
        TopNewsAdapter newsAdapter = new TopNewsAdapter(this, myNewsModel);
        topRecycler.setAdapter(newsAdapter);
        topRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));

        //If national news is clicked
        nationalNewsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new nationalNewsFragment();
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentFrameLayout, fragment).commit();
                content.setVisibility(view.INVISIBLE);
            }
        });

        //If politics news is clicked
        politicsNewsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new politicsNewsFragment();
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentFrameLayout, fragment).commit();
                content.setVisibility(view.INVISIBLE);
            }
        });

        //If international news is clicked
        intlNewsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new intlNewsFragment();
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentFrameLayout, fragment).commit();
                content.setVisibility(view.INVISIBLE);
            }
        });

        //If entertainment news is clicked
        celebNewsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new celebNewsFragment();
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentFrameLayout, fragment).commit();
                content.setVisibility(view.INVISIBLE);
            }
        });
    }
}

