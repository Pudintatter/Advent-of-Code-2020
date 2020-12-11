import java.util.*;
import java.io.*;

public class day5{

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
        StringBuilder tickets = new StringBuilder();
        while(scan.hasNext()){

            tickets.append(scan.nextLine());
            tickets.append("\n");
            count++;

        }
        String[] indTicket = new String[count];
        indTicket = tickets.toString().split("\n");
        int seatID = 0;
        int[] seatArray = new int[count];

        for(int i = 0; i < indTicket.length; i++){
            String[] parts = indTicket[i].split("");
            int[] row = new int[128];
            for(int k = 0; k < row.length; k++){
                row[k] = k;
            }
            int[] col = new int[8];
            for(int k = 0; k < col.length; k++){
                col[k] = k;
            }
            for(int j = 0; j < indTicket[i].length(); j++){
                //System.out.print(parts[j] + " ");
                switch(parts[j]){
                    case "F" :
                    row = Arrays.copyOfRange(row, 0, row.length/2);
                    //System.out.println(Arrays.toString(row));
                    break;

                    case "B" :
                    row = Arrays.copyOfRange(row, row.length/2, row.length);
                    //System.out.println(Arrays.toString(row));
                    break;

                    case "R" :
                    col = Arrays.copyOfRange(col, col.length/2, col.length);
                    //System.out.println(Arrays.toString(col));
                    break;

                    case "L" :
                    col = Arrays.copyOfRange(col, 0, col.length/2);
                    //System.out.println(Arrays.toString(col));
                    break;

                }
            }
            //System.out.println("");
            seatID = ((row[0] * 8) + col[0]);
            //System.out.println(seatID);
            seatArray[i] = seatID;
        }
        int max = seatArray[0];
        for(int i = 1; i < seatArray.length; i++){
            if(seatArray[i] > max){
                max = seatArray[i];
            }
        }
        System.out.println("The largest seat ID: " + max);
        System.out.print("Your seat ID: ");
        findMissingSeat(seatArray);
    }

    public static void findMissingSeat(int[] seatArray) {
        Arrays.sort(seatArray);
        for(int i = 0; i < seatArray.length; i++){
            if((seatArray[i] + 1) != seatArray[i + 1] ){
                System.out.println(seatArray[i] + 1);
                break;
            }
        }
        //System.out.println(Arrays.toString(seatArray));
    }
}