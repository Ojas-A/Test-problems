class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int[] sorted = nums;
        Set<List<Integer>> ans = new HashSet<>();
        //List<List<Integer>> ans = new ArrayList<>();
        for (int i =0; i< nums.length; i++) {
            int target = sorted[i];
            if (target > 0)
                break;
            target *= -1;
            int l = i+1, r = nums.length-1;
            while(l < r) {
                if (sorted[l] + sorted[r] == target) {
                    List<Integer> lst = List.of(sorted[i], sorted[l], sorted[r]);
                    ans.add(lst);
                    l++;
                    r--;
                    continue;
                } else if (sorted[l] + sorted[r] > target) {
                    r--;
                } else {
                    l++;
                }
            }
        }
        return ans.stream().toList();
    }
}
