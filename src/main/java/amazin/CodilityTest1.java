package amazin;

public class CodilityTest1 {

    public static void main(String[] args) {
        int A = -1;
                int B = -3;

        String strA =  Integer.toBinaryString(A);
        String strB =  Integer.toBinaryString(B);
        StringBuilder str = new StringBuilder();


        char[] charArrA = strA.toCharArray();
        char[] charArrB = strB.toCharArray();

        if(strA == null || strB == null || strA.trim().equals("")){
            System.out.println(0);
            return;
        }

        int aLenght = charArrA.length;
        int bLenght = charArrB.length;
        int minLenght = aLenght > bLenght? bLenght : aLenght;
        int i = minLenght-1;

        while(i >=0 ){

            if(charArrA[i]== charArrB[i]){
                str.append(charArrA[i]);
                i --;
            } else {

break;           }

        }

      //  System.out.println("binary equal is " + strA.substring(0,minLenght-i-1) + " , "+ strB.substring(0,minLenght-i-1));

           //int decimal = Integer.parseInt(strA.substring(0,minLenght-i-1),2);
        long l = Long.parseLong(strA.substring(0,minLenght-i-1),2);
        int decimal = (int) l;


        System.out.println(decimal);
    }
}
