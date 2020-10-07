package io.focusminds.shapulate;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class StartScreen extends AppCompatActivity {

    Button playBtn, instBtn;
    TextView closeBtn;
    Intent intent;
    ImageView iAbout,imtathLoveAbout;
    MediaPlayer btnClkSnd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);

        playBtn = findViewById(R.id.btn_play);
        instBtn = findViewById(R.id.instructions_btn);
        btnClkSnd = MediaPlayer.create(this, R.raw.btn_click_snd);


        imtathLoveAbout = findViewById(R.id.mathlove);
        imtathLoveAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                btnClkSnd.start();
                Intent iAbout = new Intent(StartScreen.this,Mathlove.class);
                startActivity(iAbout);
            }
        });


        iAbout = findViewById(R.id.focusminds);
        iAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                btnClkSnd.start();
                Intent iAbout = new Intent(StartScreen.this,FocusMindsAbout.class);
                startActivity(iAbout);
            }
        });

        instBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnClkSnd.start();
                final Dialog closeDlg = new Dialog(StartScreen.this);
                closeDlg.requestWindowFeature(Window.FEATURE_NO_TITLE);
                closeDlg.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                closeDlg.setOnDismissListener(new DialogInterface.OnDismissListener() {
                    @Override
                    public void onDismiss(DialogInterface dialogInterface) {


                    }
                });
                closeDlg.setContentView(R.layout.activity_instructions_popup);
                closeBtn = closeDlg.findViewById(R.id.close_btn);
                closeBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        closeDlg.dismiss();
                    }
                });
                closeDlg.show();
            }
        });
    }

    public void playClick(View view) {
        btnClkSnd.start();
        intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }
}