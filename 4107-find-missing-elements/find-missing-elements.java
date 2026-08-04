class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int a=small(nums);
        int b=largest(nums);
        List<Integer>list=new ArrayList<>();
 Set<Integer> set=new HashSet<>();
 for(int num: nums){
    set.add(num);
 }
 a++;
        while(a<b){
if(!set.contains(a)){
    list.add(a);
}
a++;
        }

        return list;
    }
    private int small(int[] nums){
        int ans=Integer.MAX_VALUE;
        for(int i=0; i<nums.length;i++){
            ans=Math.min(ans, nums[i]);
        }

        return ans;
    }

     private int largest(int[] nums){
        int ans=Integer.MIN_VALUE;
        for(int i=0; i<nums.length;i++){
            ans=Math.max(ans, nums[i]);
        }

        return ans;
    }
}