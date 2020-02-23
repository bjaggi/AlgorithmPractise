package amazin;

public class AddTwoStrings {

    public static void main(String[] args) {
        System.out.println(new AddTwoStrings().add("5","115"));
    }

    private String add(String s1, String s2) {
        StringBuilder stringBuilder = new StringBuilder();
        int i = s1.length()-1, j = s2.length()-1;
        int sum = 0 , carry = 0;

        while(i>= 0 || j >= 0 ){
            sum = carry;
            if(i >= 0   ){
                sum = sum + s1.charAt(i)- '0';
            }

            if(j >= 0    ){
                sum = sum + s2.charAt(j)- '0';
            }

            stringBuilder.append(sum%10);
            carry = sum/10;
            i --; j--;
        }

        if(carry== 1)
            stringBuilder.append(1);

        return stringBuilder.reverse().toString();

    }
}
