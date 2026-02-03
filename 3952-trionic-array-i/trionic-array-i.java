class Solution {
    public boolean isTrionic(int[] nums) {
        int n= nums.length;
        if(n<3) {
            return false; 
        }
           

        boolean[] leftpart= new boolean[n];
    leftpart[0]=true;
    for(int i=1; i<n; i++){
    leftpart[i]=leftpart[i-1] && nums[i]> nums[i-1];
    }

        boolean[] rightpart= new boolean[n];
        rightpart[n-1]=true;
        for(int i=n-2; i>=0; i--){
            rightpart[i]=rightpart[i+1]&& nums[i]<nums[i+1];
        }

        for(int k=1; k<n-2; k++){
            if(!leftpart[k]){
                continue;
            }

            int q=k+1;
            while(q<n-1&& nums[q]<nums[q-1]){
                if(rightpart[q]){
                    return true;
                }
                q++;
            }
        }

        return false;
    }

    


}