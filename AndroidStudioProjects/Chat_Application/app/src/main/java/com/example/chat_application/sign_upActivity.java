package com.example.chat_application;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.chat_application.Models.Users;
import com.example.chat_application.databinding.ActivitySignUpBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class sign_upActivity extends AppCompatActivity{
       private FirebaseAuth mAuth;
       ActivitySignUpBinding binding;
       FirebaseDatabase database;
       ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_sign_up);
        binding =ActivitySignUpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        mAuth=FirebaseAuth.getInstance();
        database=FirebaseDatabase.getInstance();
        getSupportActionBar().hide();

        progressDialog=new ProgressDialog(sign_upActivity.this);
        progressDialog.setTitle("Creating Account");
        progressDialog.setMessage("we are creating your account");

      binding.btnSignUp.setOnClickListener(new View.OnClickListener(){
          @Override
          public void onClick(View v){
       if(!binding.txtUsername.getText().toString().isEmpty()&&!binding.txtPassword.getText().toString().isEmpty()&&!binding.txtEmail.getText().toString().isEmpty()){
           progressDialog.show();
             mAuth.createUserWithEmailAndPassword(binding.txtEmail.getText().toString(),binding.txtPassword.getText().toString())
           .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
               @Override
               public void onComplete(@NonNull Task<AuthResult> task) {
                   progressDialog.dismiss();
               if(task.isSuccessful())
               {
                   //creating a user and adding it to the firebase database
                   Users users=new Users(binding.txtUsername.getText().toString(),binding.txtEmail.getText().toString(),binding.txtPassword.getText().toString());
                   String id=task.getResult().getUser().getUid();
                   // adding users to a particular id in database
                   database.getReference().child("Users").child(id).setValue(users);
                   //
                   Toast.makeText(sign_upActivity.this, "Sign Up Succesfull", Toast.LENGTH_SHORT).show();
                      }
               else {
                   Toast.makeText(sign_upActivity.this, task.getException().toString(), Toast.LENGTH_SHORT).show();
               }
               }
           });
       }
       else {
           Toast.makeText(sign_upActivity.this, "Enter creadential", Toast.LENGTH_SHORT).show();
       }
          }
      });

    }
}