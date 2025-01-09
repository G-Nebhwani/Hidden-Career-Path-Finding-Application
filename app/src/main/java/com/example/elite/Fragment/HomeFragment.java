package com.example.elite.Fragment;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.elite.GraduateActivity;
import com.example.elite.HelpFragment;
import com.example.elite.LoginActivity;
import com.example.elite.R;
import com.example.elite.StudentActivity;
import com.example.elite.UserChaterActivity;
import com.google.android.material.navigation.NavigationView;

public class HomeFragment extends Fragment  {
    private DrawerLayout drawerLayout;
    private ImageView sliderBar;
    private ImageButton chatting ;
    NavigationView navigationView;
    SharedPreferences sharedPreferences;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);


        // Initialize DrawerLayout and ImageButton
        drawerLayout = view.findViewById(R.id.drawerLayout_menu); // Make sure the ID matches your XML
        sliderBar = view.findViewById(R.id.SlideBarToggle);
        navigationView=view.findViewById(R.id.navigation_view);
        chatting=view.findViewById(R.id.home_chatting);


        ImageView studentIcon = view.findViewById(R.id.icon_student);
        ImageView graduateIcon = view.findViewById(R.id.icon_graduate);
        ImageView professionalIcon = view.findViewById(R.id.icon_professional);
        ImageView entrepreneurIcon = view.findViewById(R.id.icon_entrepreneur);


        studentIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(requireContext(), "Student", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(requireActivity(), StudentActivity.class);
                startActivity(intent);
            }
        });

        graduateIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(requireContext(), "Graduate ", Toast.LENGTH_SHORT).show();
                Intent i=new Intent(requireActivity(), GraduateActivity.class);
                startActivity(i);
            }
        });

        professionalIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(requireContext(), "Professional", Toast.LENGTH_SHORT).show();
            }
        });

        entrepreneurIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(requireContext(), "Entrepreneur", Toast.LENGTH_SHORT).show();

            }
        });

        

        chatting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), UserChaterActivity.class);
                startActivity(intent);

                Toast.makeText(getContext(), "Chatting", Toast.LENGTH_SHORT).show();
            }
        });


        // Set onClickListener for the ImageButton to open the drawer
        sliderBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open the drawer (left side)
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        MyAccountFragment accountFragment = new MyAccountFragment();
        MyCounsalationFragment counsalationFragment=new MyCounsalationFragment();
        AssesmentFragment assesment=new AssesmentFragment();
        SendFeedBackFragment feedBackFragment=new SendFeedBackFragment();
        PaymentFragment paymentFragment=new PaymentFragment();
        HelpFragment helpFragment=new HelpFragment();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId= item.getItemId();
                if (itemId == R.id.nav_item_Account) {
                    // Use FragmentManager and FragmentTransaction to replace the current fragment
                    FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.dash_framelayout, accountFragment); // `R.id.fragment_container` is the container where your fragment will be placed.
                    fragmentTransaction.addToBackStack(null); // Optional, adds the transaction to the back stack
                    fragmentTransaction.commit();
                    hideActionBar();
                }
                if (itemId == R.id.nav_item_Cousulations) {
                    // Use FragmentManager and FragmentTransaction to replace the current fragment
                    FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.dash_framelayout, counsalationFragment); // `R.id.fragment_container` is the container where your fragment will be placed.
                    fragmentTransaction.addToBackStack(null); // Optional, adds the transaction to the back stack
                    fragmentTransaction.commit();
                    showActionBar();
                }

                if (itemId == R.id.nav_item_Assesment) {
                    // Create an instance of the Fragment you want to navigate to


                    // Use FragmentManager and FragmentTransaction to replace the current fragment
                    FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.dash_framelayout, assesment); // `R.id.fragment_container` is the container where your fragment will be placed.
                    fragmentTransaction.addToBackStack(null); // Optional, adds the transaction to the back stack
                    fragmentTransaction.commit();
                    showActionBar();
                }

                if (itemId == R.id.nav__item_Payment) {
                    // Use FragmentManager and FragmentTransaction to replace the current fragment
                    FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.dash_framelayout, paymentFragment); // `R.id.fragment_container` is the container where your fragment will be placed.
                    fragmentTransaction.addToBackStack(null); // Optional, adds the transaction to the back stack
                    fragmentTransaction.commit();
                    showActionBar();
                }
                if (itemId == R.id.nav__item_feedback ){
                    // Use FragmentManager and FragmentTransaction to replace the current fragment
                    FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.dash_framelayout, feedBackFragment); // `R.id.fragment_container` is the container where your fragment will be placed.
                    fragmentTransaction.addToBackStack(null); // Optional, adds the transaction to the back stack
                    fragmentTransaction.commit();
                    showActionBar();
                }
                if (itemId == R.id.nav__item_help ){
                    // Use FragmentManager and FragmentTransaction to replace the current fragment
                    FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.dash_framelayout, helpFragment); // `R.id.fragment_container` is the container where your fragment will be placed.
                    fragmentTransaction.addToBackStack(null); // Optional, adds the transaction to the back stack
                    fragmentTransaction.commit();
                    showActionBar();
                }
                if (itemId == R.id.nav_item_logout) {
                    showCustomLogoutDialog();
                }

                drawerLayout.closeDrawers();
                return true;
            }
        });

        return view;
    }
    private void showCustomLogoutDialog() {
        // Inflate custom layout for the dialog
        LayoutInflater inflater = getLayoutInflater();
        View customView = inflater.inflate(R.layout.logout_alter, null);

        // Create an AlertDialog builder with the fragment context
        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
        builder.setView(customView);  // Set custom view to the dialog

        // Get reference to buttons in the custom layout
        Button btnCancel = customView.findViewById(R.id.btnCancel);
        Button btnConfirm = customView.findViewById(R.id.btnConfirm);

        // Create the AlertDialog object
        AlertDialog dialog = builder.create();

        // Set onClick listener for Cancel button
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();  // Close the dialog
            }
        });

        // Set onClick listener for Confirm button (Logout)
        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle logout action
                logout();
                dialog.dismiss();  // Close the dialog

            }
        });

        // Show the custom dialog
        dialog.show();
    }

    // Handle the logout action
    private void logout() {
        SharedPreferences sharedPreferences = requireContext().getSharedPreferences("UserPrefs", requireContext().MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("islogin", false);

        editor.apply();
        // Add your logout logic here, such as clearing session data or navigating to login screen
        // Example: Redirect to login screen
         Intent intent = new Intent(getActivity(), LoginActivity.class);
         startActivity(intent);
         getActivity().finish();  // Close current activity
    }

    private void hideActionBar() {
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        if (activity != null) {
            ActionBar actionBar = activity.getSupportActionBar();
            if (actionBar != null) {
                actionBar.hide();
            }
        }
    }

    private void showActionBar() {
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        if (activity != null) {
            ActionBar actionBar = activity.getSupportActionBar();
            if (actionBar != null) {
                actionBar.show();
            }
        }
    }
}

