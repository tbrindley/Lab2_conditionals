import java.util.Scanner;

/**
 * Created by Travis Brindley on 6/26/2017.
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

        // returns a boolean response
        Boolean oddEven = (divByTwo == true)? true:false;

        return oddEven;
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

    public static void main(String[] args) {

        //variable declaration
        Scanner scnr = new Scanner(System.in);
        char cont;

        //welcome statement
        System.out.println("Lab 2:  Conditional Statements");

        //collects username
        System.out.print("Welcome!  What is your name? ");
        String name = scnr.nextLine();

        //creates a counter to change the input as it iterates through
        int i = 1;

        //loops the process until user quits.
        do{
            //Gives a different prompt the first time through
            if(i == 1) {
                System.out.printf("%s, please enter a whole number between 1 & 100:  ", name);
            }
            else{
                System.out.printf("You know the routine %s, please enter a whole number between 1 & 100:  ", name);
            }

            //if input isn't an integer, this while loop will continue until it is
            while(!scnr.hasNextInt()) {
                System.out.printf("I'm sorry %s, that isn't a valid integer. Please enter an integer between 1 & 100: ",name);
                scnr.next();
            }

            //inputs number
            int number = scnr.nextInt();

            //ensures the number is between 1 & 100
            number = Validate(scnr,number, name);

            //Gets odd or even status
            Boolean oddEven = oddEven(number);

            // determines the number range
            String numRange = numRange(number, oddEven);

            // results output
            System.out.println(numRange);

            //repeats the loop as needed
            System.out.print("Continue? Y/N: ");
            cont = scnr.next().charAt(0);

            //adds a count
            i += 1;
        }while(cont == 'y' || cont == 'Y' );

        //exit line
        System.out.printf("goodbye %s, thanks for playing!",name);
    }


}
