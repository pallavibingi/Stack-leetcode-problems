        //span = how many consecutive days are there which are less than the current day
        //previous day<=current day : span+=1;
        /* for loop from n to 0:
                go backwards
              count until larger day encounter
              and span+=1 */

        // stack used to store the price and span instead of storing the indices
        /* whenever we see the smaller days,pop the span(second element in the array) then store the current price and current span

        we pop only the smaller elements span then we storing the the span in current element span
        100 80 60 70 60 75 85 
        at 60 : stack = [70,2] [80,1] [100,1]  
        at 75:  stack  = [60,1] [70,2] [80,1] [100,1] after
                stack  =[75,4] [80,1] [100,1]*/

    // go backwards continue until a larger element encounters 
    // smaller elements are merged into larger element means their span

class StockSpanner {
    Stack<int[]> stack;

    public StockSpanner() {
        stack=new Stack<>();   
    }
    
    public int next(int price) {
        int span=1;
       while(!stack.isEmpty() && stack.peek()[0]<=price){
        span+=stack.pop()[1];

       }
       stack.push(new int[]{price,span});
       return span;
        
    } 
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
