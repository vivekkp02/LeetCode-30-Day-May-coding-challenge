/*

Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode",
return 2.
Note: You may assume the string contain only lowercase letters.

*/

class Solution {
    public int firstUniqChar(String s) {
        
        if(s == null || s.length() == 0){
            return -1;
        }
        
        int counts[] = new int[26];
        
        int len = s.length();
        
        int max = Integer.MAX_VALUE;        
      
        for(int i=0; i<len; i++){
            int index = s.charAt(i) - 'a';
            if(counts[index] != 0){
                counts[index] = -1;
            }else{
                counts[index] = i+1;
            }
        }
        
        int minIndex = max;
        for(int i=0; i<26; i++){
            if(counts[i] > 0 && counts[i] < minIndex)
                minIndex = counts[i];
        }
        
        return minIndex == max ? -1 : minIndex-1;        
    }
}
