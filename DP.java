/************** Function to find the minimum number of coins to make the change for value using the coins of given denominations infinite supply of coins. *********/


    public long minimumNumberOfCoins(int arr[],int numberOfCoins,int value)
    {
        int dp[] = new int[value+1];
        for(int i=1;i<value+1;i++){
            dp[i] = Integer.MAX_VALUE;
        }
        for(int i=1;i<=value;i++){
            int res = Integer.MAX_VALUE;
            for(int j=0;j<numberOfCoins;j++){
                if(arr[j]<=i){
                    res = dp[i-arr[j]];
                    if(res!=Integer.MAX_VALUE){
                        dp[i] = Math.min(dp[i],res+1);
                    }
                }
            }
        }
        if(dp[value]!=Integer.MAX_VALUE)
        return dp[value];
        else return -1;
    }


/***************746. Min Cost Climbing Stairs *******************/

You are given an integer array cost where cost[i] is the cost of ith step on a staircase. Once you pay the cost, you can either climb one or two steps.

You can either start from the step with index 0, or the step with index 1.

Return the minimum cost to reach the top of the floor.

 

Example 1:

Input: cost = [10,15,20]
Output: 15
Explanation: Cheapest is: start on cost[1], pay that cost, and go to the top.



  public int minCostClimbingStairs(int[] cost) {
        
        int dp [] = new int[cost.length];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for(int i=2;i<cost.length;i++){
            
            dp[i] = cost[i]+Math.min(dp[i-1],dp[i-2]);
        }
        return Math.min(dp[cost.length-1],dp[cost.length-2]);
    }
	
	
	/***********************740. Delete and Earn*****************************/
	You are given an integer array nums. You want to maximize the number of points you get by performing the following operation any number of times:
	Pick any nums[i] and delete it to earn nums[i] points. Afterwards, you must delete every element equal to nums[i] - 1 and every element equal to nums[i] + 1.
	Return the maximum number of points you can earn by applying the above operation some number of times.
	
	public int deleteAndEarn(int[] nums) {
        int max=0 ;
        for(int i=0;i<nums.length;i++){
            max=Math.max(max,nums[i]);
        }
        int arr[] = new int[max+1];
        for(int i=0;i<nums.length;i++) arr[nums[i]]+=nums[i];
        
        for(int k=2;k<=max;k++){
            arr[k] = Math.max(arr[k]+arr[k-2],arr[k-1]);
        }
        return arr[max];
    }