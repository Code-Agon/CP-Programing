
10,18,21,37,40,41,82
done with day 13

56-completed
/**** sort 0's, 1's and 2's whith out extra space and 0(n) ***/

class Solution {
public:
    void sortColors(vector<int>& nums) {
       int lo = 0; 
        int hi = nums.size() - 1; 
        int mid = 0; 

        while (mid <= hi) { 
            switch (nums[mid]) { 

            // If the element is 0 
            case 0: 
                swap(nums[lo++], nums[mid++]); 
                break; 

            // If the element is 1 . 
            case 1: 
                mid++; 
                break; 

            // If the element is 2 
            case 2: 
                swap(nums[mid], nums[hi--]); 
                break; 
            }
        }
    }
};


/**
Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.

There is only one repeated number in nums, return this repeated number.

You must solve the problem without modifying the array nums and uses only constant extra space.
**/
we will represent the array as the graph like and we use tortoise method to find the slow and fast pointer and then
we will traves one by one tot find the repeated num

eg: index	0	1	2	3	4	5	6
	arr		2	6	4	1	3	1	5
	
	arr[0] = 2 –> arr[2] = 4 –> arr[4] = 3 –> arr[3] = 1 –> arr[1] = 6 –> arr[6] = 5 –> arr[5] = 1. 
 
				 6	
				/ |
	2->4->3->1->  |
				\ 5


class Solution {
    public int findDuplicate(int[] nums) {
        
        int slow = nums[0];
        int fast = nums[0];
        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while(slow!=fast);
        
        fast = nums[0];
        
        while(slow!=fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return fast;
    }
}


/***** Find the Missing and Repeating Number ************/

1) take an empty array and iterate over the given array and increase the index of occurance in the empty array by one, after that iterate over the array and check if index i is zero then it is the missing number and if index contains 2 then it is the repeated element.

2) sort
3 )

	static int x, y;
 
    static void getTwoElements(int arr[], int n)
    {
        /* Will hold xor of all elements and numbers from 1 to n  */
        int xor1;
 
        /* Will have only single set bit of xor1 */
        int set_bit_no;
 
        int i;
        x = 0;
        y = 0;
 
        xor1 = arr[0];
 
        /* Get the xor of all array elements  */
        for (i = 1; i < n; i++)
            xor1 = xor1 ^ arr[i];
 
        /* XOR the previous result with numbers from
       1 to n*/
        for (i = 1; i <= n; i++)
            xor1 = xor1 ^ i;
 
        /* Get the rightmost set bit in set_bit_no */
        set_bit_no = xor1 & ~(xor1 - 1);
 
        /* Now divide elements into two sets by comparing
    rightmost set bit of xor1 with the bit at the same
    position in each element. Also, get XORs of two
    sets. The two XORs are the output elements. The
    following two for loops serve the purpose */
        for (i = 0; i < n; i++) {
            if ((arr[i] & set_bit_no) != 0)
                /* arr[i] belongs to first set */
                x = x ^ arr[i];
 
            else
                /* arr[i] belongs to second set*/
                y = y ^ arr[i];
        }
        for (i = 1; i <= n; i++) {
            if ((i & set_bit_no) != 0)
                /* i belongs to first set */
                x = x ^ i;
 
            else
                /* i belongs to second set*/
                y = y ^ i;
        }
 
        /* *x and *y hold the desired output elements */
    }







/************ Merge two sorted arrays in O(1) space  ************/

1) Initialize i,j,k as 0,0,n-1 where n is size of arr1 
2) Iterate through every element of arr1 and arr2 using two pointers i and j respectively
    if arr1[i] is less than arr2[j]
        increment i
    else
        swap the arr2[j] and arr1[k]
        increment j and decrement k

3) Sort both arr1 and arr2 

// Function to merge two arrays
void merge(int arr1[], int arr2[], int n, int m)
{
    int i = 0, j = 0, k = n - 1;
   
    // Untill i less than equal to k
    // or j is less tha m
    while (i <= k && j < m) {
        if (arr1[i] < arr2[j])
            i++;
        else {
            swap(arr2[j++], arr1[k--]);
        }
    }
   
    // Sort first array
    sort(arr1, arr1 + n);
   
    // Sort second array
    sort(arr2, arr2 + m);
}




/***************** Maximum Subarray Sum also called as Kadane's Algorithm (find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.)*****************/

	public int maxSubArray(int[] nums) {
        
        int n=nums.length;
        int sum = 0 ,m = Integer.MIN_VALUE;

        for(int i =0;i<n;i++){

            sum+=nums[i];

            m = Math.max(m,sum);

            if(sum<0) sum = 0;     
           
            }

        return m;

        }
        


/******************  Merge Intervals  ***********************/
/*Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

 

Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].*/



  vector<vector<int>> merge(vector<vector<int>>& intervals) {
     
        vector<vector<int>> ans;
        sort(intervals.begin(),intervals.end());
        vector<int> temp = intervals[0];
        
        for(auto it: intervals){
            if(temp[1]>=it[0]){
                temp[1] = max(temp[1],it[1]);
            }else{
                ans.push_back(temp);
                temp=it;
            }
        }
        ans.push_back(temp);
        return ans;
    }
};





/*********** Pascals Triagle *******/


			  1
            1   1
           1  2  1
          1 3  3  1
         1 4  6  4  1

1)  if you want only r th row and c th coloumn value the it is 

	r-1
	   C
		c-1

ex: 5,3 = 4C2 





2) if we want entire row lets sat 4 o/p: 1 3 3 1

Then we know that 4c0= 1, 4c1 = 4*1/1 , 4c2 = 4*3/2*1,

we see that upper number is multiplying a lesser number and lower number is multiplying a incresed by 1 

for( int i= 0 ; i < k ;i++){
res *= (n-i);
res/= (i+1);
cout<<res<<" " <<; 
}

   vector<int> getRow(int rowIndex) {
        vector<int> ans;
        long res = 1;
        ans.push_back(res);
        for(int i=0;i<(rowIndex);i++){
            res*=(rowIndex-i);
            res/=(i+1);
            ans.push_back((int)res);
            
            
        }
         return ans;
	
		}


	         (OR)

        vector<int> ans(rowIndex+1,1);
    int small = rowIndex/2;
    long comb = 1;
    int j = 1;
    for (int i=rowIndex; i>=small; i--){
        comb *= i;
        comb /= j;
        j ++;
        ans[i-1] = (int)comb;
        ans[j-1] = (int)comb;
    }
    return ans;
    }




3) if we want entire pascals trialgle (N2)
 
 vector<vector<int>> generate(int numRows) {
        
        vector<vector<int>> res(numRows);
        for(int i=0;i<numRows;i++){
            res[i].resize(i+1);
            
            res[i][0] = res[i][i] = 1;
            
            for(int j=1 ; j<i;j++){
                res[i][j] = res[i-1][j-1] + res[i-1][j];
            }
            
        }
        return res;
        
    }

/**********************31. Next Permutation ************************/
Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such an arrangement is not possible, it must rearrange it as the lowest possible order (i.e., sorted in ascending order).

The replacement must be in place and use only constant extra memory.

 

Example 1:

Input: nums = [1,2,3]
Output: [1,3,2]



sol:


1) iterate from right and find index where arr[i] < arr[i+1]  let say ind1
2) iterate from right and find index where arr[i] > arr[ind1]  let say ind2
3) swap (arr[ind1],arr[ind2])
4) reverse fron ind1+1 ---> last


 public void nextPermutation(int[] nums) {
        
        int len = nums.length-1;
        
        int i =len-1;
        while(i>=0 && nums[i]>=nums[i+1]) i--;
        int j =len;
        if(i>=0){
            while(j>0 && nums[j]<=nums[i]){
                j--;
            }
            swap(nums,i,j);
        }
        j = len;
        i++;
        while( i<j){
            swap(nums,i++,j--);
        }
       
    }
    public void swap(int arr[],int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


/********************198. House Robber**************************/

Given an integer array nums representing the amount of money of each house, return the maximum sum such that you should not take adjaent numbers.

 

Example 1:

Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.


 public int rob(int[] nums) {
        
        int arr[] = new int[nums.length];
        if(nums.length==1) return nums[0];
        arr[0]= nums[0];
        arr[1] = Math.max(nums[0],nums[1]);
        
        for(int i=2;i<nums.length;i++){
            arr[i] = Math.max(arr[i-2]+nums[i],arr[i-1]);
        }
        
        return arr[nums.length-1];
        
        
    }

	/*********************** 268. Missing Number ***************************/
	Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.
	public int missingNumber(int[] nums) {
        int ans = 0;
        for(int i=0;i<nums.length;i++) ans+=nums[i];
        int  k = nums.length;
        int tot = k*(k+1)/2;    
         return tot-ans;
        
    }
 
 
 
 
 /*********************55. Jump Game***************************/
 You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.

Return true if you can reach the last index, or false otherwise.

 
 
  public boolean canJump(int[] nums) {
        int ans = 0;
        for(int i=0;i<nums.length-1;i++){
            ans = Math.max(ans,nums[i]);
            if(ans == 0 && i<nums.length){
                return false;
            }
            ans--;
        }
        return true;
        
    }
	
	
	
	
	
	
	/*****************45. Jump Game II******************/
	
	
	iven an array of non-negative integers nums, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

You can assume that you can always reach the last index.


 public int jump(int[] nums) {
        int cur = 0, prev = 0, count = 0;
        for(int i = 0; i < nums.length-1; ++i)
        {
			//find the current max step
            cur = Math.max(cur, i+nums[i]);
			//check if reach the top
            if(cur >= nums.length-1)
                return count+1;
			//if pass the previous step, then jump
            if(i == prev)
            {
                prev = cur;
                ++count;
            }
        }
        return count;
        
    }
	
	
	
	/*********************73. Set Matrix Zeroes**********************/
	Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's, and return the matrix.

	You must do it in place.
	
	  public void setZeroes(int[][] matrix) {
        int col0 = 0;
        int row = matrix.length;
        int col = matrix[0].length;
        for(int i=0;i<row;i++){
            if(matrix[i][0]==0) col0 = 1;
            for(int j=1;j<col;j++){
                    if(matrix[i][j] == 0 )
                        matrix[0][j] = matrix[i][0] = 0;
            }
        }
        for(int i = row-1;i>=0;i--){
            for(int j = col-1;j>=1;j--){
                if(matrix[i][0] == 0 || matrix[0][j]==0) matrix[i][j]= 0;
            }
            if(col0==1)  matrix[i][0] = 0; 
        }
        
    }
	
	
	
	/****************50. Pow(x, n)************************/
	Implement pow(x, n), which calculates x raised to the power n (i.e., xn).
	   public double myPow(double x, int n) {
        long nn=n;
        if(n<0) nn=-1*nn;
        double ans = 1.0;
        while(nn>0){
            if(nn%2==1){
                ans = ans*x;
                nn--;
            }else{
              x=x*x;
                nn=nn/2;
        }
            
        } 
        if(n<0){
            ans = (double)1.0/(double)ans;
        }
        return ans;
        
    }
	
	/************************48. Rotate Image**************************/
	You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).

	You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
	
	public void rotate(int[][] matrix) {
        
        int row =matrix.length;
        int col = matrix[0].length;
        for(int i=0;i<row;i++){
            for(int j=i;j<col;j++){
               int temp = matrix[i][j];
                matrix[i][j]=matrix[j][i] ;
                matrix[j][i] = temp;
            }
        }
        for(int i=0;i<row;i++){
            for(int j=0;j<(matrix[i].length/2);j++){
               int temp = matrix[i][j];
                matrix[i][j]=matrix[i][row-j-1] ;
                matrix[i][row-j-1] = temp;
            }
        }
        
    }

/*************************************Given a sorted array and a number x, find the pair in array whose sum is closest to x*************************************/
class CloseSum {
      
