package com.example.kbs.a0410_2;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(findViewById(R.id.fragment_container)!=null){
            if(savedInstanceState!=null){
                return;
            }
            FragmentA first = new FragmentA();
            first.setArguments(getIntent().getExtras());

            getFragmentManager().beginTransaction().add(R.id.fragment_container, first).commit();
        }

    }
    public void selectFragment(View view) {
        Fragment fr = null;

        switch (view.getId()){
            case R.id.button2:
                fr = new FragmentA();
                break;
            case R.id.button3:
                fr = new FragmentB();
                break;
        }
        FragmentManager fm = getFragmentManager();
        FragmentTransaction  fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container,fr);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
