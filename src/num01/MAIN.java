package num01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 *
 * Created by Administrator on 2017/12/15.
 */
public class MAIN {
    //25337
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int max=91;
        int count = 0;
        for (int i =1 ; i<20 ;i++){
            for(int j = i+1;j<max;j++){
                for(int k=j+1;k<max;k++){
                    for(int m=k+1;m<max;m++){
                        int n = 100-i-j-k-m;
                        if(n<=0){ //不能小于0
                            break;
                        }
                        if(n>=22){// 我不知道为啥。但是这个数就对。可能是因为 18 19 20 21 22 这个特殊的组合
                            max=n;
                        }
                        // 数字不能相同
                        if(i!=n && j!=n && k!=n && m!=n) {
                            count++;
                            System.out.println(i + " " + j + " " + k + " " + m + " " + n + " max:" + max);
                        }
                    }
                }
            }
        }
        System.out.println(count);
        System.out.println("time:"+(System.currentTimeMillis()-start));
    }

    }

