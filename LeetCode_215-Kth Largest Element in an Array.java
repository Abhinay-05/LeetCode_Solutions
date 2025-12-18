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
    void rearrange(vector<int>& v) {
        int size = v.size();
        int curr = size - 1;
        // upheap
        while (curr > 0) {
            int parent = (curr - 1) / 2;

            if (v[parent] >= v[curr]) {
                break;
            } else {
                swap(v[parent], v[curr]);
                curr = parent;
            }
        }
    }

    int removal(vector<int>& v) {
        int ans = v.at(0);

        v[0] = v.at(v.size() - 1);
        v.pop_back();
        int len = v.size();

        int i = 0;
        // downHeap
        while (i < len) {
            int min = i;
            int left = 2 * i + 1;
            int right = 2 * (i + 1);

            if (left < len && v[left] > v[min]) {
                min = left;
            }

            if (right < len && v[right] > v[min]) {
                min = right;
            }

            if (min == i) {
                break;
            } else {
                swap(v[min], v[i]);
                i = min;
            }
        }

        return ans;
    }
    
    int findKthLargest(vector<int>& nums, int k) {
        // using Heap
        vector<int> ans;
        for (int el : nums) {
            ans.emplace_back(el);
            rearrange(ans);
        }
        int returnable = 0;
        for (int i = 0; i < k; i++) {
            returnable = removal(ans);
        }
        return returnable;
    }
};
