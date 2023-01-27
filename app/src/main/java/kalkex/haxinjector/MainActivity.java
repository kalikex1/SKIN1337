package kalkex.haxinjector;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
        Switch tunron;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        tunron = findViewById(R.id.play_protect_turn_off);
        tunron.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    Toast.makeText(MainActivity.this, "Turn Off Play Protect", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent();
                    i.setClassName("com.google.android.gms", "com.google.android.gms.security.settings.VerifyAppsSettingsActivity" );
                    try {
                        startActivity(i);
                    } catch (android.content.ActivityNotFoundException ex) {
                        Toast.makeText(getApplicationContext(), "Activity Not Found", Toast.LENGTH_LONG).show();
                    }
                }else {
                    Toast.makeText(MainActivity.this, "Please turn Off Your Play Protect", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}