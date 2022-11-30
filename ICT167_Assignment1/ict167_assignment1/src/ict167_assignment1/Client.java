package ict167_assignment1;

import java.util.Scanner;
import ict167_assignment1.Change;

/*
 * 
 * Author: David Long
 * Student ID: 1234567
 * ICT 167 Assignment 1
 * 
 */

public class Client {

	public static void main(String[] args) {

		StudentInfo();
		
		// ---------------------------------------- //
		
		// hardcoded example (uncomment the line below)
		//HardCodedExample();

		// ---------------------------------------- //
		
		Scanner sc = new Scanner(System.in);

		// store the customer retrieval data in a string
		String customers_buff = RetrieveCustomers(sc);
		// the string will contain the customer count followed by '~',
		// which can be read easily by splitting and indexing the string
		int n = Integer.parseInt(customers_buff.split("~")[0]);
		customers_buff = customers_buff.split("~")[1];

		// the person count was tracked in the retrieval loop,
		// so now it is possible to create an array of that size
		// (which was previously unknown due to it being not-user-specified
		Change[] customers = new Change[n];

		// split the customers buffer by the bar '|' character
		// so it can be indexed
		String[] customers_buff_split = customers_buff.split("\\|");
		// every 2 items in the array will contain the information
		// for 1 person, so the loop must increment by 2, until the second
		// last item

		// j (int) is to keep count of loop to ensure the customers are
		// added to the correct index in the array
		// (i in the for loop won't work since it's being incremented
		// by 2 on each iteration)
		int j = 0;
		// (n*2) is the length of customers_buff_split
		for (int i = 0; i < (n * 2) - 1; i += 2) {
			customers[j] = new Change(customers_buff_split[i], Integer.valueOf(customers_buff_split[i + 1]));
			j++;
		}
		
		// run the menu loop, if the loop is exited, 
		// the program will end (no further instructions)
		HandleMenu(sc, customers);
	}

	public static String RetrieveCustomers(Scanner sc) {
		String ret = "";
		int n = 0; // keep track of the count

		// loop to retrieve the names and change amount for each
		// customer (to be stored into an array after)
		// this loop will store all the details in a string
		// and count each addition
		// after the loop is finished, the customers are extracted
		// from the string buffer and then stored into an array
		boolean running = true;
		while (running) {

			// input buffer storage
			String name_buff = "";
			int change_buff = 0;

			// retrieve the name of each customer and store it in the name buffer
			System.out.println("Please enter the name of the person:");
			name_buff = sc.nextLine().trim();

			// if the name already exists in the customers buffer,
			// send the loop back to the beginning to try again
			if (ret.indexOf(name_buff) != -1) {
				System.out.printf("Error: The name %s has already been entered.\nTry again.\n", name_buff);
				continue;
			}

			// retrieve the change amount and store it in the change buffer
			System.out.println("Please enter the coin value for the person:");
			change_buff = Integer.parseInt(sc.nextLine().trim());

			// once both the name and the change has been retrieved,
			// store them in the customers buffer (string),
			// separating them with the bar '|' character
			ret += String.format("%s|%d", name_buff, change_buff);

			// increment the count to keep track of how many customers
			// have been added by the user
			n += 1;

			// prompt the user to choose to either add another customer
			// or move onto the next menu (by quitting this loop)

			// store the response in a string
			String response = "";

			// keep looping the prompt until a valid response has been detected
			boolean valid_response = false;
			while (!valid_response) {
				System.out.println("Do you have more people to enter (Y/N):");
				// retrieve the response and store it in the string
				response = sc.nextLine().trim().toLowerCase();
				// check if it valid by storing the validity boolean as
				// the loop condition. if the response is valid,
				// the loop will naturally end after
				valid_response = (response.equals("y") || response.equals("n"));
				// display a prompt if the response is invalid,
				// since the condition of the loop is an invalid response,
				// the loop will continue until a valid response is entered
				if (!valid_response)
					System.out.println("Invalid response. Try again.");
			}

			// if the response was to not enter another person,
			// exit the loop
			if (response.equals("n")) {
				running = false;
				break;
			}

			// if the response was to add another person,
			// separate the next person with the bar '|' character
			// and continue the loop
			ret += "|";
		}
		return String.format("%d~", n) + ret;
	}

