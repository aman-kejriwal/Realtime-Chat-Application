package com.example.chat_application;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.chat_application.Adapter.FragmentAdapter;
import com.example.chat_application.databinding.ActivityMainBinding;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    public static final String FIREBASE_DATABASE_LINK = "https://chat-application-be2ab-default-rtdb.firebaseio.com/";
   ActivityMainBinding binding;
   FirebaseAuth mAuth;
//    @Override
//    public void onBackPressed() {
//        // do something on back.
//        finish();
//        return;
//    }
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        binding= ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        mAuth=FirebaseAuth.getInstance();
//        ViewPagerMessengerAdapter adapter=new ViewPagerMessageAdapter(getSupportFragmentManager());

        binding.viewPager.setAdapter(new FragmentAdapter(getSupportFragmentManager()));
        binding.tabLayout.setupWithViewPager(binding.viewPager);
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater inflater=getMenuInflater();
//        inflater.inflate(R.menu.menu,menu);
//        return super.onCreateOptionsMenu(menu);
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

//        switch(item.getItemId()){
//
//        }
//        return super.onOptionsItemSelected(item);
//    }
}
