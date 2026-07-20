import java.util.*;

class NextGreaterElement{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];

        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }

        Stack<Integer> stack=new Stack<>();
        int[] res=new int[n];
        //start from the end and find the NGE
        for(int i=n-1;i>=0;i--){
            //invalid condition then pop the element
            while(!(stack.isEmpty()) && stack.peek()<=arr[i]){
                //in left side having the smaller element than the current element - then current element becomes NGE
                // in left side having the greater element than the current element - it is not important 

                stack.pop(); // when we pop an element in stack means it is not that much important
            }
            if(stack.isEmpty()){
                res[i]=-1;
            }
            else{
                res[i]=stack.peek();

            }
            stack.push(arr[i]);
        }
        System.out.println(Arrays.toString(res));
    }
}
