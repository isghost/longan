package Chapter1;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Arrays;

/**
 * Created by isghost on 2017/9/17.
 * 原题目地址： https://github.com/julycoding/The-Art-Of-Programming-By-July/blob/master/ebook/zh/01.03.md
 */
public class Code01_03 {
    int strToInt(String str){
        if(str == null || !"-+0123456789".contains("" + str.charAt(0))){
            return 0;
        }
        int n = 0;
        int sign = str.charAt(0) == '-' ? -1 : 1;
        char [] digits;
        if(!Character.isDigit(str.charAt(0))){
            digits = Arrays.copyOfRange(str.toCharArray(), 1, str.length());
        }
        else{
            digits = str.toCharArray();
        }
        for(char c: digits){
            if(!Character.isDigit(c)){
                break;
            }
            if(sign == 1 && (Integer.MAX_VALUE / 10 < n || Integer.MAX_VALUE / 10 == n && (c > (Integer.MAX_VALUE % 10 + '0')))){
                return Integer.MAX_VALUE;
            }
            else if(sign == -1 && (Integer.MIN_VALUE / 10 > -n || Integer.MIN_VALUE / 10 == -n && (c > (-(Integer.MIN_VALUE % 10) + '0')))) {
                return Integer.MIN_VALUE;
            }
            else{
                n = n * 10 + (c - '0');
            }
        }
        return n * sign;
    }

    @Test
    public void resolve(){
        assertNotEquals(Integer.MIN_VALUE, strToInt(String.valueOf(Integer.MIN_VALUE + 1)));
        assertEquals(12345678, strToInt("12345678"));
        assertEquals(12345, strToInt("12345aa678"));
        assertEquals(12345, strToInt("+12345aa678"));
        assertEquals(-12345, strToInt("-12345aa678"));
        assertEquals(0, strToInt(null));
        assertEquals(0, strToInt("a12345678"));

        assertEquals(Integer.MAX_VALUE, strToInt(String.valueOf(Integer.MAX_VALUE)));
        assertEquals(Integer.MAX_VALUE, strToInt(String.valueOf(1l + Integer.MAX_VALUE)));
        assertNotEquals(Integer.MAX_VALUE, strToInt(String.valueOf(Integer.MAX_VALUE - 1)));

        assertEquals(Integer.MIN_VALUE, strToInt(String.valueOf(Integer.MIN_VALUE)));
        assertEquals(Integer.MIN_VALUE, strToInt(String.valueOf(-1l + Integer.MIN_VALUE)));
        // 计划遍历所有正常数据，但CPU速度有点慢
        for(int i = Integer.MIN_VALUE/10; i < Integer.MAX_VALUE/10;i++){
            assertEquals(i, strToInt(String.valueOf(i)));
        }
    }
}
