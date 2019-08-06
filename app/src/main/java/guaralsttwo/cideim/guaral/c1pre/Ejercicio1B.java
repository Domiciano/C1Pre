package guaralsttwo.cideim.guaral.c1pre;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import static android.view.View.GONE;

public class Ejercicio1B extends AppCompatActivity {

    private Button whiteButton, blackButton, blueButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio1_b);
        whiteButton = findViewById(R.id.white_button);
        blackButton = findViewById(R.id.black_button);
        blueButton = findViewById(R.id.blue_button);

        whiteButton.setOnClickListener(v -> {
            Intent i = new Intent();
            i.putExtra("color","WHITE");
            setResult(RESULT_OK, i);
            finish();
        });

        blackButton.setOnClickListener(v -> {
            Intent i = new Intent();
            i.putExtra("color","BLACK");
            setResult(RESULT_OK, i);
            finish();
        });

        blueButton.setOnClickListener(v -> {
            Intent i = new Intent();
            i.putExtra("color","BLUE");
            setResult(RESULT_OK, i);
            finish();
        });


        int actualColor = getIntent().getExtras().getInt("actualColor");
        switch (actualColor){
            case Ejercicio1A.WHITE:
                whiteButton.setVisibility(GONE);
                break;
            case Ejercicio1A.BLACK:
                blackButton.setVisibility(GONE);
                break;
            case Ejercicio1A.BLUE:
                blueButton.setVisibility(GONE);
                break;
        }

    }
}
