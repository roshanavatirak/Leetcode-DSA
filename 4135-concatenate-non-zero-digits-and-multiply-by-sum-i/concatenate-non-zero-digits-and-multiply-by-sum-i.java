class Solution {
    public long sumAndMultiply(int n) {
        long sum=0;
        long x=0;
        long a=1;
        while(0<n){
            long d=n%10;
            if(d!=0){
                sum+=d;
                x+=(d*a);
                a*=10;
            }
            n/=10;
        }

        return x*sum;
    }
}