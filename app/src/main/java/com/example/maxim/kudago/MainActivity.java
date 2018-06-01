package com.example.maxim.kudago;


import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (isOnline(MainActivity.this)){
            setContentView(R.layout.activity_main);
            Toolbar toolbar = findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            toolbar.setLogo(R.drawable.ic_logo_white);
        } else
        {
            setContentView(R.layout.no_internet);
            Snackbar snackbar = Snackbar.make(
                    findViewById(android.R.id.content),
                    "Невозможно загрузить данные, проверьте" +
                            " соединение с интернетом.",
                    Snackbar.LENGTH_LONG
            );
            snackbar.getView().setBackgroundColor(ContextCompat.getColor(this, R.color.snack_bar));
            snackbar.show();
        }
    }

    public static boolean isOnline(Context context)
    {
        ConnectivityManager connectivityManager =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnectedOrConnecting();
    }

}
