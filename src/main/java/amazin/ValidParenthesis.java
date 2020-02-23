package amazin;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParenthesis {

    // Hash table that takes care of the mappings.
    private HashMap<Character, Character> validParenthesisMap;

    public ValidParenthesis(){
        this.validParenthesisMap = new HashMap<Character, Character>();
        this.validParenthesisMap.put(')', '(');
        this.validParenthesisMap.put('}', '{');
        this.validParenthesisMap.put(']', '[');
    }

    public static void main(String[] args) {

        System.out.println(new ValidParenthesis().isValidParanthesis("({[[()]]})"));
    }

    private  boolean isValidParanthesis(String s) {
        Stack<Character> stackOfParanthesis = new Stack<Character>();
        boolean isValid = false;

        for( Character c : s.toCharArray()){

            // If the current character is a closing bracket.
            if(validParenthesisMap.containsKey(c) ){
                    if(!stackOfParanthesis.isEmpty()  && stackOfParanthesis.pop().equals(validParenthesisMap.get(c)))
                        isValid =  true;
                        else
                            return  false; // IMP

            } else {
                stackOfParanthesis.push(c);

            }

        }

        return isValid;
    }





}
