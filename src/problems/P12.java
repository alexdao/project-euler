package problems;

/**
 * Created by alex on 5/12/16.
 */
public class P12 {

    public static void main(String args[]){
        long triangleNum = 0;
        long addNum = 1;
        while(true){
            triangleNum += addNum;
            if(countDivisor(triangleNum) > 500){
                break;
            }
            addNum++;
        }
        System.out.print(triangleNum);
    }

    private static int countDivisor(long num){
        int count = 0;
        for(long i = 1; i*i <= num; i++){
            if(num%i == 0){
                if(i*i == num)
                    count++;
                else
                    count += 2;

            }
        }
        return count;
    }
}
