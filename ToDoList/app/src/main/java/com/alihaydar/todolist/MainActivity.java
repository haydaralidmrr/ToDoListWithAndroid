package com.alihaydar.todolist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.alihaydar.todolist.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    ArrayList<String>arrayList;
    SharedPreferences sharedPreferences;
    DoAdepter doAdepter;
    String addedItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        View view=binding.getRoot();
        setContentView(view);
        arrayList=new ArrayList<>();

        arrayList=FileHelper.readData(this);
        binding.recylerView.setLayoutManager(new LinearLayoutManager(this));
        doAdepter=new DoAdepter(arrayList);
        binding.recylerView.setAdapter(doAdepter);


        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(binding.editText.getText().toString().matches("")){
                    Toast.makeText(MainActivity.this, "Enter a item that you want add", Toast.LENGTH_SHORT).show();
                }else {
                    addedItem=binding.editText.getText().toString();
                    arrayList.add(addedItem);
                    binding.editText.setText("");
                    FileHelper.writeData(arrayList,MainActivity.this);
                    doAdepter.notifyDataSetChanged();
                }

            }
        });



    }



}