package com.example.mynewsapplication;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

public class intlNewsFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public intlNewsFragment() {}

    public static intlNewsFragment newInstance(String param1, String param2) {
        intlNewsFragment fragment = new intlNewsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    ArrayList<MyVerticalModel> verticalModels = new ArrayList<>();
    int[] VerticalImages = {R.drawable.top_solareclipse, R.drawable.top_negotiation,
            R.drawable.top_climate, R.drawable.top_company, R.drawable.top_football};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_intlnews, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.verticalRecyclerIntl);

        String[] verticalNames = getResources().getStringArray(R.array.verticalNewsTitles);
        String[] verticalDescription = getResources().getStringArray(R.array.verticalNewsDescriptions);

        for( int i =0; i < verticalNames.length; i++)
        {
            verticalModels.add(new MyVerticalModel(verticalNames[i],
                verticalDescription[i],VerticalImages[i]));
        }

        MyVerticalAdapter adapter = new MyVerticalAdapter(this.getContext(), verticalModels);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));

        return view;
    }
}
