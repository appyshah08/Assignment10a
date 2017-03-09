package com.example.anand.assignment10a;

import android.animation.Animator;
import android.content.DialogInterface;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    LinearLayout linearLayout;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=(Button)findViewById(R.id.button);
        linearLayout= (LinearLayout) findViewById(R.id.linearLayout);
        button.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertDialog=new AlertDialog.Builder(MainActivity.this);

                int x=linearLayout.getWidth()/2;
                int y=linearLayout.getHeight()/2;
                float initialRadius = (float) Math.hypot(x, y);
                final Animator animation= ViewAnimationUtils.createCircularReveal(linearLayout, x,y, initialRadius, 0);
                animation.start();
                alertDialog.setTitle(R.string.title);
                alertDialog.setMessage(R.string.description);
                alertDialog.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                       animation.end();
                    }
                });
                alertDialog.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                       animation.end();
                    }
                });
                AlertDialog alertDialog1=alertDialog.create();
                alertDialog1.show();

            }
        });
    }
}
