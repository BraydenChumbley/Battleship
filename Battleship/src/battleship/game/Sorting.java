/*
 * Tony Yu 
 * June 6 2019
 * This program sorts the player scores
 */
package battleship.game;

import java.util.ArrayList;

/**
 *
 * @author toyu2550
 */
public class Sorting {

    int hits=1;
    int hitsTook=1;
    int accuracy = hits / hitsTook * 100;

    public ArrayList<Integer> listOfScores(int n) {
        ArrayList<Integer> listOfScore = new ArrayList();
        for (int i = 0; i < n; i++) {
            listOfScore.add(accuracy);
        }
        return listOfScore;
    }

    public long quickSort(ArrayList<Integer> data, int left, int right) {
         
        int temp; //will hold a temporary value
        //if the left index is greater than or equal to the right right
        if (left >= right) {
           
            return 0;
        }
        int middle = data.get((left + right) / 2); //find the middle of the array list
        int l = left;
        int r = right;

        //while l is less than r
        while (l < r) {  
            //while the value at the index l is less than the middle
            while (data.get(l) < middle) {
                l++;
            }
            //while the value at the index r is greater than the middle
            while (data.get(r) >middle) {
                //add one to the loop counter

                //subtract r by 1
                r--;
            }
            //if l is less than or equal to r
            if (l <= r) {
                //hold the value at index l in the temp variable
                temp = data.get(l);
                //set the value at index r to the index l
                data.set(l, data.get(r));
                //make temp value equal to r
                data.set(r, temp);
                l++;  //increase l by one
                //subtract r by 1
                r--;
            }
        }
        //recursive call with r as right value
        quickSort(data, left, r);
        //recursive call with l as left value
        quickSort(data, l, right);
        //return 0 if it reaches this statement

        return 0;
    }

  
}

