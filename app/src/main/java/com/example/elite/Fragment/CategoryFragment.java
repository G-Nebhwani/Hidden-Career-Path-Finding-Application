package com.example.elite.Fragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.example.elite.R;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class CategoryFragment extends Fragment {
    private Button top_Categories,top_Counselors;
    ImageView backimg;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_category, container, false);



        top_Categories=view.findViewById(R.id.TopCategories);
        top_Counselors=view.findViewById(R.id.topCounselors);
        backimg=view.findViewById(R.id.fagCategory_back);
        backimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.category_fragment, new HomeFragment()); // Replace with the ID of your container
                fragmentTransaction.addToBackStack(null); // Optional: Adds to back stack
                fragmentTransaction.commit();

            }
        });

        // Set default fragment to Top Categories
        if (savedInstanceState == null) { // Ensures it's set only once when the fragment is first created
            loadFragment(new TopCategoriesFragment());
           top_Categories.setSelected(true);
            top_Counselors.setSelected(false);
        }

        top_Categories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new TopCategoriesFragment());
                setButtonColour(top_Categories,top_Counselors);
            }
        });

        top_Counselors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new TopCounselorsFragment());
                setButtonColour(top_Counselors,top_Categories);
            }
        });

        return view;
    }

    private void setButtonColour(Button selectedButton, Button anotherButton) {
        selectedButton.setBackgroundColor(Color.parseColor("#0C8A60"));
        selectedButton.setTextColor(Color.parseColor("#FFFFFF"));       // White text color

        anotherButton.setBackgroundColor(Color.parseColor("#E1E1E1"));    // Default (white) background
        anotherButton.setTextColor(Color.parseColor("#000000"));
    }
    private void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.replace(R.id.fragmentContainer, fragment);
        transaction.commit();
    }

}