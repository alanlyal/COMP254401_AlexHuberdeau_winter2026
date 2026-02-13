package ex3;/*
 * Copyright 2014, Michael T. Goodrich, Roberto Tamassia, Michael H. Goldwasser
 *
 * Developed for use with the book:
 *
 *    Data Structures and Algorithms in Java, Sixth Edition
 *    Michael T. Goodrich, Roberto Tamassia, and Michael H. Goldwasser
 *    John Wiley & Sons, 2014
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

import java.util.Arrays;

/**
 * Demonstration of algorithms for testing element uniqueness.
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 */
public class Uniqueness {

    /**
     * Returns true if there are no duplicate elements in the array.
     */
    public static boolean unique1(int[] data) {
        int n = data.length;
        for (int j = 0; j < n - 1; j++)
            for (int k = j + 1; k < n; k++)
                if (data[j] == data[k])
                    return false;                    // found duplicate pair
        return true;                           // if we reach this, elements are unique
    }

    /**
     * Returns true if there are no duplicate elements in the array.
     */
    public static boolean unique2(int[] data) {
        int n = data.length;
        int[] temp = Arrays.copyOf(data, n);   // make copy of data
        Arrays.sort(temp);                     // and sort the copy
        for (int j = 0; j < n - 1; j++)
            if (temp[j] == temp[j + 1])            // check neighboring entries
                return false;                      // found duplicate pair
        return true;                           // if we reach this, elements are unique
    }

    public static void main(String[] args) {
        long maxTime = 30000; // timer test
        //note its not 1 minute exact it like a minute and 10 seconds
        System.out.println("test for unique 1 using time of " + maxTime);
        int n = 100;//starting array size
        long startTime = System.currentTimeMillis(); //records the totaltime
        long totalTime = 0;// start of total time
        while (totalTime <= maxTime) {
            int[] data = new int[n];// create an array
            for (int i = 0; i < n; i++) {
                data[i] = i;//fill the array with numbers
            }
            long start = System.currentTimeMillis();//start the timer for this test
            unique1(data);// run the unique1
            long timeSpent = System.currentTimeMillis() - start;// time that was used for this test
            totalTime = System.currentTimeMillis() - startTime;// update the time
            if (totalTime > maxTime)// if incase if the timer break which has happened many times to just end
            {
                break;
            }
            n += 500;// slowly increasing the array size
        }
        int high = n;//set high limit for binary search
        int low = n / 2;// set the lowest limit for binary seach
        int resul1 = low;// store the largest n size
        while (low <= high) {
            int mid = (low + high) / 2;// creates the mid point
            int[] data = new int[mid];//creates array with the mid size
            for (int i = 0; i < mid; i++) {
                data[i] = i;//fill the mid array
            }
            long start = System.currentTimeMillis();//start the timer
            unique1(data);// run unique1
            long timeSpent = System.currentTimeMillis() - start;// update the time
            if (timeSpent <= maxTime)//incase if time breaks as it has happened many times
            {
                resul1 = mid;//give the final result mid
                low = mid + 1;// search the lower half
            } else {
                high = mid - 1;//searh the upper half
            }
        }
        System.out.println("largest n from unique1 in is " + resul1);
// no need to add comments for part v as its the same as part ^
        System.out.println("test for unique 2 using time of " + maxTime);
        maxTime = 30000;
        n = 100;
        startTime = System.currentTimeMillis();
        totalTime = 0;
        while (totalTime <= maxTime) {
            int[] data = new int[n];
            for (int i = 0; i < n; i++) {
                data[i] = i;
            }
            long start = System.currentTimeMillis();
            unique2(data);
            long timeSpent = System.currentTimeMillis() - start;
            totalTime = System.currentTimeMillis() - startTime;
            if (totalTime > maxTime) {
                break;
            }
            n += 500;
        }
        int high2 = n;
        int low2 = n / 2;
        int resul2 = low2;
        while (low2 <= high2) {
            int mid = (low2 + high2) / 2;
            int[] data = new int[mid];
            for (int i = 0; i < mid; i++) {
                data[i] = i;
            }
            long start = System.currentTimeMillis();
            unique2(data);
            long timeSpent = System.currentTimeMillis() - start;
            if (timeSpent <= maxTime) {
                resul2 = mid;
                low2 = mid + 1;
            } else {
                high2 = mid - 1;
            }
        }
        System.out.println("largest n from unique2 in is " + resul2);
    }
}