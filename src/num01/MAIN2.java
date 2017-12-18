package num01;

/**
 * 暴力破解 显然不是最高效的  但是肯定对
 * Created by Administrator on 2017/12/18.
 */
public class MAIN2 {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int count = 0;
        for (int i =1 ; i<20 ;i++){
            for(int j = i+1;j<100;j++){
                for(int k=j+1;k<100;k++){
                    for(int m=k+1;m<100;m++){
                        for(int n =m+1 ; n<100;n++){
                            if(i+j+k+m+n==100) {
                                count++;
                                System.out.println(i + " " + j + " " + k + " " + m + " " + n );
                            }
                        }


                    }
                }
            }
        }
        System.out.println(count);
        System.out.println("time:"+(System.currentTimeMillis()-start));
    }
}
