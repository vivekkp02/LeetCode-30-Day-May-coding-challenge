/*

Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.

Example 1:

Input: [3,2,3]
Output: 3
Example 2:

Input: [2,2,1,1,1,2,2]
Output: 2

*/

class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int candidate = getCandidate(nums, n);
        int mCount = 0;
        for(int i=0; i<n; i++){
            if(nums[i] == candidate){
                mCount++;
            }
        }        
        if(mCount > n/2){
            return candidate;
        }        
        return -1;       
    }
    
    int getCandidate(int nums[], int n){
        int count = 1;
        int majIndex = 0;
        for(int i=1; i<n; i++){
            if(nums[majIndex] == nums[i]){
                count++;
            }else{
                count--;
            }            
            if(count == 0){
                majIndex = i;
                count = 1;
            }
        }
        return nums[majIndex];        
    }
}
