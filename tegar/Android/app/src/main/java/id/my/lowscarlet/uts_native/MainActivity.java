package id.my.lowscarlet.uts_native;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(null);
        }
        TextView appBarTitle = findViewById(R.id.appBarTitle);
        TextView appBarSubTitle = findViewById(R.id.appBarSubTitle);
        appBarTitle.setText("Aplikasi Manajemen E-Portfolio");
        appBarSubTitle.setText("By Tegar Maulana Fahreza");

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragmentContainer, new MainFragment(), "MAIN_FRAGMENT")
                    .commit();
        }
    }
}
