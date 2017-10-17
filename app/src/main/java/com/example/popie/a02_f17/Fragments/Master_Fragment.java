package com.example.popie.a02_f17.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.popie.a02_f17.Model.Contact;
import com.example.popie.a02_f17.R;
import com.example.popie.a02_f17.RecyclerViewAdapter.RecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class Master_Fragment extends Fragment {

    RecyclerView recyclerView;
    List<Contact> contacts;
    RecyclerViewAdapter adapter;

    public Master_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_master_, container, false);

        //recyclerView
        recyclerView = view.findViewById(R.id.recyclerView);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);

        //Data
        contacts = new ArrayList<>();
        contacts.add(new Contact(1, "Arsalan", "", "arslan@gmail.com", "03046284692"));
        contacts.add(new Contact(2, "Badar", "", "badar@gmail.com", "03004760818"));
        contacts.add(new Contact(3, "Faisal", "", "faisal@gmail.com", "03347979265"));
        contacts.add(new Contact(4, "Nazim", "", "nazim@gmail.com", "xxxxxxx"));
        contacts.add(new Contact(5, "Omair", "", "omair@gmail.com", "03224405507"));
        contacts.add(new Contact(6, "Saqib", "", "saqib@gmail.com", "xxxxxxx"));
        contacts.add(new Contact(7, "Umer", "", "umer@gmail.com", "03451522997"));
        contacts.add(new Contact(8, "Zeeshan", "", "zeeshan@gmail.com", "xxxxxxx"));

        for (int i = 9; i <= 1000; i++) {
            contacts.add(new Contact(i, "Name: " + i, "", "example@gmail.com", "xxxxxxxx"));
        }

        //adapter

        adapter = new RecyclerViewAdapter(contacts, getActivity());
        recyclerView.setAdapter(adapter);

        return view;
    }

}
