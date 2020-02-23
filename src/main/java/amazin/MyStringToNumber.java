package amazin;

import java.util.List;

public class MyStringToNumber {
 
    public static int convert_String_To_Number(String numStr){
         
        char ch[] = numStr.toCharArray();
        int sum = 0;
        //get ascii value for zero
        int zeroAscii = (int)'0';
        for(char c:ch){
            int tmpAscii = (int)c;
            sum = (sum*10)+(tmpAscii-zeroAscii);
        }
        return sum;
    }
     
    public static void main(String a[]){
         
        System.out.println("\"3256\" == "+convert_String_To_Number2("3256"));
        //System.out.println("\"76289\" == "+convert_String_To_Number("76289"));
        //System.out.println("\"90087\" == "+convert_String_To_Number("90087"));
        String inputStr = "coursera,rocks";
        String[] list = inputStr.split(",");

    }


    public static int convert_String_To_Number2(String numStr){

        char ch[] = numStr.toCharArray();
        int sum = 0;

        for( Character c : ch){

            sum = sum * 10 + (int)c - '0' ;

        }

        return sum;
    }
}