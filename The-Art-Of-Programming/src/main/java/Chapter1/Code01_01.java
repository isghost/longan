package Chapter1;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by isghost on 2017/9/16.
 * 原题目地址：https://github.com/julycoding/The-Art-Of-Programming-By-July/blob/master/ebook/zh/01.01.md
 */
public class Code01_01 {
    /**
     * 三步反转法
     */
    void reverseString(char[] str, int from, int to) {
        while (from < to) {
            char t = str[from];
            str[from++] = str[to];
            str[to--] = t;
        }
    }

    /**
     * 左移字符串
     *
     * @param str 需要移动的字符串
     * @param m   要移动的个数
     */
    char[] leftRotateString1(char[] str, int m) {
        char [] newStr = str.clone();
        int n = newStr.length;
        m %= n;
        reverseString(newStr, 0, m - 1);
        reverseString(newStr, m, n - 1);
        reverseString(newStr, 0, n - 1);
        return newStr;
    }

    @Test
    public void resolve1() {
        char actuals[] = "abc123456789".toCharArray();
        int m = 6;
        char expecteds2[] = "456789abc123".toCharArray();
        assertArrayEquals(expecteds2, leftRotateString1(actuals, m));
    }
    //------------------------- 分割线 ------------------------------------------

    /**
     * 直接平移法，未实现
     * 根据平移数量，算出每个字符的新位置，直接移动过去
     */
}
