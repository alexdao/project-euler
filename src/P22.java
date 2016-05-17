import java.util.*;

/**
 * Created by alex on 5/14/16.
 */
public class P22 {

    public static void main(String args[]){

        Scanner in = new Scanner(System.in);
        String longString = in.next();
        List<String> names = Arrays.asList(longString.split(","));
        List<String> rawNames = new ArrayList<>();
        for(String name: names){
            rawNames.add(name.substring(1, name.length()-1));
        }
        Collections.sort(rawNames);

        List<String> processedNames = new ArrayList<>();
        for(String name: rawNames){
            processedNames.add(name.toLowerCase());
        }

        long score = 0;
        for(int j=0; j<processedNames.size(); j++){
            String name = processedNames.get(j);
            long letterScore = 0;
            for(int i=0; i<name.length(); i++){
                letterScore += name.charAt(i)-96;
            }
            score += letterScore * (j+1);
        }
        System.out.print(score);
    }
}
