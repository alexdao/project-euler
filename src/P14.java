import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by alex on 5/12/16.
 */
public class P14 {

    public static void main(String args[]){
        Map<Long, Long> visited = new HashMap<>();
        long max = 0;
        long maxPath = 0;
        for(int i=1; i<1000000; i++){
            long pathLength = 1;
            long curr = i;
            while(curr != 1){
                if(visited.containsKey(curr)){
                    pathLength += visited.get(curr);
                    break;
                }
                if(curr % 2 == 0){
                    curr /= 2;
                }
                else{
                    curr = 3 * curr + 1;
                }
                pathLength++;
            }

            visited.put(curr, pathLength);

            if(pathLength > maxPath){
                maxPath = pathLength;
                max = i;
            }
        }
        System.out.print(max);
    }
}
