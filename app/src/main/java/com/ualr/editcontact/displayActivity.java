package com.ualr.editcontact;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class displayActivity extends AppCompatActivity {

    TextView fullNameText;
    TextView phoneText;
    TextView emailText;
    TextView addressText;
    TextView webText;

    String fName;
    String lName;
    String phone;
    String email;
    String address;
    String web;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        fullNameText = findViewById(R.id.fullNameText);
        phoneText = findViewById(R.id.phoneText);
        emailText = findViewById(R.id.emailText);
        addressText = findViewById(R.id.addressText);
        webText = findViewById(R.id.webText);

        Intent intent = getIntent();

        fName = intent.getStringExtra(MainActivity.EXTRA_FIRST_NAME);
        lName = intent.getStringExtra(MainActivity.EXTRA_LAST_NAME);
        phone = intent.getStringExtra(MainActivity.EXTRA_PHONE);
        email = intent.getStringExtra(MainActivity.EXTRA_EMAIL);
        address = intent.getStringExtra(MainActivity.EXTRA_LOCATION);
        web = intent.getStringExtra(MainActivity.EXTRA_WEB);

        fullNameText.setText(String.format("%s %s", fName, lName));
        phoneText.setText(phone);
        emailText.setText(email);
        addressText.setText(address);
        webText.setText(web);
    }

    public void onCallClick(View view){
        String phoneUri = String.format("tel:%s",phone);
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse(phoneUri));
        startActivity(intent);
    }

    public void onWebClick(View view){
        String webUri = String.format("https://%s/",web);
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(webUri));
        startActivity(intent);
    }

    public void onMapClick(View view){
        String placeUri = String.format("geo:0,0?q=(%s)",address);
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(placeUri));
        startActivity(intent);
    }

    public void onTextClick(View view){
        String smsUri = String.format("smsto:%s",phone);
        Intent intent = new Intent(Intent.ACTION_SENDTO,Uri.parse(smsUri));
        startActivity(intent);
    }

    public void onEmailClick(View view){
        String emailUri = String.format("mailto:%s",email);
        Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse(emailUri));
        startActivity(Intent.createChooser(intent, "To complete action choose"));
    }
}

