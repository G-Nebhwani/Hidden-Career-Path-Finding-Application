package com.example.elite.AdapterClass;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.elite.APIs;
import com.example.elite.Fragment.OfferFragment;
import com.example.elite.Model.OfferModel;
import com.example.elite.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class OfferAdapter extends RecyclerView.Adapter<OfferAdapter.ViewHolder> {
    Context context;
    ArrayList<OfferModel> arrOffer;

    public OfferAdapter(Context context, ArrayList<OfferModel> arrOffer, OfferFragment offerFragment){
        this.context=context;
        this.arrOffer=arrOffer;
    }
    @NonNull
    @Override
    public OfferAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.offerdesign,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull OfferAdapter.ViewHolder holder, int position) {
        Picasso.get()
                .load(APIs.image+arrOffer.get(position).getOffer_userimg())
                .placeholder(R.drawable.ic_launcher_background) // optional placeholder
                .into(holder.offer_userimg);
//        holder.offer_userimg.setImageResource(arrOffer.get(position).getOffer_userimg());
        holder.off_title.setText(arrOffer.get(position).getOff_title());
        holder.off_discription.setText(arrOffer.get(position).getOff_discription());
        holder.off_instructor.setText(arrOffer.get(position).getOff_instructor());
        holder.off_percentage.setText(arrOffer.get(position).getOff_percentage());
        holder.off_actualprice.setText(arrOffer.get(position).getOff_actualprice());
        holder.off_dicount_price.setText(arrOffer.get(position).getOff_dicount_price());

    }

    @Override
    public int getItemCount() {
        return arrOffer.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
       ImageView offer_userimg;
        TextView off_title, off_discription,off_instructor, off_percentage , off_actualprice, off_dicount_price;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            offer_userimg=itemView.findViewById(R.id.offer_userimg);
            off_title=itemView.findViewById(R.id.offer_title);
            off_discription=itemView.findViewById(R.id.offer_discription);
            off_instructor=itemView.findViewById(R.id.offer_instructor_name);
            off_percentage=itemView.findViewById(R.id.offer_percentage);
            off_actualprice=itemView.findViewById(R.id.offer_orignal_price);
            off_dicount_price=itemView.findViewById(R.id.offer_dicount_price);


        }
    }
}
