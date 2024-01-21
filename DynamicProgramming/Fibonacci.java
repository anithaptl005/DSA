//https://leetcode.com/problems/fibonacci-number


//1. recursive solution - 9ms-runtime , 40 MB memory

class Solution {
    public int fib(int n) {
       return helperFib(n);
    }

    public int helperFib(int n){
        if(n<2) return n;

        return helperFib(n-1)+helperFib(n-2);
    }
}


/**
2. Memoisation - 0 ms-runtime , 40.18 MB memory
**/
class Solution {
    public int fib(int n) {
      /** create dp array with 1 size extra n **/
        int[] dp=new int[n+1];
        for(int i=0;i<=n;i++){
          //initialise with -1 in memoisation
            dp[i]=-1;
        }
       return helperMemosieFib(n,dp);
    }

    public int helperMemosieFib(int n,int[] dp){
        if(n<2) return n;

      //this check is required to substitute data  default value
        if(dp[n]!=-1) return dp[n];

      // store recursion in dp array
         dp[n]= helperMemosieFib(n-1,dp)+helperMemosieFib(n-2,dp);
         return dp[n];
    }
}

/**

3. Bottom up approach   - 0 ms-runtime , 40.18 MB memory
**/
class Solution {
    public int fib(int n) {
        int[] dp=new int[n+1];
      // this below condition can be written or ignored based on test case
      //if(n<0) return n;
      // this edge case condition is required to pass test case
        if(n==0) return 0;
      // this intial values need to be initialised for this approach
        dp[0]=0;dp[1]=1;
        for(int i=2;i<=n;i++){
          dp[i]= dp[i-1]+dp[i-2];
        }
       return dp[n];
    }
}

/**
4.space optimisation - 0 ms-runtime , 40.18 MB memory
**/
class Solution {
    public int fib(int n) { 
      //instead of array replace with 3 variables being initialised 
        int result =0;
        int firstResult=1;
        int secondResult=0;
      
        if(n==0) return secondResult;
        if(n==1) return firstResult;
        
        for(int i=2;i<=n;i++){
          result= firstResult+secondResult;
          secondResult=firstResult;
          firstResult=result;
        }
       return result;
    }
}

