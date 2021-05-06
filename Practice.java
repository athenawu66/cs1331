import java.util.Scanner;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.ArrayList;
public class Practice {
    public static void main(String[] args){
        System.out.println(sumOfDigits(126));
    }

    public int sumOfDigits(int number){
        if(number == 0){
            return number;
        } else{
            if (number % 2 == 1){
                return 2 + sumOfDigits(number-1);
            } else{
                return 3 + sumOfDigits(number-1);
            }
        }
    } 
}
