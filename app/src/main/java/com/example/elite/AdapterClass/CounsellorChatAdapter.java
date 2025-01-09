package com.example.elite.AdapterClass;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.elite.Model.CounsellorChatModel;
import com.example.elite.R;

import java.util.ArrayList;


public class CounsellorChatAdapter extends RecyclerView.Adapter<CounsellorChatAdapter.myviewholder> {

        private static final int USER_TYPE_1 = 1;
        private static final int USER_TYPE_2 = 2;
        private static final int USER_TYPE_3 = 3;

        private ArrayList<CounsellorChatModel> dataholder;
        private Context context;

        public CounsellorChatAdapter(ArrayList<CounsellorChatModel> dataholder, Context context) {
            this.dataholder = dataholder;
            this.context = context;
        }

        @NonNull
        @Override
        public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view;
            switch (viewType) {
                case USER_TYPE_1:
                    view = LayoutInflater.from(parent.getContext()).inflate(R.layout.me, parent, false);
                    break;
                case USER_TYPE_2:
                    view = LayoutInflater.from(parent.getContext()).inflate(R.layout.other, parent, false);
                    break;
//            case USER_TYPE_3:
//                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lodingitem, parent, false);
//                break;
                default:
                    throw new IllegalStateException("Unexpected value: " + viewType);
            }
            return new myviewholder(view, viewType);
        }

        @Override
        public void onBindViewHolder(@NonNull myviewholder holder, int position) {

            CounsellorChatModel model = dataholder.get(position);
            // Bind data to views based on view type
            if (holder.viewType == USER_TYPE_1) {
                // Bind data for user type 1
                holder.message.setText(model.getMessage());
                // Bind other views
            } else if (holder.viewType == USER_TYPE_2) {
                // Bind data for user type 2

                holder.message.setText(model.getMessage());
                // Bind other views
            }
            else if (holder.viewType == USER_TYPE_3) {
                // Bind data for user type 2
//            holder.message.setText(model.getMessage());
                // Bind other views
            }
        }

        @Override
        public int getItemCount() {
            return dataholder.size();
        }

        @Override
        public int getItemViewType(int position) {
            CounsellorChatModel model = dataholder.get(position);
            // Determine the view type based on the user field in Model
            if (model.getUser()==1) {
                return USER_TYPE_1;
            } else if (model.getUser()==2) {
                return USER_TYPE_2;
            }
            else if (model.getUser()==3) {
                return USER_TYPE_3;
            }else {
                // Default view type
                return USER_TYPE_1; // or USER_TYPE_2 depending on your logic
            }
        }

        class myviewholder extends RecyclerView.ViewHolder {

            TextView message;
            int viewType;

            public myviewholder(@NonNull View itemView, int viewType) {
                super(itemView);
                this.viewType = viewType;
                if (viewType == USER_TYPE_1) {
                    message = itemView.findViewById(R.id.text_gchat_message_me);
                    // Find other views for user type 1
                } else if (viewType == USER_TYPE_2) {
                    message = itemView.findViewById(R.id.text_gchat_message_other);
                    // Find other views for user type 2
                }
                else if (viewType == USER_TYPE_3) {


                }
            }
        }

        @Override
        public boolean onFailedToRecycleView(@NonNull myviewholder holder) {
            return super.onFailedToRecycleView(holder);
        }
    }

