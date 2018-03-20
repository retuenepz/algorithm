package codeforces.pro2C;

import java.util.Scanner;

/**
 * 2c-commentator problem 模拟退火
 * 作者:hongyanbo
 * 时间:2018/3/19
 */

public class Main {

    static  Circle[] circles = new Circle[3];
    static class Circle{
        double x,y,r;
    }
    public static void main(String[] args) {
         Scanner sc  = new Scanner(System.in);
         // 中心点，算法开始的点。
         double x =0,y=0;
         for (int i = 0; i < 3; i++) {
            Circle circle = new Circle();
            circle.x = sc.nextInt();
            circle.y = sc.nextInt();
            circle.r = sc.nextInt();
            x += circle.x /3;
            y += circle.y /3;
            circles[i] = circle;
        }
        double step = 1.0; // 步长,或者也叫温度
        while(step > 1e-6){
            boolean flag = true ;
            double d = deviation(x,y);
            if(deviation(x+step,y) < d){
                x+= step;
            }else if(deviation(x,y+step) <d){
                y += step;
            }else if(deviation(x-step,y) <d){
                x -= step ;
            }else if(deviation(x,y-step) <d){
                y -= step;
            }else{
                step*=0.7;
            }
        }
        if(deviation(x,y) < 1e-5){
            System.out.println(String.format("%.5f %.5f",x,y));
        }
    }

    /**
     * 计算点到三个角度的方差
     * 题目要求 the stadiums should be observed at the same angle
     * 就是说，方差最后要等于0才行。
     */
    public static double deviation(double x , double y){
        double res = 0.0; //方差
        double[] arr = new double[3]; //角度
        int i = 0;
        for (Circle circle : circles) {
            arr[i] = Math.sqrt(square(circle.x-x)+square(circle.y-y))/circle.r;
            i++;
        }
        for (int k = 0; k < 3; k++) {
            res += square(arr[k] - arr[(k+1)%3]);
        }
        return res;
    }

    public static double square(double x){ return x*x;}
}
