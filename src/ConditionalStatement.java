import java.util.Scanner;

/**
 * Created by Travis Brindley on 6/26/2017.
 * Assignment:  Creates multiple outputs based off branching.
 */

public class ConditionalStatement {

    //Method to validate the range
    public static int Validate(Scanner scnr, int number, String name){

        while(number < 0 || number > 100){
            System.out.printf("Incorrect number %s.  Please enter a whole number between 1 & 100:  ", name);
            number = scnr.nextInt();
        }
        return number;
    }

    public static Boolean oddEven(int number){
        //checks if the number is divisible by 2
        boolean divByTwo = number % 2 == 0;

        return divByTwo;
    }
    public static String numRange(int number, Boolean oddEven){

        String x;
        String num = String.valueOf(number);

        //Changes output if the number is odd or even
        if(oddEven == false){
            if(number > 60){
                x = "Odd and over 60";
            }
            else{
                x = num.concat(" and odd");
            }

        }

        else{
            //number range
            if(number <= 25){
                x = "Even and equal to or under 25.";
            }
            else if(number <=60){
                x = "Even";
            }
            else{
                x = num.concat(" and even.");
            }
        }

        return x;
    }

    public static String getName(){
        Scanner scnr = new Scanner(System.in);
        System.out.println("Lab 2:  Conditional Statements");
        System.out.print("Welcome!  What is your name? ");
        String name = scnr.nextLine();
        return name;
    }

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        String cont;
        String name = getName();

        boolean firstTime = true;

        do{
            if(firstTime == true) {
                System.out.printf("%s, please enter a whole number between 1 & 100:  ", name);
            }
            else{
                System.out.printf("You know the routine %s, please enter a whole number between 1 & 100:  ", name);
            }

            while(!scnr.hasNextInt()) {  //if input isn't an integer, this while loop will continue until it is
                System.out.printf("I'm sorry %s, that isn't a valid integer. Please enter an integer between 1 & 100: ",name);
                scnr.next();
            }
            int number = scnr.nextInt();

            number = Validate(scnr,number, name); //ensures the number is between 1 & 100

            Boolean oddEven = oddEven(number);    //Gets odd or even status

            String numRange = numRange(number, oddEven);  // determines the number range

            System.out.println(numRange); // results output

            scnr.nextLine(); //junk line because Java struggles switching between types

            System.out.print("Continue? Y/N: ");
            cont = scnr.nextLine();


            firstTime = false;  //changes the first time condition
        }while(cont.equalsIgnoreCase("y"));

        //exit line
        System.out.printf("goodbye %s, thanks for playing!",name);
    }


}
