package com.edinsson.contact.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.edinsson.contact.R;
import com.edinsson.contact.modelo.Contact;
import com.google.android.material.textfield.TextInputEditText;

public class Confirm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);
        showToolBar("", false);
        rellenar();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_appbar, menu);
        return true;
    }

    public void showToolBar(String tittle, boolean upButton){
        androidx.appcompat.widget.Toolbar toolbar = (androidx.appcompat.widget.Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(tittle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }

    public void returnMain(View view){
        super.onBackPressed();
    }

    public void rellenar(){
        Bundle bundle = getIntent().getExtras();
        Contact contact = (Contact) bundle.getSerializable("contact");

        TextView name = (TextView) findViewById(R.id.name);
        TextView date = (TextView) findViewById(R.id.date);
        TextView phone = (TextView) findViewById(R.id.phone);
        TextView mail = (TextView) findViewById(R.id.mail);
        TextView contactDescription = (TextView) findViewById(R.id.contact_description);

        name.setText("Nombre: " + contact.getName());
        date.setText("Fecha: " + contact.getDate());
        phone.setText("Telefono: " + contact.getPhone());
        mail.setText("Email: " + contact.getMail());
        contactDescription.setText("Descripcion de contacto: " + contact.getContactDescrition());
    }
}