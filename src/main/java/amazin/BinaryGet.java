package amazin;

import java.util.Stack;

public class BinaryGet {

    public static void main(String[] args) {
        String inputStr = "1000000100101000";
        System.out.println(new BinaryGet().highestBinaryGet(inputStr));
    }

    private int highestBinaryGet(String inputStr) {

        Stack stack = new Stack();
        char[] charArray = inputStr.toCharArray();
        int lenght = 0;
        int maxLenght = 0;
        for(char ch : charArray){

            if(ch == '1' && stack.isEmpty()){
                stack.push(ch);
            } else if(ch == '1' && !stack.isEmpty()){

                if(lenght > maxLenght){
                    maxLenght = lenght;
                }
                lenght = 0;
            } else{
                lenght ++;
            }

        }

        return maxLenght;
    }
}
