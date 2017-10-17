package com.example.popie.a02_f17.Fragments;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.popie.a02_f17.Model.Contact;
import com.example.popie.a02_f17.R;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

public class DetailFragment extends Fragment {

    private static final String ARG_PARAM = "Contact";

    private static Gson gson = new Gson();
    TextView id, name, email, phone;
    ImageView circleImageView;
    private Contact contact;

    public static DetailFragment newInstance(Contact contact) {
        DetailFragment fragment = new DetailFragment();
        String contactData = gson.toJson(contact);
        Bundle arguments = new Bundle();
        arguments.putString(ARG_PARAM, contactData);
        fragment.setArguments(arguments);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail, container, false);


        id = view.findViewById(R.id.id);
        name = view.findViewById(R.id.name);
        email = view.findViewById(R.id.email);
        phone = view.findViewById(R.id.phone);
        circleImageView = view.findViewById(R.id.profilepic);

        Bundle bundle = getArguments();
        contact = gson.fromJson(bundle.getString(ARG_PARAM), Contact.class);

        id.setText(String.valueOf(contact.getId()));
        name.setText(contact.getName());
        email.setText(contact.getEmail());
        phone.setText(contact.getPhone());
        Picasso.with(getActivity())
                .load(R.drawable.placeholder)
                .into(circleImageView);

        return view;
    }
}