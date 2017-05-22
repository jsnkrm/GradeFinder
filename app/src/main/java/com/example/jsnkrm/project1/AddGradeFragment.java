package com.example.jsnkrm.project1;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static android.R.layout.simple_spinner_item;


public class AddGradeFragment extends Fragment {

    private Spinner spinner;

    private Spinner spinner1;

    private SQLiteHandler sqLiteHandler;

    private LinearLayout linearLayout;

    String a,b;

    EditText e1,e2,e3,e4,e5,name;


    StuInfo stuInfo = null;

    public AddGradeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        
        // Inflate the layout for this fragment
        final View rootview = inflater.inflate(R.layout.fragment_add_grade, container, false);

        setspinner1(rootview);

        setspinner2(rootview);

        linearLayout = (LinearLayout)rootview.findViewById(R.id.grade_container);
        spinner = (Spinner) rootview.findViewById(R.id.spinner);
        spinner1 = (Spinner) rootview.findViewById(R.id.spinner1);


        final TextView g1 = (TextView) rootview.findViewById(R.id.grade1);
        final TextView g2 = (TextView) rootview.findViewById(R.id.grade2);
        final TextView g3 = (TextView) rootview.findViewById(R.id.grade3);
        final TextView g4 = (TextView) rootview.findViewById(R.id.grade4);
        final TextView g5 = (TextView) rootview.findViewById(R.id.grade5);
        final TextView gTot = (TextView) rootview.findViewById(R.id.totGrade_Textview);

         e1 = (EditText) rootview.findViewById(R.id.sub1);
         e2 = (EditText) rootview.findViewById(R.id.sub2);
         e3 = (EditText) rootview.findViewById(R.id.sub3);
         e4 = (EditText) rootview.findViewById(R.id.sub4);
         e5 = (EditText) rootview.findViewById(R.id.sub5);
         name = (EditText) rootview.findViewById(R.id.input_name);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                a = (String) spinner.getSelectedItem();
            }


            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                b = (String) spinner1.getSelectedItem();
            }


            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        Button save = (Button) rootview.findViewById(R.id.save_button);
        save.setVisibility(View.GONE);

        final Button eval_button = (Button) rootview.findViewById(R.id.eval_button);

        final Button finalSave = save;
        eval_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!validateAddGrade()){}
                else {

                    eval_button.setVisibility(View.GONE);
                    finalSave.setVisibility(View.VISIBLE);

                    stuInfo = new StuInfo(name.getText().toString(), b, Integer.parseInt(a), Integer.parseInt(e1.getText().toString())
                            , Integer.parseInt(e2.getText().toString()), Integer.parseInt(e3.getText().toString()), Integer.parseInt(e4.getText().toString()),
                            Integer.parseInt(e5.getText().toString()));

                    findGrades(stuInfo);

                    if(stuInfo.getmGrade1() == null ||stuInfo.getmGrade2() == null||stuInfo.getmGrade3() == null
                            ||stuInfo.getmGrade4() == null||stuInfo.getmGrade5() == null)
                            gTot.setText(getResources().getString(R.string.enter_valid_marks));
                    else
                    {
                        linearLayout.setVisibility(View.VISIBLE);
                        g1.setText(stuInfo.getmGrade1());
                        g2.setText(stuInfo.getmGrade2());
                        g3.setText(stuInfo.getmGrade3());
                        g4.setText(stuInfo.getmGrade4());
                        g5.setText(stuInfo.getmGrade5());
                        gTot.setText("Total Grade:" + stuInfo.getmTotGrade());
                    }
                }
            }
        });

        save = (Button) rootview.findViewById(R.id.save_button);

        final Button finalSave1 = save;
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                finalSave1.setVisibility(View.GONE);
                eval_button.setVisibility(View.VISIBLE);

                AddStu(stuInfo);
                stuInfo.ClearStu();

