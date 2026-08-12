
class Solution {
    public int largestRectangleArea(int[] heights) {

        int[] RightSmallest = new int[heights.length];

        int area = 0;
        Stack<Integer> s1 = new Stack<>();

        // Right Smallest
        for(int i = heights.length - 1; i >= 0; i--) {

            while(!s1.isEmpty() && heights[i] <= heights[s1.peek()]) {
                s1.pop();
            }

            if(s1.isEmpty()) {
                RightSmallest[i] = 0;
                s1.push(i);
            }
            else {
                RightSmallest[i] = s1.peek() - i;
                s1.push(i);
            }
        }

        // ----------------------------------------------------

        Stack<Integer> s2 = new Stack<>();

        int[] reversed = new int[heights.length];
        int[] LeftSmallest = new int[heights.length];

        int left = 0;
        int right = heights.length - 1;

        // Reverse heights
        while(left < heights.length) {
            reversed[left] = heights[right];
            left++;
            right--;
        }

        // Left Smallest
        for(int i = reversed.length - 1; i >= 0; i--) {

            while(!s2.isEmpty() && reversed[i] <= reversed[s2.peek()]) {
                s2.pop();
            }

            if(s2.isEmpty()) {
                LeftSmallest[i] = 0;
                s2.push(i);
            }
            else {
                LeftSmallest[i] = s2.peek() - i;
                s2.push(i);
            }
        }

        // Reverse LeftSmallest
        left = 0;
        right = heights.length - 1;

        while(left < right) {

            int temp = LeftSmallest[left];
            LeftSmallest[left] = LeftSmallest[right];
            LeftSmallest[right] = temp;

            left++;
            right--;
        }

        // ----------------------------------------------------
        // Calculate maximum area

        for(int i = 0; i < heights.length; i++) {

            int leftWidth;
            int rightWidth;

            if(LeftSmallest[i] == 0) {
                leftWidth = i + 1;
            }
            else {
                leftWidth = LeftSmallest[i];
            }

            if(RightSmallest[i] == 0) {
                rightWidth = heights.length - i;
            }
            else {
                rightWidth = RightSmallest[i];
            }

            int width = leftWidth + rightWidth - 1;

            int currentArea = heights[i] * width;

            area = Math.max(area, currentArea);
        }

        return area;
    }
}