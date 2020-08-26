package com.example.trevt.navigationbar.Login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.trevt.navigationbar.API_LOGIN.APIList;
import com.example.trevt.navigationbar.API_LOGIN.WisatawanListt;
import com.example.trevt.navigationbar.MainActivity;
import com.example.trevt.navigationbar.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class activity_signinn extends AppCompatActivity {

    EditText edtEmail;
    EditText edtPassword;
    Button btnLogin;
    Button btnSkip;

    TextView textSignUp;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_signinn);

        edtEmail = findViewById(R.id.editText_email_login_activity);
        edtPassword = findViewById(R.id.editText_password_login_activity);
        textSignUp = findViewById(R.id.textView_signup_login);
        btnLogin = findViewById(R.id.button_login_activity);
        btnSkip = findViewById(R.id.button_skip_login_activity);



        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = edtEmail.getText().toString();
                String password = edtPassword.getText().toString();


                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(APIList.URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                APIList api = retrofit.create(APIList.class);


                //Login
                Call<WisatawanListt>call = api.login(email,password);
                call.enqueue(new Callback<WisatawanListt>() {
                    @Override
                    public void onResponse(Call<WisatawanListt> call, Response<WisatawanListt> response) {

                        //progress dismiss
                        if (response.code() == 200){
                            Toast.makeText(activity_signinn.this, "Login Sukses", Toast.LENGTH_SHORT).show();
                            Intent main = new Intent(activity_signinn.this, MainActivity.class);
                            startActivity(main);
                            finish();
                        } else {
                            Toast.makeText(activity_signinn.this,"error", Toast.LENGTH_SHORT).show();
                        }
                    }



                    @Override
                    public void onFailure(Call<WisatawanListt> call, Throwable t) {
                        Toast.makeText(activity_signinn.this, "Jaringan Error!", Toast.LENGTH_SHORT).show();
                    }
                });


            }
        });

        btnSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity_signinn.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

        textSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity_signinn.this, activity_signup.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }
}
