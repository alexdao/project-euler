package problems;

import sun.jvm.hotspot.jdi.ArrayReferenceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by alex on 5/12/16.
 */
public class P018 {

    private static List<List<Integer>> tree = new ArrayList<>();

    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int count = 1;
        int lines = 15;
        for(int i=0; i<lines; i++){
            List<Integer> line = new ArrayList<>();
            for(int j=0; j<count; j++){
                line.add(in.nextInt());
            }
            tree.add(line);
            count++;
        }
        System.out.print(calcMaxPath(0, 0));
    }

    private static int calcMaxPath(int line, int index){
        if(line == 14){
            return tree.get(line).get(index);
        }
        return tree.get(line).get(index) + Math.max(calcMaxPath(line+1, index), calcMaxPath(line+1, index+1));
    }
}
