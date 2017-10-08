package Chapter1;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * Created by isghost on 2017/10/8.
 * 原题目地址： https://github.com/julycoding/The-Art-Of-Programming-By-July/blob/master/ebook/zh/01.06.md
 * 题目：字符串的全排列
 */
public class Code01_06 {
    /**
     * 解法一 递归实现
     */
    void allPerMutation1(char [] str, int num, List<String> list){
        if(num == str.length){
            list.add(String.valueOf(str));
            return ;
        }
        for(int i = num; i< str.length;i++){
            swap(str, num ,i);
            allPerMutation1(str, num + 1, list);
            swap(str, num ,i);
        }

    }
    void swap(char [] str, int i, int j){
        char tmpC = str[i];
        str[i] = str[j];
        str[j] = tmpC;
    }
    boolean compareList(List<String> listA, List<String>listB) {
        Collections.sort(listA);
        Collections.sort(listB);
        if(listA.size() != listB.size()){
            return false;
        }
        for(int i = 0;i<listA.size();i++){
            if(listA.get(i).compareTo(listB.get(i))!= 0){
                return false;
            }
        }
        return true;
    }

    @Test
    public void resolve1(){
        // 用于保存所有的字符串
        ArrayList<String> arrayList = new ArrayList<>();

        allPerMutation1("123".toCharArray(), 0, arrayList);
        Assert.assertEquals(true, compareList(Arrays.asList("123","132", "312", "321", "213", "231"), arrayList));
        arrayList.clear();

        allPerMutation1("abc".toCharArray(), 0, arrayList);
        Assert.assertEquals(true, compareList(Arrays.asList("abc","acb", "bac", "bca", "cab", "cba"), arrayList));
        arrayList.clear();

        allPerMutation1("abc".toCharArray(), 0, arrayList);
        Assert.assertEquals(false, compareList(Arrays.asList("abc","acb", "bac", "bca", "cabd", "cba"), arrayList));
        arrayList.clear();

        allPerMutation1("ab".toCharArray(), 0, arrayList);
        Assert.assertEquals(true, compareList(Arrays.asList("ab","ba"), arrayList));
        arrayList.clear();
    }

    /**
     * 解法二 nextPermutation算法
     *
     */
    void allPerMutation2(char [] str, List<String> list){
        Arrays.sort(str);
        list.add(String.valueOf(str));
        boolean isEnd = true;
        while(true){
            // 最右边可增加的位置
            int lastIncrease;
            // 寻找位置
            for(lastIncrease = str.length - 2; lastIncrease >= 0 && str[lastIncrease] > str[lastIncrease + 1];lastIncrease --){}
            // 如果查不到，说明已经单调递减， 结束
            if(lastIncrease == -1){
                break;
            }
            // 寻找比上一步找到的值大的最小值
            int rightMost = str.length - 1;
            for(;rightMost > lastIncrease && str[rightMost] <= str[lastIncrease];rightMost --){}
            // 交换位置
            swap(str, rightMost, lastIncrease);
            // 反转，因为这时， lastIncrease的右侧是单调递减，需要改成单调递增
            reverse(str, lastIncrease + 1);
            list.add(String.valueOf(str));
        }

    }

    /**
     * 反转数组的后半部分
     * @param str
     * @param begin
     */
    void reverse(char [] str, int begin){
        int end = str.length - 1;
        while(begin < end){
            swap(str, begin, end);
            begin++;
            end--;
        }
    }

    @Test
    public void resolve2(){
        // 用于保存所有的字符串
        ArrayList<String> arrayList = new ArrayList<>();

        allPerMutation2("123".toCharArray(),  arrayList);
        Assert.assertEquals(true, compareList(Arrays.asList("123","132", "312", "321", "213", "231"), arrayList));
        arrayList.clear();

        allPerMutation2("abc".toCharArray(),arrayList);
        Assert.assertEquals(true, compareList(Arrays.asList("abc","acb", "bac", "bca", "cab", "cba"), arrayList));
        arrayList.clear();

        allPerMutation2("abc".toCharArray(), arrayList);
        Assert.assertEquals(false, compareList(Arrays.asList("abc","acb", "bac", "bca", "cabd", "cba"), arrayList));
        arrayList.clear();

        allPerMutation2("ab".toCharArray(), arrayList);
        Assert.assertEquals(true, compareList(Arrays.asList("ab","ba"), arrayList));
        arrayList.clear();
    }
}
