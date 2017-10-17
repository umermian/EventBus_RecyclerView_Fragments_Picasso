package com.example.popie.a02_f17.RecyclerViewAdapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.popie.a02_f17.ActivityB;
import com.example.popie.a02_f17.Model.Contact;
import com.example.popie.a02_f17.R;
import com.squareup.picasso.Picasso;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ContactViewHolder> {

    List<Contact> contacts;
    Context context;


    public RecyclerViewAdapter(List<Contact> contacts, Context context) {
        this.contacts = contacts;
        this.context = context;
    }

    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view, parent, false);

        return new ContactViewHolder(view);

    }

    @Override
    public void onBindViewHolder(ContactViewHolder holder, int position) {

        Contact contact = contacts.get(position);

        holder.tvName.setText(contact.getName());

        Picasso.with(context)
                .load(R.drawable.placeholder)
                .into(holder.profilepic);

    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    public void onRemove(int position) {

        contacts.remove(position);
        notifyItemRemoved(position);

    }

    public class ContactViewHolder extends RecyclerView.ViewHolder {
        CircleImageView profilepic;
        TextView tvName;
        Button removeButton;

        public ContactViewHolder(View itemView) {
            super(itemView);

            profilepic = itemView.findViewById(R.id.circleImageView);
            tvName = itemView.findViewById(R.id.name);
            removeButton = itemView.findViewById(R.id.removeButton);
            View v = itemView.findViewById(R.id.cardView);

            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Contact contact = contacts.get(getAdapterPosition());
                    Intent intent = new Intent(context, ActivityB.class);
                    context.startActivity(intent);
                    EventBus.getDefault().postSticky(contacts.get(getAdapterPosition()));

                }
            });

            removeButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onRemove(getAdapterPosition());
                    Toast.makeText(context, "Contact Removed!", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

}
