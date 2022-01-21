package com.example.project15.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project15.R;
import com.example.project15.model.Member;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> /*implements ItemTouchHelperAdapter*/ {

    public final Context context;
    private final ArrayList<Member> itemList;


    public CustomAdapter(Context context, ArrayList<Member> itemList) {
        this.itemList = itemList;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CustomViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_member, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Member member = itemList.get(position);

        if (holder instanceof CustomViewHolder) {
            TextView textView = holder.itemView.findViewById(R.id.text_view_title);

            textView.setText(member.getName());

        }
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public static final class CustomViewHolder extends RecyclerView.ViewHolder {
        public RelativeLayout viewBackground, viewForeground;
        public final View view;
        public TextView textView;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            this.view = itemView;

            viewBackground = view.findViewById(R.id.view_background);
            viewForeground = view.findViewById(R.id.view_foreground);
            textView = view.findViewById(R.id.text_view_title);
        }
    }
}
