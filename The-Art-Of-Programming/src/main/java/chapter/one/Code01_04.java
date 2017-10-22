package chapter.one;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by isghost on 2017/9/24.
 * 原题目地址： https://github.com/julycoding/The-Art-Of-Programming-By-July/blob/master/ebook/zh/01.04.md
 */
public class Code01_04 {
    boolean isPalindrome(char str[]){
        for(int i = 0, j = str.length - 1; i < j;i ++, j--){
            if(str[i] != str[j]){
                return false;
            }
        }
        return true;
    }

    @Test
    public void resolve(){
        assertEquals(true, isPalindrome("12321".toCharArray()));
        assertEquals(true, isPalindrome("1".toCharArray()));
        assertEquals(true, isPalindrome("11".toCharArray()));
        assertEquals(true, isPalindrome("1a1".toCharArray()));
        assertEquals(true, isPalindrome(".*.".toCharArray()));
        assertEquals(true, isPalindrome(".**.".toCharArray()));
        assertEquals(true, isPalindrome("abcdefgfedcba".toCharArray()));

        assertEquals(false, isPalindrome("abc".toCharArray()));
        assertEquals(false, isPalindrome("abac".toCharArray()));
        assertEquals(false, isPalindrome("ab".toCharArray()));
        assertEquals(false, isPalindrome("abcd".toCharArray()));
        assertEquals(false, isPalindrome("123a32".toCharArray()));
        assertEquals(false, isPalindrome("aaaaa2".toCharArray()));
    }
}
