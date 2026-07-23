/*combination of prefix sum + pse +nse */
/*prequisites :
prefix sum array , pse ,nse */
//output: minimum * (sum of the subarray)
/* we already kow that pse and nse find the distance of the subarray means elements from the left and right*/

 /* steps:
 1- take the subarray which gives the maximum sum means longest subarray 
 2- by using the left and right variables we find the maximum subarray
 left=pse[i]-1
 right=nse[i]+1
 3- left means starting index of the max subarray
    right means ending index of the min subarray
4-find the sum of the subarray using the prefix array values 
sum=prefix[right+1]-prefix[left]
5-multiply the min with sum
product=arr[i] * sum
6-always take the maximum product 
max_product=Math.max(max,product)

*/
class Solution {
    public int maxSumMinProduct(int[] nums) {
        long[] prefix=new long[nums.length+1];
        prefix[0]=0;
        for(int i=0;i<nums.length;i++){
            prefix[i+1]=prefix[i]+nums[i];
        }
        int[] pse=findPSE(nums);
        int[] nse=findNSE(nums);
        long max_product=0;
        int mod=(int)Math.pow(10,9)+7;

        for(int i=0;i<nums.length;i++){
            int left=pse[i]+1;
            int right=nse[i]-1;
            long sum=(prefix[right+1]-prefix[left]);
            long product=(long)(nums[i]*sum);
            max_product=Math.max(max_product,product);
        }
        return (int)(max_product%mod);

    }
    public static int[] findPSE(int[] arr){
        Stack<Integer> st=new Stack<>();
        int[] pse=new int[arr.length];
        for(int i=0;i<arr.length;i++){

            while(!st.isEmpty() && arr[st.peek()]>arr[i]){
                st.pop();
            }
            pse[i]=st.isEmpty()?-1:st.peek();
            st.push(i);
        }
        return pse;

    }
    public static int[] findNSE(int[] arr){
        Stack<Integer> st=new Stack<>();
        int[] nse=new int[arr.length];
        int n=arr.length;
        for(int i=arr.length-1;i>=0;i--){

            while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
                st.pop();
            }
            nse[i]=st.isEmpty()?n:st.peek();
            st.push(i);
        }
         return nse;
    }
   
}
