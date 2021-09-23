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





 