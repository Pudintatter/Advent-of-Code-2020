import java.util.*;
import java.io.*;

public class day4A{
   
    public static void main(String[] args) {
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
        StringBuilder passport = new StringBuilder();
        while(scan.hasNext()){

            passport.append(scan.nextLine());
            passport.append("\n");
            count++;

        }
        String[] indPass = new String[count];
        indPass = passport.toString().split("\n\n");
        int pTotal = 0;
        int pValid = 0;
        int pInvalid = 0;//254        
        String[] search = {"ecl", "pid", "eyr", "hcl", "byr", "iyr", "hgt"};

        for(int i = 0; i < indPass.length; i++) {
            pTotal++;
            if(Arrays.stream(search).allMatch(indPass[i] :: contains)) {
                pValid++;
            }else{
                pInvalid++;
            }
        }
        System.out.println("Total passports scanned: " + pTotal);
        System.out.println("Total valid passports scanned: " + pValid);
        System.out.println("Total invalid passports scanned: " + pInvalid);

    }
}