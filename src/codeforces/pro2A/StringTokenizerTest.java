package codeforces.pro2A;

import java.util.StringTokenizer;

/**
 * 用来分割字符串的类
 * 作者:hongyanbo
 * 时间:2018/3/19
 */
public class StringTokenizerTest {
    public static void main(String[] args) {
        String s = "This is a test string";
        StringTokenizer tokenizer = new StringTokenizer(s);
        System.out.println(tokenizer.countTokens());
        while (tokenizer.hasMoreElements()){
            System.out.println(tokenizer.nextToken());
        }
    }
}
