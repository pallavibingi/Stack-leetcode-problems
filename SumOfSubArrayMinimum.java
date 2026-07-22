class Solution {
    public int sumSubarrayMins(int[] arr) {
        //finding the pse and nse 
        int[] pse=findPSE(arr);
        int[] nse=findNSE(arr);

        int mod=(int)Math.pow(10,9)+7;
        long total=0;
//we do this problem by finding the how many times an element is minimum in each subarray
/*[3,1,2,4] : 3 is minimum in only one subarray 
            1 is minium in 6 subarrays
            2 is minimum in 2 subarrays
            4 is minimum in only 1 subarray
            */
        for(int i=0;i<arr.length;i++){
            //tell that how many elements are there in previous (from the left to current how many elements)
            int left=i-pse[i];
            //tell that how many elements are there in next(from the current to right how many elements)
            int right=nse[i]-i;
//total subarrays in that the current is minimum
           int  subArrays=(left*right)%mod;
//sum
            total=(total+(arr[i]*1L*subArrays)%mod)%mod;
        }
        return (int)total;
    }
    public static int[] findPSE(int[] arr){
        int[] pse=new int[arr.length];
        Stack<Integer> st=new Stack<>();
        int n=arr.length;
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && arr[st.peek()]>arr[i]){
                st.pop();
            }
            pse[i]=st.isEmpty()?-1:st.peek();
            st.push(i);
        }
        return pse;
    }
    public static int[] findNSE(int[] arr){
        int[] nse=new int[arr.length];
        Stack<Integer> st=new Stack<>();
        int n=arr.length;
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
                st.pop();
            }
            nse[i]=st.isEmpty()?n:st.peek();
            st.push(i);
        }
        return nse;
    }
}
