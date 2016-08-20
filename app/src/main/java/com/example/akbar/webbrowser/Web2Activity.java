package com.example.akbar.webbrowser;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class Web2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TextView num = (TextView) findViewById(R.id.textView);
        TextView em = (TextView) findViewById(R.id.textView2);
        TextView f = (TextView) findViewById(R.id.textView3);


        String numberString = getIntent().getStringExtra("num");
        String emailString = getIntent().getStringExtra("em");
        String facebookString = getIntent().getStringExtra("s");


        num.setText(" Введите номер: " + numberString);
        em.setText(" E-mail: " + emailString);
        f.setText(" facebook: " + facebookString);
    }


    public void mailDeveloper(View view) {
        Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                " mailto ", " sinnigami@gmail.com ", null));
        startActivity(Intent.createChooser(intent, " Выбирите почтовую программу :"));
    }

    public void callDeveloper(View view) {
        String phone = "+996550953075";
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + phone));


        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        startActivity(intent);

    }
}


