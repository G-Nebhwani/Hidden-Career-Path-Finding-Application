package com.example.elite.AdapterClass;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.elite.Model.UserChaterModel;
import com.example.elite.R;

import java.util.ArrayList;

public class UserChaterAdapter extends RecyclerView.Adapter<UserChaterAdapter.ViewHolder> {

    Context context;
    ArrayList<UserChaterModel> arrUserChat;

    // Constructor
    public UserChaterAdapter(Context context, ArrayList<UserChaterModel> arrUserChat) {
        this.context = context;
        this.arrUserChat = arrUserChat;
    }

    @NonNull
    @Override
    public UserChaterAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.user_chat_ui, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // Bind data from the model to the ViewHolder
        UserChaterModel chatModel = arrUserChat.get(position);
        holder.txtName.setText(chatModel.getUser_username());
        holder.txtLastmsg.setText(chatModel.getUser_lastMsg());
        holder.imgProfile.setImageResource(chatModel.getUser_img()); // Assuming profile images are resource IDs
    }

    @Override
    public int getItemCount() {
        // Return the size of the dataset
        return arrUserChat.size();
    }

    // ViewHolder class
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtName, txtLastmsg;
        ImageView imgProfile;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            // Initialize views
            txtName = itemView.findViewById(R.id.userchat_name);
            txtLastmsg = itemView.findViewById(R.id.userchat_lastmessage);
            imgProfile = itemView.findViewById(R.id.userchat_profile);
        }
    }
}
