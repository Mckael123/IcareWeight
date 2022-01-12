package com.example.cobad;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SetFragment extends Fragment {
    @Nullable

    //nampilin layout
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.set_fr,container,false);
    }

    //logic yang sama kyk Activity biasa di sini
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
       Button btnLogOut = (Button) view.findViewById(R.id.btnLogout);
       btnLogOut.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent LogOutIntent = new Intent(getActivity(), MainActivity.class);
               startActivity(LogOutIntent);
           }
       });
    }
}
