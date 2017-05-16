package com.example.jsnkrm.project1;

import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Objects;

/**
 * Created by jsnkrm on 16/5/17.
 */

public class deleteTables extends AppCompatActivity {

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
        editText.setHint(R.string.delete_hint);

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
                    b.setText(R.string.confirm_delete);

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
                    b.setText(R.string.confirm_delete);

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
                    b.setText(R.string.confirm_delete);

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

                    finish();
                }
            });

        }
    }
}
