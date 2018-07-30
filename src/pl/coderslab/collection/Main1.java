package pl.coderslab.collection;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main1 {

    private static final Pattern Earning = Pattern.compile("[1-9][0-9]{2,}(\\.[0-9]{2})?");

    public static void main(String[] args) {

        File file = new File("earnings.txt");

        List<String> top3ofNotKowalski = new ArrayList<>();

        Pattern Kowalski = Pattern.compile("Kowalsk[ia]{1}", Pattern.CASE_INSENSITIVE);

        try {
            Scanner scanFile = new Scanner(file);

            while (scanFile.hasNextLine()) {

                String line = scanFile.nextLine();

                if (!Kowalski.matcher(line).find()){

                    if (Earning.matcher(line).find()) {
                        updateTopEarningsList(top3ofNotKowalski, line, 3);
                    }
                }
            }
        } catch(IOException e) {e.printStackTrace();}

        top3ofNotKowalski = top3ofNotKowalski.subList(0,3);
        for (String line : top3ofNotKowalski){
            System.out.println(line);
        }
    }


    private static void updateTopEarningsList(List<String> topList, String lineToCompare, int listTargerSize) {

        Iterator<String> iterator = topList.iterator();

        Matcher foundEarning = Earning.matcher(lineToCompare);
        foundEarning.find();
        double thisEarning = Double.parseDouble(lineToCompare.substring(foundEarning.start(),foundEarning.end()));

        for (int i=0; i < listTargerSize; i++){
            if (iterator.hasNext()) {

                String lineFromTopList = iterator.next();
                foundEarning = Earning.matcher(lineFromTopList);
                foundEarning.find();
                double comparedEarning = Double.parseDouble(lineFromTopList.substring(foundEarning.start(), foundEarning.end()));

                if (comparedEarning < thisEarning){
                    topList.add(i, lineToCompare);
                    break;
                }

            }else{
                topList.add(lineToCompare);
                break;
            }
        }
    }
}