package util;

import java.util.Random;

/**
 * Created by isghost on 2017/10/22.
 */
public class Utils {
    public static int [] generateRandomArray(int size, int begin, int end){
        int array[] = new int[size];
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = rand.nextInt(end - begin) + begin;
        }
        return array;
    }

    public static int [] generateRandomArray(int size, int end){
        return generateRandomArray(size, 0 , end);
    }
}
