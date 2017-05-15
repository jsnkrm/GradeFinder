package com.example.jsnkrm.project1;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by jsnkrm on 15/5/17.
 */

public class icscSettings extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cbse_settings);

        Button addnew = (Button) findViewById(R.id.add_new_button);
        addnew.setBackgroundResource(R.color.icsc);

        addnew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(),icscActivity.class);
                startActivity(intent);
            }
        });

        Button mod = (Button) findViewById(R.id.modify_button);
        mod.setBackgroundResource(R.color.icsc);
        mod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(),modifyTables.class);
                intent.putExtra("syllabus","ICSC");
                startActivity(intent);
            }
        });

    }
}
