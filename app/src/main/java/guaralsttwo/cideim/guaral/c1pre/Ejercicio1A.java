package guaralsttwo.cideim.guaral.c1pre;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Ejercicio1A extends AppCompatActivity {

    private Button configBtn, shareButton, notiButton, hotButton;
    private RelativeLayout profile_base_container;
    private TextView profile_descripcion;
    private TextView profile_title;

    public static final int BLACK = 0;
    public static final int WHITE = 1;
    public static final int BLUE = 2;
    public static final int COLOR_ACTIVITY = 101;


    private int tema = WHITE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio1_a);

        profile_base_container = findViewById(R.id.profile_base_container);
        profile_descripcion = findViewById(R.id.profile_descripcion);
        profile_title = findViewById(R.id.profile_title);
        shareButton = findViewById(R.id.share_button);
        notiButton = findViewById(R.id.noti_button);
        hotButton = findViewById(R.id.hot_button);
        configBtn = findViewById(R.id.config_btn);

        configBtn.setOnClickListener(
                (View v) -> {
                    Intent i = new Intent(this, Ejercicio1B.class);
                    i.putExtra("actualColor", tema);
                    startActivityForResult(i, COLOR_ACTIVITY);
                }
        );
        cambiarTema();
    }

    public void cambiarTema(){
        int fondo =0;
        int contraste=0;
        switch (tema){
            case WHITE:
                fondo = Color.rgb(255,255,255);
                contraste = Color.rgb(0,0,0);
                break;
            case BLACK:
                fondo = Color.rgb(50,50,50);
                contraste = Color.rgb(255,255,255);
                break;
            case BLUE:
                fondo = Color.rgb(50,40,105);
                contraste = Color.rgb(255,255,255);
                break;
        }

        profile_base_container.setBackgroundColor( fondo );
        profile_descripcion.setTextColor( contraste );
        profile_title.setTextColor( contraste );
        configBtn.setBackgroundTintList(ColorStateList.valueOf(contraste));
        shareButton.setBackgroundTintList(ColorStateList.valueOf(contraste));
        notiButton.setBackgroundTintList(ColorStateList.valueOf(contraste));
        hotButton.setBackgroundTintList(ColorStateList.valueOf(contraste));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == COLOR_ACTIVITY && resultCode == RESULT_OK){
            String color = data.getExtras().getString("color");
            switch (color){
                case "WHITE":
                    tema = WHITE;
                    break;
                case "BLACK":
                    tema = BLACK;
                    break;
                case "BLUE":
                    tema = BLUE;
                    break;
            }
            cambiarTema();
        }
    }

}
