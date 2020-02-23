package amazin.traversal;

import java.util.Map;

public class decodeJsonPractise {

    public static void main(String[] args) {
        new decodeJsonPractise().parse("{name : brijesh, age : 31}");
    }


    JsonObject parse(String inputStr){

        JsonObject jsonObject = new JsonObject();

        char[] charArr = inputStr.toCharArray();

        for( int i = 0 ; i < charArr.length ; i ++) {
            if ( charArr[i] == '{'){
                String key="";
                while(charArr[i] != ':'){
                    key = key + charArr[i];
                    i ++;
                }
                System.out.println(key);
            }
        }



        return  jsonObject;

    }

    class JsonObject{
        Object value;
        Map<String, Object> map;

    }
}
