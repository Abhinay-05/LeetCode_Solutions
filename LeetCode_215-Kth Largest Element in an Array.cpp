// Given an integer array nums and an integer k, return the kth largest element in the array.
// Note that it is the kth largest element in the sorted order, not the kth distinct element.
// Can you solve it without sorting?


// Example 1:
// Input: nums = [3,2,1,5,6,4], k = 2
// Output: 5
  
// Example 2:
// Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
// Output: 4
 

// Constraints:
// 1 <= k <= nums.length <= 105
// -104 <= nums[i] <= 104

class Solution {
public:
    int pivotFinding(vector<int>& v, int l, int h, int k){
        int len = v.size();
        int pivot = v[h];
        int p = l;
        for(int i = l ; i < h ; i++){
            if(v[i] < pivot){
                swap(v[i], v[p]);
                p++;
            }
        }
        swap(v[p], v[h]);
        return p;
    }
    
    int findKthLargest(vector<int>& nums, int k) {
        int len = nums.size();
        int l = 0, h = len - 1;
        while(l <= h){
            int p = pivotFinding(nums, l, h, k);
            if(p < (len - k)){
                l = p + 1;
            }
            else if(p > (len - k)){
                h = p - 1;
            }
            else{// if(p == (len - k))
                return nums[p];
            } 
        }
        return -1;
    }
};
