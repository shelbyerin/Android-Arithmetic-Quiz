package cosc426.assign1part8;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int answer;
    int score = 0;
    int total = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.initialize();
    }

    public void initialize(){
        //gets the textViews for the equation
        TextView num1TextView = (TextView)findViewById(R.id.num1);
        TextView num2TextView = (TextView)findViewById(R.id.num2);
        TextView operatorTextView = (TextView)findViewById(R.id.opperator);

        Generator generator = new Generator();
        generator.generateValues(); //generates the values for operator, number1, number2, and answer

        String opperator = generator.getOperator(); //gets the operator from the generator file
        operatorTextView.setText(opperator);    //sets the text for the operator

        int number1 = generator.getNum1(); //gets the number1 from the generator file
        num1TextView.setText("" + number1); //sets the text for the number1

        int number2 = generator.getNum2(); //gets the number2 from the generator file
        num2TextView.setText("" + number2); //sets the text for the number2

        this.answer = generator.getAnswer(); //gets the answer from the generator file

        TextView responseTextVeiw = (TextView)findViewById(R.id.response);
        responseTextVeiw.setTextColor(Color.parseColor("black"));
        responseTextVeiw.setText("Submit your Answer");

        EditText answerEditText = (EditText)findViewById(R.id.answer);
        answerEditText.setText("");

        //sets the nextButton to disabled and the submit button to enabled
        Button nextButton = (Button)findViewById(R.id.nextButton);
        nextButton.setEnabled(false);
        Button submitButton = (Button)findViewById(R.id.submitButton);
        submitButton.setEnabled(true);
    }

    public void submit(View v){
        try {
            EditText answerEditText = (EditText) findViewById(R.id.answer);
            String answerString = answerEditText.getText().toString();
            int answerInput = Integer.parseInt(answerString); //gets the int value for the answer inputted by user

            TextView responseTextVeiw = (TextView)findViewById(R.id.response);
            TextView scoreTextView = (TextView)findViewById(R.id.score);
            if(answerInput == this.answer){             //if the user got it correct, displays in green & increases both score and total
                responseTextVeiw.setText("Correct");
                responseTextVeiw.setTextColor(Color.parseColor("green"));
                this.score++;
                this.total++;
            }else{                                      //if user got it incorrect, displays in red & only increases total
                responseTextVeiw.setText("Incorrect");
                responseTextVeiw.setTextColor(Color.parseColor("red"));
                this.total++;
            }
            scoreTextView.setText("Score:  " + this.score + " / " + this.total); //displays score over total

            //enables the next button and disables the submit button
            Button nextButton = (Button)findViewById(R.id.nextButton);
            nextButton.setEnabled(true);
            Button submitButton = (Button)findViewById(R.id.submitButton);
            submitButton.setEnabled(false);
        }catch (NumberFormatException e){
            return;
        }
    }

    public void next(View v){
        this.initialize();
    }
}
