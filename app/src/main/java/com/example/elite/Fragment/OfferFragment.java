package com.example.elite.Fragment;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.elite.APIs;
import com.example.elite.AdapterClass.OfferAdapter;
import com.example.elite.Model.OfferModel;
import com.example.elite.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class OfferFragment extends Fragment {
    private ArrayList<OfferModel> arrOffer ;
    OfferAdapter adapter;
    private RecyclerView recyclerView;
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
            titleTextView.setText("Offers");
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

    // Handle the back button press
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            // Handle the back button action
            requireActivity().onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_offer, container, false);



        recyclerView = view.findViewById(R.id.offer_recycleview);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));

        arrOffer=new ArrayList<>();
//        // Sample static data
//        arrOffer.add(new OfferModel(R.drawable.userimg, "Resume Making", "Resume that gets you hired", "Instructor: Ravi Gupta", "50% off", "Rs. 1000", "Rs. 750"));
//        arrOffer.add(new OfferModel(R.drawable.userimg, "LinkedIn Optimization", "Get noticed by top recruiters", "Instructor: Ankit Sharma", "30% off", "Rs. 1200", "Rs. 840"));
//        arrOffer.add(new OfferModel(R.drawable.userimg, "Interview Preparation", "Ace your interviews with confidence", "Instructor: Priya Jain", "40% off", "Rs. 1500", "Rs. 900"));

        adapter = new OfferAdapter(getContext(), arrOffer, this);
        recyclerView.setAdapter(adapter);

        getOfferData();

        return view;
    }

    private void getOfferData() {
        RequestQueue requestQueue = Volley.newRequestQueue(requireContext());
        String Url = APIs.Offers;

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, Url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    if (response.getString("status").equals("success")) {
                        JSONArray offerArr = response.getJSONArray("data");

                        for (int i = 0; i < offerArr.length(); i++) {
                            JSONObject offerObj = offerArr.getJSONObject(i);

                            String offerName = offerObj.getString("offer_name");
                            String offerDescription = offerObj.getString("description");
                            String offerDiscount = offerObj.getString("discount_percentage");
                            String offerOldPrice = offerObj.getString("old_price");
                            String offerNewPrice = offerObj.getString("new_price");
                            String offerCounselorName = offerObj.getString("counselor_name");
                            String offerProfile = offerObj.getString("counselor_icon");

                            arrOffer.add(new OfferModel(
                                    offerProfile,
                                    offerName,
                                    offerDescription,
                                    offerCounselorName,
                                    offerDiscount,
                                    offerOldPrice,
                                    offerNewPrice
                            ));
                        }

                        adapter.notifyDataSetChanged();
                    } else {
                        Toast.makeText(requireContext(), "No Data Found", Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(requireContext(), "Error parsing JSON data", Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(requireContext(), "Error fetching data: " + error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        requestQueue.add(jsonObjectRequest);
    }
}
