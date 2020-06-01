/*
Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1. In other words, one of the first string's permutations is the substring of the second string.

Example 1:
Input: s1 = "ab" s2 = "eidbaooo"
Output: True
Explanation: s2 contains one permutation of s1 ("ba").

Example 2:
Input:s1= "ab" s2 = "eidboaoo"
Output: False

Constraints:
The input strings only contain lower case letters.
The length of both given strings is in range [1, 10,000].
*/

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length())
            return false;
        int count[] = new int[26];
        for(char ch : s1.toCharArray()){
            count[ch-'a']++;
        }
        int start=0;
        for(int i=0; i<s1.length(); i++){
            count[s2.charAt(i)-'a']--;
        }
        boolean match=true;
        for(int c : count){
            if(c!=0){
                match = false;
                break;
            }
        }
        if(match)
            return true;
        start++;
        while(start <= s2.length()-s1.length()){
            int index1 = s2.charAt(start-1)-'a';
            int index2 = s2.charAt(start + s1.length() - 1)-'a';
            count[index1]++;
            count[index2]--;
            match=true;
            for(int c : count){
                if(c!=0){
                    match = false;
                    break;
                }
            }
            if(match)
                return true;
            start++;            
        }
        return false;
    }
}
