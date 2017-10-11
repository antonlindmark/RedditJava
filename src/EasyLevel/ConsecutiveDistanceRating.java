package EasyLevel;

public class ConsecutiveDistanceRating {

    public static void main (String []args){

        /*
         Program calculates the sum of the distances between consecutive integers.

         For example "1 7 2 11 8 34 3"
         1 and 2 is consecutive integers distance between them is 2
         2 and 3 are consecutive integers, and their distance is 4.
         The distance between 7 and 8 is 3.
         The sum of these distances is 9.

         */

        int y=6; // Rows
        int x=20; // Columns

        int[][] inputArray= { {76 ,74 ,45 ,48 ,13 ,75 ,16 ,14 ,79 ,58 ,78 ,82 ,46 ,89 ,81 ,88 ,27 ,64, 21, 63},
                { 37 ,35 ,88 ,57 ,55, 29 ,96 ,11 ,25 ,42 ,24 ,81 ,82 ,58 ,15 ,2, 3, 41, 43, 36},
                {54 ,64 ,52 ,39 ,36 ,98 ,32 ,87 ,95 ,12 ,40 ,79 ,41 ,13 ,53 ,35 ,48 ,42 ,33 ,75},
                {21 ,87 ,89 ,26 ,85, 59, 54, 2, 24, 25, 41, 46, 88, 60, 63, 23, 91, 62, 61, 6},
                { 94 ,66 ,18 ,57 ,58 ,54 ,93 ,53 ,19 ,16 ,55 ,22 ,51 ,8 ,67, 20 ,17 ,56 ,21 ,59},
                { 6 ,19 ,45 ,46 ,7 ,70, 36, 2 ,56, 47, 33, 75, 94, 50, 34, 35, 73, 72, 39, 5},
        };

        for (int i = 0; i <y ; i++) {
            for (int j = 0; j <x ; j++)
                System.out.print(inputArray[i][j]+" ");
            System.out.println();
        }
        System.out.println("\nResult :\n");


        int arr [] = getOutputArray(inputArray);
        for (int anArr : arr)
            System.out.println(anArr);
    }

    public static int [] getOutputArray(int [][] arr){
        int rows = arr.length;
        int cols = arr[0].length;

        int outputArray [] = new int[rows];

        for (int i = 0; i <rows ; i++) {
            int distance=0;
            for (int j = 0; j <cols ; j++) {
                                                         // Each row starts here
                int currentNumber = arr[i][j];

                for (int k = j+1; k <cols ; k++) {      // Forwards in the check  : 9 ,3, 10 ->distance =2  10,3,9 should also give 2
                    if(currentNumber+1 ==arr[i][k])
                        distance+= (k-j);
                }
                for (int k = cols-1; k >=j+1 ; k--) {  // backwards
                    if(currentNumber-1 ==arr[i][k])
                        distance+= (k-j);
                }
            }
            outputArray[i]=distance;
        }
        return outputArray;
    }
}
