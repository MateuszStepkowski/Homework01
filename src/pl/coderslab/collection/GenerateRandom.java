package pl.coderslab.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class GenerateRandom {

    public static void main(String[] args) {
        System.out.println(checkRand(50000,10));
    }

    public static Map<Integer, Integer> checkRand(int amount, int interval){

        Random rand = new Random();
        Map<Integer, Integer> resultMap = new HashMap<>();
        for (int i = 0; i<amount; i++){
            int randNum = rand.nextInt(interval);
            if (resultMap.containsKey(randNum)) {
                int occurences = resultMap.get(randNum) + 1;
                resultMap.put(randNum, occurences);
            }else{
                resultMap.put(randNum, 1);
            }
        }
        return resultMap;
    }
}
