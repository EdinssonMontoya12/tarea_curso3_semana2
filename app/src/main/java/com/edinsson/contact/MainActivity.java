package com.edinsson.contact;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.DatePicker;

import com.edinsson.contact.modelo.Contact;
import com.edinsson.contact.recursos.DatePickerFragment;
import com.edinsson.contact.view.Confirm;
import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showToolBar("", false);
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

    public void showDatePicker(View view){
        showDatePickerDialog();
    }

    private void showDatePickerDialog(){
        DatePickerFragment datePickerFragment = DatePickerFragment.newInstance(new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                final String dateSelected = day + "/" + (month+1) + "/" + year;
                TextInputEditText textInputEditText = (TextInputEditText) findViewById(R.id.date);
                textInputEditText.setText(dateSelected);
            }
        });

        datePickerFragment.show(getSupportFragmentManager(), "datePicker");
    }

    public void goToConfirm(View view){

        TextInputEditText textInputEditText = (TextInputEditText) findViewById(R.id.name_contact);
        String name = textInputEditText.getText().toString();

        TextInputEditText textInputEditText1 = (TextInputEditText) findViewById(R.id.date);
        String date = textInputEditText1.getText().toString();

        TextInputEditText textInputEditText2 = (TextInputEditText) findViewById(R.id.phone);
        String phone = textInputEditText2.getText().toString();

        TextInputEditText textInputEditText3 = (TextInputEditText) findViewById(R.id.mail);
        String mail = textInputEditText3.getText().toString();

        TextInputEditText textInputEditText4 = (TextInputEditText) findViewById(R.id.contact_description);
        String contactDescription = textInputEditText4.getText().toString();

        Contact contact = new Contact(name, date, phone, mail, contactDescription);

        Intent intent = new Intent(this, Confirm.class);

        Bundle bundle = new Bundle();
        bundle.putSerializable("contact", contact);

        intent.putExtras(bundle);
        startActivity(intent);
    }
}