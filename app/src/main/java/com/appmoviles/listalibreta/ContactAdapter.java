package com.appmoviles.listalibreta;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class ContactAdapter extends BaseAdapter {


    /**
     * The contacts to display in the list view
     */
    private ArrayList<Contact> contacts;

    public ContactAdapter() {
        contacts = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return contacts.size();
    }

    @Override
    public Object getItem(int position) {
        return contacts.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    // It is concerned in render an object

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Object which converts xml text in java objects
        LayoutInflater inflater = (LayoutInflater) parent.getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.row, null); // This view will not have parent. It will be independent.

        // Instantiate the components of the row.
        TextView rowNameEt = view.findViewById(R.id.row_name_et);
        TextView rowPhoneEt = view.findViewById(R.id.row_phone_et);
        Button rowCallBtn = view.findViewById(R.id.row_call_btn);
        Button rowRemoveBtn = view.findViewById(R.id.row_remove_btn);

        // Fetch the contact from the model
        final Contact currentContact = (Contact) getItem(position);

        rowCallBtn.setOnClickListener(
                (View v) -> {
                    // Make a call
                }
        );

        rowRemoveBtn.setOnClickListener(
                (View v) -> removeContact(currentContact)
        );

        // Render the information of the contact
        rowNameEt.setText(currentContact.getName());
        rowPhoneEt.setText(currentContact.getPhone());

        return view;
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
        notifyDataSetChanged();
    }

    private void removeContact(Contact contact) {
        contacts.remove(contact);
        notifyDataSetChanged();
    }
}
