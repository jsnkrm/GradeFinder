package com.example.jsnkrm.project1;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;


public class ListGradeFragment extends Fragment {

    SQLiteHandler sqLiteHandler;

    StuAdapter itemsAdapter;
    Cursor cursor;

    View rootview;

    ArrayList<StuInfo> students = new ArrayList<>();

    public ListGradeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootview = inflater.inflate(R.layout.fragment_list_grade, container, false);

        sqLiteHandler = new SQLiteHandler(getActivity());

        cursor = sqLiteHandler.getAllStudents();

        if (cursor != null && cursor.getCount() != 0)
        {

            if (cursor.moveToFirst())
            {

                do
                {
                    String name = cursor.getString(cursor.getColumnIndex("name"));
                    String syll = cursor.getString(cursor.getColumnIndex("syll"));
                    int cl = Integer.parseInt(cursor.getString(cursor.getColumnIndex("class")));
                    String gr1 = cursor.getString(cursor.getColumnIndex("grd1"));
                    String gr2 = cursor.getString(cursor.getColumnIndex("grd2"));
                    String gr3 = cursor.getString(cursor.getColumnIndex("grd3"));
                    String gr4 = cursor.getString(cursor.getColumnIndex("grd4"));
                    String gr5 = cursor.getString(cursor.getColumnIndex("grd5"));
                    String grtot = cursor.getString(cursor.getColumnIndex("TotGrd"));

                    students.add(new StuInfo(name,syll,cl,grtot,gr1,gr2,gr3,gr4,gr5));



                }while (cursor.moveToNext());

            }
        }

        cursor.close();
        itemsAdapter = new StuAdapter(getActivity(),students);


        ListView listView = (ListView) rootview.findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);
//        itemsAdapter.notifyDataSetChanged();
        itemsAdapter.setNotifyOnChange(true);
        itemsAdapter.notifyDataSetChanged();
        return rootview;
    }


}