    // Prints the pair with sum closest to x
    static void printClosest(int arr[], int n, int x)
    {
        int res_l=0, res_r=0;  // To store indexes of result pair
   
        // Initialize left and right indexes and difference between
        // pair sum and x
        int l = 0, r = n-1, diff = Integer.MAX_VALUE;
   
        // While there are elements between l and r
        while (r > l)
        {
            // Check if this pair is closer than the closest pair so far
            if (Math.abs(arr[l] + arr[r] - x) < diff)
            {
               res_l = l;
               res_r = r;
               diff = Math.abs(arr[l] + arr[r] - x);
            }
   
            // If this pair has more sum, move to smaller values.
            if (arr[l] + arr[r] > x)
               r--;
            else // Move to larger values
               l++;
        }
   
    System.out.println(" The closest pair is "+arr[res_l]+" and "+ arr[res_r]);
}
	

/********************************Max sum in a matrix from (0,0)-(n,m)***********************************************/
You have to start from the top-left position and traverse all the way to the bottom-right position, collecting apples on your way. You can move only in right and downward direction,ie, from any cell (i,j) you can only move right: (i,j+1) or down: (i+1,j). Find the maximum number of apples you can collect.

public class Solution {
    static int check(int arr[][],int i,int j,int dp[][]){
        if(i<0 || j<0) return 0;
        if(i==0 && j==0) return arr[0][0];
        if(dp[i][j]!=0) return dp[i][j];
        if(i==0 && j>0){
            return dp[i][j] = arr[i][j]+check(arr,i,j-1,dp);
        }else if(i>0 && j==0){
            return dp[i][j] = arr[i][j]+check(arr,i-1,j,dp);
        }
        
        return dp[i][j]=arr[i][j] + Math.max(check(arr,i-1,j,dp),check(arr,i,j-1,dp));
    }
    public static void main(String[] args)throws Exception {
     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-->0){
            String str2[] = br.readLine().split(" ");
            int n = Integer.parseInt(str2[0]);
            int m = Integer.parseInt(str2[1]);
            int arr[][] = new int[n][m];
            
            for(int i=0;i<n;i++){
                String str[] = br.readLine().split(" ");
                for(int j=0;j<m;j++){
                    arr[i][j] = Integer.parseInt(str[j]);
                }
            }
            int dp[][] = new int[n+1][m+1];
            System.out.println(check(arr,n-1,m-1,dp));
        }
    }
}
	
	/**********************************Maximum Non-adjacent Subsequence Sum*************************************/
	public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int arr[] = new int[n];
            for(int i=0;i<n;i++) arr[i] = sc.nextInt();
            int dp[] = new int[n];
             dp[0] = arr[0];
            if(n>1){
            dp[1] = Math.max(arr[0],arr[1]);
            for(int i=2;i<n;i++){
                dp[i] = Math.max(dp[i-1],Math.max(dp[i-2]+arr[i],arr[i]));
            }
            }
            System.out.println(dp[n-1]);
        }
    }
}
	
	/***************************COUNT INVERSIONS in an ARRAY ****************************/
	two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j 
	
	public static void merger(int arr[],int l,int m,int r){
     
	int i, j, k; 
	int n1 = m - l + 1; 
	int n2 = r - m; 
	int L[]= new int[n1];
	int R[]= new int[n2]; 

	for (i = 0; i < n1; i++) 
		L[i] = arr[l + i]; 
	for (j = 0; j < n2; j++) 
		R[j] = arr[m + 1 + j]; 	
	i = 0; 
	j = 0; 
	k = l; 
	while (i < n1 && j < n2) { 
		if (L[i] <= R[j]) { 
			arr[k] = L[i]; 
			i++; 
		} 
		else { 
			arr[k] = R[j]; 
			j++;
			ans+=(m+1)-(l+i);
		} 
		k++; 
	} 

	
	while (i < n1) { 
		arr[k] = L[i]; 
		i++; 
		k++; 
	} 

	
	while (j < n2) { 
		arr[k] = R[j]; 
		j++; 
		k++; 
	} 
     }
     public static void mergersort(int arr[],int low,int hig){
         
         if(low<hig){
             int mid = (low+hig)/2;
             mergersort(arr,low,mid);
             mergersort(arr,mid+1,hig);
             merger(arr,low,mid,hig);
         }
         
         

     }
	 
	 
	 
	 
	 
	 
	 
/***************************121. Best Time to Buy and Sell Stock****************************************************/
You are given an array prices where prices[i] is the price of a given stock on the ith day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 public int maxProfit(int[] prices) {
        
        int maxpro = 0;
        int minPrice = Integer.MAX_VALUE;
        for(int i=0;i<prices.length;i++){
           minPrice = Math.min(minPrice,prices[i]);
            maxpro = Math.max(maxpro,prices[i]-minPrice);
        }
        return maxpro;
    }
	
	
	/*********************169. Majority Element*****************************/
	Given an array nums of size n, return the majority element.
	The majority element is the element that appears more than n / 2 times. You may assume that the majority element always exists in the array.

	better appaoach: nlogn
	 public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
	
	optimal: O(n)
	  public int majorityElement(int[] nums) {
        int majEle = 0,count = 0;
        for(int i=0;i<nums.length;i++){
            if(count==0){
                majEle = nums[i];
            }
            
            if(majEle == nums[i]){
                count++;
            }else {
                count--;
            }
        }
        return majEle;
        
    }
	
	/*************************229. Majority Element II using Boyer-Moore Majority Vote algorithm ******************************/
	
	Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.

	Follow-up: Could you solve the problem in linear time and in O(1) space?
	
	 public List<Integer> majorityElement(int[] nums) {
        
        int cur1 = 0, cur2 = 0, num1 = 0 ,num2=0;
        
        for(int i=0 ; i<nums.length;i++){
            if(num1 == nums[i]){
                cur1++;
            }
            else if(num2 == nums[i]){
                cur2++;
            }
            else if(cur1==0){
                num1 = nums[i];
                cur1 = 1;
            }
            else if(cur2 == 0){
                num2 = nums[i];
                cur2 = 1;
            }else{
                cur1--;
                cur2--;
            }
        }
        int ans1 = 0, ans2=0;
        for(int i=0 ; i<nums.length;i++){
            if(nums[i] == num1){
                ans1++;
            }
            else if(nums[i]==num2) ans2++;
        }
    
        List<Integer> list = new ArrayList<>();
        if((nums.length/3) < ans1) list.add(num1);
         if((nums.length/3) < ans2) list.add(num2);
        
        return list;
        
    }
	
	
	/*************************237. Delete Node in a Linked List*************************/
	
	 public void deleteNode(ListNode node) {
        
        if(node.next==null) node=null;
        else {
            node.val = node.next.val;
            node.next = node.next.next;
        }
        
    }
	
	/******************************876. Middle of the Linked List**************************/
	
	  public ListNode middleNode(ListNode head) {
        ListNode slow = head,fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast =fast.next.next;
        }
        return slow;
    
    }
	
	/************************141. Linked List Cycle*****************************/
	Given head, the head of a linked list, determine if the linked list has a cycle in it.
	
	   public boolean hasCycle(ListNode head) {
        
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast!=null && fast.next!=null){
           
            slow = slow.next;
            fast = fast.next.next;
             if(slow==fast) return true;
        }
        return false;
        
    }
	
	
	/***********************************160. Intersection of Two Linked Lists*****************************************/
	1) use hashmap
	
	2) get length of lista and length of listb find diff and move the list with higher length with diff and move each list one by one when they meet return node
	
	3) traverse list a and list b one by one, if a reaches null assign it to headb, do the same for the list b, then travese if they find a point both will stay at some point if intersection exists.	
	
	 public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        ListNode a = headA;
        ListNode b = headB;
        while(a!=b){
            a = a==null ? headB : a.next; 
            b = b==null ? headA : b.next; 
        }
        return a;
    }
	
	
	/**********************1. Two Sum*****************************/
	Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
	You may assume that each input would have exactly one solution, and you may not use the same element twice.

	
	 public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int result[] = new int[2];
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(target-nums[i])){
                result[0] = i;
                result[1] = map.get(target-nums[i]);
                return result;
            }
            map.put(nums[i],i);
        }
        return result;
        
        
    }
	
	
	/********************Largest subarray with 0 sum ****************************/
	Given an array having both positive and negative integers. The task is to compute the length of the largest subarray with sum 0.
	
	 int maxLen(int arr[], int n)
    {
        HashMap<Integer,Integer> map = new HashMap<>();
        int ans = 0,sum=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            if(sum==0) ans = i+1;
            else{
                if(map.containsKey(sum)){
                    ans = Math.max(ans,i-map.get(sum));
                }else{
                    map.put(sum,i);
                }
            }
        }
        return ans;
    }
	/***********************************Find the element that appears once in a sorted array in Log(n)*********************************/
public class Main {
    // A Binary Search based method to find the element
    // that appears only once
    public static void search(int[] arr, int low, int high)
    {
        if (low > high)
            return;
        if (low == high) {
            System.out.println("The required element is "
                               + arr[low]);
            return;
        }
 
        // Find the middle point
        int mid = (low + high) / 2;
 
        // If mid is even and element next to mid is
        // same as mid, then output element lies on
        // right side, else on left side
        if (mid % 2 == 0) {
            if (arr[mid] == arr[mid + 1])
                search(arr, mid + 2, high);
            else
                search(arr, low, mid);
        }
        // If mid is odd
        else if (mid % 2 == 1) {
            if (arr[mid] == arr[mid - 1])
                search(arr, mid + 1, high);
            else
                search(arr, low, mid - 1);
        }
    }
 
    // Driver Code
    public static void main(String[] args)
    {
        int[] arr = { 1, 1, 2, 4, 4, 5, 5, 6, 6 };
        search(arr, 0, arr.length - 1);
    }
}
	
	/*************************128. Longest Consecutive Sequence*************************/
	Given an unsorted array of integers nums, return the length of the longest consecutive  elements sequence.
	You must write an algorithm that runs in O(n) time.
	consecutive ex: 1 2 3 4 5 6.....
	
	 public int longestConsecutive(int[] nums) {
        
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<nums.length;i++) set.add(nums[i]);
        int count=0,ans=0;
        for(int i=0;i<nums.length;i++){
            if(!set.contains(nums[i]-1)){
                while(set.contains(nums[i]+count)==true){
                    count++;
                }
                ans=Math.max(ans,count);
                count=0;
            }
        }
        return ans;
    }
	
	/********************206. Reverse Linked List********************/
	Given the head of a singly linked list, reverse the list, and return the reversed list.
	public ListNode reverseList(ListNode head) {
        
        ListNode pre = null,cur = null;
        while(head!=null){
            cur = head;
            head = head.next;
            cur.next = pre;
            pre = cur;
            
        }
        return cur;
        
    }
	
	/*******************19. Remove Nth Node From End of List**********************/
	Given the head of a linked list, remove the nth node from the end of the list and return its head.
	
	  public ListNode removeNthFromEnd(ListNode head, int n) {
        
        ListNode start = new ListNode();
        start.next = head;
        ListNode slow  = start;
        ListNode fast = start;
        
        for(int i=0;i<n;i++) {
            fast = fast.next;
        }
        while(fast.next!=null){
            fast=fast.next;
            slow=slow.next;
        }
        if(slow.next==head) return head.next;
        
        slow.next = slow.next.next;
        
        return head;
        
    }
	
	
	/***************************485. Max Consecutive Ones******************************/
	Given a binary array nums, return the maximum number of consecutive 1's in the array.
	
	   public int findMaxConsecutiveOnes(int[] nums) {
        int ans = 0,max=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1) ans++;
            else ans =0;
            max = Math.max(ans,max);
        }
        return max;
        
    }
	
	
	/**********************21. Merge Two Sorted Lists**************************/
	
	Merge two sorted linked lists and return it as a sorted list. The list should be made by splicing together the nodes of the first two lists.
	
	 public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        
        if(l1==null) return l2;
        if(l2==null) return l1;
        
        if(l1.val>l2.val){
             ListNode temp = l1;
            l1=l2;
            l2=temp;
        }
        ListNode pre = l1 ,head=l1, curr = null;
        l1=l1.next;
        
        while(l1!=null && l2!=null){
            if(l1.val<l2.val){
                curr = l1;
                l1=l1.next;
                pre.next = curr;
                pre=curr;
                
            }else{
                 curr = l2;
                l2=l2.next;
                pre.next = curr;
                pre=curr;
            }
        }
        if(l1!=null){
            pre.next=l1;
        }
        if(l2!=null){
            pre.next=l2;
        }
        
        return head;
        
    }
	
	/**********************142. Linked List Cycle II******************************/
	
	public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode entry = head;
        
        while(fast!=null && fast.next!=null){
           
            slow = slow.next;
            fast = fast.next.next;
             if(slow==fast){
                 while(entry!=slow){
                     entry = entry.next;
                     slow=slow.next;
                 }
                 return slow;
             }
        }
         
        return null;
    }
	
	
	/************************* search in 2d matrix**************************/
	
