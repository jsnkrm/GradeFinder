package com.example.jsnkrm.project1;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by jsnkrm on 11/5/17.
 */

public class StuAdapter extends ArrayAdapter<StuInfo> {

    public StuAdapter(Activity context, ArrayList<StuInfo> stu)
    {
        super(context,0,stu);

    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        StuInfo currentStu = getItem(position);

        if(currentStu.getmSyllabus().equals("CBSE"))
            listItemView.setBackgroundResource(R.color.cbse);
        else if (currentStu.getmSyllabus().equals("ICSC"))
            listItemView.setBackgroundResource(R.color.icsc);
        else if (currentStu.getmSyllabus().equals("SSLC"))
            listItemView.setBackgroundResource(R.color.sslc);

        TextView name = (TextView) listItemView.findViewById(R.id.name_textview);
        name.setText("NAME: " + currentStu.getmName());

        TextView syll = (TextView) listItemView.findViewById(R.id.syll_textview);
        syll.setText("SYLLABUS: " + currentStu.getmSyllabus());

        TextView cl  = (TextView) listItemView.findViewById(R.id.class_textview);
        cl.setText("CLASS: " + currentStu.getmClass());

        TextView sub1 = (TextView) listItemView.findViewById(R.id.sub1_show);
        sub1.setText("SUBJECT 1:"+ currentStu.getmGrade1());

        TextView sub2 = (TextView) listItemView.findViewById(R.id.sub2_show);
        sub2.setText("SUBJECT 2:"+ currentStu.getmGrade2());

        TextView sub3 = (TextView) listItemView.findViewById(R.id.sub3_show);
        sub3.setText("SUBJECT 3:"+ currentStu.getmGrade3());

        TextView sub4 = (TextView) listItemView.findViewById(R.id.sub4_show);
        sub4.setText("SUBJECT 4:"+ currentStu.getmGrade4());

        TextView sub5 = (TextView) listItemView.findViewById(R.id.sub5_show);
        sub5.setText("SUBJECT 5:"+ currentStu.getmGrade5());

        TextView subtot = (TextView) listItemView.findViewById(R.id.totgrade_show);
        subtot.setText("TOTAL GRADE:"+ currentStu.getmTotGrade());


        return listItemView;
    }
}
