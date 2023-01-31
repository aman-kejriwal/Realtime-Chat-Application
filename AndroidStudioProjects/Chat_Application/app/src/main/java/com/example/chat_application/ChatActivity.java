package com.example.chat_application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.chat_application.Fragments.ChatFragment;
import com.example.chat_application.databinding.ActivityChatBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class ChatActivity extends AppCompatActivity {
      ActivityChatBinding binding;
      FirebaseDatabase database;
      FirebaseAuth auth;
    @Override
        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityChatBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().hide();
        database=FirebaseDatabase.getInstance();
        auth= FirebaseAuth.getInstance();
        final String senderid=auth.getUid();
        String receiveId=getIntent().getStringExtra("userId");
        String userName=getIntent().getStringExtra("userName");
        String profilePic=getIntent().getStringExtra("profilepic");
        binding.userName.setText(userName);
        Picasso.get().load(profilePic).placeholder(R.drawable.googlecontacts).into(binding.profilePic);
     binding.backArrow.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             Intent intent=new Intent(ChatActivity.this, MainActivity.class);
             startActivity(intent);
         }
     });
    }
}