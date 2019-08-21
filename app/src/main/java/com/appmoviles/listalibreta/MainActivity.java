package com.appmoviles.listalibreta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private EditText nameEt;

    private EditText phoneEt;

    private Button newContactBtn;

    private ListView contactsList;

    private ContactAdapter contactAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeComponents();
        configureListeners();
    }

    private void initializeComponents() {
        nameEt = findViewById(R.id.name_et);
        phoneEt = findViewById(R.id.phone_et);
        newContactBtn = findViewById(R.id.newContact_btn);
        contactsList = findViewById(R.id.contacts_list);
        contactAdapter = new ContactAdapter();
        contactsList.setAdapter(contactAdapter);
    }

    private void configureListeners() {
        newContactBtn.setOnClickListener(
                (View v) -> {
                    Contact newContact = new Contact();
                    newContact.setName(nameEt.getText().toString());
                    newContact.setPhone(phoneEt.getText().toString());
                    contactAdapter.addContact(newContact);
                }
        );
    }
}
