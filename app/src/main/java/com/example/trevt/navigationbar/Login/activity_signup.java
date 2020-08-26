package com.example.trevt.navigationbar.Login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.trevt.navigationbar.API_LOGIN.APIList;
import com.example.trevt.navigationbar.API_LOGIN.WisatawanListt;
import com.example.trevt.navigationbar.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class activity_signup extends AppCompatActivity {
    EditText edtFullName;
    EditText edtMobile;
    EditText edtEmail;
    EditText edtPassword;
    EditText edtRepass;
    Button btnSignUp;
    TextView txtlogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_signup);

        edtFullName = findViewById(R.id.editText_name_register);
        edtMobile = findViewById(R.id.editText_phoneNo_register);
        edtEmail = findViewById(R.id.editText_email_register);
        edtPassword = findViewById(R.id.editText_password_register);
        edtRepass = findViewById(R.id.editText_repassword_register);
        txtlogin = findViewById(R.id.textView_login_register);


        btnSignUp = findViewById(R.id.button_submit);


        btnSignUp.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String username_wisatawan = edtFullName.getText().toString();
                String notelp = edtMobile.getText().toString();
                String email = edtEmail.getText().toString();
                String password = edtPassword.getText().toString();
                String repassword = edtRepass.getText().toString();


                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(APIList.URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                APIList api = retrofit.create(APIList.class);


                //Register
                Call<WisatawanListt> call = api.register(username_wisatawan, notelp, email, password, repassword);
                call.enqueue(new Callback<WisatawanListt>() {
                    @Override
                    public void onResponse(Call<WisatawanListt> call, Response<WisatawanListt> response) {
//                        Integer status = response.body().getStatus();
//                        boolean error = response.body().isError();
//                        String message = response.body().getMessage();

                        //progress.dismiss();
//                        Log.d("test", "Errronya " + error);
                        if (response.code() == 200){
                            Toast.makeText(activity_signup.this, "Register Sukses", Toast.LENGTH_SHORT).show();
                            Intent main = new Intent(activity_signup.this, activity_signinn.class);
                            startActivity(main);
                            finish();
                        } else {
                            Toast.makeText(activity_signup.this,"error", Toast.LENGTH_SHORT).show();
                        }
                   }

//


                        @Override
                        public void onFailure(Call<WisatawanListt> call, Throwable t) {
                            //progress.dismiss();
                            Toast.makeText(activity_signup.this, "Jaringan Error!", Toast.LENGTH_SHORT).show();
                        }
                    });

            }
        });

        txtlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity_signup.this, activity_signinn.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
//
    }
}


//    Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case android.R.id.home:
//                finish();
//                break;
//        }
//        return super.onOptionsItemSelected(item);
//    }
//}




