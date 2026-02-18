class Solution {
    public boolean hasAlternatingBits(int n) {
        while (n != 0){
            int bitA = n & 1;
            n >>= 1;
            int bitB = n & 1;
            if(bitA == bitB){
                return false;
            }
        }
        return true;
    }
}