package com.example.android.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int score = 0 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button markButton = findViewById(R.id.button);

        markButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                findMark();
            }
        });
    }

    private void findMark() {
        RadioGroup radioGroup = findViewById(R.id.question1RadioGroup);

        int radioButtonID = radioGroup.getCheckedRadioButtonId();
        View radioButton = radioGroup.findViewById(radioButtonID);
        int idx = radioGroup.indexOfChild(radioButton);

        if(idx ==1 ){
            score ++;
        }

        CheckBox checkBox1 = findViewById(R.id.checkBoxAnswer1);
        CheckBox checkBox2 = findViewById(R.id.checkBoxAnswer2);
        CheckBox checkBox3 = findViewById(R.id.checkBoxAnswer3);

        if(checkBox1.isChecked() && checkBox3.isChecked() && !checkBox2.isChecked()) {
            score ++;
        }

        radioGroup = findViewById(R.id.question3RadioGroup);

        radioButtonID = radioGroup.getCheckedRadioButtonId();
        radioButton = radioGroup.findViewById(radioButtonID);
        idx = radioGroup.indexOfChild(radioButton);

        if(idx == 0 ){
            score ++;
        }

        radioGroup = findViewById(R.id.question4RadioGroup);

        radioButtonID = radioGroup.getCheckedRadioButtonId();
        radioButton = radioGroup.findViewById(radioButtonID);
        idx = radioGroup.indexOfChild(radioButton);

        if(idx == 2 ){
            score ++;
        }

        showScore();
        score = 0;
    }

    private void showScore() {

        EditText name = findViewById(R.id.nameEditText);

        String message;

        if (score > 3) {
            message = "Congratulations ";
        } else {
            message = "Too bad ";
        }
        message = message + name.getText()+getString(R.string.yourScore)+score;
        Toast.makeText(this, message,
                Toast.LENGTH_LONG).show();
    }
}