// JAVA Code for Search in a row wise and
// column wise sorted matrix
 
    /* Searches the element x in mat[][]. If the
    element is found, then prints its position
    and returns true, otherwise prints "not found"
    and returns false */
    private static void search(int[][] mat,
                                    int n, int x)
    {
         
        // set indexes for top right
        int i = 0, j = n - 1;
        // element
 
        while (i < n && j >= 0)
        {
            if (mat[i][j] == x)
            {
                System.out.print("n Found at " +
                                    i + " " + j);
                return;
            }
            if (mat[i][j] > x)
                j--;
            else // if mat[i][j] < x
                i++;
        }
 
        System.out.print("n Element not found");
        return; // if ( i==n || j== -1 )
    }


		// leetcode sol
		ntegers in each row are sorted from left to right.
		The first integer of each row is greater than the last integer of the previous row.
		([[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3)
		
		public boolean searchMatrix(int[][] matrix, int target) {
        
        int row = matrix.length;
        int col = matrix[0].length;
        int len = row*col;
        int low = 0 , hig = len-1;
        while(low<=hig){
            int mid = (low+hig)/2;
            int i = mid/col;
            int j = mid%col;
            if(matrix[i][j]==target) return true;
            if(matrix[i][j]>target) hig=mid-1;
            else low=mid+1;
        }
        return false;
    }
	
	
	/***********************62. Unique Paths***********************/
	The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid 
	How many possible unique paths are there?
	
	1) n+m-2
	        C 
			 m-1
			 
	2)
	 public int uniquePaths(int m, int n) {
         int dp[][] = new int[m+1][n+1];
        return path(m,n,1,1,dp);
    }
    public int path(int m,int n,int i,int j,int[][] dp){
        if(i==m && n==j) return 1;
        if(i>m || j>n) return 0;
        if(dp[i][j]!=0) return dp[i][j];
        dp[i][j] = path(m,n,i,j+1,dp)+path(m,n,i+1,j,dp);
        return dp[i][j];
    }
	
	/********************Count the number of subarrays having a given XOR ************************/
	
	 // Returns count of subarrays of arr with XOR
    // value equals to m
    static long subarrayXor(int arr[], int n, int m)
    {
        long ans = 0; // Initialize answer to be returned
 
        // Create a prefix xor-sum array such that
        // xorArr[i] has value equal to XOR
        // of all elements in arr[0 ..... i]
        int[] xorArr = new int[n];
 
        // Create map that stores number of prefix array
        // elements corresponding to a XOR value
        HashMap<Integer, Integer> mp
            = new HashMap<Integer, Integer>();
 
        // Initialize first element of prefix array
        xorArr[0] = arr[0];
 
        // Computing the prefix array.
        for (int i = 1; i < n; i++)
            xorArr[i] = xorArr[i - 1] ^ arr[i];
 
        // Calculate the answer
        for (int i = 0; i < n; i++) {
            // Find XOR of current prefix with m.
            int tmp = m ^ xorArr[i];
 
            // If above XOR exists in map, then there
            // is another previous prefix with same
            // XOR, i.e., there is a subarray ending
            // at i with XOR equal to m.
            ans = ans
                  + (mp.containsKey(tmp) == false
                         ? 0
                         : ((long)mp.get(tmp)));
 
            // If this subarray has XOR equal to m itself.
            if (xorArr[i] == m)
                ans++;
 
            // Add the XOR of this subarray to the map
            if (mp.containsKey(xorArr[i]))
                mp.put(xorArr[i], mp.get(xorArr[i]) + 1);
            else
                mp.put(xorArr[i], 1);
        }
 
        // Return total count of subarrays having XOR of
        // elements as given value m
        return ans;
    }
	
	/***********************3. Longest Substring Without Repeating Characters********************/
	
	public int lengthOfLongestSubstring(String s) {
        int left = 0,len=0;
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i))){
                left = Math.max(map.get(s.charAt(i))+1,left);
            }
            map.put(s.charAt(i),i);
            len = Math.max(len,i-left+1);
        }
        return len;
    }
	
	/**********************2. Add Two Numbers*********************/
	You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
	You may assume the two numbers do not contain any leading zero, except the number 0 itself.
	
	
	 public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dum = new ListNode();
        ListNode t = dum;
        int sum = 0;
        int carry = 0;
        while(l1!=null || l2!=null || carry==1){
            if(l1!=null){
                sum+=l1.val;
                l1=l1.next;
            }
            if(l2!=null){
                sum+=l2.val;
                l2=l2.next;
            }
            sum+=carry;
            carry = sum/10;
            ListNode temp = new ListNode(sum%10);
            sum=0;
            dum.next=temp;
            dum=dum.next;
        }
        return t.next;
    }
	
	
	/*************************N meetings in one room *****************************************/
	Given starting and ending time of a meeting, find the max number of meeting that can happen in the one room
	
	
	class meeting {
    int start;
    int end;
    int pos;
     
    meeting(int start, int end, int pos)
    {
        this.start = start;
        this.end = end;
        this.pos = pos;
    }
}
class meetingComparator implements Comparator<meeting>
{
    @Override
    public int compare(meeting o1, meeting o2) 
    {
        if (o1.end < o2.end)
            return -1;
        else if (o1.end > o2.end)
            return 1;
        else if(o1.pos < o2.pos)
            return -1;
        return 1; 
    }
}
class Meeting {
    static void maxMeetings(int start[], int end[], int n) {
        ArrayList<meeting> meet = new ArrayList<>();
        
        for(int i = 0; i < start.length; i++)
            meet.add(new meeting(start[i], end[i], i+1));
        
        meetingComparator mc = new meetingComparator(); 
        Collections.sort(meet, mc); 
        ArrayList<Integer> answer = new ArrayList<>();
        answer.add(meet.get(0).pos);
        int limit = meet.get(0).end; 
        
        for(int i = 1;i<start.length;i++) {
            if(meet.get(i).start > limit) {
                limit = meet.get(i).end; 
                answer.add(meet.get(i).pos);
            }
        }
        
        for(int i = 0;i<answer.size(); i++) {
            System.out.print(answer.get(i) + " ");
        }
    }
}

/*********************25. Reverse Nodes in k-Group**************************/

Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.
You may not alter the values in the list's nodes, only nodes themselves may be changed.

 public ListNode reverseKGroup(ListNode head, int k) {
        
        if(head == null || k==1) return head;
        
        ListNode tempHead = head;
        int totalNoedes =0 ;
        while(tempHead!=null){
            tempHead=tempHead.next;
            totalNoedes++;
        }
        
        int tot = totalNoedes/k;
        
        ListNode head1 = new ListNode();
        ListNode temp = head1;
        while(head!=null && tot>0){
            int g = k;
            ListNode prev = null, curr = null, head2=head;
            while(g>0 && head!=null){
                curr = head;
                head = head.next;
                curr.next = prev;
                prev = curr;
                g--;
            }
            tot--;
            head1.next = prev;
            while(head1.next!=null){
                head1=head1.next;
            }
        }
        head1.next= head;
        return temp.next;
        
    }
	
	/********************234. Palindrome Linked List**********************/
	Given the head of a singly linked list, return true if it is a palindrome.
	Could you do it in O(n) time and O(1) space?
	
	public ListNode reverseList(ListNode head) {
        
        ListNode pre = null,cur = null;
        while(head!=null){
            cur = head;
            head = head.next;
            cur.next = pre;
            pre = cur;
            
        }
        return cur;
        
    }
    public boolean isPalindrome(ListNode head) {
        if( head==null || head.next==null) return true;
        
        ListNode slow= head,fast= head, temp=head;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        
        slow.next=reverseList(slow.next);
        slow= slow.next;
        while(slow!=null){
            if(temp.val!=slow.val) return false;
            temp=temp.next;
            slow=slow.next;
        }
        return true;
    }
	
	/**********************61. Rotate List*************************/
	Given the head of a linked list, rotate the list to the right by k places.
	Input: head = [1,2,3,4,5], k = 2
	Output: [4,5,1,2,3]

	public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null || k==0) return head;
        
        ListNode curr = head;
        int totnodes = 1;
        while(curr.next!=null){
            curr=curr.next;
            totnodes++;
        }
        curr.next=head;
        k=k%totnodes;
        k=totnodes-k;
        while(k>0){
          curr = curr.next;
            k--;
        } 
        
        head = curr.next;
        curr.next=null;
        
        return head;
    }
	
	/**********************************138. Copy List with Random Pointer*********************************/
	
	    public Node copyRandomList(Node head) {
        
        Node curr = head;
        Node front = head;
        while(curr!=null){
            front = curr.next;
            Node copy = new Node(curr.val);
            copy.next = front;
            curr.next = copy;
            curr = front;
        }
        
        Node temp = new Node(-1);
        temp.next = head;
        Node temp2 = temp;
        curr = head;
        while(curr!=null){
            if(curr.random!=null){
                curr.next.random = curr.random.next; 
            }
             curr = curr.next.next;
        }
        
        
        curr = head;
        front  = head;
        while(curr!=null){
            front  = curr.next.next;
            temp2.next=curr.next;
            curr.next=front;
            temp2=temp2.next;
            curr = front;
        }
        return temp.next;
    }
	
	
	
	
	
	
	/*************************Stack using Arrays***********************/
	
	class MyStack
	{
		int top;
		int arr[] = new int[1000];

		MyStack()
		{
			top = -1;
		}
	
	//Function to push an integer into the stack.
		void push(int a)
		{
			arr[++top] = a;
		}	 
	
    //Function to remove an item from top of the stack.
		int pop()
		{
			if(top==-1) return -1;
			return  arr[top--];
        // Your code here
		}
	}
	
	/************************Queue using Arrays***************************/
	
	class Queue {
    private static int front, rear, capacity,count;
    private static int queue[];
 
    Queue(int c)
    {
        front = rear = 0;
        capacity = c;
		count=0;
		
        queue = new int[capacity];
    }
 
    void queueEnqueue(int data)
    {
       if(count == capacity) return ;
	   
	   queue[rear%capacity] = data;
	   rear++;
	   count++;
    }

    static void queueDequeue()
    {
       if(count == 0) return;
	   queue[front%capacity] = -1;
	   front++;
	   count--;
    }
 
    static void queueDisplay()
    {
        int i;
        if (front == rear) {
            System.out.printf("\nQueue is Empty\n");
            return;
        }
 
        
        for (i = front; i < rear; i++) {
            System.out.printf(" %d <-- ", queue[i]);
        }
        return;
    }
 
    static void queueFront()
    {
        if (front == rear) {
           
            return;
        }
        System.out.printf("\nFront Element is: %d", queue[front]);
        return;
    }
}


	/******************implement stack using queue*******************/

	1) using 2 queues
	
	push():
		add x in q2;
		add all the element of q1 - >q2
		add all the elements of q2 - >q1;
		
	pop():
	
		remote top of q1;
	
	2) using single queue
	
		push(x){
			q.push(x);
			for(int i=0;i<q.size()-1;i++){
				q.push(q.top());
				q.pop();
			}
		}
		pop(){
			q.pop();
		}
		
		top(){
			q.top()
		}
		
		
	/**********************implement queue using stack**********************/
	
	push(x){
		input.push(x);
		
	}
	
	pop(){
		if(output!=empty) output.pop();
		
		else{
			while(input.empty == false){
				output.push(input.top);
				input.top();
			}
			output.pop();
		}
	}
	
	top(){
		
		if(output.empty!=false){
			
			return output.top();
		}
		else{
			while(input.empty == false){
				output.push(input.top);
				input.top();
			}
			output.top();
		}
			
	}
	/**************************************42. Trapping Rain Water**********************************************/
1) the main intention is we can get the water at index i the min(leftMax(i),rightMax(i))-arr[i]; 
for finding leftmax and right max it will take 0(N) for every index total complexity is N square

2) to reduce leftmax and rightmax we will store the prefix max and suffix max and we apply the formula but space is 2N

3)we will use two pointers to solve this space problem take low and hig, 

class Solution {
    public int trap(int[] arr) {
        int low = 0,hig=arr.length-1,leftmax =0,rightmax=0,res=0;
        while(low<hig){
            if(arr[low]<=arr[hig]){ // at this point we will get there is a wall size greater than arr[low]
				//but the left max is less than the current arr[low] so we can't fill water here 
                if(arr[low]>leftmax) leftmax = arr[low];
                else{
					// but here we know that there is a wall which is greater at left and right then we will calculate the water as res and it will follow for else case also
                    res+= leftmax-arr[low];
                }
                low++;
            }else{
                if(arr[hig]>rightmax) rightmax = arr[hig];
                else{
                    res+= rightmax-arr[hig];
                }
                hig--;
                
            }
        }
        return res;
        
    }
}

/********************************************largestRectangleArea in a historgram***********************************************/
class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length; 
        Stack<Integer> st = new Stack<>();
        int leftSmall[] = new int[n]; 
        int rightSmall[] = new int[n]; 
        for(int i = 0;i<n;i++) {
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop(); 
            }
            
            if(st.isEmpty()) leftSmall[i] = 0; 
            else leftSmall[i] = st.peek() + 1; 
            st.push(i); 
        }
        
        // clear the stack to be re-used
        while(!st.isEmpty()) st.pop(); 
        
        for(int i = n-1;i>=0;i--) {
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop(); 
            }
            
            if(st.isEmpty()) rightSmall[i] = n-1; 
            else rightSmall[i] = st.peek() - 1;
            
            st.push(i); 
        }
        
        int maxA = 0; 
        for(int i = 0;i<n;i++) {
            maxA = Math.max(maxA, heights[i] * (rightSmall[i] - leftSmall[i] + 1));
        }
        return maxA; 
        
    }
}
/*********************************maxSlidingWindow*********************************************/


class Solution {
    public int[] maxSlidingWindow(int[] a, int k) {
        int n = a.length;
		int[] r = new int[n-k+1];
		int ri = 0;
		// store index
		Deque<Integer> q = new ArrayDeque<>();
		for (int i = 0; i < a.length; i++) {
			// remove numbers out of range k
			if (!q.isEmpty() && q.peek() == i - k) {
				q.poll();
			}
			// remove smaller numbers in k range as they are useless
			while (!q.isEmpty() && a[q.peekLast()] < a[i]) {
				q.pollLast();
			}
            
			q.offer(i);
			if (i >= k - 1) {
				r[ri++] = a[q.peek()];
			}
		}
		return r;
    }
}

/*****************************994. Rotting Oranges**********************************/
ou are given an m x n grid where each cell can have one of three values:

0 representing an empty cell,
1 representing a fresh orange, or
2 representing a rotten orange.
Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1
class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int count_fresh = 0;
        //Put the position of all rotten oranges in queue
        //count the number of fresh oranges
        for(int i = 0 ; i < rows ; i++) {
            for(int j = 0 ; j < cols ; j++) {
                if(grid[i][j] == 2) {
                    queue.offer(new int[]{i , j});
                }
                if(grid[i][j] != 0) {
                    count_fresh++;
                }
            }
        }
       
        if(count_fresh == 0) return 0;
        int countMin = 0, cnt = 0;
        int dx[] = {0, 0, 1, -1};
        int dy[] = {1, -1, 0, 0};
        
        //bfs starting from initially rotten oranges
        while(!queue.isEmpty()) {
            int size = queue.size();
            cnt += size; 
            for(int i = 0 ; i < size ; i++) {
                int[] point = queue.poll();
                for(int j = 0;j<4;j++) {
                    int x = point[0] + dx[j];
                    int y = point[1] + dy[j];
                    
                    if(x < 0 || y < 0 || x >= rows || y >= cols || grid[x][y] == 0 || grid[x][y] == 2) continue;
                    
                    grid[x][y] = 2;
                    queue.offer(new int[]{x , y});
                }
            }
            if(queue.size() != 0) {
                countMin++;
            }
        }
        return count_fresh == cnt ? countMin : -1;
    }
}
/***********************************************LRU(Last recently used)**************************************************/
class LRUCache {  
  Node head = new Node(0, 0), tail = new Node(0, 0);
  Map<Integer, Node> map = new HashMap();
  int capacity;
  
  public LRUCache(int _capacity) {
    capacity = _capacity;
    head.next = tail;
    tail.prev = head;
  }

  public int get(int key) {
    if(map.containsKey(key)) {
      Node node = map.get(key);
      remove(node);
      insert(node);
      return node.value;
    } else {
      return -1;
    }
  }

  public void put(int key, int value) {
    if(map.containsKey(key)) {
      remove(map.get(key));
    }
    if(map.size() == capacity) {
      remove(tail.prev);
    }
    insert(new Node(key, value));
  }
  
  private void remove(Node node) {
    map.remove(node.key);
    node.prev.next = node.next;
    node.next.prev = node.prev;
  }
  
