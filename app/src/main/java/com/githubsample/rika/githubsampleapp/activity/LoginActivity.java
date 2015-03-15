package com.githubsample.rika.githubsampleapp.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.githubsample.rika.githubsampleapp.R;
import com.rejasupotaro.octodroid.GitHub;

import rx.Subscription;
import rx.android.app.AppObservable;
import rx.subscriptions.Subscriptions;

public class LoginActivity extends Activity {
    TextView usrTxtview, pwdTxtview;
    EditText usrnameInput, pwdInput;
    Button loginBtn;

    String usrname, password;
    public static final String myPreferences = "MyPrefs";
    public static final String myPref_username = "username";
    public static final String myPref_password = "password";

    Subscription subscription = Subscriptions.empty();
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usrTxtview = (TextView) findViewById(R.id.usrTxtView);
        pwdTxtview = (TextView) findViewById(R.id.pwdTxtView);

        usrnameInput = (EditText) findViewById(R.id.usrnameInput);
        pwdInput = (EditText) findViewById(R.id.pwdInput);

        loginBtn = (Button) findViewById(R.id.loginBtn);
        loginBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                usrname = usrnameInput.getText().toString();
                password = pwdInput.getText().toString();
                if(usrname.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Input your username", Toast.LENGTH_SHORT).show();
                    return;
                }else if(password.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Input your password", Toast.LENGTH_SHORT).show();
                    return;
                }
                loginGithub(usrname, password);
            }
        });

    }

    void loginGithub(String usrname, String password){
        GitHub.client().authorization(usrname,password);
        subscription = AppObservable.bindActivity(this, GitHub.client().user()).subscribe(s -> {
            if(s.isSuccessful()){
                Toast.makeText(getApplicationContext(), "Welcome!", Toast.LENGTH_SHORT).show();
                sessionManagement(usrname, password);
            }
        }, throwable -> {
            Log.getStackTraceString(throwable);
            Toast.makeText(getApplicationContext(),"error",Toast.LENGTH_SHORT).show();
        });
    }

    public void sessionManagement(String usrname,String password){
        sharedPreferences = getSharedPreferences(myPreferences, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.putString(myPref_username,usrname);
        editor.putString(myPref_password, password);
        editor.commit();

        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}
