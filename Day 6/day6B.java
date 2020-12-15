import java.util.*;
import java.io.*;

public class day6B{
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
            int personCount = 0;
            String[] singleGroup = group[i].split("\n");
            String answers = group[i].replaceAll("[\\r\\n]+", "");
            for(int j = 0; j < singleGroup.length; j++) {
                personCount++;
            }
            if(personCount == 1) {
                String[] individual = singleGroup[0].split("");
                sum = sum + individual.length;
            } else {
                int[] freq = new int[answers.length()];
                char string[] = answers.toCharArray();
                for(int k = 0; k < answers.length(); k++){
                    freq[k] = 1;
                    for(int t = k + 1; t < answers.length(); t++) {
                        if(string[k] == string[t]) {
                            freq[k]++;
                            string[t] = '0';
                        }
                    }
                }
                for(int k = 0; k < freq.length; k++) {
                    if(string[k] != ' ' && string[k] != '0') {
                        if(freq[k] == personCount) {
                            sum = sum + 1;
                        }
                    }
                }
            }

        }
        System.out.println("The total sum is: " + sum);
    }
}