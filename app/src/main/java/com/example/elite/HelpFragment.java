package com.example.elite;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.elite.Fragment.HomeFragment;


public class HelpFragment extends Fragment {

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Access the ActionBar through the parent activity
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        if (activity != null && activity.getSupportActionBar() != null) {
            ActionBar actionBar = activity.getSupportActionBar();

            actionBar.setBackgroundDrawable(
                    new ColorDrawable(ContextCompat.getColor(requireContext(), R.color.app_green)));

            // Create a TextView for custom title styling
            TextView titleTextView = new TextView(requireContext());
            titleTextView.setText("Help");
            titleTextView.setTextColor(ContextCompat.getColor(requireContext(), R.color.white));
            titleTextView.setTextSize(20);

            // Set the custom title view in the ActionBar
            actionBar.setDisplayShowTitleEnabled(false);
            actionBar.setDisplayShowCustomEnabled(true);
            actionBar.setCustomView(titleTextView);

            // Enable the back button
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.white_back); // Optional: custom back icon
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            // Navigate to HomeFragment
            requireActivity().getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.helpFragment, new HomeFragment()) // Replace with your container ID and fragment
                    .addToBackStack(null) // Optional: Add to back stack if needed
                    .commit();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_help, container, false);
    }
}