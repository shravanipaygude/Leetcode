class Solution {
    public int minAddToMakeValid(String s) {
        int openNeeded = 0;
        int closeNeeded = 0;
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                openNeeded++;
            } else {
                // If we have an open parenthesis available, match it
                if (openNeeded > 0) {
                    openNeeded--;
                } else {
                    // Otherwise, we need an extra '(' to match this ')'
                    closeNeeded++;
                }
            }
        }
        
        // Total additions needed = unmatched '(' + unmatched ')'
        return openNeeded + closeNeeded;
    }
}