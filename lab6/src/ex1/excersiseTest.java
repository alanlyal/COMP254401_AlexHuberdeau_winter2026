package ex1;
import java.util.Random;
public class excersiseTest {
    public static void main(String[] args) {
        double[] loads = {0.1, 0.2, 0.3, 0.4, 0.5};// list of loads to test
        int number = 100; // number of elements that can be inserted
        Random rand = new Random();// generates random key
        System.out.println("excersice 1");
        for(double load:loads)// for loop for each load factor
        {
            System.out.println("current load factor: " + load);
            ChainHashMap<Integer, Integer> map = new ChainHashMap<>(load);// create a Chainhashmap with the load factor
            long start = System.nanoTime();//start the timer
            for(int i = 0; i< number; i++)// loop to insert random key
            {
                map.put(rand.nextInt(),i);
            }
            long end = System.nanoTime();//end the timer
            System.out.println("time spent: " + (end - start) + "nano seconds");
            System.out.println("-------------------------------------------");
        }
        System.out.println("excersice 2");
        SortedTableMap<Integer, String> map = new SortedTableMap<>(); // creates a sortedtablemap
        //the next 3 line are keys
        map.put(1,"a");
        map.put(2,"b");
        map.put(3,"c");
        //next lines are test to see if keys exist or not exist
        System.out.println("true test, checking for a 1 " + map.containsKey(1)); //true test
        System.out.println("true test, checking for a 2 " + map.containsKey(2)); //true test
        System.out.println("true test, checking for a 3 " + map.containsKey(3)); //true test
        System.out.println("false test, checking for a 3 " + map.containsKey(4)); //false test
        //
    }
}
