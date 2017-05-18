package com.example.jsnkrm.project1;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutCompat;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.ArrayList;

import static com.example.jsnkrm.project1.R.string.lvalue;

public class icscActivity extends AppCompatActivity {

    SQLiteHandler sqLiteHandler;

    public ArrayList<gradeDef> icscGradeSystem = new ArrayList<>();

    public ArrayList<idArray> icscId = new ArrayList<>();

    final LinearLayout[] linearLayouts = new LinearLayout[15];

    private int n = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cbse);

        sqLiteHandler = new SQLiteHandler(getApplicationContext());

        icscId = new ArrayList<>();

        Button b = (Button) findViewById(R.id.confirm_button);
        b.setVisibility(View.GONE);

        final LinearLayout ll = (LinearLayout) findViewById(R.id.ll);
        ll.setBackgroundResource(R.color.icsc);

        final EditText[] editTexts = new EditText[3];



        final EditText editText = (EditText) findViewById(R.id.input_field_number);


        Button button = (Button) findViewById(R.id.submit_button);

        button.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
            @Override
            public void onClick(View v) {

                if(editText.getText().toString().trim().isEmpty() == true)
                {
                    editText.setError(getResources().getString(R.string.enter_value));
                }
                else {
                Button b = (Button) findViewById(R.id.confirm_button);
                b.setVisibility(View.VISIBLE);

                n = Integer.parseInt(editText.getText().toString());

                for(int i=0;i<n;i++) {

                    final LinearLayout lLayout = new LinearLayout(getBaseContext());

                    EditText lvalue_input = new EditText(getBaseContext());
                    lvalue_input.setPadding(16,16,16,16);
                    lvalue_input.setTag("a");
                    lvalue_input.setTextColor(R.color.colorAccent);
                    lvalue_input.setInputType(InputType.TYPE_CLASS_NUMBER);
                    lvalue_input.setHint(lvalue);
                    LinearLayout.LayoutParams params = new LinearLayout.LayoutParams
                            (LinearLayoutCompat.LayoutParams.WRAP_CONTENT, LinearLayoutCompat.LayoutParams.WRAP_CONTENT);
                    lLayout.addView(lvalue_input);

                    EditText uvalue_input = new EditText(getBaseContext());
                    uvalue_input.setHint(R.string.uvalue);
                    uvalue_input.setTextColor(R.color.colorAccent);
                    uvalue_input.setPadding(16,16,16,16);
                    uvalue_input.setTag("b");
                    uvalue_input.setInputType(InputType.TYPE_CLASS_NUMBER);
                    lLayout.addView(uvalue_input);

                    //  editTexts[i+1] = uvalue_input;

                    EditText grade_input = new EditText(getBaseContext());
                    grade_input.setHint(R.string.grade);
                    grade_input.setTextColor(R.color.colorAccent);
                    grade_input.setTag("c");
                    grade_input.setPadding(16,16,16,16);
                    grade_input.setInputType(InputType.TYPE_CLASS_TEXT);
                    lLayout.addView(grade_input);

                    //   editTexts[i+2] = grade_input;

                    linearLayouts[i] = lLayout;

                    ll.addView(lLayout,params);


                }


                }
            }

        });

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!validateAddGrade()){}
                else {
                    for (int i = 0; i < n; i++) {
                        EditText editText1 = (EditText) linearLayouts[i].findViewWithTag("a");
                        int lower = Integer.parseInt(editText1.getText().toString());

                        EditText editText2 = (EditText) linearLayouts[i].findViewWithTag("b");
                        int upper = Integer.parseInt(editText2.getText().toString());

                        EditText editText3 = (EditText) linearLayouts[i].findViewWithTag("c");
                        String s = editText3.getText().toString();

                        icscGradeSystem.add(new gradeDef(lower, upper, s));

                        sqLiteHandler.addIcscGrade(String.valueOf(i), lower, upper, s);
                    }

                    finish();
                }

            }


        });



    }

    public boolean validateAddGrade() {
        boolean valid = true;
        for(int i=0; i<n;i++) {
            EditText editText1 = (EditText) linearLayouts[i].findViewWithTag("a");
            String lower = editText1.getText().toString().trim();

            EditText editText2 = (EditText) linearLayouts[i].findViewWithTag("b");
            String upper = editText2.getText().toString().trim();

            EditText editText3 = (EditText) linearLayouts[i].findViewWithTag("c");
            String s = editText3.getText().toString().trim();

            if (lower.isEmpty()) {
                editText1.setError(getResources().getString(R.string.enter_lvalue));
                valid = false;
            } else if (upper.isEmpty()) {
                editText2.setError(getResources().getString(R.string.enter_uvalue));
                valid = false;
            } else if (s.isEmpty()) {
                editText3.setError(getResources().getString(R.string.enter_grade));
                valid = false;
            }
        }
        return valid;
    }
}