	public static void HandleMenu(Scanner sc, Change[] customers) {
		// run another loop to prompt the user with the next menu
		// the same running boolean from the previous loop can be reused
		boolean running = true;
		while (running) {

			// show each menu option
			System.out.println("\n1. Enter a name and display change to be given for each denomination");
			System.out.println("2. Find the name with the largest amount and display change to be given for each denomination");
			System.out.println("3. Find the name with the smallest amount and display change to be given for each denomination");
			System.out.println("4. Calculate and display the total number of coins for each denomination");
			System.out.println("5. Calculate and display the total amount (i.e. NOT the total number of coins) for the sum of all denominations");
			System.out.println("6. Exit");

			// store the response from the user
			String response = sc.nextLine().trim().toLowerCase();

			// the options (string) will store each option and allow for
			// easier indexing to ensure the user response is valid
			String options = "123456";
			// since "1" is the first index of options (string)
			// it will be at index 0. so to get the same number as the index
			// the index needs to have 1 added to it
			int iresponse = options.indexOf(response) + 1;
			// restart the loop if the response was invalid
			if (iresponse == -1) {
				System.out.println("Invalid response. Try again.");
				continue;
			}

			// target_index (int) will be used as an index for the target customer
			// which will be calculated on the individual functions
			int target_index = 0;

			// execute the correct functions for the user's choice
			switch (iresponse) {
			case 1:
				// the first option requires the user to enter a name
				System.out.println("Enter a name:");
				target_index = -1; // reset the index target_index
				// target_index the customer name to be searched
				String search_name = sc.nextLine().trim().toLowerCase();
				// if the customer's name is not found in the list,
				// GetCustomerIndexByName will return -1
				target_index = GetCustomerIndexByName(customers, search_name);
				// display the optimal change coin for the customer with the
				// matching name
				if (target_index != -1)
					System.out.println(customers[target_index].GetOptimalCoins());
				break;
			case 2:
				// get the index of the customer with the largest change amount
				// the GetCustomerIndexbyLargestAmount function will return
				// the index, which will be used to index the list and
				// print the correct customer's details
				target_index = GetCustomerIndexByLargestAmount(customers);
				System.out.println(customers[target_index].GetOptimalCoins());
				break;
			case 3:
				// GetCustomerIndexByLowestAmount (int) will return the index
				// of the customer with the lowest change amount
				// which will be used to index the customer list and
				// display the correct details
				target_index = GetCustomerIndexByLowestAmount(customers);
				System.out.println(customers[target_index].GetOptimalCoins());
				break;
			case 4:
				// this option can be stored neatly in a separate function
				// it will loop through the customer list and
				// display the relevant details
				DisplayCoinCounts(customers);
				break;
			case 5:
				// this option is similar to Option4, as it will also
				// loop through the customer list (passed into the function)
				// and display the relevant details
				DisplayTotalChangeInDollars(customers);
				break;
			case 6:
				// this will break the loop, and since there is nothing to be
				// executed after the loop, the program will end
				System.out.println("Exiting program.");
				running = false; // set the loop condition to false
				break; // exit the loop
			default:
				// if somehow a different response was detected,
				// print an error and restart the loop
				// (this is unlikely to happen due to the way the response was retrieved &
				// checked)
				System.out.println("Invalid response. Try again.");
				continue;
			}
		}
	}

	// displays the total number of coins for each customer in the array
	public static void DisplayCoinCounts(Change[] c) {
		int n = c.length;
		// loop through the customer list
		// and display relevant details
		for (int i = 0; i < n; i++) {
			System.out.printf("Total number of coins for %8s: %d\n", c[i].GetName(), c[i].GetSumOfCoins());
		}
	}

	// displays the change amount for each customer in the array (in dollars)
	public static void DisplayTotalChangeInDollars(Change[] c) {
		int n = c.length;
		// loop through the customer list
		// and display relevant details
		for (int i = 0; i < n; i++) {
			System.out.printf("Total change for %8s: %s\n", c[i].GetName(), c[i].GetTotalChangeInDollars());
		}
	}

	// loops through the customer array until
	// a matching name is found (both passed into the function)
	public static int GetCustomerIndexByName(Change[] c, String name) {
		int n = c.length;
		for (int i = 0; i < n; i++) {
			if (c[i].GetName().toLowerCase().equals(name)) {
				// return the index of the customer with the matching name
				return i;
			}
		}
		// if function reached this point, no matching name was found
		// display an error message and return -1
		System.out.printf("Name %s\nNot found\n", name);
		return -1;
	}

	// loops through customer array to find
	// the index of the customer with the largest change amount
	public static int GetCustomerIndexByLargestAmount(Change[] c) {
		int amount_buff = -9999;
		int index = -1;
		int n = c.length;
		for (int i = 0; i < n; i++) {
			if (c[i].GetChangeAmount() > amount_buff) {
				amount_buff = c[i].GetChangeAmount();
				index = i;
			}
		}
		// if function reached this point,
		// display an error message and return -1
		if (index == -1)
			System.out.println("Error finding largest amount.");
		return index;
	}

	// loops through customer array to find
	// the index of the customer with the lowest change amount
	public static int GetCustomerIndexByLowestAmount(Change[] c) {
		int amount_buff = 99999;
		int index = -1;
		int n = c.length;
		for (int i = 0; i < n; i++) {
			if (c[i].GetChangeAmount() < amount_buff) {
				amount_buff = c[i].GetChangeAmount();
				index = i;
			}
		}
		// if function reached this point,
		// display an error message and return -1
		if (index == -1)
			System.out.println("Error finding lowest amount.");
		return index;
	}

	// display all the customers in the list
	// *** for debugging purposes ***
	public static void ShowCustomers(Change[] c) {
		int n = c.length;
		for (int i = 0; i < n; i++) {
			System.out.printf("[%d]: %s, %d\n", i, c[i].GetName(), c[i].GetChangeAmount());
			//c[i].CalculateOptimalCoins();
			System.out.println(c[i].GetOptimalCoins());
		}
	}

	public static void StudentInfo() {
		System.out.printf("Author: David Long\nStudent ID: 1234567\nExternal Enrolment\nTutor: John Smith\n\n");
	}
	
	// *** hard coded example containing 12 customers ***
	public static void HardCodedExample() {
		System.out.println("***** hardcoded example running *****");
		
		// array containing 12 customers
		Change[] example_customers = new Change[12];
	
		// hardcoded examples
		example_customers[0] = 	new Change("john", 120);
		example_customers[1] = 	new Change("jAnE", 63);
		example_customers[2] = 	new Change("    mikey", 21);
		example_customers[3] = 	new Change();		
		example_customers[4] = 	new Change(" david", 77);
		example_customers[5] = 	new Change("joseph", 164);
		example_customers[6] = 	new Change("Muhammad           ", 20);
		example_customers[7] = 	new Change("annabelle", 99);
		example_customers[8] = 	new Change("liam ", 33);
		example_customers[9] =	new Change("   neel", 4);
		example_customers[10] = new Change("CHRIS", 2);
		example_customers[11] = new Change("jess", 199);
		
		// run the menu with these examples
		HandleMenu(new Scanner(System.in), example_customers);
		
		System.out.println("***** hardcoded example finished *****\n");
	}
}
