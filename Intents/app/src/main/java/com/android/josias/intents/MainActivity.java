package com.android.josias.intents;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;

import com.android.josias.intents.core.ControllerMainActivity;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void nextScreen(View v){
        Intent i = new Intent(this, SecondActivity.class);
        startActivity(i);
        //Não vai voltar para a MainActivity :)
        finish();
    }

    public void nextDataTransf(View v){
        Intent i = new Intent(this, SecondActivity.class);
        i.putExtra("tagName", "o valor foi esse aqui!");
        startActivity(i);
    }

    public void nextDataTransf2(View v){
        ControllerMainActivity.getInstance().setValue("O valor é esse aqui do controller!");

        Intent i = new Intent(this, SecondActivity.class);
        startActivity(i);
    }

    public void discagem(View v){
        Intent i = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:8388884444"));
        startActivity(i);
    }

    public void chamada(View v){
        Intent i = new Intent(Intent.ACTION_CALL, Uri.parse("tel:8388884444"));
        startActivity(i);
    }

    public void sendEmail(View v){
        Intent emailIntent = new Intent(
                Intent.ACTION_SENDTO, Uri.fromParts("mailto","abc@gmail.com", null));
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Assunto email");
        emailIntent.putExtra(Intent.EXTRA_TEXT   , "Corpo do email");
        startActivity(Intent.createChooser(emailIntent, "Enviando email..."));
    }

    public void shareText(View v){
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_TEXT   , "Opa! Blz?");
        startActivity(emailIntent);
    }

}
