import java.util.Scanner;
public class Task1 {
    public static int recursive(int m, int n)
    {
      if (m == 0 || n == 0){// if m is 0
          return 0;
      }
      return n+ recursive( m -1,n);//subract m by 1 each time until m = 0
    }
}
public static void main(String[] args)
{
    Scanner scan = new Scanner(System.in);//creating a scanner object
    System.out.println("please enter a positive int for m: ");
    int m = scan.nextInt();//reads what the user put in and assignst it to m
    System.out.println("now for n: ");
    int n= scan.nextInt();//same as the other one but for n
    int product = Task1.recursive(m,n); // call the recursive methode using m and n the user has put in
    System.out.println(" the product of " + m +" and " + n +" is " + product);
    scan.close();// close the scanner
}//