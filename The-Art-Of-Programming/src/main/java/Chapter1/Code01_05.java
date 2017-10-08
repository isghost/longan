package Chapter1;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by isghost on 2017/10/2.
 * 原题目地址： https://github.com/julycoding/The-Art-Of-Programming-By-July/blob/master/ebook/zh/01.05.md
 * TODO: 还有一个O(n)的算法待实现
 */
public class Code01_05 {
    int maxPalindromeLength(char str[]){
        int maxLength = 0;
        for(int i = 0;i < str.length;i++){
            int left=-1, right=1;
            while(left + i >=0 && right + i < str.length && str[left + i] == str[right + i]){
                left--;
                right++;
            }
            if(maxLength < (right - 1) * 2 + 1){
                maxLength = (right - 1) * 2 + 1;
            }
            left = 0;
            right = 1;
            while(left + i >=0 && right + i < str.length && str[left + i] == str[right + i]){
                left--;
                right++;
            }
            if(maxLength < (right - 1) * 2){
                maxLength = (right - 1) * 2;
            }
        }
        return maxLength;
    }

    @Test
    public void resolve(){
        Assert.assertEquals(3, maxPalindromeLength("aabb121aabb".toCharArray()));
        Assert.assertEquals(5, maxPalindromeLength("aabb121baabb".toCharArray()));
        Assert.assertEquals(5, maxPalindromeLength("aabb12221aabb".toCharArray()));
        Assert.assertEquals(1, maxPalindromeLength("abcdefgah".toCharArray()));
        Assert.assertEquals(2, maxPalindromeLength("aabbccddeeffgg".toCharArray()));
        Assert.assertEquals(1, maxPalindromeLength("a".toCharArray()));
        Assert.assertEquals(0, maxPalindromeLength("".toCharArray()));
        Assert.assertEquals(2, maxPalindromeLength("bb".toCharArray()));
        Assert.assertEquals(1, maxPalindromeLength("abc".toCharArray()));
    }
}
