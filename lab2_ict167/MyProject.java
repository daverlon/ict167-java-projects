import java.util.Scanner;

// 
// David Long
// Student id: 1234566
//
// ICT167
// Lab 2 submission
// 

public class MyProject {

    public static void main (String[] args) {
        // Program is stored in a main loop function
        mainLoop();
    }

    public static void mainLoop() {
        // flag for the main loop, when it is set to false,
        // the program will end
        boolean running = true;

        // scanner to retrieve input from user
        Scanner sc = new Scanner(System.in);

        // string of all possible char input choices
        String choices = " abcdefgq";

        // main loop
        while (running) {
            
            System.out.println("\nEnter one of the following characters: a, b, c, d, e, f, g, q");

            // store the user's choice
            char choice;

            // convert input to lower case & trim it
            String buff = sc.nextLine().trim().toLowerCase();

            // ensure there is a valid char to store in the 'choice' variable
            if (buff.length() > 0)
                choice = buff.charAt(0);
            else {
                System.out.println("Invalid choice. Try again..");
                continue;
            }

            // get index of matching choice letter in 'choices' string
            int choice_index = choices.indexOf(choice);

            // ensure it is a valid choice
            if (choice_index == -1 || choice_index == 0) {
                System.out.println("Invalid choice. Try again.");
                continue;
            }

            // handle each choice and run respective functionality
            switch (choice_index) {
                // a
                case 1:
                    System.out.println("My name is David Long. My tutor's name is John Smith.");
                    break;
                // b
                case 2:
                    smallestAndLargestNumbers(sc);
                    break;
                // c
                case 3:
                    displayRange(sc);
                    break;
                // d
                case 4:
                    validTriangle(sc);
                    break;
                // e
                case 5:
                    isPrimeNumber(sc);
                    break;
                // f
                case 6:
                    listAverage(sc);
                    break;
                // g
                case 7:
                    swapLetters(sc);
                    break;
                // q
                case 8:
                    System.out.println("Quitting...");
                    running = false;
                    break;
                // else
                default:
                    break;
            }
        }
    } 

    // display the smallest and largest numbers in a list
    public static void smallestAndLargestNumbers(Scanner sc) {
        // store the integer array (size 3)
        int[] inputs = {0, 0, 0};
        // the names of the ints (according to the lab instructions)
        char[] names = {'x', 'y', 'z'};

        System.out.print("\n");
        // retrieve 3 integers from the user
        for (int i = 0; i < 3; i++) {
            String msg = String.format("Enter a number for %c: ", names[i]);
            System.out.print(msg);
            int a = sc.nextInt();
            // store the retrieved integer in the respective array index
            inputs[i] = a;
        }

        // output a the results
        String output = String.format("%d is the smallest and %d is the highest.",
            lowestNumber(inputs), highestNumber(inputs));
        System.out.println(output);

        // clear the input buffer
        sc.nextLine();
    }

    // get the lowest number in an int array
    public static int lowestNumber(int[] numbers) {
        int min = 99999;
        for (int i = 0; i < numbers.length; i++)
            if (numbers[i] < min) min = numbers[i];
        return min;
    }

    // get the highest number in an int array
    public static int highestNumber(int[] numbers) {
        int max = -99999;
        for (int i = 0; i < numbers.length; i++)
            if (numbers[i] > max) max = numbers[i];
        return max;
    }

    // get the average number (float) in an int array
    public static float averageNumber(int[] numbers) {
        int n = numbers.length;
        float sum = 0.0f;
        for (int i = 0; i < n; i++) {
            sum += (float)numbers[i];
        }
        return sum / (float)n;
    }