  private void insert(Node node){
    map.put(node.key, node);
    node.next = head.next;
    node.next.prev = node;
    head.next = node;
    node.prev = head;
  }
  
  class Node{
    Node prev, next;
    int key, value;
    Node(int _key, int _value) {
      key = _key;
      value = _value;
    }
  }
}

/**************************************Last frequently used*****************************************/
class LFUCache {

    final int capacity;
    int curSize;
    int minFrequency;
    Map<Integer, DLLNode> cache;
    Map<Integer, DoubleLinkedList> frequencyMap;

    /*.*/
    /*
    * @param capacity: total capacity of LFU Cache
    * @param curSize: current size of LFU cache
    * @param minFrequency: frequency of the last linked list (the minimum frequency of entire LFU cache)
    * @param cache: a hash map that has key to Node mapping, which used for storing all nodes by their keys
    * @param frequencyMap: a hash map that has key to linked list mapping, which used for storing all
    * double linked list by their frequencies
    * */
    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.curSize = 0;
        this.minFrequency = 0;

        this.cache = new HashMap<>();
        this.frequencyMap = new HashMap<>();
    }

    /*
    * @param key: node key
    * @param val: node value
    * @param frequency: frequency count of current node
    * (all nodes connected in same double linked list has same frequency)
    * @param prev: previous pointer of current node
    * @param next: next pointer of current node
    * */
    class DLLNode {
        int key;
        int val;
        int frequency;
        DLLNode prev;
        DLLNode next;

        public DLLNode(int key, int val) {
            this.key = key;
            this.val = val;
            this.frequency = 1;
        }
    }

    /*
    * @param listSize: current size of double linked list
    * @param head: head node of double linked list
    * @param tail: tail node of double linked list
    * */
    class DoubleLinkedList {
        int listSize;
        DLLNode head;
        DLLNode tail;
        public DoubleLinkedList() {
            this.listSize = 0;
            this.head = new DLLNode(0, 0);
            this.tail = new DLLNode(0, 0);
            head.next = tail;
            tail.prev = head;
        }

        /** add new node into head of list and increase list size by 1 **/
        public void addNode(DLLNode curNode) {
            DLLNode nextNode = head.next;
            curNode.next = nextNode;
            curNode.prev = head;
            head.next = curNode;
            nextNode.prev = curNode;
            listSize++;
        }

        /** remove input node and decrease list size by 1**/
        public void removeNode(DLLNode curNode) {
            DLLNode prevNode = curNode.prev;
            DLLNode nextNode = curNode.next;
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
            listSize--;
        }

    }

    /** get node value by key, and then update node frequency as well as relocate that node **/
    public int get(int key) {
        DLLNode curNode = cache.get(key);
        if (curNode == null) {
            return -1;
        }
        updateNode(curNode);
        return curNode.val;
    }

    /**
     * add new node into LFU cache, as well as double linked list
     * condition 1: if LFU cache has input key, update node value and node position in list
     * condition 2: if LFU cache does NOT have input key
     *  - sub condition 1: if LFU cache does NOT have enough space, remove the Least Recent Used node
     *  in minimum frequency list, then add new node
     *  - sub condition 2: if LFU cache has enough space, add new node directly
     * **/
    public void put(int key, int value) {
        // corner case: check cache capacity initialization
        if (capacity == 0) {
            return;
        }

        if (cache.containsKey(key)) {
            DLLNode curNode = cache.get(key);
            curNode.val = value;
            updateNode(curNode);
        }
        else {
            curSize++;
            if (curSize > capacity) {
                // get minimum frequency list
                DoubleLinkedList minFreqList = frequencyMap.get(minFrequency);
                cache.remove(minFreqList.tail.prev.key);
                minFreqList.removeNode(minFreqList.tail.prev);
                curSize--;
            }
            // reset min frequency to 1 because of adding new node
            minFrequency = 1;
            DLLNode newNode = new DLLNode(key, value);

            // get the list with frequency 1, and then add new node into the list, as well as into LFU cache
            DoubleLinkedList curList = frequencyMap.getOrDefault(1, new DoubleLinkedList());
            curList.addNode(newNode);
            frequencyMap.put(1, curList);
            cache.put(key, newNode);
        }
    }

    public void updateNode(DLLNode curNode) {
        int curFreq = curNode.frequency;
        DoubleLinkedList curList = frequencyMap.get(curFreq);
        curList.removeNode(curNode);

        // if current list the the last list which has lowest frequency and current node is the only node in that list
        // we need to remove the entire list and then increase min frequency value by 1
        if (curFreq == minFrequency && curList.listSize == 0) {
            minFrequency++;
        }

        curNode.frequency++;
        // add current node to another list has current frequency + 1,
        // if we do not have the list with this frequency, initialize it
        DoubleLinkedList newList = frequencyMap.getOrDefault(curNode.frequency, new DoubleLinkedList());
        newList.addNode(curNode);
        frequencyMap.put(curNode.frequency, newList);
    }

}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */


	/**********************************26. Remove Duplicates from Sorted Array********************************/
	
	Input: nums = [0,0,1,1,1,2,2,3,3,4]
Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
	
	class Solution {
    public int removeDuplicates(int[] nums) {
        
        if(nums.length==0) return 0;
        int i=0;
        
        for(int j=1;j<nums.length;j++){
            if(nums[i]!=nums[j]){
                i++;
                nums[i]=nums[j];
            }
        }
        return i+1;
        
    }
}

	/*********************************20. Valid Parentheses********************************/
	  public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(' || s.charAt(i)=='{' || s.charAt(i)=='['){
                stack.push(s.charAt(i));
            } else{
                if(stack.size()> 0){
                    if((s.charAt(i)==')' && stack.peek()=='(') || (s.charAt(i)=='}' && stack.peek()=='{' ) || (s.charAt(i)==']' && stack.peek()=='[')){
                        stack.pop();
                        
                    }else{
                        return false;
                    }
                }
                else{
                    return false;
                }
            }
        }
        if(stack.size()==0){
            return true;
        }
        return false;
        
    }
	
	/*****************************503. Next Greater Element II*******************************/
	
	if array is not circullar
		use stack
	1) iterate from last element to start ele
	2) if stack is empty then it is -1
	3) if(sstack is not emty and stack.top() > ith ele)
			print stack.top()
			stack.push(ele)
		else
			while(stack.top()<=ele && stack is not emty) {
					stack.pop();
			}
			if(stack is empty){
				return -1;
			}
			else{
				return stack.top();
			}
			
			stack.push(ele);
			
	if array is circular
	
	public int[] nextGreaterElements(int[] nums) {
     int n = nums.length; 
        int nge[] = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i = 2*n-1;i>=0;i--) {
            while(st.isEmpty() == false && st.peek() <= nums[i%n]) {
                st.pop(); 
            }
            
            if(i<n) {
                if(st.isEmpty() == false) nge[i] = st.peek(); 
                else nge[i] = -1; 
            }
            
            st.push(nums[i%n]);
        }
        return nge; 
    }
	
	
	
	/************************ Next Smaller Element  **************************/
	
	 public int[] finalPrices(int[] prices) {
        Stack<Integer> stack = new Stack<>();
        int ans[] = new int[prices.length];
        for(int i=prices.length-1;i>=0;i--){
            
            if(stack.size()==0){
                ans[i] = prices[i];
           }else{
                
                while(stack.size()>0 && stack.peek()>prices[i]){
                    stack.pop();
                  
                }
                if(stack.size()==0){
                    ans[i] = prices[i];
                }else{
                    ans[i] = prices[i]-stack.peek();
                }   
            }
            stack.push(prices[i]);
        }
        return ans;
        
    }
		
	/********************************N meetings in one room************************************/

class Solution 
{
    //Function to find the maximum number of meetings that can
    //be performed in a meeting room.
    public static int maxMeetings(int start[], int end[], int n)
    {
        ArrayList<meet> list = new ArrayList<>();
        for(int i=0;i<n;i++) {
            meet m = new meet(start[i],end[i],i);
            list.add(m);
        }
        Collections.sort(list,new meetsort());
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(list.get(0).pos);
        int limit  = list.get(0).end;
        for(int i=1;i<n;i++){
            if( list.get(i).start > limit){
                 ans.add(list.get(i).pos);
                  limit  = list.get(i).end;
            }
        }
        return ans.size();
        
    }
}
class meetsort implements Comparator<meet>{
    
    public int compare(meet a, meet b)
    {
		//sort in assending order 
        if(a.end<b.end) return -1;
        else if(a.end>b.end) return 1;
        else {
            if(a.pos<b.pos) return -1;
        }
        return 1;
     }
}
class meet{
    int start;
    int end;
    int pos;
    meet(int start,int end,int pos){
        this.start=start;
        this.end =end;
        this.pos = pos;
    }
}


/***********************Minimum Platforms*************************************/

Given arrival and departure times of all trains that reach a railway station. Find the minimum number of platforms required for the railway station so that no train is kept waiting.
Consider that all the trains arrive on the same day and leave on the same day. Arrival and departure time can never be the same for a train but we can have arrival time of one train equal to departure time of the other. At any given instance of time, same platform can not be used for both departure of a train and arrival of another train. In such cases, we need different platforms.

class Solution
{
    //Function to find the minimum number of platforms required at the
    //railway station such that no train waits.
    static int findPlatform(int arr[], int dep[], int n)
    {
        Arrays.sort(arr);
        Arrays.sort(dep);
        
        int  i = 0,j=0,res=0,platforms_need = 0;
        
        while(i<n && j<n){
            if(arr[i]<=dep[j]){
                platforms_need++;
                i++;
            }else {
                platforms_need--;
                j++;
            }
            res = Math.max(res,platforms_need);
        }
        
        return res;
    }
    
    
}

/**************************************Job Sequencing Problem ******************************/
Given a set of N jobs where each jobi has a deadline and profit associated with it. Each job takes 1 unit of time to complete and only one job can be scheduled at a time. We earn the profit if and only if the job is completed by its deadline. The task is to find the number of jobs done and the maximum profit.

Note: Jobs will be given in the form (Jobid, Deadline, Profit) associated with that Job.

class Solution
{
    //Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n)
    {
        Arrays.sort(arr,(a,b)->(b.profit-a.profit));
        int maxi =0;
        for(int i=0;i<n;i++){
            maxi = Math.max(arr[i].deadline,maxi);
        }
        int result[] = new int[maxi+1];
        int totProfit=0, noOfJobsDone = 0;
        for(int i=0;i<n;i++){
            for(int j=arr[i].deadline;j>=1;j--){
                if(result[j] == 0){
                    totProfit+=arr[i].profit;
                    result[j]=-1;
                    noOfJobsDone++;
                    break;
                }
            }
        }
        int ans [] =new int[2];
        ans[0] = noOfJobsDone;
        ans[1] = totProfit;
        return ans;
    }
}

/************************Fractional Knapsack | Greedy Algorithms*****************************/

class itemComparator implements Comparator<Item>
{
    @Override
    public int compare(Item a, Item b) 
    {
        double r1 = (double)(a.value) / (double)(a.weight); 
        double r2 = (double)(b.value) / (double)(b.weight); 
        if(r1 < r2) return 1; 
        else if(r1 > r2) return -1; 
        else return 0; 
    }
}
class solve{
    double fractionalKnapsack(int W, Item arr[], int n) {
        Arrays.sort(arr, new itemComparator()); 
        
        int curWeight = 0; 
        double finalvalue = 0.0; 
        
        for (int i = 0; i < n; i++) {
       
            if (curWeight + arr[i].weight <= W) {
                curWeight += arr[i].weight;
                finalvalue += arr[i].value;
            }
     
            else {
                int remain = W - curWeight;
                finalvalue += ((double)arr[i].value / (double)arr[i].weight) * (double)remain;
                break;
            }
        }
     
        return finalvalue;
        
    }

}


/*****************************Greedy Algorithm to find Minimum number of Coins*********************************/
Given a value V, if we want to make a change for V Rs, and we have an infinite supply of each of the denominations in Indian currency, i.e., we have an infinite supply of { 1, 2, 5, 10, 20, 50, 100, 500, 1000} valued coins/notes, what is the minimum number of coins and/or notes needed to make the change?

    // All denominations of Indian Currency 
    static int deno[] = {1, 2, 5, 10, 20, 
    50, 100, 500, 1000};
    static int n = deno.length;
  
    static void findMin(int V)
    {
    
        Vector<Integer> ans = new Vector<>();
		
        for (int i = n - 1; i >= 0; i--)
        { 
            while (V >= deno[i]) 
            {
                V -= deno[i];
                ans.add(deno[i]);
            }
        }
  
        // Print result 
        for (int i = 0; i < ans.size(); i++)
        {
            System.out.print(
                " " + ans.elementAt(i));
        }
    }
	
	/***********************************Subset Sums ************************************/
	Given a list arr of N integers, print sums of all subsets in it.

	Input:
		N = 2
		arr[] = {2, 3}
	Output:
		0 2 3 5

	
	class Solution{
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N){
        ArrayList<Integer> list =  new ArrayList<>();
        
        subsetSums(arr,N,list,0,0);
        return list;
    }
    
    void subsetSums(ArrayList<Integer> arr, int N,ArrayList<Integer> subarr,int ind,int sum){
            
            if(ind==N){
                subarr.add(sum);
                return ;
            }
            
            // pick ele
            subsetSums(arr,N,subarr,ind+1,sum+arr.get(ind));
            //don't pick 
            subsetSums(arr,N,subarr,ind+1,sum);
            
    }
}

/*************************************90. Subsets II*******************************************/
Given an integer array nums that may contain duplicates, return all possible subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        subsetWitOutDup(nums,list,0,new ArrayList());
        return list;
    }
    public void subsetWitOutDup(int[] nums,List<List<Integer>> list,int ind,List<Integer> res){
        list.add(new ArrayList<>(res));
        for(int i=ind;i<nums.length;i++){
            
            if(i!=ind && nums[i]==nums[i-1]) {continue;}
            res.add(nums[i]);
            subsetWitOutDup(nums,list,i+1,res);
            res.remove(res.size()-1);
        }
    }
}

