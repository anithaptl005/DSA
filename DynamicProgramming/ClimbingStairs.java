// https://leetcode.com/problems/climbing-stairs/

//recursion -TLE

class Solution {
    public int climbStairs(int n) {
        return  helperClimbStairs(n);
    }

    public int helperClimbStairs(int n){
        if(n<=2) return n;
        int result =helperClimbStairs(n-1)+helperClimbStairs(n-2);
        return result;
    }

}

/**
Bottom up approach
**/

class Solution {
    public int climbStairs(int n) {
        int[] dp =new int[n+1];
        if(n<=2) return dp[n]=n;
        dp[0]=0;
        dp[1]=1;
        dp[2]=2;
      //initialise with 3
        for(int i=3;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}

/**
Space optimisation
**/
class Solution {
    public int climbStairs(int n) {
        if(n<=2) return n;
        int b=2;
        int a=1;
        int result=0;
       
        for(int i=3;i<=n;i++){
            result=a+b;
            a=b;
            b=result;
        }
        return b;
    }
}
