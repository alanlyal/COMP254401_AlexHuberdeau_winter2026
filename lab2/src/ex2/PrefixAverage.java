
import java.util.Arrays;
import java.util.Random;

/**
 * Demonstration of algorithms for computing the prefix averages of an array.
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 */
class PrefixAverage {

  /** Returns an array a such that, for all j, a[j] equals the average of x[0], ..., x[j]. */
  public static double[] prefixAverage1(double[] x) {
    int n = x.length;
    double[] a = new double[n];    // filled with zeros by default
    for (int j=0; j < n; j++) {
      double total = 0;            // begin computing x[0] + ... + x[j]
      for (int i=0; i <= j; i++)
        total += x[i];
      a[j] = total / (j+1);        // record the average
    }
    return a;
  }

  /** Returns an array a such that, for all j, a[j] equals the average of x[0], ..., x[j]. */
  public static double[] prefixAverage2(double[] x) {
    int n = x.length;
    double[] a = new double[n];    // filled with zeros by default
    double total = 0;              // compute prefix sum as x[0] + x[1] + ...
    for (int j=0; j < n; j++) {
      total += x[j];               // update prefix sum to include x[j]
      a[j] = total / (j+1);        // compute average based on current sum
    }
    return a;
  }

}
public static void main(String[] args)
{
   int[] input={10,50,100,150,200};// list of input sizes
   for (int n : input)// the loop for each input size
   {
       double[] array = new double[n];// array
       for (int i = 0; i < n; i++) // loops for the array size based on nis
       {
           array[i] = i;
       }
     long time = System.nanoTime();// the 3 lines are the clock for the first prefix average
       PrefixAverage.prefixAverage1(array);//run algorithm
       time= System.nanoTime() - time;// calculates the time it took

       long time2 = System.nanoTime();// the 3 lines are the clock for the first prefix average
       PrefixAverage.prefixAverage2(array);//run algorithm
       time2= System.nanoTime() - time2;// calculates the time it took
       System.out.println("excerise 2");
       System.out.println(n + " prefix1 " +time + "|" + " prefix2 " + time2);// print the input size and the result of
       //first clock and the second clock
   }
//
}