/*********************************39. Combination Sum***************************/
Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.

The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.

It is guaranteed that the number of unique combinations that sum up to target is less than 150 combinations for the given input.


class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
         List<List<Integer>> res = new ArrayList<>();
        getCombinationSum(candidates,target,res,0,new ArrayList<>());
        return res;
    }
    public void getCombinationSum(int[] candidates, int target,List<List<Integer>> res,int ind,List<Integer> ans){
        if(ind==candidates.length){
            if(target==0){
                res.add(new ArrayList<>(ans));
            }
            return;
        }
        if(candidates[ind]<=target){
            ans.add(candidates[ind]);
            getCombinationSum(candidates,target-candidates[ind],res,ind,ans);
            ans.remove(ans.size()-1);
        }
        getCombinationSum(candidates,target,res,ind+1,ans);
    }
}

/********************************************$0. Combination Sum II***************************************/

Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.

Each number in candidates may only be used once in the combination.

Note: The solution set must not contain duplicate combinations.

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
         Arrays.sort(candidates);
        List<List<Integer>> list = new ArrayList<>();
        findCombinations(candidates,list,0,target,new ArrayList());
        return list;
    }
    
   public void findCombinations(int[] candidates,List<List<Integer>> list,int ind, int target,List<Integer> ans) {
        if(target==0){
            list.add(new ArrayList<>(ans));
        }
       
        for(int i=ind;i<candidates.length;i++){
            if(i!=ind && candidates[i]==candidates[i-1]) continue;
             if(candidates[i]>target) break;
            ans.add(candidates[i]);
            findCombinations(candidates,list,i+1,target-candidates[i],ans);
            ans.remove(ans.size()-1);
        }
         
    }
}

/******************************************131. Palindrome Partitioning********************************************/
Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of s.
A palindrome string is a string that reads the same backward as forward
Input: s = "aab"
Output: [["a","a","b"],["aa","b"]]

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> list = new ArrayList<>();
        
        findPart(s,0,list,new ArrayList<>());
        return list;
        
    }
    
    void findPart(String s,int ind,List<List<String>> list,List<String> res){
        
        if(s.length()==ind){
            list.add(new ArrayList<>(res));
        }
        for(int i=ind;i<s.length();i++){
            if(isPalindeome(s,ind,i)){
                res.add(s.substring(ind,i+1));
                findPart(s,i+1,list,res);
                res.remove(res.size()-1);
            }
        }
    }
    boolean isPalindeome(String str,int start,int end){
        while(start<end){
            if(str.charAt(start++)!=str.charAt(end--)) return false;
        }
        return true;
    }
}


/********************************************60. Permutation Sequence***********************************************/
The set [1, 2, 3, ..., n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order, we get the following sequence for n = 3:

"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.
Input: n = 3, k = 3
Output: "213"

class Solution {
    public String getPermutation(int n, int k) {
       int fact = 1;
        List<Integer> list = new ArrayList<>();
        
        for(int i=1;i<n;i++){
            list.add(i);
            fact = fact*i;
        }
        list.add(n);
        k--;
        String ans = "";
        while(true){
            ans+=list.get(k/fact);
            list.remove(k/fact);
            if(list.size()==0) break;
            
            k=k%fact;
            fact=fact/list.size();
        }
        return ans;
    }
}

/***********************************46. Permutations**************************************/
Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>>  list= new ArrayList<>();
         permute(nums,list,new ArrayList<>(),-1);
        return list;
    }
    void permute(int[] nums,List<List<Integer>> list,List<Integer> res,int ind){
        
        if(res.size()==nums.length){
            list.add(new ArrayList<>(res));
        }
        
        for(int i=0;i<nums.length;i++){
            if(res.contains(nums[i])) continue;
            res.add(nums[i]);
            permute(nums,list,res,i);
            res.remove(res.size()-1);
        }
    }
}


/***********************Program to find whether a given number is power of 2***********************/

	static boolean isPowerOfTwo (int x)
    {
        return x!=0 && ((x&(x-1)) == 0);
         
    }
	/******************************count set bits in an integer**************************/
	   public static int countSetBits(int n)
    {
        // `count` stores the total bits set in `n`
        int count = 0;
 
        while (n != 0)
        {
            n = n & (n - 1);    // clear the least significant bit set
            count++;
        }
 
        return count;
    }
 
 /***********************************************************/
 
 class GFG
{
public static long divide(long dividend,
                        long divisor)
{
 
// Calculate sign of divisor i.e., sign will be negative only iff either one of them is negative otherwise it will be positive
long sign = ((dividend < 0) ^
            (divisor < 0)) ? -1 : 1;
 
// remove sign of operands
dividend = Math.abs(dividend);
divisor = Math.abs(divisor);
 
// Initialize the quotient
long quotient = 0, temp = 0;
 
// test down from the highest bit and accumulate the tentative value for valid bit 1<<31 behaves incorrectly and gives Integer Min Value which should not be the case, instead  1L<<31 works correctly.
for (int i = 31; i >= 0; --i)
{
 
    if (temp + (divisor << i) <= dividend)
    {
        temp += divisor << i;
        quotient |= 1L << i;
    }
}
 
//if the sign value computed earlier is -1 then negate the value of quotient
if(sign==-1)
  quotient=-quotient;
return quotient;
}

/******************************Power Set *****************************/
Given a string S find all possible subsequences of the string in lexicographically-sorted order.
Input : str = "abc"
Output: a ab abc ac b bc c

	public: vector<string> AllPossibleStrings(string s){
		    // Code here
	vector<string> v;
    int n=s.length();
    for(int i=0;i<(1<<n);i++)
    {
        string res="";
        for(int j=0;j<n;j++)
        {
            if( ( i&(1<<j) ) )
            {
                res+=s[j];
            }
        }
        if(res!="")
        {
            v.push_back(res);
        }
    }
   sort(v.begin(),v.end());
   return v;
}

/********************msb  of a number***********************/
	int k = (int)(Math.log(n) / Math.log(2));
 
        // To return the the value of the number
        // with set bit at k-th position
     return 1 << k;
		
/*****************************Calculate square of a number without using *, / and pow()**************************/
If n is even, it can be written as
  n = 2*x 
  n2 = (2*x)2 = 4*x2
If n is odd, it can be written as 
  n = 2*x + 1
  n2 = (2*x + 1)2 = 4*x2 + 4*x + 1

static int square(int n)
    {
 
        // Base case
        if (n == 0)
            return 0;
 
        // Handle negative number
        if (n < 0)
            n = -n;
 
        // Get floor(n/2) using
        // right shift
        int x = n >> 1;
 
        // If n is odd
        ;
        if (n % 2 != 0)
            return ((square(x) << 2) + (x << 2) + 1);
        else // If n is even
            return (square(x) << 2);
    }
 
 
 /*********************types of binary trees**************************/
 
 1) full binary tree: either has 0 or 2 childredn
 2) complete : all levels are completely filled except the last
			   The last node level has all the nodes as left as possible
 3) perfect : all the leaf nodes are at same level
 4) Balanced: height can me max of log(n)base2 n is no of nodes 
 5) Degenerate : evert node has only one child(stright line)
 
 /************************************************/
 (DFS)
 precheck condition
 if(root==null)  return
 preOrder : (root left right)
 
 class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        
        List<Integer> list = new ArrayList<>();
        if(root==null) return list;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(stack.size()>0){
            TreeNode curr = stack.pop();;
            if(curr.right!=null) stack.push(curr.right);
            if(curr.left!=null) stack.push(curr.left);
            list.add(curr.val);      
           
        }
        return list;
    }
}
 
 postOrder: (left right root)
 using 2 stack:
 class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root==null) return list;
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack.push(root);
        while(stack.size()>0){
            TreeNode curr = stack.pop();;
            stack2.push(curr);
           
            if(curr.left!=null) stack.push(curr.left);
             if(curr.right!=null) stack.push(curr.right);
           
        }
        while(stack2.size()>0) list.add(stack2.pop().val);
        return list;
    
    }
 }

using 1 stack:
class Solution {

    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> st1 = new Stack<TreeNode>(); 
        List<Integer> postOrder = new ArrayList<Integer>();
        
        if(root == null) return postOrder; 
        
        TreeNode current = root;  
        while(current != null || !st1.isEmpty()) {
            if(current != null){
                st1.push(current);
                current = current.left;
            }else{
                TreeNode temp = st1.peek().right;
                if (temp == null) {
                    temp = st1.pop();
                    postOrder.add(temp.val);
                    while (!st1.isEmpty() && temp == st1.peek().right) {
                        temp = st1.pop();
                        postOrder.add(temp.val);
                    }
                } else {
                    current = temp;
                }
            }
        }
      
        return postOrder; 
    }
}
 
 Inorder: (left root right)

 class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while(true){
           if(node!=null){
               stack.push(node);
               node = node.left;
           }else{
               if(stack.isEmpty()){
                   break;
               }
               node = stack.pop();
               list.add(node.val);
               node = node.right;
           }
        }
        return list; 
    }
}

 pre, post and in order using one program
class Pair {
    TreeNode node; 
    int num; 
    Pair(TreeNode _node, int _num) {
        num = _num; 
        node = _node; 
    }
}
class Solution {

    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<Pair> st = new Stack<Pair>(); 
        st.push(new Pair(root, 1)); 
        List<Integer> pre = new ArrayList<>();
        List<Integer> in = new ArrayList<>();
        List<Integer> post = new ArrayList<>();
        if(root == null) return post;

        while(!st.isEmpty()) {
            Pair it = st.pop(); 

            // this is part of pre
            // increment 1 to 2 
            // push the left side of the tree
            if(it.num == 1) {
                pre.add(it.node.val); 
                it.num++; 
                st.push(it); 
                
                if(it.node.left != null) {
                    st.push(new Pair(it.node.left, 1)); 
                }
            }

            // this is a part of in 
            // increment 2 to 3 
            // push right 
            else if(it.num == 2) {
                in.add(it.node.val); 
                it.num++; 
                st.push(it); 

                if(it.node.right != null) {
                    st.push(new Pair(it.node.right, 1)); 
                }
            }
            // don't push it back again 
            else {
                post.add(it.node.val); 
            }
        } 

        return post; 

    }
}
 
 (BFS)
 
 levelOrder: 
 
 Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
 Input: root = [3,9,20,null,null,15,7]
Output: [[3],[9,20],[15,7]]

 class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> list = new ArrayList<>();
        
        if(root==null) return list;
        
        queue.add(root);
        
        while(queue.size()>0){
            int size = queue.size();
            List<Integer> ans = new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode curr = queue.poll();
                ans.add(curr.val);
                if(curr.left!=null) queue.add(curr.left);
                 if(curr.right!=null) queue.add(curr.right);
                
            }
            list.add(ans);
        }
        return list;     
    }
}



/********************************104. Maximum Depth of Binary Tree**************************/
Given the root of a binary tree, return its maximum depth. vv Imp

A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

iterative:
return levelorder list.size();

recursive(preferred):

   public int maxDepth(TreeNode root) {
        
        if(root==null) return 0;
        
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
        
    }
	
/*******************************Check for Balanced Binary Tree****************************/
Given a binary tree, determine if it is height-balanced.

for every node heightofleftNode - heightOfRightNode <= 1

class Solution {
    public boolean isBalanced(TreeNode root) {
        if(maxDepth(root)==-1) return false;
        return true;
    }
     public int maxDepth(TreeNode root) {
        
        if(root==null) return 0;
        int left = maxDepth(root.left);
         if(left==-1) return -1;
         int right = maxDepth(root.right);
         if(right==-1) return -1;
         if(Math.abs(left-right)>1) return -1;
        return 1 + Math.max(left,right);
        
    }
}

/**********************543. Diameter of Binary Tree*******************************/

Given the root of a binary tree, return the length of the diameter of the tree.

The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.


class Solution {
     public int maxDepth(TreeNode root,int[] max) {
        
        if(root==null) return 0;
        int left = maxDepth(root.left,max);
       
         int right = maxDepth(root.right,max);

        max[0] = Math.max(max[0],left+right);
        return 1 + Math.max(left,right);
        
    }
    public int diameterOfBinaryTree(TreeNode root) {
        int max[] = new int[1];
         maxDepth(root,max);
        return max[0];
    }
}

/********************************124. Binary Tree Maximum Path Sum*********************************/
A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them. A node can only appear in the sequence at most once. Note that the path does not need to pass through the root.

The path sum of a path is the sum of the node's values in the path.

class Solution {
      public int maxDepth(TreeNode root,int[] max) {
        
        if(root==null) return 0;
        int left = Math.max(0,maxDepth(root.left,max));
       
        int right = Math.max(0,maxDepth(root.right,max));

        max[0] = Math.max(max[0],left+right+root.val);
        return root.val + Math.max(left,right);
        
    }
 
    public int maxPathSum(TreeNode root) {
         int max[] = new int[1];
         max[0] = Integer.MIN_VALUE;
         maxDepth(root,max);
        return max[0];
    }
}
	
 	/*********************100. Same Tree ********************/
	  public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null) return true;
        if( (p==null || q==null)  || p.val != q.val) return false;
        else{
            return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
        }
        
    }
	
	/****************************103. Binary Tree Zigzag Level Order Traversal****************************/
	Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. (i.e., from left to right, then right to left for the next level and alternate between).

	class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root==null) return list;
        
        boolean lefttoright =false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while(queue.size()>0){
            int size = queue.size();
            List<Integer> ans = new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode curr = queue.poll();
                ans.add(curr.val);
                if(curr.left!=null) queue.add(curr.left);
                 if(curr.right!=null) queue.add(curr.right);
                
            }
            if(lefttoright){
                List<Integer> ans2 = new ArrayList<>();
                for(int i=ans.size()-1;i>=0;i--) ans2.add(ans.get(i));
                list.add(ans2);
            }else
            list.add(ans);
            lefttoright = !lefttoright;
            
        } 
        return list;
    }
}



