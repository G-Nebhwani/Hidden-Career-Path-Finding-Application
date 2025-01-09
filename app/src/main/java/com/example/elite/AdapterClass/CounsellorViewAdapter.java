package com.example.elite.AdapterClass;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.elite.APIs;
import com.example.elite.Model.CounsellorViewModel;
import com.example.elite.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CounsellorViewAdapter extends RecyclerView.Adapter<CounsellorViewAdapter.ViewHolder> {
    private ArrayList<CounsellorViewModel> dataholder;
    private final OnItemButtonClickListener listener;
    private Context context;
    public CounsellorViewAdapter(Context context, ArrayList<CounsellorViewModel> dataholder,OnItemButtonClickListener listener){
        this.context=context;
        this.dataholder=dataholder;
        this.listener=listener;
    }
    @NonNull
    @Override
    public CounsellorViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.counsellor_ui,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CounsellorViewAdapter.ViewHolder holder, int position) {

        Picasso.get()
                .load(APIs.image+dataholder.get(position).getCcprofile())
                .placeholder(R.drawable.ic_launcher_background) // optional placeholder
                .into(holder.Counsellor_profile);
        holder.Counsellor_Name.setText(dataholder.get(position).getCcName());
        holder.Counsellor_Detail.setText(dataholder.get(position).getCcDetail());
        holder.Counsellor_Experience.setText(dataholder.get(position).getCcExperience());
        holder.Counsellor_rate.setText(dataholder.get(position).getCcrate());
        holder.Counsellor_price.setText(dataholder.get(position).getCcprice());

        holder.btn_viewDetails.setOnClickListener(v -> listener.onButton1Click(position));
        holder.btn_book.setOnClickListener(v -> listener.onButton2Click(position));


    }

    @Override
    public int getItemCount() {
        return  dataholder.size();
    }

    public interface OnItemButtonClickListener {
        void onButton1Click(int position);
        void onButton2Click(int position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView Counsellor_Name,Counsellor_Detail,Counsellor_Experience,Counsellor_price,Counsellor_rate;
        ImageView Counsellor_profile;
        Button btn_viewDetails,btn_book;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            Counsellor_Name=itemView.findViewById(R.id.counselor_name);
            Counsellor_Detail=itemView.findViewById(R.id.counselor_details);
            Counsellor_Experience=itemView.findViewById(R.id.counselor_Experience);
            Counsellor_price=itemView.findViewById(R.id.counsellor_rate);
            Counsellor_rate=itemView.findViewById(R.id.counselor_rating);
            Counsellor_profile=itemView.findViewById(R.id.c_profile_image);

            btn_viewDetails=itemView.findViewById(R.id.view_details_button);
            btn_book=itemView.findViewById(R.id.book_btn);


        }
    }
}
