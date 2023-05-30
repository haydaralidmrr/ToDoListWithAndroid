package com.alihaydar.todolist;

import android.content.Context;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class FileHelper {
    public static final String FILENAME="listinfo.dat";

    public static void writeData(ArrayList<String>arrayList, Context context){

        try {
            FileOutputStream fileOutputStream=context.openFileOutput(FILENAME,Context.MODE_PRIVATE);
            ObjectOutputStream objectOutputStream=new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(arrayList);
            objectOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
           e.printStackTrace();
        }

    }

    public static ArrayList<String> readData(Context context){
        ArrayList<String>item=null;
        try {
            FileInputStream fileInputStream = context.openFileInput(FILENAME);
            ObjectInputStream objectInputStream=new ObjectInputStream(fileInputStream);
            item= (ArrayList<String>) objectInputStream.readObject();
        } catch (FileNotFoundException e) {
            item=new ArrayList<>();
            e.printStackTrace();
        } catch (IOException e) {
           e.printStackTrace();
        } catch (ClassNotFoundException e) {
           e.printStackTrace();
        }
        return item;

    }
}