package com.example.chapter3.homework;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class adapter extends RecyclerView.Adapter<adapter.numviewholder> {

    private static final String TAG = "adapter";

    private static int viewHolderCount;
    Context context;

    public adapter(Context context) {
        this.context = context;
        viewHolderCount = 0;
    }

    @NonNull
    @Override
    public numviewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        Context context = viewGroup.getContext();
        int layoutIdForListItem = R.layout.item;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;

        View view = inflater.inflate(layoutIdForListItem, viewGroup, shouldAttachToParentImmediately);
        numviewholder viewHolder = new numviewholder(view);

        int num = viewHolderCount;
        viewHolder.textview.setText("好友 " + num);

        viewHolderCount++;
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull numviewholder numberViewHolder, int position) {
        numberViewHolder.bind(position);
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class numviewholder extends RecyclerView.ViewHolder {

        private final TextView textview;

        public numviewholder(@NonNull View itemView) {
            super(itemView);
            textview = (TextView) itemView.findViewById(R.id.text_view);
        }

        public void bind(int position) {
            ;
        }
    }
}
