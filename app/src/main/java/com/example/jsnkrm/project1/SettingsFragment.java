package com.example.jsnkrm.project1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class SettingsFragment extends Fragment {

    public SettingsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View rootview =  inflater.inflate(R.layout.fragment_settings, container, false);

        final Button cbse = (Button) rootview.findViewById(R.id.checkbox_cbse);

        cbse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getContext(),cbseActivity.class);
                startActivity(intent);
            }
        });

        final Button icsc = (Button) rootview.findViewById(R.id.checkbox_icsc);

        icsc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getContext(),icscActivity.class);
                startActivity(intent);
            }
        });

        final Button sslc = (Button) rootview.findViewById(R.id.checkbox_sslc);

        sslc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getContext(),sslcActivity.class);
                startActivity(intent);
            }
        });

        return rootview;
    }

    }
