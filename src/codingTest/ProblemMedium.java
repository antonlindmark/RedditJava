package codingTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class ProblemMedium {
    public static void main(String [] args ) {

        Scanner sc = new Scanner(System.in);

        ArrayList<String> sortedNames = new ArrayList<>();
        ArrayList<String> tempSort = new ArrayList<>();

        while (sc.hasNext()) {
            int n = sc.nextInt();
            if(n==0)
                break;
            for (int i = 0; i <n ; i++) {
                tempSort.add(sc.next());
            }
            Collections.sort(tempSort, Comparator.comparing(s -> s.substring(0,2)));
            tempSort.add(""); // Add space for printing

            for (int i = 0; i <tempSort.size(); i++) { // Add together lists to one big printing list
                sortedNames.add(tempSort.get(i));
            }
            tempSort.clear();
        }
        for (int i = 0; i <sortedNames.size()-1; i++) { // -1 to remove last "space"
            System.out.println(sortedNames.get(i));
        }
    }
}
