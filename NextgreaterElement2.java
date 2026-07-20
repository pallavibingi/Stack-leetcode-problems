//monotic stack means while pushing an element removes all smaller elements bcz it always in decreasing order from bottom to top

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int size=nums.length;
        int[] res=new int[nums.length];
        Stack<Integer> stack=new Stack<>();
        //double the array
        for(int i=2*size-1;i>=0;i--){
            //monotonic stack condition : for every element pushing in stack,check there is any smaller element in the stack if it is then pop() 
            while(!stack.isEmpty() && stack.peek()<=nums[i%size]){
                stack.pop();
            }
            //stack is empty means no NGE otherwise NGE is stack.peek()
            if(i<size){
                res[i]=stack.isEmpty()?-1:stack.peek();
            }
            stack.push(nums[i%size]);
        }
        return res;
  
        
    }
}
