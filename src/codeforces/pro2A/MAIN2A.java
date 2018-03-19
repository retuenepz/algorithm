package codeforces.pro2A;

import java.io.*;
import java.util.*;

/**
 * 作者:hongyanbo
 * 时间:2018/3/19
 */
public class MAIN2A {

    public static void main(String[] args) throws IOException {
        new MAIN2A().solve();
    }

        BufferedReader reader ;
        PrintWriter writer ;
        StringTokenizer tokenizer = null ;

        public MAIN2A() {
            reader= new BufferedReader(new InputStreamReader(System.in));
            writer = new PrintWriter(System.out);
        }
        public void solve() throws IOException {
            int round = readInt();
            String[] who = new String[round]; //输入的名字
            int[] score = new int[round];//输入的分数
            // 每个人的分数总和
            Map<String,Integer> sum = new HashMap<>();
            // 读入，计算分数总和
            for (int i = 0; i < round; i++) {
                who[i] = readString();
                score[i] = readInt();
                if(!sum.containsKey(who[i])){
                    sum.put(who[i],score[i]);
                }else{
                    sum.put(who[i],score[i]+sum.get(who[i]));
                }
            }
            // 计算最大分数
            int max = 0;
            for (Integer integer : sum.values()) {
                max = Math.max(max,integer);
            }
            String res =null;
            // 防止有些人先得了很高分，最终没有得到最高分数
            Set<String> possible =new HashSet<>();
            for (Map.Entry<String, Integer> entry : sum.entrySet()) {
                if(entry.getValue() == max){
                    res = entry.getKey();
                    possible.add(entry.getKey());
                }
            }
            sum.clear();
            if(possible.size() >1){
                for (int i = 0; i < round; i++) {
                    if(!sum.containsKey(who[i])){
                        sum.put(who[i],score[i]);
                    }else{
                        sum.put(who[i],score[i]+sum.get(who[i]));
                    }
                    if(sum.get(who[i])>=max && possible.contains(who[i])){
                        res = who[i];
                        break;
                    }
                }
            }
            writer.println(res);
            reader.close();
            writer.close();
        }
        private int readInt() throws IOException {
            return Integer.parseInt(readString());
        }

        private String readString() throws IOException {
            if(tokenizer == null || !tokenizer.hasMoreElements()){
                tokenizer = new StringTokenizer(reader.readLine());
            }
            return tokenizer.nextToken() ;
        }
}
