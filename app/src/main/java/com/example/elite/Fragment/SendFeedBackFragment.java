package com.example.elite.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.elite.R;


public class SendFeedBackFragment extends Fragment {
    private RatingBar ratingBar;
    private ImageView emojiImageView;
    private Button ratebtn, latebtn;
    private ImageView cancle;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_send_feed_back, container, false);
        ratingBar = view.findViewById(R.id.ratingBar);
        emojiImageView = view.findViewById(R.id.emojiImageView);
        ratebtn=view.findViewById(R.id.feedback_RateNow);
        latebtn=view.findViewById(R.id.feedback_lateButton);
        cancle=view.findViewById(R.id.feedback_cancel);

        cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.feedback_fag, new HomeFragment()); // Replace with the ID of your container
                fragmentTransaction.addToBackStack(null); // Optional: Adds to back stack
                fragmentTransaction.commit();

            }
        });
        ratingBar.setOnRatingBarChangeListener((ratingBar, rating, fromUser) -> {
            updateEmojiAndText(rating);
        });

        return view;
    }

    private void updateEmojiAndText(float rating) {
        int emojiResId;
        if (rating == 0) {
            emojiResId = R.drawable.angry; // Angry emoji
//            ratingText = "No rating";
        } else if (rating <= 1) {
            emojiResId = R.drawable.sad; // Sad emoji
//            ratingText = "Poor";
        } else if (rating <= 2) {
            emojiResId = R.drawable.irretated; // Neutral emoji
//            ratingText = "Fair";
        } else if (rating <= 3) {
            emojiResId = R.drawable.happy_emoji; // Smile emoji
//            ratingText = "Good";
        }  else if(rating <=4){
            emojiResId = R.drawable.smart; // Star emoji
//            ratingText = "Excellent";
        }
        else{
            emojiResId=R.drawable.like;
        }

        // Update ImageView and TextView
        emojiImageView.setImageResource(emojiResId);
    }
}