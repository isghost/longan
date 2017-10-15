package Chapter2;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * Created by isghost on 2017/10/14.
 * 原题目地址： https://github.com/julycoding/The-Art-Of-Programming-By-July/blob/master/ebook/zh/02.01.md
 * 题目：寻找最小的k个数
 */
public class Code02_01 {
    public int [] minValues(int values[], int minNum){
        int length = values.length;
        for(int i = (length - 1) / 2; i >= 0 ;i--){
            adjustDown(values, i, length);
        }
        for(int i = length - 1; i > (length - 1 - minNum);i--){
            swap(values, i, 0);
            adjustDown(values, 0, i );
        }
        return Arrays.copyOfRange(values, length - minNum, length);
    }
    private void swap(int values[], int indexA, int indexB){
        int tmp = values[indexA];
        values[indexA] = values[indexB];
        values[indexB] = tmp;
    }

    /**
     *
     * @param values
     * @param parentIndex
     * @return 1 左边 2右边
     */
    private int swapMin(int values[], int parentIndex, int length){
        int leftIndex = parentIndex * 2 + 1;
        int rightIndex = parentIndex * 2 + 2;
        // 左右结点相同时，与左边换
        if( (leftIndex < length && values[leftIndex] < values[parentIndex]) &&(rightIndex >= length || values[leftIndex] <= values[rightIndex])){
            swap(values, leftIndex, parentIndex);
            return 1;
        }
        else if(rightIndex < length && values[rightIndex] < values[parentIndex] && values[rightIndex] < values[leftIndex]){
            swap(values, rightIndex, parentIndex);
            return 2;
        }
        return 0;
    }

    private void adjustDown(int values[], int num, int length){
        while(num <= (length - 1)/2 ){
            int status = swapMin(values, num, length);
            if(status == 1){
                num = num * 2 + 1;
            }
            else if(status == 2){
                num =num * 2 + 2;
            }
            else{
                break ;
            }
        }
    }
    // 仅作调试使用
    boolean checkHeap(int values[], int size){
        for(int i = 0;i <= (size - 2) / 2;i ++){
            int left = i * 2 + 1;
            int right = i * 2 + 2;
            if(values[left] < values[i]){
                int a = 2;
                return false;
            }
            if(right < size && values[right] < values[i]){
                int b = 3;
                return false;
            }
        }
        return true;
    }

    @Test
    public void resolve(){
        int []values = new int[100];
        Random random = new Random(11);
        for (int i = 0; i < values.length; i++) {
            values[i] = random.nextInt(1000);
        }
        int result[] = minValues(values, 10);
    }
}
