package Stack;

public class Stack {
    int max=10;
    int top=-1;
    int[]arr=new int[max];

    public   void push(int value){
        if(top==max-1){
            System.out.println("stack is full");

        }
        else{
            top++;
            arr[top]=value;
        }
    }

    public  void peek(){
        if(top==-1)
            System.out.println("stack is empty");
        else{
            System.out.println(arr[top]);
        }
    }
    public void pop(){
        if(top==-1)
            System.out.println("stack is empty");
        else{
            System.out.println(arr[top--]);

        }
    }
    public static void main(String[] args) {
        Stack stack=new Stack();
        stack.push(2);
        stack.push(8);
        stack.push(7);
        System.out.println("pop");
        stack.pop();
        System.out.println("peek");
        stack.peek();
    }


}
