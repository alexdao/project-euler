package problems;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by alex on 5/10/16.
 */
public class P1 {

    public static void main(String args[]){
        Set<Integer> multiples = new HashSet<>();
        for(int i=3; i<1000; i+=3){
            multiples.add(i);
        }
        for(int i=5; i<1000; i+=5){
            multiples.add(i);
        }
        int total = 0;
        for(Integer i: multiples){
            total += i;
        }
        System.out.print(total);
    }
}
