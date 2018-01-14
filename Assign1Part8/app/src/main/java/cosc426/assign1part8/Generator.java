package cosc426.assign1part8;

import java.util.Random;

public class Generator {
    public  String opperator;
    public int num1, num2, answer;
    Random rand;

    public void Generator(){
    }

    public void generateValues(){ //generates the values of the numbers, answers and operators (based on randomness)
        this.rand = new Random();
        int randomInt = this.rand.nextInt(100);
        if(randomInt <= 25){
            this.opperator = "+";
            this.num1 = this.rand.nextInt(999) + 1;
            this.num2 = this.rand.nextInt(999) + 1;
            this.answer = num1 + num2;
        }else if(randomInt > 25 && randomInt <= 50){
            this.opperator = "-";
            this.num1 = this.rand.nextInt(999) + 1;
            this.num2 = this.rand.nextInt(999) + 1;
            this.answer = num1 - num2;
        }else if(randomInt > 50 && randomInt <= 75){
            this.opperator = "*";
            this.num1 = this.rand.nextInt(99) + 1;
            this.num2 = this.rand.nextInt(99) + 1;
            this.answer = num1 * num2;
        }else if(randomInt > 75 && randomInt <= 100){
            this.opperator = "/";
            this.num1 = this.rand.nextInt(999) + 1;
            this.num2 = this.rand.nextInt(99) + 1;
            this.answer = num1 / num2;
        }
    }

    public String getOperator(){
        return this.opperator; //returns the operator that was generated above
    }

    public int getNum1(){
        return this.num1; //returns the number1 that was generated above
    }

    public int getNum2(){
        return this.num2; //returns the number2 that was generated above
    }

    public int getAnswer(){
        return this.answer; //returns the answer that was generated above
    }
}
