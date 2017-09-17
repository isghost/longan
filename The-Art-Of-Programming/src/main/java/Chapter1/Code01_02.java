package Chapter1;

import org.junit.Test;

import java.util.HashSet;
import static org.junit.Assert.*;

/**
 * Created by isghost on 2017/9/17.
 * 原题目地址：https://github.com/julycoding/The-Art-Of-Programming-By-July/blob/master/ebook/zh/01.02.md
 */
public class Code01_02 {
    /**
     * 采用HashSet方法
     * @param longStr
     * @param shortStr
     * @return
     */
    boolean stringContain(char [] longStr, char [] shortStr){
        HashSet<Character> characterHashSet = new HashSet<Character>();
        for(char c : longStr){
            characterHashSet.add(c);
        }
        for(char c : shortStr){
            if(!characterHashSet.contains(c)){
                return false;
            }
        }
        return true;
    }
    @Test
    public void resolve(){
        assertEquals(true, stringContain("ABC".toCharArray(), "AAA".toCharArray()));
        assertEquals(true, stringContain("ABC".toCharArray(), "BCA".toCharArray()));
        assertEquals(true, stringContain("ABC".toCharArray(), "BBB".toCharArray()));
        assertEquals(true, stringContain("ABC".toCharArray(), "CCC".toCharArray()));
        assertEquals(true, stringContain("ABC".toCharArray(), "CBA".toCharArray()));

        assertEquals(false, stringContain("ABC".toCharArray(), "CBD".toCharArray()));
        assertEquals(false, stringContain("ABC".toCharArray(), "DDD".toCharArray()));
        assertEquals(false, stringContain("ABC".toCharArray(), "KBA".toCharArray()));
    }
}
