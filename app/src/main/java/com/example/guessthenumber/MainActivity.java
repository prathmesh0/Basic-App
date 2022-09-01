package com.example.guessthenumber;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int randomNumber;

    public void OnClickButton(View view){
        EditText editText = findViewById(R.id.editTextNumber);
        int enterdNumber = Integer.parseInt(editText.getText().toString());
        String output;
        if(enterdNumber < randomNumber){
            output = "Please enter higher number";
        }
        else if(enterdNumber > randomNumber){
            output = "Please enter lower number";
        }
        else{
            output = "You got it right!";
            //visible play again button
            Button playAgainButton = findViewById(R.id.button2);
            playAgainButton.setVisibility(View.VISIBLE);
            //onclick button programatically
            playAgainButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //generate random number
                    generateRandomNumber();
                    OnClickButton(view);
                    playAgainButton.setVisibility(View.INVISIBLE);
                }
            });

        }
        Snackbar.make(view,output,Snackbar.LENGTH_LONG).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //random number
        generateRandomNumber();

        //hide visibility of play again button
        Button playAgainButton = findViewById(R.id.button2);
        playAgainButton.setVisibility(View.INVISIBLE);
    }

    private void generateRandomNumber() {
        Random random = new Random();
        randomNumber = random.nextInt(20)+1;
    }
}