package ict167_assignment1;

import java.util.Arrays;

public class Change {
	
	// private variables to hold the customer information
	private String person_name;
	private int change_amount;
	private int[] coins;
	
	// constructor with a name and change amount given
	public Change(String name, int change_amount) {
		// store the name with a capital letter (i.e. Jane)
		this.person_name = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
		
		// store the change amount (int)
		this.change_amount = change_amount;
		
		// initialize the array to hold 5 integers
		this.coins = new int[5];
		
		// since the change amount has been entered by the user,
		// it must be rounded
		this.RoundChange();
		
		// calculate the optimal coins ahead of time
		this.CalculateOptimalCoins();
	}
	
	// default constructor with no information given
	public Change() {
		this.person_name = "no-name";
		this.change_amount = 0;
		this.coins = new int[5];
	}
	
	// getters and setters for the 2 private variables
	
	public void   SetName(String name) { this.person_name = name;	}
	public String GetName() { return this.person_name; }
	
	public void SetChangeAmount(int changeAmount) { this.change_amount = changeAmount; }
	public int 	GetChangeAmount() { return this.change_amount; }
	
	// -------------------------- //
	
	// round the change to the nearest 5
	private void RoundChange() {
		// check if it is already a multiple of 5
		int r = this.change_amount % 5; // get the remainder
		// if it is a multiple of 5, return (no more work needed)
		if (r == 0) { return; }
		// if the remainder is 3 or more, add (5-r),
		// if it is under 3, minus the remainder
		this.change_amount += (r >= 3) ? (5-r) : -r;
	}
	
	// calculate the optimal coins, prioritizing higher coins
	private void CalculateOptimalCoins() {
		// copy the change amount into a editable value
		int a = this.change_amount;
		while (a > 0) {
			// if there is more than 100 cents in the cur total,
			// add 1 to the 100-cent-count
			// then minus 100 from the cur total,
			// then restart the loop
			
			// same will be done for each coin denomination
			
			if (a >= 100) {
				coins[0] += 1;
				a -= 100;
				continue;
			}
			if (a >= 50) {
				coins[1] += 1;
				a -= 50;
				continue;
			}
			if (a >= 25) {
				coins[2] += 1;
				a -= 25;
				continue;
			}
			if (a >= 10) {
				coins[3] += 1;
				a -= 10;
				continue;
			}
			if (a >= 5) {
				coins[4] += 1;
				a -= 5;
				continue;
			}
		}
		// *** debug purposes ***
		//System.out.println(Arrays.toString(this.coins));
	}
	
	// display the optimal coins which were previously calculated in CalculateOptimalCoins()
	public String GetOptimalCoins() {
		// display this customer's name and total cents

		// create and add to a string with the correct information,
		// this string will be returned
		String res = String.format("\nCustomer:\n%s %d cents\n\n", this.person_name, this.change_amount);
		res += "Change:\n";
		
		// iterate through the coin labels
		int n = this.coins.length;
		String[] coin_names = ("1 dollar:|50 cents:|25 cents:|10 cents:|5 cents:").split("\\|");
		for (int i = 0; i < n; i++) {
			// if the coin count for each coin label index is higher than zero,
			// add the label to the output string (which will be returned)
			if (this.coins[i] > 0) {
				res += String.format("%s %d\n", coin_names[i], this.coins[i]);
			}
		}
		return res;
	}
	
	// loop through the coin array and return the sum
	public int GetSumOfCoins() {
		int ret = 0;
		int n = coins.length;
		for (int i = 0; i < n; i++) {
			ret += coins[i];
		}
		return ret;
	}
	
	// format the total change amount in $x.yy (dollars & cents) format
	public String GetTotalChangeInDollars() {
		// a string will be built and returned, starting with "$"
		// create an editable copy of the change amount
		int buff = this.change_amount;
		
		// calculate the number of dollars found (100 cents)
		// divide the change amount by 100 (converting to int will floor the amount)
		
		int dollars = (int)(buff/100);
		buff -= dollars*100;	
		int cents = buff;	
		
		// if the remaining cents has 2 digits, add those digits to the
		// total amount string, if it has a single digit, add a zero in front of it first
		String ret = String.format("$%d.", dollars);
		ret += ((int)(cents/10) >= 1) ? cents : String.format("0%d", cents);
		return ret;
	}
}
