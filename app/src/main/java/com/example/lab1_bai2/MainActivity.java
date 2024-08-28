package com.example.lab1_bai2;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.view.View;
import android.widget.*;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView imgDice;
    private Button btnRollDice;
    private Random random;

    private void rollDice(){
        int randomNumber = random.nextInt(6) + 1;
        int dice;
        switch (randomNumber){
            case 1: {
                dice = R.drawable.mat_1;
                break;
            }
            case 2: {
                dice = R.drawable.mat_2;
                break;
            }
            case 3: {
                dice = R.drawable.mat_3;
                break;
            }
            case 4: {
                dice = R.drawable.mat_4;
                break;
            }
            case 5: {
                dice = R.drawable.mat_5;
                break;
            }
            case 6: {
                dice = R.drawable.mat_6;
                break;
            }
            default: {
                dice = R.drawable.mat_1;
            }
        }
        imgDice.setImageResource(dice);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        imgDice = findViewById(R.id.imgDice);
        btnRollDice = findViewById(R.id.btnRollDice);
        random = new Random();

        btnRollDice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rollDice();
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}