/***********************************_boundaryTraversalJava***************************************/
to print (only boundaries)all the boundrys of the tree

class Solution
{
    Boolean isLeaf(Node root) {
        return (root.left == null) && (root.right == null);
    }
    
    void addLeftBoundary(Node root, ArrayList<Integer> res) {
        Node cur = root.left;
        while (cur != null) {
            if (isLeaf(cur) == false) res.add(cur.data);
            if (cur.left != null) cur = cur.left;
            else cur = cur.right;
        }
    }
    void addRightBoundary(Node root, ArrayList<Integer> res) {
        Node cur = root.right;
        ArrayList<Integer> tmp = new ArrayList<Integer>();
        while (cur != null) {
            if (isLeaf(cur) == false) tmp.add(cur.data);
            if (cur.right != null) cur = cur.right;
            else cur = cur.left;
        }
        int i;
        for (i = tmp.size()-1; i >= 0; --i) {
            res.add(tmp.get(i));
        }
    }
    
    void addLeaves(Node root, ArrayList<Integer> res) {
        if (isLeaf(root)) {
            res.add(root.data);
            return;
        }
        if (root.left != null) addLeaves(root.left, res);
        if (root.right != null) addLeaves(root.right, res);
    }
	ArrayList <Integer> printBoundary(Node node)
	{
	    ArrayList<Integer> ans = new ArrayList<Integer>(); 
	    if(isLeaf(node) == false) ans.add(node.data); 
	    addLeftBoundary(node, ans);

		// inorder traversal
	    addLeaves(node, ans); 
	    addRightBoundary(node, ans); 
	    return ans;
	}
}

/*****************************************verticalTraversal*************************************/

class Tuple {
    TreeNode node; 
    int row;
    int col; 
    public Tuple(TreeNode _node, int _row, int _col) {
        node = _node; 
        row = _row; 
        col = _col; 
    }
}
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>(); 
        Queue<Tuple> q = new LinkedList<Tuple>();
        q.offer(new Tuple(root, 0, 0)); 
        while(!q.isEmpty()) {
            Tuple tuple = q.poll(); 
            TreeNode node = tuple.node; 
            int x = tuple.row; 
            int y = tuple.col; 
            
            
            if (!map.containsKey(x)) {
                map.put(x, new TreeMap<>());
            }
            if (!map.get(x).containsKey(y)) {
                map.get(x).put(y, new PriorityQueue<>());
            }
            map.get(x).get(y).offer(node.val);
            
            if(node.left != null) {
                q.offer(new Tuple(node.left, x - 1, y + 1)); 
            } 
            if(node.right != null) {
                q.offer(new Tuple(node.right, x + 1, y + 1)); 
            }
        }
        List<List<Integer>> list = new ArrayList<>();
        for (TreeMap<Integer, PriorityQueue<Integer>> ys : map.values()) {
            list.add(new ArrayList<>());
            for (PriorityQueue<Integer> nodes : ys.values()) {
                while (!nodes.isEmpty()) {
                    list.get(list.size() - 1).add(nodes.poll());
                }
            }
        }
        return list;
    }
}



/*******************************TopView******************************/

class Pair(){
	Node node;
	int hd;
	
