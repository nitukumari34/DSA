
package Stack;

import java.util.*;

public class MyStack {

    int max = 10;
    int top = -1;
    int[] arr = new int[max];

    public void push(int value) {
        if (top == max - 1) {
            System.out.println("Stack is full");
        } else {
            arr[++top] = value;
        }
    }

    public void peek() {
        if (top == -1)
            System.out.println("Stack is empty");
        else
            System.out.println(arr[top]);
    }

    public void pop() {
        if (top == -1)
            System.out.println("Stack is empty");
        else
            System.out.println(arr[top--]);
    }
//    //        brute force approach
    ////    public  static int largestRectangleArea(int[] heights) {
    ////
    ////        int maxArea=0;
    ////        for(int i=0;i<heights.length;i++){
    ////            int minheight=heights[i];
    ////            for(int j=i;j<heights.length;j++){
    ////                minheight=Math.min(minheight,heights[j]);
    ////                int width=j-i+1;
    ////                maxArea=Math.max(maxArea,width*minheight);
    ////            }
    ////        }
    ////        return  maxArea;
    ////    }

    public static int largestRectangleArea(int[] heights) {

        Stack<Integer> st = new Stack<>();
        st.push(-1);
        int maxArea = 0;

        for (int i = 0; i < heights.length; i++) {
            while (st.peek() != -1 && heights[i] < heights[st.peek()]) {
                int height = heights[st.pop()];
                int right = i;
                int left = st.peek();
                maxArea = Math.max(maxArea, height * (right - left - 1));
            }
            st.push(i);
        }

        while (st.peek() != -1) {
            int height = heights[st.pop()];
            int right = heights.length;
            int left = st.peek();
            maxArea = Math.max(maxArea, height * (right - left - 1));
        }

        return maxArea;
    }

    public static void main(String[] args) {

        MyStack stack = new MyStack();
        stack.push(2);
        stack.push(8);
        stack.push(7);

        int[] heights = {2, 1, 5, 6, 2, 3};
        int ans = largestRectangleArea(heights);
        System.out.println("Max Area = " + ans);
    }
}
