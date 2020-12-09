import java.util.*;
import java.io.*;

public class day4B{//121
   
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
        int pInvalid = 0;

        for(int i = 0; i < indPass.length; i++) {
            day4B isValid = new day4B();
            pTotal++;
            if(isValid.validPassport(indPass[i]) == true) {
                pValid++;
            }else{
                pInvalid++;
            }
        }
        System.out.println("Total passports scanned: " + pTotal);
        System.out.println("Total valid passports scanned: " + pValid);
        System.out.println("Total invalid passports scanned: " + pInvalid);
    }

    public boolean validPassport(String currentPass) {
        String[] search = {"ecl:", "pid:", "eyr:", "hcl:", "byr:", "iyr:", "hgt:"};
        String[] validECL = {"amb", "blu", "brn", "gry", "grn", "hzl", "oth"};
        String newCurrentPass = currentPass.replaceAll("[\\r\\n]+", " ");
        //System.out.print("\n");

        if(Arrays.stream(search).allMatch(currentPass :: contains)){
            String[] pairs = newCurrentPass.split(" ");
            String val = pairs[1];
            int count = 0;
            for(int i = 0; i < pairs.length; i++){
                String[] data = pairs[i].split(":");
                //System.out.println(data[0] + " " + data[1]);            
                switch(data[0])
                {
                    case "ecl" :
                        for(int j = 0; j < validECL.length; j++){
                            if(data[1].contains(validECL[j])){
                                //System.out.println("check 1");
                                count++;
                            }
                        }
                    break;

                    case "pid" :
                    int length = data[1].length();
                    if(length == 9){
                        //System.out.println("check 2");
                        count++;
                    }
                    break;

                    case "eyr" :
                    int exYear = Integer.parseInt(data[1]);
                    if(data[1].length() == 4){
                        if(exYear >= 2020 && exYear <= 2030){
                            //System.out.println("check 3");
                            count++;
                        }
                    }
                    break;

                    case "hcl" :
                    String match = ".*#[ABCDEFabcdef0123456789].*";
                    if(data[1].matches(match)){
                        //System.out.println("check 4");
                        count++;
                    }
                    break;

                    case "byr" :
                    if(data[1].length() == 4){
                        int year = Integer.parseInt(data[1]);
                        if(year >= 1920 && year <= 2002){
                            //System.out.println("check 5");
                            count++;
                        }
                    }
                    break;

                    case "iyr" :
                    if(data[1].length() == 4){
                        int issue = Integer.parseInt(data[1]);
                        if(issue >= 2010 && issue <= 2020){
                            //System.out.println("check 6");
                            count++;
                        }
                    }
                    break;

                    case "hgt" :
                    String[] height = data[1].split("(?<=\\d)(?=\\D)");
                    int tall = Integer.parseInt(height[0]);
                    if(height[height.length - 1].equals("cm")) {
                        if(tall >= 150 && tall <= 193){
                            //System.out.println("check 7");
                            count++;
                        }
                    }
                    else if(height[height.length - 1].equals("in")){
                        if(tall >= 59 && tall <= 76){
                            //System.out.println("check 7");
                            count++;
                        }
                    }
                    break;

                }
                if(count == 7){
                    return true;
                }
                
            }
        }
        return false;
    }
}