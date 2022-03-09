package com.gtappdevelopers.videocallingapp;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

import org.jitsi.meet.sdk.JitsiMeetActivity;
import org.jitsi.meet.sdk.JitsiMeetConferenceOptions;

import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            JitsiMeetConferenceOptions options
                    = new JitsiMeetConferenceOptions.Builder()
                    .setServerURL(new URL(""))
                    .setWelcomePageEnabled(false)
                    .build();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }

    public void onButtonClick(View v) {
        TextInputEditText editText = findViewById(R.id.idEdtMeetingRoom);
        String text = editText.getText().toString();
        if (text.length() > 0) {
            JitsiMeetConferenceOptions options
                    = new JitsiMeetConferenceOptions.Builder()
                    .setRoom(text)
                    .build();
            JitsiMeetActivity.launch(this, options);
        }
    }
}