//                ProgressDialog progressDialog = new ProgressDialog(getActivity());
//                progressDialog.setMessage(getResources().getString(R.string.adding_student));
//                progressDialog.setCancelable(true);
//                progressDialog.show();

                linearLayout.setVisibility(View.GONE);
                g1.setText(null);
                g2.setText(null);
                g3.setText(null);
                g4.setText(null);
                g5.setText(null);
                gTot.setText(null);
                e1.setText(null);
                e2.setText(null);
                e3.setText(null);
                e4.setText(null);
                e5.setText(null);
                name.setText(null);

            }
        });


        return rootview;



    }

    private void setspinner1(View view)
    {
        List<String> categories = new ArrayList<>();
        categories.add("1");
        categories.add("2");
        categories.add("3");
        categories.add("4");
        categories.add("5");
        categories.add("6");
        categories.add("7");
        categories.add("8");
        categories.add("9");
        categories.add("10");
        categories.add("11");
        categories.add("12");

        spinner = (Spinner) view.findViewById(R.id.spinner);

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(getActivity().getBaseContext(),simple_spinner_item,categories);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(dataAdapter);
    }


    private void setspinner2(View view)
    {
        List<String> categories = new ArrayList<>();
        categories.add("CBSE");
        categories.add("ICSC");
        categories.add("SSLC");

        spinner1 = (Spinner) view.findViewById(R.id.spinner1);

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(getActivity().getBaseContext(),simple_spinner_item,categories);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner1.setAdapter(dataAdapter);
    }

    private void findGrades(StuInfo stuInfo){

        stuInfo.setmGrade1(getGrade(stuInfo.getmMark1()));
        stuInfo.setmGrade2(getGrade(stuInfo.getmMark2()));
        stuInfo.setmGrade3(getGrade(stuInfo.getmMark3()));
        stuInfo.setmGrade4(getGrade(stuInfo.getmMark4()));
        stuInfo.setmGrade5(getGrade(stuInfo.getmMark5()));

        stuInfo.setmTotMrks((stuInfo.getmMark1()+stuInfo.getmMark2()+stuInfo.getmMark3()+stuInfo.getmMark4()
        +stuInfo.getmMark5())/5);
        stuInfo.setmTotGrade(getGrade(stuInfo.getmTotMrks()));

    }

    private String getGrade(int m)
    {

        sqLiteHandler = new SQLiteHandler(getActivity());

        String grade = null;
        if (stuInfo.getmSyllabus().equals("CBSE"))
        {

            final Cursor cursor = sqLiteHandler.getAllCBSE();

            if (cursor != null && cursor.getCount() != 0)
            {

                if (cursor.moveToFirst())
                {

                    do
                    {
                        int l = Integer.parseInt(cursor.getString(cursor.getColumnIndex("lower_marks")));
                        int u = Integer.parseInt(cursor.getString(cursor.getColumnIndex("upper_marks")));

                        if((l<=m) && (m<=u))
                            grade = cursor.getString(cursor.getColumnIndex("grade"));

                    }while (cursor.moveToNext());

                }
            }

            cursor.close();

        }

        else if(stuInfo.getmSyllabus().equals("ICSC"))
        {
            final Cursor cursor = sqLiteHandler.getAllICSE();

            if (cursor != null && cursor.getCount() != 0)
            {

                if (cursor.moveToFirst())
                {

                    do
                    {
                        int l = Integer.parseInt(cursor.getString(cursor.getColumnIndex("lower_marks")));
                        int u = Integer.parseInt(cursor.getString(cursor.getColumnIndex("upper_marks")));

                        if((l<=m) && (m<=u))
                            grade = cursor.getString(cursor.getColumnIndex("grade"));

                    }while (cursor.moveToNext());

                }
            }

            cursor.close();

        }

        else if (stuInfo.getmSyllabus().equals("SSLC"))
        {
            final Cursor cursor = sqLiteHandler.getAllSSLC();

            if (cursor != null && cursor.getCount() != 0)
            {

                if (cursor.moveToFirst())
                {

                    do
                    {
                        int l = Integer.parseInt(cursor.getString(cursor.getColumnIndex("lower_marks")));
                        int u = Integer.parseInt(cursor.getString(cursor.getColumnIndex("upper_marks")));

                        if((l<=m) && (m<=u))
                            grade = cursor.getString(cursor.getColumnIndex("grade"));

                    }while (cursor.moveToNext());

                }
            }

            cursor.close();
        }
        return grade;
    }

    private void AddStu(StuInfo stu)
    {
        sqLiteHandler = new SQLiteHandler(getActivity());

        sqLiteHandler.addStudent(stu.getmName(),stu.getmSyllabus(),stu.getmClass(),
                stu.getmGrade1(),stu.getmGrade2(),stu.getmGrade3(),stu.getmGrade4(),
                stu.getmGrade5(),stu.getmTotGrade());

    }

    public boolean validateAddGrade() {
        boolean valid = true;
        String stuName = name.getText().toString().trim();
        String sub1 = e1.getText().toString().trim();
        String sub2 = e2.getText().toString().trim();
        String sub3 = e3.getText().toString().trim();
        String sub4 = e4.getText().toString().trim();
        String sub5 = e5.getText().toString().trim();
        if (stuName.isEmpty())
        {
            name.setError(getResources().getString(R.string.please_enter_name));
            valid = false;
        }
        else if (sub1.isEmpty())
        {
            e1.setError(getResources().getString(R.string.enter_sub1));
            valid = false;
        }
        else if (sub2.isEmpty())
        {
            e2.setError(getResources().getString(R.string.enter_sub2));
            valid = false;
        }
        else if (sub3.isEmpty())
        {
            e3.setError(getResources().getString(R.string.enter_sub3));
            valid = false;
        }
        else if (sub4.isEmpty())
        {
            e4.setError(getResources().getString(R.string.enter_sub4));
            valid = false;
        }
        else if (sub5.isEmpty())
        {
            e5.setError(getResources().getString(R.string.enter_sub5));
            valid = false;
        }

        return valid;
    }

}
