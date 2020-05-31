/*
Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.
The order of output does not matter.

Example 1:
Input:
s: "cbaebabacd" p: "abc"
Output:
[0, 6]
Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".

Example 2:
Input:
s: "abab" p: "ab"
Output:
[0, 1, 2]
Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".
*/

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if(p.length()>s.length())
            return result;
        int[] pChars = new int[26];
        for(char ch : p.toCharArray()){
            pChars[ch-'a']++;
        }
        int start=0;
        for(int i=0; i<p.length(); i++){
            pChars[s.charAt(i)-'a']--;
        }
        int mismatch_count=0;
        for(int pc : pChars){
            if(pc!=0){
                mismatch_count++;
            }
        }
        if(mismatch_count==0){
            result.add(start);
        }
        start++;
        while(start <= s.length()-p.length()){
            int index1 = s.charAt(start-1)-'a';
            int index2 = s.charAt(start + p.length()-1)-'a';
            pChars[index1]++;
            if(pChars[index1]==1){
                mismatch_count++;
            }else if(pChars[index1]==0){
                mismatch_count--;
            }
            pChars[index2]--;
            if(pChars[index2]==-1){
                mismatch_count++;
            }else if(pChars[index2]==0){
                mismatch_count--;
            }
            if(mismatch_count==0){
                result.add(start);
            }
            start++;
        }
        return result;
    }
}
