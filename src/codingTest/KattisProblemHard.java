package codingTest;

import java.util.Scanner;
import java.util.Stack;


public class KattisProblemHard {
    public  static  void main(String args[]){


        Scanner sc = new Scanner(System.in);
        StringBuilder userInput= new StringBuilder();


        while (sc.hasNextLine()) {
            userInput.append(sc.nextLine());
            userInput.append("\n");
            userInput.append("| "); // New line separator when print
        }
        //  userInput.deleteCharAt(userInput.length()-1);

        String [] inputWithoutSpaces=userInput.toString().split("\\s+"); //Remove spaces from input
        Stack stack = simplyfy(inputWithoutSpaces);

        int counter=1;

        System.out.print("Case " + (counter) + ": ");
        while(!stack.isEmpty()){
            if(stack.peek().toString().charAt(0)=='|'){
                counter++;
                stack.pop();
                if(stack.size()>0){
                    System.out.println();
                    System.out.print("Case " + ( counter) + ": ");
                }
            }
            else{
                System.out.print(stack.pop()+" ");
            }
        }
    }

    public static Stack simplyfy(String [] inputWithoutSpaces){
        int E1;
        int E2;
        Stack stack = new Stack();
        for (int i =inputWithoutSpaces.length-1; i >=0; i--) {
            stack.push(inputWithoutSpaces[i]);

            if (inputWithoutSpaces[i].equals("*") && stack.size()>2) {

                Object temp1= stack.pop();

                String s = (String) stack.peek();
                if(s.matches(".*\\d+.*")){
                    Object temp2= stack.pop();
                    E1 =Integer.parseInt(s);

                    String s2 = (String) stack.peek();
                    if(s2.matches(".*\\d+.*")){
                        stack.pop();
                        E2=Integer.parseInt(s2);
                        String newPush=String.valueOf(E1 *E2);
                        stack.push(newPush);
                    }
                    else{
                        stack.push(temp2);
                        stack.push(temp1);
                    }
                }
                else{
                    stack.push(temp1);
                }
            }

            else if (inputWithoutSpaces[i].equals("+")&& stack.size()>2) {
                Object temp1= stack.pop();

                String s = (String) stack.peek();
                if(s.matches(".*\\d+.*")){
                    Object temp2= stack.pop();
                    E1 =Integer.parseInt(s);

                    String s2 = (String) stack.peek();
                    if(s2.matches(".*\\d+.*")){
                        stack.pop();
                        E2=Integer.parseInt(s2);
                        String newPush=String.valueOf(E1 +E2);
                        stack.push(newPush);
                    }
                    else{
                        stack.push(temp2);
                        stack.push(temp1);
                    }
                }
                else
                    stack.push(temp1);
            }

            else if (inputWithoutSpaces[i].equals("-")&& stack.size()>2) {
                Object temp1= stack.pop();

                String s = (String) stack.peek();
                if(s.matches(".*\\d+.*")){
                    Object temp2= stack.pop();
                    E1 =Integer.parseInt(s);

                    String s2 = (String) stack.peek();
                    if(s2.matches(".*\\d+.*")){
                        stack.pop();
                        E2=Integer.parseInt(s2);
                        String newPush=String.valueOf(E1 -E2);
                        stack.push(newPush);
                    }
                    else{
                        stack.push(temp2);
                        stack.push(temp1);
                    }
                }
                else
                    stack.push(temp1);
            }
        }
        return stack;
    }
}

