package com.example.jsnkrm.project1;

import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutCompat;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Objects;

import static com.example.jsnkrm.project1.R.string.lvalue;

/**
 * Created by jsnkrm on 15/5/17.
 */

public class modifyTables extends AppCompatActivity {

    SQLiteHandler sqLiteHandler;

    Cursor cursor;

    int low,up,i=0;

    String gr;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_modify_tables);

        String msyll = getIntent().getStringExtra("syllabus");

        sqLiteHandler = new SQLiteHandler(getApplicationContext());

        Button b = (Button) findViewById(R.id.continue_modify_button);
        b.setVisibility(View.GONE);

        Button c = (Button) findViewById(R.id.confirm_modify_button);
        c.setVisibility(View.GONE);

        final LinearLayout ll = (LinearLayout) findViewById(R.id.ll_modify);
        ll.setBackgroundResource(R.color.cbse);

        final EditText editText = (EditText) findViewById(R.id.modify_grade_input);

        Button button = (Button) findViewById(R.id.submit_button_modify);

        final TextView lowText = (TextView) findViewById(R.id.lower_mark_modify);
        final TextView upText = (TextView) findViewById(R.id.upper_mark_modify);
        final TextView gradeText = (TextView) findViewById(R.id.grade_modify);

        if(Objects.equals(msyll, "CBSE"))
        {

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Button b = (Button) findViewById(R.id.continue_modify_button);
                    b.setVisibility(View.VISIBLE);

                    String grade = editText.getText().toString();

                    cursor = sqLiteHandler.getCBSErow(grade);

                    if (cursor != null && cursor.getCount() != 0)
                    {

                        if (cursor.moveToFirst())
                        {

                            do
                            {
                                low = Integer.parseInt(cursor.getString(cursor.getColumnIndex("lower_marks")));
                                up = Integer.parseInt(cursor.getString(cursor.getColumnIndex("upper_marks")));
                                gr = cursor.getString(cursor.getColumnIndex("grade"));

                            } while (cursor.moveToNext());

                        }
                    }

                    cursor.close();

                    lowText.setText("Lower Marks: " + low);
                    upText.setText("Upper Marks: "+ up);
                    gradeText.setText("Grade: "+ gr);

                }
            });

            final Button mod = (Button) findViewById(R.id.continue_modify_button);

            mod.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    String grade = editText.getText().toString();

                    sqLiteHandler.deleteCBSErow(grade);

                    mod.setVisibility(View.GONE);

                    Button c = (Button) findViewById(R.id.confirm_modify_button);
                    c.setVisibility(View.VISIBLE);

                    final LinearLayout lLayout = new LinearLayout(getBaseContext());

                    EditText lvalue_input = new EditText(getBaseContext());
                    lvalue_input.setPadding(16, 16, 16, 16);
                    lvalue_input.setTag("a");
                    lvalue_input.setTextColor(R.color.colorAccent);
                    lvalue_input.setInputType(InputType.TYPE_CLASS_NUMBER);
                    lvalue_input.setHint(lvalue);
                    LinearLayout.LayoutParams params = new LinearLayout.LayoutParams
                            (LinearLayoutCompat.LayoutParams.WRAP_CONTENT, LinearLayoutCompat.LayoutParams.WRAP_CONTENT);
                    lLayout.addView(lvalue_input);

                    EditText uvalue_input = new EditText(getBaseContext());
                    uvalue_input.setTextColor(R.color.colorAccent);
                    uvalue_input.setHint(R.string.uvalue);
                    uvalue_input.setPadding(16, 16, 16, 16);
                    uvalue_input.setTag("b");
                    uvalue_input.setInputType(InputType.TYPE_CLASS_NUMBER);
                    lLayout.addView(uvalue_input);


                    EditText grade_input = new EditText(getBaseContext());
                    grade_input.setHint(R.string.grade);
                    grade_input.setTextColor(R.color.colorAccent);
                    grade_input.setTag("c");
                    grade_input.setPadding(16, 16, 16, 16);
                    grade_input.setInputType(InputType.TYPE_CLASS_TEXT);
                    lLayout.addView(grade_input);

                    ll.addView(lLayout, params);


                }
            });

            Button confirm = (Button) findViewById(R.id.confirm_modify_button);
            confirm.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                        i++;

                        EditText editText1 = (EditText) ll.findViewWithTag("a");
                        int lower = Integer.parseInt(editText1.getText().toString());

                        EditText editText2 = (EditText) ll.findViewWithTag("b");
                        int upper = Integer.parseInt(editText2.getText().toString());

                        EditText editText3 = (EditText) ll.findViewWithTag("c");
                        String s = editText3.getText().toString();

                        sqLiteHandler.addCbseGrade(String.valueOf(i),lower,upper,s);

                        finish();
                }


            });

        }


        else if(Objects.equals(msyll, "SSLC"))
        {

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Button b = (Button) findViewById(R.id.continue_modify_button);
                    b.setVisibility(View.VISIBLE);

                    String grade = editText.getText().toString();

                    cursor = sqLiteHandler.getSSLCrow(grade);

                    if (cursor != null && cursor.getCount() != 0)
                    {

                        if (cursor.moveToFirst())
                        {

                            do
                            {
                                low = Integer.parseInt(cursor.getString(cursor.getColumnIndex("lower_marks")));
                                up = Integer.parseInt(cursor.getString(cursor.getColumnIndex("upper_marks")));
                                gr = cursor.getString(cursor.getColumnIndex("grade"));

                            } while (cursor.moveToNext());

                        }
                    }

                    cursor.close();

                    lowText.setText("Lower Marks: " + low);
                    upText.setText("Upper Marks: "+ up);
                    gradeText.setText("Grade: "+ gr);

                }
            });

            final Button mod = (Button) findViewById(R.id.continue_modify_button);

            mod.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    String grade = editText.getText().toString();

                    sqLiteHandler.deleteSSLCrow(grade);

                    mod.setVisibility(View.GONE);

                    Button c = (Button) findViewById(R.id.confirm_modify_button);
                    c.setVisibility(View.VISIBLE);

                    final LinearLayout lLayout = new LinearLayout(getBaseContext());

                    EditText lvalue_input = new EditText(getBaseContext());
                    lvalue_input.setPadding(16, 16, 16, 16);
                    lvalue_input.setTag("a");
                    lvalue_input.setTextColor(R.color.colorAccent);
                    lvalue_input.setInputType(InputType.TYPE_CLASS_NUMBER);
                    lvalue_input.setHint(lvalue);
                    LinearLayout.LayoutParams params = new LinearLayout.LayoutParams
                            (LinearLayoutCompat.LayoutParams.WRAP_CONTENT, LinearLayoutCompat.LayoutParams.WRAP_CONTENT);
                    lLayout.addView(lvalue_input);

                    EditText uvalue_input = new EditText(getBaseContext());
                    uvalue_input.setTextColor(R.color.colorAccent);
                    uvalue_input.setHint(R.string.uvalue);
                    uvalue_input.setPadding(16, 16, 16, 16);
                    uvalue_input.setTag("b");
                    uvalue_input.setInputType(InputType.TYPE_CLASS_NUMBER);
                    lLayout.addView(uvalue_input);


                    EditText grade_input = new EditText(getBaseContext());
                    grade_input.setHint(R.string.grade);
                    grade_input.setTextColor(R.color.colorAccent);
                    grade_input.setTag("c");
                    grade_input.setPadding(16, 16, 16, 16);
                    grade_input.setInputType(InputType.TYPE_CLASS_TEXT);
                    lLayout.addView(grade_input);

                    ll.addView(lLayout, params);


                }
            });

            Button confirm = (Button) findViewById(R.id.confirm_modify_button);
            confirm.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    i++;

                    EditText editText1 = (EditText) ll.findViewWithTag("a");
                    int lower = Integer.parseInt(editText1.getText().toString());

                    EditText editText2 = (EditText) ll.findViewWithTag("b");
                    int upper = Integer.parseInt(editText2.getText().toString());

                    EditText editText3 = (EditText) ll.findViewWithTag("c");
                    String s = editText3.getText().toString();

                    sqLiteHandler.addSslcGrade(String.valueOf(i),lower,upper,s);

                    finish();
                }


            });

        }

        else if(Objects.equals(msyll, "ICSC"))
        {

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Button b = (Button) findViewById(R.id.continue_modify_button);
                    b.setVisibility(View.VISIBLE);

                    String grade = editText.getText().toString();

                    cursor = sqLiteHandler.getICSCrow(grade);

                    if (cursor != null && cursor.getCount() != 0)
                    {

                        if (cursor.moveToFirst())
                        {

                            do
                            {
                                low = Integer.parseInt(cursor.getString(cursor.getColumnIndex("lower_marks")));
                                up = Integer.parseInt(cursor.getString(cursor.getColumnIndex("upper_marks")));
                                gr = cursor.getString(cursor.getColumnIndex("grade"));

                            } while (cursor.moveToNext());

                        }
                    }

                    cursor.close();

                    lowText.setText("Lower Marks: " + low);
                    upText.setText("Upper Marks: "+ up);
                    gradeText.setText("Grade: "+ gr);

                }
            });

            final Button mod = (Button) findViewById(R.id.continue_modify_button);

            mod.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    String grade = editText.getText().toString();

                    sqLiteHandler.deleteICSCrow(grade);

                    mod.setVisibility(View.GONE);

                    Button c = (Button) findViewById(R.id.confirm_modify_button);
                    c.setVisibility(View.VISIBLE);

                    final LinearLayout lLayout = new LinearLayout(getBaseContext());

                    EditText lvalue_input = new EditText(getBaseContext());
                    lvalue_input.setPadding(16, 16, 16, 16);
                    lvalue_input.setTag("a");
                    lvalue_input.setTextColor(R.color.colorAccent);
                    lvalue_input.setInputType(InputType.TYPE_CLASS_NUMBER);
                    lvalue_input.setHint(lvalue);
                    LinearLayout.LayoutParams params = new LinearLayout.LayoutParams
                            (LinearLayoutCompat.LayoutParams.WRAP_CONTENT, LinearLayoutCompat.LayoutParams.WRAP_CONTENT);
                    lLayout.addView(lvalue_input);

                    EditText uvalue_input = new EditText(getBaseContext());
                    uvalue_input.setTextColor(R.color.colorAccent);
                    uvalue_input.setHint(R.string.uvalue);
                    uvalue_input.setPadding(16, 16, 16, 16);
                    uvalue_input.setTag("b");
                    uvalue_input.setInputType(InputType.TYPE_CLASS_NUMBER);
                    lLayout.addView(uvalue_input);


                    EditText grade_input = new EditText(getBaseContext());
                    grade_input.setHint(R.string.grade);
                    grade_input.setTextColor(R.color.colorAccent);
                    grade_input.setTag("c");
                    grade_input.setPadding(16, 16, 16, 16);
                    grade_input.setInputType(InputType.TYPE_CLASS_TEXT);
                    lLayout.addView(grade_input);

                    ll.addView(lLayout, params);


                }
            });

            Button confirm = (Button) findViewById(R.id.confirm_modify_button);
            confirm.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    i++;

                    EditText editText1 = (EditText) ll.findViewWithTag("a");
                    int lower = Integer.parseInt(editText1.getText().toString());

                    EditText editText2 = (EditText) ll.findViewWithTag("b");
                    int upper = Integer.parseInt(editText2.getText().toString());

                    EditText editText3 = (EditText) ll.findViewWithTag("c");
                    String s = editText3.getText().toString();

                    sqLiteHandler.addIcscGrade(String.valueOf(i),lower,upper,s);

                    finish();
                }


            });

        }
    }
}
