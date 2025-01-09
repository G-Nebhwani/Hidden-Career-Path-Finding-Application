package com.example.elite.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.elite.DashboardActivity;
import com.example.elite.R;


public class MyAccountFragment extends Fragment {

ImageView imgBack;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_my_account, container, false);
        imgBack=view.findViewById(R.id.frgAcc_back);
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(requireContext(), DashboardActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }
}