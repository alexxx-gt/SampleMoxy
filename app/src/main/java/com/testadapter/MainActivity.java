package com.testadapter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.testadapter.notif2.ui.fragment.blank.Notifs;

public class MainActivity extends AppCompatActivity {

    //NotificationSettingsFragment fragment = new NotificationSettingsFragment();
    Notifs fragment = new Notifs();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getFragmentManager().beginTransaction()
                .replace(R.id.frame, fragment)
                .commit();
    }
}
