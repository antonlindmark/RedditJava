package EasyLevel;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by user on 2017-09-04.
 */
public class NearestLuckyNumbers {

    public static void main(String [] args){

        while(true){
            System.out.println("Enter a positive integer!");
            Scanner scanner = new Scanner(System.in);
            int userInput = scanner.nextInt();
            if(userInput<1){
                System.err.println("Enter a positive integer");
                System.exit(1);
            }

            int upUserInput=userInput;
            int lowUserInput=userInput;
            int listSize = 5000; // Must be bigger than userInput
            ArrayList al = getLuckyList(listSize);

            //Checks either if its a lucky nr, or the closest ones and prints
            if(al.contains(userInput)){
                System.out.println(userInput+" is a lucky number\n");
            }
            else{
                while(!al.contains(upUserInput)){
                    upUserInput++;
                }
                while(!al.contains(lowUserInput)){
                    lowUserInput--;
                }
                System.out.println(lowUserInput+"<"+userInput+"<"+upUserInput+"\n");
            }
        }
    }

    public static ArrayList<Integer> getLuckyList(int listSize){
        int removeFrequency=0;
        ArrayList<Integer> al = new ArrayList<>();

        //Adds all numbers to the list
        for (int i = 0; i < listSize; i++) {
            al.add(i,i+1);
        }
        // Remove numbers from list to get lucky numbers
        while(removeFrequency<al.size()){ // add some statement on how long run depending on user input
            int x = al.get(removeFrequency);
            for (int i = 1; i <al.size() ; i++) {
                if(i*x <al.size()){

                    if(removeFrequency==0){
                        al.remove(i*x);
                    }
                    else{
                        al.remove((i*x)-i);
                        // -i to compensate for every removed nr in the list
                    }
                }
            }
            removeFrequency++;
        }
        return al;
    }
}
