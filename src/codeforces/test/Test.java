package codeforces.test;

import java.util.Scanner;

/**
 * 公共子序列。
 * 作者:hongyanbo
 * 时间:2018/3/20
 */
public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.next();
        String s2 = scanner.next();


        System.out.println(maxLen(s1,s2));
    }

    private static int maxLen(String s1, String s2) {
        if(s1.length()>0 && s2.length()>0){
            if(s1.charAt(0)==s2.charAt(0)){
                return maxLen(s1.substring(1,s1.length()),s2.substring(1,s2.length()))+1;
            }else{
                return Math.max(maxLen(s1.substring(1,s1.length()),s2),maxLen(s1,s2.substring(1,s2.length())));
            }
        }else{
            return 0;
        }
    }
}
