package com.example.elite.AdapterClass;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.elite.Model.CounsellorChaterModel;
import com.example.elite.R;

import java.util.ArrayList;

public class CounsellorUserChaterAdapter extends RecyclerView.Adapter<CounsellorUserChaterAdapter.ViewHolder> {
    Context context;
    ArrayList<CounsellorChaterModel> arrUserChat;
    public CounsellorUserChaterAdapter(Context context, ArrayList<CounsellorChaterModel> arrUserChat){
        this.context=context;
        this.arrUserChat=arrUserChat;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //view create

        View view=LayoutInflater.from(context).inflate(R.layout.user_chat_ui,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //data Binding
        holder.imgProfile.setImageResource(arrUserChat.get(position).getImg());
        holder.txtName.setText(arrUserChat.get(position).getUsername());
        holder.txtLastmsg.setText(arrUserChat.get(position).getLastmsg());
    }

    @Override
    public int getItemCount() {
        return arrUserChat.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtName,txtLastmsg;
        ImageView imgProfile;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName=itemView.findViewById(R.id.userchat_name);
            txtLastmsg=itemView.findViewById(R.id.userchat_lastmessage);
            imgProfile=itemView.findViewById(R.id.userchat_profile);

        }
    }

}
