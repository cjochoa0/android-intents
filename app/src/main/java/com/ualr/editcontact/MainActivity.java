package com.ualr.editcontact;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.telephony.PhoneNumberFormattingTextWatcher;
import android.view.View;
import android.widget.EditText;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {
    private EditText firstNameEdit;
    private EditText lastNameEdit;
    private EditText phoneEdit;
    private EditText emailEdit;
    private EditText locationEdit;
    private EditText webEdit;


    private MaterialButton saveButton;

    public static final String EXTRA_FIRST_NAME = "fname";
    public static final String EXTRA_LAST_NAME = "lname";
    public static final String EXTRA_PHONE = "phone";
    public static final String EXTRA_EMAIL = "email";
    public static final String EXTRA_LOCATION = "location";
    public static final String EXTRA_WEB = "web";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstNameEdit = findViewById(R.id.firstNameEdit);
        lastNameEdit = findViewById(R.id.lastNameEdit);
        phoneEdit = findViewById(R.id.phoneEdit);
        phoneEdit.addTextChangedListener(new PhoneNumberFormattingTextWatcher());
        emailEdit = findViewById(R.id.emailEdit);
        locationEdit = findViewById(R.id.addressEdit);
        webEdit = findViewById(R.id.webEdit);

        saveButton = findViewById(R.id.saveContact);
    }

    /** Called when the user tabs a button */
    public void onButtonClicked(View view){
        Intent intent = new Intent(this, displayActivity.class);
        intent.putExtra(EXTRA_FIRST_NAME, firstNameEdit.getText().toString());
        intent.putExtra(EXTRA_LAST_NAME, lastNameEdit.getText().toString());
        intent.putExtra(EXTRA_PHONE, phoneEdit.getText().toString());
        intent.putExtra(EXTRA_EMAIL, emailEdit.getText().toString());
        intent.putExtra(EXTRA_LOCATION, locationEdit.getText().toString());
        intent.putExtra(EXTRA_WEB, webEdit.getText().toString());
        startActivity(intent);
    }

}