    // display all numbers within a user selected range 
    public static void displayRange(Scanner sc) {
        int start = 0;
        int end = 0;

        // retrieve the two ranges
        System.out.print("\nEnter a number for m: ");
        start = sc.nextInt();
        System.out.print("Enter a number for n: ");
        end = sc.nextInt();

        // determine the range start and finish
        int a = (start < end) ? start : end;
        int b = (start > end) ? start : end;

        // keep count of the iterations
        int count = 0;
        for (int i = a; i < b+1; i++) {
            // print the number
            System.out.printf("%d", i);
            // print a comma between the numbers
            // unless it is the final number
            if (i != b)
                System.out.print(",");
            // increment the count
            count++;

            // go to the next line if the count
            // is a multiple of 5
            if (count % 5 == 0) {
                System.out.print("\n");
            }
        }
        System.out.print("\n");

        // clear the input buffer
        sc.nextLine();
    }

    public static void validTriangle(Scanner sc) {
        // store each triangle side in an int array
        int[] sides = {0, 0, 0};
        // retrieve the sides as chosen by the user
        System.out.print("Enter three triangle side lengths (e.g. \"25 25 25\"): ");
        for (int i = 0; i < 3; i++) {
            sides[i] = sc.nextInt();
        }
        System.out.print("\n");

        // the triangle is assumed to be valid
        // this loop will detect if it is invalid
        boolean isvalid = true;
        for (int i = 0; i < 3; i++) {
            // 'loop' through each combination of sides

            // store the current index as side 1
            int side1 = sides[i];

            // store the next side as the next
            int side2 = (i >= 3-1) ? sides[0] : sides[i+1];

            // the final side
            // the index will 'loop' back to 0 as the index 
            // goes over (3-1)
            int otherside = (i >= 1) ? sides[Math.abs(i-2)] : sides[i+2];

            // if one side is more than the other 2 combined,
            // triangle is invalid
            boolean valid = (side1 + side2) > otherside;

            // output the steps to the user
            System.out.printf("%d+%d > %d? %b\n", side1, side2, otherside, valid);

            if (valid == false) isvalid = false;
        }

        // output the result to the user
        String result = (isvalid) ? "Triangle is valid." : "Invalid triangle sides.";
        System.out.println(result);
        
        // clean the input buffer
        sc.nextLine();
    }

    public static void isPrimeNumber(Scanner sc) {
        int n = 0;
        // retrieve the chosen number from the user 
        System.out.print("Enter a number for n: ");
        n = sc.nextInt();
        boolean isPrime = true;
        for (int i = 2; i < n; i++) {
            // try to divide the number with all numbers
            // up to n
            // if it finds a divisible number
            // break the loop and set to false
            if (n % i == 0) {
                isPrime = false;
                break;
            }
        }
        // output results to the user
        String result = String.format("%d is %s prime number.", n, (isPrime) ? "a" : "not a");
        System.out.println(result);

        // clean the input buffer
        sc.nextLine();
    }

    public static void listAverage(Scanner sc) {
        // store 10 numbers in an array
        int[] numbers = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        System.out.print("Enter 10 numbers (e.g. \"1 2 3 4 5 6 7 8 9 10\"): ");
        // retrieve 10 integers from the user
        for (int i = 0; i < 10; i++) {
            numbers[i] = sc.nextInt();
        }
        // display relevant information
        System.out.printf("Average number in list: %1.3f\n", averageNumber(numbers));
        System.out.printf("Highest number in list: %d\n", highestNumber(numbers));
        System.out.printf("Lowest number in list:  %d\n", lowestNumber(numbers));
        // clean the input buffer
        sc.nextLine();
    }

    public static void swapLetters(Scanner sc) {
        System.out.println("Enter a string with up to 50 characters");
        String s = "";
        // retrieve a string from the user
        s = sc.nextLine();
        // if the string is over the character limit (50),
        // keep asking for a new string
        while (s.length() > 50) {
            System.out.println("Error. String length is over 50.\nPlease try again.");
            s = sc.nextLine();
        }
        // save the length
        int n = s.length();
        // save the first and last chars
        char first = s.charAt(0);
        char last = s.charAt(n-1);

        // create a new string by appending the
        // last char, then 'in-between' portion, then first char
        s = last + s.substring(1, n-1) + first;

        // display the string to the user
        String res = String.format("Result string: %s\n", s);
        System.out.println(res);
        // clean the input buffer
        //sc.nextLine();
    }
}
