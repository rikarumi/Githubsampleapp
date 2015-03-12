package com.githubsample.rika.githubsampleapp;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.githubsample.rika.githubsampleapp.model.UserAccount;
import com.rejasupotaro.octodroid.GitHub;

import rx.Subscription;
import rx.android.app.AppObservable;
import rx.subscriptions.Subscriptions;


public class MainActivity extends ActionBarActivity {

    TextView usrTxtview, pwdTxtview;
    EditText usrnameInput, pwdInput;
    Button loginBtn;
    String usrname, password;
    Subscription subscription = Subscriptions.empty();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
                if(usrname.isEmpty() || password.isEmpty()){
                    return;
                }
                loginGithub(usrname, password);

                Toast.makeText(getApplicationContext(),"clicked", Toast.LENGTH_SHORT).show();
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //login process
    void loginGithub(String usrname, String pwd){
        GitHub.client().authorization(usrname,pwd);
            subscription = AppObservable.bindActivity(this, GitHub.client().user()).subscribe(s -> {
                if(s.isSuccessful()){
                    Toast.makeText(getApplicationContext(), "Welcome!", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(), "Incorrect username or password", Toast.LENGTH_SHORT).show();
                }
            }, throwable -> {
                Toast.makeText(getApplicationContext(),"error",Toast.LENGTH_SHORT).show();
            });
    }
}
