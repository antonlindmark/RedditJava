package codingTest;

import java.util.Scanner;

public class ProblemEasy {

    public static void main(String [] args ) {
        Scanner sc = new Scanner(System.in);
        int heightRoof = sc.nextInt();
        int angleToGround = sc.nextInt();

        double ladderLength = heightRoof / (Math.sin(Math.toRadians(angleToGround)));
        System.out.println((int)Math.ceil(ladderLength));
    }
}
