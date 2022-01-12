package com.example.cobad;

import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.cobad.Database.DBHelper;

import java.text.DecimalFormat;

public class HomeFragment extends Fragment {
    public static String KEY_ACTIVITY = "msg_activity";

    TextView IMTScore,Status,NameHome;
    DBHelper DB;
    Button CountMore;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fr, container, false);
//        IMTScore = (TextView) view.findViewById(R.id.imtScoreHome);
//        Double IMTGET = getArguments().getDouble(KEY_ACTIVITY);
//        if (IMTGET != null) {
//            IMTScore.setText(""+IMTGET);
//        } else {
//            IMTScore.setText("-");
//        }

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        IMTScore = (TextView) view.findViewById(R.id.imtScoreHome);
        Status   = (TextView) view.findViewById(R.id.StatusHome);
        NameHome = (TextView) view.findViewById(R.id.NameHome);
        CountMore = (Button) view.findViewById(R.id.cekIMT);
       DB = new DBHelper(getActivity());

        Cursor res = DB.getdata();
        if (res.getCount() == 0) {
            Toast.makeText(getActivity(), "No Entry Exists", Toast.LENGTH_SHORT).show();
            return;
        }
        StringBuffer buffer = new StringBuffer();

        while (res.moveToNext()) {
            DecimalFormat numberFormat = new DecimalFormat("#.00");
            String name=String.valueOf(res.getString(0));
            NameHome.setText("Hello "+name);
            Status.setText(String.valueOf(res.getString(3)));
            IMTScore.setText(String.valueOf(res.getString(2)));

        }
        CountMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create new fragment and transaction
                IMTCountFragment newFragment = new IMTCountFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.frLay, newFragment);
                transaction.addToBackStack(null);

                // Commit the transaction
                transaction.commit();

            }
        });

//        displayData();

    }

}
