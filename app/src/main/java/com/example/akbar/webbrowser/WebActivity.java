package com.example.akbar.webbrowser;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.Toast;

public class WebActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_web, menu);
        return true;
    }
    public void address(View v) {

        EditText et = (EditText) findViewById(R.id.edit);
        WebView wv = (WebView) findViewById(R.id.webView);
        int i =2;


        while (i==0){
            i--;
        }//пример цикла while


        String s = et.getText().toString();
        if (s.equals("")) {//проводится проверка на то что пользователь вообще что то ввел
            Toast.makeText(WebActivity.this, "Введите данные", Toast.LENGTH_SHORT).show();

        } else {

            if (s.startsWith("http://") || s.startsWith("https://")) { // если пользовать ввел http или Https то я сразу открываю сайт котоырй пользоватль ввел

                wv.getSettings().setJavaScriptEnabled(true);//включение в webView javasctipt
                wv.setWebViewClient(new WebViewClient());//опеределение клиента браузера по умолчанию
                wv.setWebChromeClient(new WebChromeClient());////ссылки будут открывать в chrome
                wv.loadUrl(s);//функция загружает сайт указанный в круглых скобках


            } else {

                String sUrl = "http://" + s;
                wv.getSettings().setJavaScriptEnabled(true);
                wv.setWebViewClient(new WebViewClient());
                wv.setWebChromeClient(new WebChromeClient());
                wv.loadUrl(sUrl);

            }

        }

        //    Toast.makeText(WebActivity.this, "Заполните форму", Toast.LENGTH_SHORT).show();


    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent i = new Intent(WebActivity.this, Web2Activity.class);
            startActivity(i);
        }

        return super.onOptionsItemSelected(item);
    }


}
