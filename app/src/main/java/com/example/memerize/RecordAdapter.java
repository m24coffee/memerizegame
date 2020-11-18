package com.example.memerize;

import android.content.Context;
import android.widget.Toast;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;

class RecordAdapter {

    private static String FILE_RECORDS = "memerize-records";

    ArrayList<String> recTime;
    ArrayList<Integer> recPoint;
    Context mContext;

    public RecordAdapter(Context context)
    {
        recTime = new ArrayList<>();
        recPoint = new ArrayList<>();

        mContext = context;

        try {
            FileInputStream fis = mContext.openFileInput(FILE_RECORDS);
            ObjectInputStream is = new ObjectInputStream(fis);
            recPoint = (ArrayList<Integer>) is.readObject();
            recTime = (ArrayList<String>) is.readObject();
            is.close();
        } catch (Exception e) {
            Toast.makeText(mContext, "Oops! There is an error", Toast.LENGTH_LONG);
        }
    }

    public void WriteRecords ()
    {

        try {
            FileOutputStream fos = mContext.openFileOutput(FILE_RECORDS, Context.MODE_PRIVATE);
            ObjectOutputStream os = new ObjectOutputStream(fos);
            os.writeObject(recPoint);
            os.writeObject(recTime);
            os.close();
        } catch (Exception e) {
            Toast.makeText(mContext, "Oops! There is an error", Toast.LENGTH_LONG);
        }
        return;
    }

    public void addTime (String str)
    {

        if (!recTime.contains(str))
            recTime.add(str);


        Collections.sort(recTime);


        for (int i = 5; i < recTime.size(); i++)
            recTime.remove(i);

        return;
    }

    public void addPoint (Integer num)
    {
        if (!recPoint.contains(num))
            recPoint.add(num);

        Collections.sort(recPoint);

        for (int i = 5; i < recPoint.size(); i++)
            recPoint.remove(i);

        return;
    }

    public ArrayList<String> getRecTime()
    {

        return recTime;
    }

    public ArrayList<String> getRecPoint()
    {

        ArrayList<String> arr = new ArrayList<String>();
        for (Integer temp : recPoint)
            arr.add(temp.toString());


        return arr;
    }
}
