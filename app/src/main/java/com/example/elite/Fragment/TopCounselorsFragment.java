package com.example.elite.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.elite.APIs;
import com.example.elite.AdapterClass.CounsellorViewAdapter;
import com.example.elite.BookSlotActivity;
import com.example.elite.CounselorDeatilsActivity;
import com.example.elite.Model.CounsellorViewModel;
import com.example.elite.R;
import com.example.elite.UserChaterActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class TopCounselorsFragment extends Fragment implements CounsellorViewAdapter.OnItemButtonClickListener {

    private ArrayList<CounsellorViewModel> counsellorViewArr;
    private CounsellorViewAdapter adapter;
    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_top_counselors, container, false);

        recyclerView = view.findViewById(R.id.topCounselors_view_recycle);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Initialize the ArrayList before using it
        counsellorViewArr = new ArrayList<>();

        // Sample data (can be removed later)
//        CounsellorViewModel model1 = new CounsellorViewModel("Samira Pathak", "Clinical Psychologist, Counseling Psychologist", "12 Years of Experience", "100/hr", "4.0", R.drawable.userimg);
//        counsellorViewArr.add(model1);
//
        // Pass `this` as the listener to the adapter
        adapter = new CounsellorViewAdapter(getContext(), counsellorViewArr, this);
        recyclerView.setAdapter(adapter);

        fetchCounsellorData();

        return view;
    }

    @Override
    public void onButton1Click(int position) {
        // Handle Button 1 click: Open details activity
        CounsellorViewModel selectedCounsellor = counsellorViewArr.get(position);
        Intent i = new Intent(getActivity(), CounselorDeatilsActivity.class);

        i.putExtra("name", selectedCounsellor.getCcName());
        i.putExtra("detail", selectedCounsellor.getCcDetail());
        i.putExtra("experience", selectedCounsellor.getCcExperience());
        i.putExtra("price", selectedCounsellor.getCcprice());
        i.putExtra("rating", selectedCounsellor.getCcrate());
        i.putExtra("profileImageUrl", selectedCounsellor.getCcprofile());
        startActivity(i);
    }

    @Override
    public void onButton2Click(int position) {
        // Handle Button 2 click: Open booking activity
        Intent i = new Intent(getActivity(), UserChaterActivity.class);
        startActivity(i);
    }

    private void fetchCounsellorData() {
        RequestQueue requestQueue = Volley.newRequestQueue(requireContext());

        String url = APIs.TopCounselors; // Ensure this points to your API endpoint

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.GET,
                url,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            // Check for success status
                            if (response.getString("status").equals("success")) {
                                JSONArray counselorsArray = response.getJSONArray("data");

                                for (int i = 0; i < counselorsArray.length(); i++) {
                                    JSONObject counselorObject = counselorsArray.getJSONObject(i);

                                    String profileImageUrl = counselorObject.getString("icon");
                                    String name = counselorObject.getString("name");
                                    String detail = counselorObject.getString("fields");
                                    String experience = counselorObject.getString("years_of_experience") + " Years";
                                    String rate = String.valueOf(counselorObject.getDouble("rating"));
                                    String price = counselorObject.getString("fees");

                                    // Add data to the list
                                    counsellorViewArr.add(new CounsellorViewModel(
                                            name, detail, experience, price, rate, profileImageUrl
                                    ));
                                }

                                // Notify the adapter of data profileImageUrl
                                adapter.notifyDataSetChanged();
                            } else {
                                Toast.makeText(requireContext(), "No data found", Toast.LENGTH_SHORT).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(requireContext(), "Error parsing JSON data", Toast.LENGTH_SHORT).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(requireContext(), "Error fetching data: " + error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
        );

        requestQueue.add(jsonObjectRequest);
    }
}
