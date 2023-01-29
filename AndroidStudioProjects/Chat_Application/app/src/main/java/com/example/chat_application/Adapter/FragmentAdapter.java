package com.example.chat_application.Adapter;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.chat_application.Fragments.CallsFragment;
import com.example.chat_application.Fragments.ChatFragment;
import com.example.chat_application.Fragments.StatusFragment;

public class FragmentAdapter extends FragmentPagerAdapter {

    public FragmentAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }
    @Override
    public Fragment getItem(int position){
        switch (position){
            case 0:return new ChatFragment();
            case 1:return new StatusFragment();
            case 2:return new CallsFragment();
            default:return new ChatFragment();
        }
    }
    @Override
    public int getCount() {
        return 3;
    }
    @Override
    public CharSequence getPageTitle(int position) {
//        Log.d("TAG","AMan");
        String title =null;
        if(position==0){
            Log.d("TAG","AMan");
            title="CHATS";
        }
         if(position==1)
        {
            title="STATUS";
        }
        if(position==2)
        title="CALLS";
        return title;
    }
}
