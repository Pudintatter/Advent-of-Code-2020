import java.util.*;
import java.io.*;

public class day6A{
    public static void main(String[] args){
        final long startTime = System.currentTimeMillis();
        try{
            File file = new File(args[0]);
            Scanner scan = new Scanner(file);
            processData(scan);
        }catch(IOException e){
            System.out.println("File not found.");
        }

        final long endTime = System.currentTimeMillis();
        System.out.println("Total execution time: " + (endTime - startTime) + " ms");
    }
   
    public static void processData(Scanner scan) {
        int count = 0;
        int sum = 0;
        StringBuilder strBld = new StringBuilder();
        while(scan.hasNext()){
            strBld.append(scan.nextLine());
            strBld.append("\n");
            count++;
        }
        String[] group = new String[count];
        group = strBld.toString().split("\n\n");

        for(int i = 0; i < group.length; i++) {
            String singleGroup = group[i].replaceAll("[\\r\\n]+", " ");
            singleGroup = singleGroup.replaceAll(" ", "");
            String[] newSingleGroup = singleGroup.split("");
            ArrayList<String> uniqueLetter = new ArrayList<>();
            for(int j = 0; j < newSingleGroup.length; j++){
                String w = newSingleGroup[j];
                if(!uniqueLetter.contains(w)) {
                    uniqueLetter.add(w);
                    sum++;
                }
            }
        }
        System.out.println("The total sum is: " + sum);
    }
}