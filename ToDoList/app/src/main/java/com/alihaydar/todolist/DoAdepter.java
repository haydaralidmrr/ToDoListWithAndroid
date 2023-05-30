package com.alihaydar.todolist;

import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.alihaydar.todolist.databinding.RowLayoutBinding;

import java.util.ArrayList;

public class DoAdepter extends RecyclerView.Adapter<DoAdepter.DoHolder> {
    ArrayList<String>arrayList;

    public DoAdepter(ArrayList<String> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public DoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RowLayoutBinding rowLayoutBinding=RowLayoutBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new DoHolder(rowLayoutBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull DoHolder holder, int position) {
        holder.binding.recyclerTextView.setText(arrayList.get(position).toString());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alert=new AlertDialog.Builder(holder.itemView.getContext());
                alert.setTitle("DELETE");
                alert.setMessage("Are you sure?");
                alert.setCancelable(false);
                alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        holder.binding.recyclerTextView.setText(arrayList.remove(holder.getAdapterPosition()));
                        notifyDataSetChanged();



                    }

                });
                alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                alert.show();


            }
        });


    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class DoHolder extends RecyclerView.ViewHolder{
        private RowLayoutBinding binding;

        public DoHolder(RowLayoutBinding rowLayoutBinding) {
            super(rowLayoutBinding.getRoot());
            this.binding=rowLayoutBinding;
        }
    }
}
