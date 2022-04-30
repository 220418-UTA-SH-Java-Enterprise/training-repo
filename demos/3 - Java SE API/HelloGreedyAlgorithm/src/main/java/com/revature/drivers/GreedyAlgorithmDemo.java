package com.revature.drivers;

/* What is a greedy algorithm?
 * - the process at which we build a solution piece by piece,
 * always choosing the next locally optimal option that offers 
 * the most obvious and immediate benefit to the overall outcome.
 * 
 * So why choose the greedy algorithm over others?
 * - Solutions to smaller instances of the problem can be more 
 * straightforward and easier to understand than the iterative
 * or brute force implementation to the solution.
 * - Typically have less time complexities
 * 
 * What are the drawback of greedy algorithms?
 * - Sometimes greedy algorithms fail to find the globally 
 * optimal solution because they do not consider all the data.
 * - Can get stuck in loops, possibly leading to the worst possible 
 * long-term outcome
 * 
 * So what would be a situation of where greedy first is best?
 * - In this example, we will simulate an island survival situation
 * where there is only one shop that is open 6 days out of the week.
 * (first day is Monday, making closing day Sunday)
 * 
 * You have X amount of amount of days to survive and must buy X units 
 * of food for each day. Overall, you need to find the minimum days on 
 * which you need to buy food from the shop so that you can survive the
 * next S days.
 * 
 * In this case, we have no choice but to be greedy for our gut's sake!
 * 
 * So will you survive and if so how many days do you have?
 */

public class GreedyAlgorithmDemo {

	//N – Maximum unit of food you can buy each day.
	//S – Number of days you are required to survive.
	//M – Unit of food required each day to survive.
	static void survive(int S, int N, int M) {
		// If we can not buy at least a week
        // supply of food during the first
        // week OR We can not buy a day supply
        // of food on the first day then we
        // can't survive.
        if (((N * 6) < (M * 7) && S > 6) || M > N)
            System.out.println("No, sorry");
 
        else {
 
            // If we can survive then we can
            // buy ceil(A/N) times where A is
            // total units of food required.
        	//ceil = rounding up to the next whole number
            int days = (M * S) / N;
 
            if (((M * S) % N) != 0)
                days++;
 
            System.out.println("Yes, for " + days + " day(s)");
        }
	}
	
	public static void main(String[] args) {
		int S = 10, N = 16, M = 2; //yes, 2
		//int S = 10, N = 20, M = 30; //no
		 
        survive(S, N, M);
	}

}
