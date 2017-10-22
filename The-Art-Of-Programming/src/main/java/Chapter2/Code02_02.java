package Chapter2;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by isghost on 2017/10/12.
 * 原题目地址： https://github.com/julycoding/The-Art-Of-Programming-By-July/blob/master/ebook/zh/02.02.md
 * 题目：寻找和为定值的两个数
 */
public class Code02_02 {
    public int[] getTargetSumIndex(int []array, int sum){
        int [] arrayResult = new int[]{0,0};
        // 这道题目重点不在于排序，直接调用原方法
        Arrays.sort(array);
        for (int i = 0, j = array.length - 1; i < j;) {
            if(array[i] + array[j] == sum){
                arrayResult[0] = i;
                arrayResult[1] = j;
                return arrayResult;
            }
            else if(array[i] + array[j] > sum){
                j--;
            }
            else if(array[i] + array[j] < sum){
                i++;
            }
        }
        return arrayResult;
    }

    @Test
    public void resolve(){
        int array[] = new int[]{1, 2, 3, 4 , 11, 20, 26, 40};
        int[] targetSumIndex = getTargetSumIndex(array, 15);
        Assert.assertArrayEquals(new int[]{3, 4}, targetSumIndex);

        int[] targetSumIndex1 = getTargetSumIndex(array, 25);
        Assert.assertArrayEquals(new int[]{0, 0}, targetSumIndex1);

        int[] targetSumIndex2 = getTargetSumIndex(array, 31);
        Assert.assertArrayEquals(new int[]{4, 5}, targetSumIndex2);
    }
}