	Pair(Node node, int hd`){
		this.node = node;
		this.hd = hd;
	}
}
class Solution
{
    //Function to return a list of nodes visible from the top view 
    //from left to right in Binary Tree.
    static ArrayList<Integer> topView(Node root)
    {
        ArrayList<Integer> ans = new ArrayList<>(); 
        if(root == null) return ans;
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(root, 0)); 
        while(!q.isEmpty()) {
            Pair it = q.remove();
            int hd = it.hd; 
            Node temp = it.node; 
            if(map.get(hd) == null) map.put(hd, temp.data); 
            if(temp.left != null) {
                
                q.add(new Pair(temp.left, hd - 1)); 
            }
            if(temp.right != null) {
                
                q.add(new Pair(temp.right, hd + 1)); 
            }
        }
    
        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            ans.add(entry.getValue()); 
        }
        return ans; 
        
    }
}

/**********************************bottomView*******************************/
class Solution
{
    //Function to return a list containing the bottom view of the given tree.
    public ArrayList <Integer> bottomView(Node root)
    {
        ArrayList<Integer> ans = new ArrayList<>(); 
        if(root == null) return ans;
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Node> q = new LinkedList<Node>();
        root.hd = 0;
        q.add(root); 
        while(!q.isEmpty()) {
            Node temp = q.remove();
            int hd = temp.hd; 
            map.put(hd, temp.data); 
            if(temp.left != null) {
                temp.left.hd = hd - 1; 
                q.add(temp.left); 
            }
            if(temp.right != null) {
                temp.right.hd = hd + 1; 
                q.add(temp.right); 
            }
        }
        
        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            ans.add(entry.getValue()); 
        }
        return ans; 
        
    }
}


/********************************rightSideView of bst**********************************/

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
       List<Integer> list =  new ArrayList<>();
        rightSide(root,0,list);
        return list;
    }
    void rightSide(TreeNode root,int lev,List<Integer> list){
        if(root==null) return;
        if(lev==list.size()) list.add(root.val);
        rightSide(root.right,lev+1,list);
        rightSide(root.left,lev+1,list);      
    }
}

/*********************************left view of bst********************************/

class Tree
{
    //Function to return list containing elements of left view of binary tree.
    ArrayList<Integer> leftView(Node root)
    {
      // Your code here
      ArrayList<Integer> list =  new ArrayList<>();
        leftSide(root,0,list);
        return list;
    }
      void leftSide(Node root,int lev,List<Integer> list){
        if(root==null) return;
        if(lev==list.size()) list.add(root.data);
       
        leftSide(root.left,lev+1,list); 
         leftSide(root.right,lev+1,list);
    }
}

/********************************101. Symmetric Tree***************************************/
Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).

class Solution {
    public boolean isSymmetric(TreeNode root) {
        return isSame(root.right,root.left);
    }
    boolean isSame(TreeNode left, TreeNode right){
        if(left==null && right==null) return true;
        
        if(left==null || right==null|| left.val!=right.val) return false;
        return isSame(left.right,right.left) && isSame(left.left,right.right);
        
        
    }
}

/***************************Path to Given Node*********************************/
Given a Binary Tree A containing N nodes.

You need to find the path from Root to a given node B.
public class Solution {
    private boolean getPath(TreeNode root, ArrayList<Integer> arr, int x) {
        if(root == null) {
            return false; 
        }
        arr.add(root.val);
        if(root.val == x) {
            return true; 
        }

        if(getPath(root.left, arr, x) || getPath(root.right, arr, x)) {
            return true; 
        }

        arr.remove(arr.size() - 1); 
        return false; 
    }
    public ArrayList<Integer> solve(TreeNode A, int B) {
        ArrayList<Integer> arr = new ArrayList<>(); 
        if(A == null) return arr; 
        getPath(A, arr, B); 
        return arr; 
    }
}

/***********************************236. Lowest Common Ancestor of a Binary Tree********************************/

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        if(root==null || root==q || root==p) return root;
        
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        
        if(left==null) return right;
        else if(right==null) return left;
        else return root;
        
    }
	
	/*******************************662. Maximum Width of Binary Tree******************************************/
	length between any two nodes
	
	class Pair {
    TreeNode node; 
    int num; 
    Pair(TreeNode _node, int _num) {
        num = _num;
        node = _node; 
    }
}
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        int ans = 0;
        Queue<Pair> q = new LinkedList<>(); 
        q.offer(new Pair(root, 0)); 
        while(!q.isEmpty()){
            int size = q.size();
            int mmin = q.peek().num;    //to make the id starting from zero
            int first = 0,last = 0;
            for(int i=0; i<size; i++){
                int cur_id = q.peek().num-mmin;
                TreeNode node = q.peek().node;
                q.poll();
                if(i==0) first = cur_id;
                if(i==size-1) last = cur_id;
                if(node.left != null)
                    q.offer(new Pair(node.left, cur_id*2+1));
                if(node.right != null) 
                    q.offer(new Pair(node.right, cur_id*2+2));
            }
            ans = Math.max(ans, last-first+1);
        }
        return ans;
    }
}

/********************************L29. Children Sum Property in Binary Tree*************************/
for every node value should be sum of node.left and node.right , u can only increase the value 
public class Solution {
    public static void changeTree(BinaryTreeNode < Integer > root) {
        if(root == null) return; 
        int child = 0;
        if(root.left != null) {
            child += root.left.data; 
        }
        if(root.right != null) {
            child += root.right.data; 
        }

        if(child >= root.data) root.data = child; 
        else {
            if(root.left != null) root.left.data = root.data; 
            else if(root.right != null) root.right.data = root.data; 
        }

        changeTree(root.left); 
        changeTree(root.right); 

        int tot = 0; 
        if(root.left != null) tot += root.left.data; 
        if(root.right != null) tot+= root.right.data; 
        if(root.left != null || root.right != null) root.data = tot;  
    }
}

/*********************************L30. Print all the Nodes at a distance of K in Binary Tree******************************/
it can be parent or child nodes from that nodes

class Solution {
    private void markParents(TreeNode root, Map<TreeNode, TreeNode> parent_track, TreeNode target) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()) { 
            TreeNode current = queue.poll(); 
            if(current.left != null) {
                parent_track.put(current.left, current);
                queue.offer(current.left);
            }
            if(current.right != null) {
                parent_track.put(current.right, current);
                queue.offer(current.right);
            }
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> parent_track = new HashMap<>();
        markParents(root, parent_track, root); 
        Map<TreeNode, Boolean> visited = new HashMap<>(); 
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(target);
        visited.put(target, true);
        int curr_level = 0;
        while(!queue.isEmpty()) { /*Second BFS to go upto K level from target node and using our hashtable info*/
            int size = queue.size();
            if(curr_level == k) break;
            curr_level++;
            for(int i=0; i<size; i++) {
                TreeNode current = queue.poll(); 
                if(current.left != null && visited.get(current.left) == null) {
                    queue.offer(current.left);
                    visited.put(current.left, true);
                }
                if(current.right != null && visited.get(current.right) == null ) {
                    queue.offer(current.right);
                    visited.put(current.right, true);
                }
                if(parent_track.get(current) != null && visited.get(parent_track.get(current)) == null) {
                    queue.offer(parent_track.get(current));
                    visited.put(parent_track.get(current), true);
                }
            }
        }
        List<Integer> result = new ArrayList<>(); 
        while(!queue.isEmpty()) {
            TreeNode current = queue.poll(); 
            result.add(current.val);
        }
        return result;
    }
}

/**********************************Time To Burn Tree*****************/
You have been given a binary tree of 'N' unique nodes and a Start node from where the tree will start to burn. Given that the Start node will always exist in the tree, your task is to print the time (in minutes) that it will take to burn the whole tree.
It is given that it takes 1 minute for the fire to travel from the burning node to its adjacent node and burn down the adjacent node.
import java.util.HashMap;
import java.util.*;
public class Solution
{
    private static BinaryTreeNode<Integer> bfsToMapParents(BinaryTreeNode<Integer> root,
                                                       HashMap<BinaryTreeNode<Integer>, BinaryTreeNode<Integer>> mpp, int start) {
        Queue<BinaryTreeNode<Integer>> q = new LinkedList<>();
        q.offer(root);
        BinaryTreeNode<Integer> res = new BinaryTreeNode<>(-1);
        while(!q.isEmpty()) {
            BinaryTreeNode<Integer> node = q.poll();
            if(node.data == start) res = node;
            if(node.left != null) {
                mpp.put(node.left, node);
                q.offer(node.left);
            }
            if(node.right != null) {
                mpp.put(node.right, node);
                q.offer(node.right);
            }
        }
        return res;
    }
    private static int findMaxDistance(HashMap<BinaryTreeNode<Integer>, BinaryTreeNode<Integer>> mpp, BinaryTreeNode<Integer> target) {
        Queue<BinaryTreeNode<Integer>> q = new LinkedList<>();
        q.offer(target);
        HashMap<BinaryTreeNode<Integer>,Integer> vis = new HashMap<>();
        vis.put(target, 1);
        int maxi = 0;
        
        while(!q.isEmpty()) {
            int sz = q.size();
            int fl = 0;
            
            for(int i = 0;i<sz;i++) {
                BinaryTreeNode<Integer> node = q.poll();
                if(node.left != null && vis.get(node.left) == null) {
                    fl = 1;
                    vis.put(node.left, 1);
                    q.offer(node.left);
                }
                if(node.right != null && vis.get(node.right) == null) {
                    fl = 1;
                    vis.put(node.right, 1);
                    q.offer(node.right);
                }

                if(mpp.get(node) != null && vis.get(mpp.get(node)) == null) {
                    fl = 1;
                    vis.put(mpp.get(node), 1);
                    q.offer(mpp.get(node));
                }
            }
            if(fl == 1) maxi++;
        }
        return maxi;
    }
    public static int timeToBurnTree(BinaryTreeNode<Integer> root, int start)
    {
        HashMap<BinaryTreeNode<Integer>, BinaryTreeNode<Integer>> mpp = new HashMap<>();
        BinaryTreeNode<Integer> target = bfsToMapParents(root, mpp, start);
        int maxi = findMaxDistance(mpp, target);
        return maxi;
    }
}

/*****************************L32. Count total Nodes in a COMPLETE Binary Tree | O(Log^2 N) *******************************/

class Solution {
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        
        int left = getHeightLeft(root);
        int right = getHeightRight(root);
        
        //If left and right are equal it means that the tree is complete and hence go for 2^h -1.
        if(left == right) return ((2<<(left)) -1);
            
        //else recursively calculate the number of nodes in left and right and add 1 for root.
        else return countNodes(root.left)+ countNodes(root.right)+1;
    }
    
    
    public int getHeightLeft(TreeNode root){
        int count=0;
        while(root.left!=null){
            count++;
            root = root.left;
        }
        return count;
    }
    
    
    public int getHeightRight(TreeNode root){
        int count=0;
        while(root.right!=null){
            count++;
            root = root.right;
        }
        return count;
    }
}

/******************************************Construct a Binary Tree from Preorder and Inorder Traversal***************************************************/

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inMap = new HashMap<Integer, Integer>();

        for(int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }

        TreeNode root = buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inMap);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> inMap) {
        if(preStart > preEnd || inStart > inEnd) return null;

        TreeNode root = new TreeNode(preorder[preStart]);
        int inRoot = inMap.get(root.val);
        int numsLeft = inRoot - inStart;

        root.left = buildTree(preorder, preStart + 1, preStart + numsLeft, inorder, inStart, inRoot - 1, inMap);
        root.right = buildTree(preorder, preStart + numsLeft + 1, preEnd, inorder, inRoot + 1, inEnd, inMap);

        return root;
    }
}

/***********************************Construct the Binary Tree from Postorder and Inorder Traversal ***************************************/

class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length != postorder.length)
            return null;
        HashMap<Integer, Integer> hm = new HashMap<Integer,Integer>();
        for (int i=0;i<inorder.length;++i)
            hm.put(inorder[i], i);
        return buildTreePostIn(inorder, 0, inorder.length-1, postorder, 0, 
                              postorder.length-1,hm);
    }

    private TreeNode buildTreePostIn(int[] inorder, int is, int ie, int[] postorder, int ps, int pe, 
                                     HashMap<Integer,Integer> hm){
        if (ps>pe || is>ie) return null;
        TreeNode root = new TreeNode(postorder[pe]);
        int ri = hm.get(postorder[pe]);
        TreeNode leftchild = buildTreePostIn(inorder, is, ri-1, postorder, ps, ps+ri-is-1, hm);
        TreeNode rightchild = buildTreePostIn(inorder,ri+1, ie, postorder, ps+ri-is, pe-1, hm);
        root.left = leftchild;
        root.right = rightchild;
        return root;
    }
}

/***************************297. Serialize and Deserialize Binary Tree*************************************/
Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.

public class Codec {
    public String serialize(TreeNode root) {
        if (root == null) return "";
        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder res = new StringBuilder();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node == null) {
                res.append("n ");
                continue;
            }
            res.append(node.val + " ");
            q.add(node.left);
            q.add(node.right);
        }
        return res.toString();
    }

    public TreeNode deserialize(String data) {
        if (data == "") return null;
        Queue<TreeNode> q = new LinkedList<>();
        String[] values = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        q.add(root);
        for (int i = 1; i < values.length; i++) {
            TreeNode parent = q.poll();
            if (!values[i].equals("n")) {
                TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                parent.left = left;
                q.add(left);
            }
            if (!values[++i].equals("n")) {
                TreeNode right = new TreeNode(Integer.parseInt(values[i]));
                parent.right = right;
                q.add(right);
            }
        }
        return root;
    }
}
/***************************searchBST**********************/

public TreeNode searchBST(TreeNode root, int val) {
        while(root != null && root.val != val){
            root = val<root.val? root.left:root.right;
        }
        return root;
    }
	
/*************************Ceil in a Binary Search Tree***************************/
val should be >=val
public class Solution {

    public  static int findCeil(TreeNode<Integer> root, int key) {

        int ceil = -1; 
        while (root != null) {
            if (root.data == key) {
                ceil = root.data;
                return ceil;
            }

            if (key > root.data) {
                root = root.right;
            }
            else {
                ceil = root.data; 
                root = root.left;
            }
        }
        return ceil;

    }
}

/******************************************************************/

/*************************floor in a Binary Search Tree***************************/
val should be <=val
public class Solution {

    public  static int findCeil(TreeNode<Integer> root, int key) {

        int floor = -1; 
        while (root != null) {
            if (root.data == key) {
                floor = root.data;
                return floor;
            }

            if (key > root.data) {
				floor = root.data; 
                root = root.right;
            }
            else {
                root = root.left;
            }
        }
        return floor;

    }
}
/*****************************Insert into a Binary Search Tree****************************************/
insert a new node in the bst where there are no dublicates

class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        
        TreeNode newNode = new TreeNode(val);
        if(root==null) return  newNode;
        TreeNode curr = root;
        while(true){
            if(root.val<val){
                if(root.right != null){
                    root=root.right;
                }
                else{
                    root.right=newNode;
                    break;
                }
            }else{
                if(root.left != null){
                    root=root.left;
                }
                else{
                    root.left=newNode;
                    break;
                }
            }
        }
        return curr;
    }
}

/*****************************************Delete a Node in Binary Search Tree***************************************/

class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val == key) {
            return helper(root);
        }
        TreeNode dummy = root;
        while (root != null) {
            if (root.val > key) {
                if (root.left != null && root.left.val == key) {
                    root.left = helper(root.left);
                    break;
                } else {
                    root = root.left;
                }
            } else {
                if (root.right != null && root.right.val == key) {
                    root.right = helper(root.right);
                    break;
                } else {
                    root = root.right;
                }
            }
        }
        return dummy;
    }
    public TreeNode helper(TreeNode root) {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null){
                return root.left;
            } else {
                TreeNode rightChild = root.right;
                TreeNode lastRight = findLastRight(root.left);
                lastRight.right = rightChild;
                return root.left;
            }
    }
    public TreeNode findLastRight(TreeNode root) {
        if (root.right == null) {
            return root;
        }
        return findLastRight(root.right);
    }
}

/*******************************Tries*******************************/

class Trie {
    class Node {
        Node [] childs;
        boolean isEnd;
        
        Node(){
            childs = new Node[26];
            isEnd = false;
        }
    }
    
    final private Node root;
    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        
        Node curr= root;
        
        for(int i=0;i<word.length();i++){
            if(curr.childs[word.charAt(i)-'a']==null){
                curr.childs[word.charAt(i)-'a'] = new Node();
            }
            curr = curr.childs[word.charAt(i)-'a'];
        }
        
        curr.isEnd = true;
    }
    
    public boolean search(String word) {
        Node curr= root;
        for(int i=0;i<word.length();i++){
            if(curr.childs[word.charAt(i)-'a']==null){
                return false;
            }
            curr = curr.childs[word.charAt(i)-'a'];
        }
        
       return  curr.isEnd;
        
    }
    
    public boolean startsWith(String prefix) {
        
         Node curr= root;
        for(int i=0;i<prefix.length();i++){
            if(curr.childs[prefix.charAt(i)-'a']==null){
                return false;
            }
            curr = curr.childs[prefix.charAt(i)-'a'];
        }
        
       return  true;
    }
}

/*******************Graphs**********************************/
graph can have any no of components and each node is a component 
/************************BFS**********************************/

first store the root in the queue and travers all the adjancent to the root by adding in the queue and remove the root from queue and traverse the adjacent of adjacent by adding then in the queue and removing the adjacent 

   public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj)
    {
        
        ArrayList<Integer> bfs = new ArrayList<>(); 
        boolean vis[] = new boolean[V]; 
        Queue<Integer> q = new LinkedList<>();
        
        q.add(0); 
        vis[0] = true; 
        
        while (!q.isEmpty())
        {
            Integer node = q.poll();
            bfs.add(node); 
 
            // Get all adjacent vertices of the dequeued vertex s
            // If a adjacent has not been visited, then mark it
            // visited and enqueue it
            for(Integer it: adj.get(node)) {
                if(vis[it] == false) {
                    vis[it] = true; 
                    q.add(it); 
                } 
            }
        }
        
        return bfs; 
    }
	
/*****************************dfs***************************/
class Solution
{
    public void dfs(int node, boolean vis[], ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> storeDfs) {
        storeDfs.add(node); 
        vis[node] = true; 
        for(Integer it: adj.get(node)) {
            if(vis[it] == false) {
                dfs(it, vis, adj, storeDfs); 
            }
        }
    }
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj)
    {
        ArrayList<Integer> storeDfs = new ArrayList<>(); 
        boolean vis[] = new boolean[V+1]; 
        for(int i = 1;i<=V;i++) {
            if(!vis[i]) dfs(i, vis, adj, storeDfs); 
        }
        
        return storeDfs;
    }
}


/*******************************cycle Check Uing Bfs************************************/
class Node {
    int first;
    int second;
    public Node(int first, int second) {
        this.first = first;
        this.second = second; 
    }
}
class Solution
{
   static boolean checkForCycle(ArrayList<ArrayList<Integer>> adj, int s,
            boolean vis[], int parent[])
    {
       Queue<Node> q =  new LinkedList<>(); //BFS
       q.add(new Node(s, -1));
       vis[s] =true;
       
       while(!q.isEmpty())
       {
           int node = q.peek().first;
           int par = q.peek().second;
           q.remove(); 
           
           for(Integer it: adj.get(node))
           {
               if(vis[it]==false)  
               {
                   q.add(new Node(it, node));
                   vis[it] = true; 
               }
        
               else if(par != it) return true;
           }
       }
       
       return false;
    }
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj)
    {
        boolean vis[] = new boolean[V];
        Arrays.fill(vis,false);
        int parent[] = new int[V];
        Arrays.fill(parent,-1);  
        
        for(int i=0;i<V;i++)
            if(vis[i]==false) 
                if(checkForCycle(adj, i,vis, parent)) 
                    return true;
    
        return false;
    }
}

/********************************cycle Check Using Dfs***************************/

class Solution
{
    public boolean checkForCycle(int node, int parent, boolean vis[], ArrayList<ArrayList<Integer>> adj) {
        vis[node] = true; 
        for(Integer it: adj.get(node)) {
            if(vis[it] == false) {
                if(checkForCycle(it, node, vis, adj) == true) 
                    return true; 
            }
            else if(it!=parent) 
                return true; 
        }
        
        return false; 
    }
    // 0-based indexing Graph
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj)
    {
        boolean vis[] = new boolean[V];
        
        for(int i = 0;i<V;i++) {
            if(vis[i] == false) {
                if(checkForCycle(i, -1, vis, adj))
                    return true; 
            }
        }
        
        return false; 
    }
}

/*************************************bipartiteGraph Bfs*********************************/
coloring the graph using the 2 colors such that no to adjacents have the same color then it is called bipartiteGraph
if graph had a even legth cycle then it is bipartiteGraph and if it had odd leght of cycle then it is not bipartiteGraph
class Main
{
	boolean bfsCheck(ArrayList<ArrayList<Integer>> adj, int node, int color[]) {
		Queue<Integer> q = new LinkedList<>();
		q.add(node); 
		color[node] = 1; 
		while(!q.isEmpty()) {
			Integer nde = q.poll(); 

			for(Integer it: adj.get(nde)) {
				if(color[it] == -1) {
					color[it] = 1 - color[nde]; 
					q.add(it); 
				}
				else if(color[it] == color[nde]) {
					return false; 
				}
			}
		}
		return true; 
	}


    boolean checkBipartite(ArrayList<ArrayList<Integer>> adj, int n)
    {
        int color[] = new int[n];
        for(int i = 0;i<n;i++) {
        	color[i] = -1; 
        }
        for(int i = 0;i<n;i++) {
        	if(color[i] == -1) {
        		if(!bfsCheck(adj, i, color)) {
        			return false; 
        		}
        	}
        }
        return true; 
    }
	
	/*************************************bipartiteGraph dfs*********************************/
	color array of -1 at first 
	
	boolean dfsCheck(ArrayList<ArrayList<Integer>> adj, int node, int color[]) {
		
		for(Integer it: adj.get(node)) {
			if(color[it] == -1) {
				color[it] = 1 - color[node]; 

				if(!dfsCheck(adj, it, color)) 
					return false; 
			}
			else if(color[it] == color[node]) {
				return false; 
			}
		}
		return true; 
	}
	
	/*********************************check cycle in the directed graph************************************/
	it is different from undirected graph
	
	class Solution {
    private boolean checkCycle(int node,  ArrayList<ArrayList<Integer>> adj, int vis[], int dfsVis[]) {
        vis[node] = 1; 
        dfsVis[node] = 1; 
        
        for(Integer it: adj.get(node)) {
            if(vis[it] == 0) {
                if(checkCycle(it, adj, vis, dfsVis) == true) {
                    return true; 
                }
            } else if(dfsVis[it] == 1) {
                return true; 
            }
        }
        dfsVis[node] = 0;
        return false; 
    }
    public boolean isCyclic(int N, ArrayList<ArrayList<Integer>> adj) {
        int vis[] = new int[N]; 
        int dfsVis[] = new int[N]; 
        
        for(int i = 0;i<N;i++) {
            if(vis[i] == 0) {
                if(checkCycle(i, adj, vis, dfsVis) == true) return true; 
            }
        }
        return false; 
    }
}

/******************************Topological Sort (DFS)********************************/
it should be directed acyclic gragp (DAG)

class Solution {
    static void findTopoSort(int node, int vis[], ArrayList<ArrayList<Integer>> adj, Stack<Integer> st) {
        vis[node] = 1; 
        for(Integer it: adj.get(node)) {
            if(vis[it] == 0) {
                findTopoSort(it, vis, adj, st); 
            } 
        }
        st.push(node); 
    }
	
    static int[] topoSort(int N, ArrayList<ArrayList<Integer>> adj) {
        Stack<Integer> st = new Stack<Integer>(); 
        int vis[] = new int[N]; 
        
        for(int i = 0;i<N;i++) {
            if(vis[i] == 0) {
                findTopoSort(i, vis, adj, st);
            }
        }
        
        int topo[] = new int[N];
        int ind = 0; 
        while(!st.isEmpty()) {
            topo[ind++] = st.pop();
        }
        return topo; 
    }
}

/*******************************Topological Sort (BFS)Kahn's Algorithm********************************/
class Solution {
    static void findTopoSort(int node, int vis[], ArrayList<ArrayList<Integer>> adj, Stack<Integer> st) {
        vis[node] = 1; 
        for(Integer it: adj.get(node)) {
            if(vis[it] == 0) {
                findTopoSort(it, vis, adj, st); 
            } 
        }
        st.push(node); 
    }
    static int[] topoSort(int N, ArrayList<ArrayList<Integer>> adj) {
        Stack<Integer> st = new Stack<Integer>(); 
        int vis[] = new int[N]; 
        
        for(int i = 0;i<N;i++) {
            if(vis[i] == 0) {
                findTopoSort(i, vis, adj, st);
            }
        }
        
        int topo[] = new int[N];
        int ind = 0; 
        while(!st.isEmpty()) {
            topo[ind++] = st.pop();
        }
        // for(int i = 0;i<N;i++) System.out.println(topo[i] + " "); 
        return topo; 
    }
}

/***************************Cycle Detection in Directed Graph using BFS(Kahn's Algorithm)**********************************/
class Solution {
    public boolean isCyclic(int N, ArrayList<ArrayList<Integer>> adj) {
        int topo[] = new int[N]; 
        int indegree[] = new int[N]; 
        for(int i = 0;i<N;i++) {
            for(Integer it: adj.get(i)) {
                indegree[it]++; 
            }
        }
        
        Queue<Integer> q = new LinkedList<Integer>(); 
        for(int i = 0;i<N;i++) {
            if(indegree[i] == 0) {
                q.add(i); 
            }
        }
        int cnt = 0;
        while(!q.isEmpty()) {
            Integer node = q.poll(); 
            cnt++; 
            for(Integer it: adj.get(node)) {
                indegree[it]--; 
                if(indegree[it] == 0) {
                    q.add(it); 
                }
            }
        }
        if(cnt == N) return false; 
        return true; 
    }
}

/***************************shortestPath from src to all nodes using bfs************************/

private void shortestPath(ArrayList<ArrayList<Integer>> adj,int N,int src) 
	{ 
		
		int[] dist = new int[N]; 
    	for(int i = 0; i < N; i++) 
    		dist[i] = 1000000000; 
    
    	Queue<Integer> q=new LinkedList<>();
    	
    	
    	dist[src] = 0;
    	q.add(src); 
    
    	while(q.isEmpty()==false) 
    	{ 
    		int node = q.poll();  
    		 
    		for(int it:adj.get(u)){
    		    if(dist[node] + 1 < dist[it]){
    		        dist[it] = dist[node] + 1;
    		        q.add(it);
    		    }
    		} 
    	}
    	
    	for(int i = 0;i < N;i++) {
    	    System.out.print(dist[i] + " "); 
    	}
	} 

/******************************Shortest Path in Directed Acyclic Graph (DAG)******************************/
class Pair
{
    private int v;
    private int weight;
    Pair(int _v, int _w) { v = _v; weight = _w; }
    int getV() { return v; }
    int getWeight() { return weight; }
}

class Main
{
    void topologicalSortUtil(int node, Boolean visited[], Stack stack, ArrayList<ArrayList<Pair>> adj)
    {

        visited[node] = true;
        for(Pair it: adj.get(node)) {
            if(visited[it.getV()] == false) {
                topologicalSortUtil(it.getV(), visited, stack, adj);
            }
        }
        stack.add(node);
    }

    void shortestPath(int s, ArrayList<ArrayList<Pair>> adj, int N)
    {
        Stack stack = new Stack();
        int dist[] = new int[N];

        Boolean visited[] = new Boolean[N];
        for (int i = 0; i < N; i++)
            visited[i] = false;

        for (int i = 0; i < N; i++)
            if (visited[i] == false)
                topologicalSortUtil(i, visited, stack, adj);

        for (int i = 0; i < N; i++)
            dist[i] = Integer.MAX_VALUE;
        dist[s] = 0;

        while (stack.empty() == false)
        {
            int node = (int)stack.pop();

            if (dist[node] != Integer.MAX_VALUE)
            {
                for(Pair it: adj.get(node)) {
                    if(dist[node] + it.getWeight() < dist[it.getV()]) {
                        dist[it.getV()] = dist[node] + it.getWeight(); 
                    }
                }
            }
        }

        for (int i = 0; i < N; i++)
        {
            if (dist[i] == Integer.MAX_VALUE)
                System.out.print( "INF ");
            else
                System.out.print( dist[i] + " ");
        }
    }
	
/******************************Dijkstra's Algorithm | Shortest Path in Undirected Graphs***********************************/
	class Node implements Comparator<Node>
{
    private int v;
    private int weight;
    
    Node(int _v, int _w) { v = _v; weight = _w; }
    
    Node() {}
    
    int getV() { return v; }
    int getWeight() { return weight; }
    
    @Override
    public int compare(Node node1, Node node2) 
    { 
        if (node1.weight < node2.weight) 
            return -1; 
        if (node1.weight > node2.weight) 
            return 1; 
        return 0; 
    } 
}

class Main
{
    void shortestPath(int s, ArrayList<ArrayList<Node>> adj, int N)
    {
        int dist[] = new int[N];
        
        for(int i = 0;i<N;i++) dist[i] = 100000000;
        dist[s] = 0; 
        
        PriorityQueue<Node> pq = new PriorityQueue<Node>(N, new Node());
        pq.add(new Node(s, 0));
        
        while(pq.size() > 0) {
            Node node = pq.poll();
            
            for(Node it: adj.get(node.getV())) {
                if(dist[node.getV()] + it.getWeight() < dist[it.getV()]) {
                    dist[it.getV()] = dist[node.getV()] + it.getWeight(); 
                    pq.add(new Node(it.getV(), dist[it.getV()]));
                }
            }
        }
        
        for (int i = 0; i < N; i++)
        {
            System.out.print( dist[i] + " ");
        }
    }
	
	/*********************************Minimum Spanning Tree******************************/
	1) if it has n nodes then it must have n-1 edges & from every node you should be able to reach any other node
	
	//prim's algorithm for mst
	class Node implements Comparator<Node>
{
    private int v;
    private int weight;
    
    Node(int _v, int _w) { v = _v; weight = _w; }
    
    Node() {}
    
    int getV() { return v; }
    int getWeight() { return weight; }

    @Override
    public int compare(Node node1, Node node2) 
    { 
        if (node1.weight < node2.weight) 
            return -1; 
        if (node1.weight > node2.weight) 
            return 1; 
        return 0; 
    } 
}

class Main
{
    void primsAlgo(ArrayList<ArrayList<Node>> adj, int N)
    {
        int key[] = new int[N];
        int parent[] = new int[N]; 
        boolean mstSet[] = new boolean[N]; 
        for(int i = 0;i<N;i++) {
        	key[i] = 100000000; 
        	mstSet[i] = false; 
        }

        PriorityQueue<Node> pq = new PriorityQueue<Node>(N, new Node());

        key[0] = 0;
        parent[0] = -1; 
        pq.add(new Node(key[0], 0)); 
		// Run the loop till all the nodes have been visited
	    // because in the brute code we checked for mstSet[node] == false while computing the minimum
	    // but here we simply take the minimal from the priority queue, so a lot of times a node might be taken twice
	    // hence its better to keep running till all the nodes have been taken. 
	    // try the following case: 
	    // Credits: Srejan Bera
	    // 6 7 
	    // 0 1 5 
	    // 0 2 10 
	    // 0 3 100 
	    // 1 3 50 
	    // 1 4 200
	    // 3 4 250
	    // 4 5 50 
        while(!pq.isEmpty()) {
        	int u = pq.poll().getV();
        	mstSet[u] = true;
        
        	for(Node it: adj.get(u)) {
        		if(mstSet[it.getV()] == false && it.getWeight() < key[it.getV()]) {
        			parent[it.getV()] = u; 
        			key[it.getV()] = it.getWeight(); 
        			pq.add(new Node(it.getV(), key[it.getV()]));
        		}
        	}
        }

        for(int i = 1;i<N;i++) {
        	System.out.println(parent[i] + " - " + i); 
        }
    }
 
 /********************************Find the number of islands *****************************/
 Given a grid consisting of '0's(Water) and '1's(Land). Find the number of islands.
Note: An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically or diagonally i.e., in all 8 directions.
 class Solution {
    // Function to find the number of islands.
    public int numIslands(char[][] grid) {
        int row=grid.length;
        int col = grid[0].length;
        int count=0;
        int vis[][] = new int[row+1][col+1];
      for(int i=0;i<row;i++){
          for(int j=0;j<col;j++){
              if(grid[i][j]=='1' && vis[i][j]==0){
                  dfs(grid,i,j,row,col,vis);
                  count++;
              }
          }
      }
      return count;
    }
      public void dfs(char[][] grid,int i,int j,int n,int m,int vis[][]){
         
          if(i<0||i>n-1) return;
          if(j<0 || j>m-1) return;
          if(grid[i][j]=='1' && vis[i][j]==0){

            vis[i][j]=1;
           int rowNbr[] = new int[] { -1, -1, -1, 0, 0, 1, 1, 1 };
            int colNbr[] = new int[] { -1, 0, 1, -1, 1, -1, 0, 1 };
             for (int k = 0; k < 8;k++){
                  dfs(grid,i+rowNbr[k],j+colNbr[k],n,m,vis);
             }
          
          }
    }
}

/****************************************************************/
class Solution {
    public int numDistinctIslands(int[][] grid) {
        if (grid == null || grid.length < 1 || grid[0].length < 1) return 0;
        int m = grid.length, n = grid[0].length;
        Set<String> res = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Set<String> set = new HashSet<>();
                if (grid[i][j] == 1) {
                    dfs(grid, i, j, i, j, set);
                    res.add(set.toString());
                }
            }
        }
        return res.size();
    }
    
    public void dfs(int[][] grid, int i, int j, int baseX, int baseY, Set<String> set) {
        int m = grid.length, n = grid[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 0) return;
        set.add((i - baseX) + "_" + (j - baseY));
        grid[i][j] = 0;
        dfs(grid, i + 1, j, baseX, baseY, set);
        dfs(grid, i - 1, j, baseX, baseY, set);
        dfs(grid, i, j - 1, baseX, baseY, set);
        dfs(grid, i, j + 1, baseX, baseY, set);
    }
}












/***************other than dsa*********************/
/*****************************792. Number of Matching Subsequences********************/
Given a string s and an array of strings words, return the number of words[i] that is a subsequence of s.
using map and queue
class Solution {
    public int numMatchingSubseq(String S, String[] words) {
        Map<Character, Deque<String>> map = new HashMap<>();
        for (char c = 'a'; c <= 'z'; c++) {
            map.putIfAbsent(c, new LinkedList<String>());
        }
        for (String word : words) {
            map.get(word.charAt(0)).addLast(word);
        }

        int count = 0;
        for (char c : S.toCharArray()) {
            Deque<String> queue = map.get(c);
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.removeFirst();
                if (word.length() == 1) {
                    count++;
                } else {
                    map.get(word.charAt(1)).addLast(word.substring(1));
                }
            }
        }
        return count;
    }
}


/**************************return a/b************************/
Given two integers dividend and divisor, divide two integers without using multiplication, division, and mod operator.
class Solution {
    public int divide(int dividend, int divisor) {
        if (Integer.MIN_VALUE == dividend && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        if (Integer.MIN_VALUE == dividend && divisor == 1) {
            return Integer.MIN_VALUE;
        }
        
        long t = Math.abs((long)dividend);
        long b = Math.abs((long)divisor);
        long res = 0;
        while(t>=b){
            long temp =b;
            int c = 1;
            while((t-(temp<<1))>=0){
                temp=temp<<1;
                c=c<<1;
            }
            t=t-temp;
            res=res+c;
        }
        return dividend>0 == divisor>0 ? (int)res : (int)-res;
    }
}

/***************binary search*************************/
  public int searchInsert(int[] nums, int target) {
     
        int low =0 ,hig = nums.length-1;
        int mid = 0;
        while(low<=hig){
             mid = low+(hig-low)/2;
            if(target == nums[mid]) return mid;
            if(nums[mid]<target) low=mid+1;
            else{
                hig=mid-1;
            }
            
        }
        return low;
    }


/**********************************993. Cousins in Binary Tree****************************/
Given the root of a binary tree with unique values and the values of two different nodes of the tree x and y, return true if the nodes corresponding to the values x and y in the tree are cousins, or false otherwise.
Two nodes of a binary tree are cousins if they have the same depth with different parents.
Note that in a binary tree, the root node is at the depth 0, and children of each depth k node are at the depth k + 1.
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        HashMap<Integer,Integer> map = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        map.put(root.val,0);
        int k =0;
        while(queue.size()>0){
            int size = queue.size();
            k++;
            for(int j =0 ;j<size;j++){
                TreeNode curr = queue.poll();
                if(curr.left!=null){
                    queue.add(curr.left);
                }
                 if(curr.right!=null){
                    queue.add(curr.right);
                }
                map.put(curr.val,k);
            }
        }
        
        if(map.get(x)==map.get(y)){
            if(getParent(root,x)!=getParent(root,y)){
                return true;
            }
            return false;
        }
        return false;
    }
    
    public static TreeNode getParent(TreeNode root,int x){
        if(root.left!=null && root.left.val==x){
            return root;
        } if(root.right!=null && root.right.val==x){
            return root;
        }
        if(root.left!=null){
            TreeNode g = getParent(root.left,x);
            if(g!=null){
                return g;
            }
        }
        if(root.right!=null){
            TreeNode g = getParent(root.right,x);
            if(g!=null){
                return g;
            }
        }
        return null;
    }
}