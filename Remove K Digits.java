/*
Given a non-negative integer num represented as a string, remove k digits from the number so that the new number is the smallest possible.

Note:
The length of num is less than 10002 and will be ≥ k.
The given num does not contain any leading zero.

Example 1:
Input: num = "1432219", k = 3
Output: "1219"
Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.

Example 2:
Input: num = "10200", k = 1
Output: "200"
Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.

Example 3:
Input: num = "10", k = 2
Output: "0"
Explanation: Remove all the digits from the number and it is left with nothing which is 0.

*/

class Solution {
    public String removeKdigits(String num, int k) {
        
        // if k == length then we need to deleted all num
        if(num.length() == k)
            return "0";
        
        // We use stack and greedy approach
        Stack<Character> stack = new Stack<>();
        
        // we pop all top nums if it is greater than current num
        // we need to also decrement k value
        for(char ch : num.toCharArray()){
            while(!stack.isEmpty() && stack.peek() > ch && k-- > 0){
                    stack.pop();
            }
            // then push current char
            stack.push(ch);
        }
        
        // if k!=0 then we pop till k==0
        while(k-- > 0 && !stack.isEmpty()){
            stack.pop();
        }
        
        StringBuilder res = new StringBuilder();
        // we use stringbuilder to store the result
        while(!stack.isEmpty()){
            res.append(stack.pop());
        }
        
        res.reverse();
        
        // for numbers such as 001, 02456 we need to delete leading 0's
        while(res.length() > 1 && res.charAt(0) == '0')
            res.deleteCharAt(0);
        
        return res.toString();
    }
}
