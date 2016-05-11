import java.util.HashSet;
import java.util.Set;

/**
 * Created by alex on 5/10/16.
 */
public class P9 {

    public static void main(String args[]){
        Set<Integer> squares = new HashSet<>();
        for(int i=1; i<=1000; i++){
            squares.add(i*i);
        }
        for(int j: squares){
            for(int k: squares){
                if(j != k && squares.contains(j+k)){
                    double a = Math.sqrt(j);
                    double b = Math.sqrt(k);
                    double c = Math.sqrt(j+k);
                    if(a+b+c == 1000){
                        System.out.print(a*b*c);
                        return;
                    }
                }
            }
        }
    }
}
