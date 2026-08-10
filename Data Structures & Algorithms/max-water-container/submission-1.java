
class Solution {
    public int maxArea(int[] height) {
        int sol = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            int length = Math.min(height[left], height[right]);
            int breadth = right - left;
            int area = length * breadth;

            if (sol < area) {
                sol = area;
            }

            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }

        return sol;
    }
}

