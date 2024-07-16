package net.taufik;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set custom title
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(null);
        }

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragmentContainer, new MainFragment(), "MAIN_FRAGMENT")
                    .commit();
        }
    }
}
