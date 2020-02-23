package amazin;
//https://www.techseries.dev/products/coderpro/categories/1831147/posts/6194824
public class Fibonacci {

    public static void main(String[] args) {
       /* for (int i =0;i < 10 ; i++ )
        System.out.println(new Fibonacci().recursiveFibo(i));
*/

        System.out.println(new Fibonacci().recursiveFibo(2));
        System.out.println(new Fibonacci().recursiveFibo(3));
        System.out.println(new Fibonacci().recursiveFibo(4));
        System.out.println(new Fibonacci().recursiveFibo(5));
        //new Fibonacci().normalFibo(5);
    }

    public int recursiveFibo(int n){

        if(n==0 || n == 1) {
            //System.out.println(n);
            return n;

        }else {
            int sum = recursiveFibo(n-2 ) + recursiveFibo(n-1 ) ;
            //System.out.println(sum);
            return sum;
        }

    }

    public void normalFibo(int n){
        System.out.print("0 1 ");
        int n0 =0 , n1 = 1, sum = 0;
        for(int i =0; i<n ; i++){
            sum = n0 +n1;
            n0 = n1;
            n1 = sum;
            System.out.print(sum + " ");
        }
    }


}
//0 1 1 2 3 5 8 13 21
//0 1 2 3 4 5 6 7  8

