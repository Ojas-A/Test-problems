class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<List<Integer>, List<String>> occurance = new HashMap();
        for (String str : strs) {
            List<Integer> rep = Arrays.stream(getListRep(str)).boxed().toList();
            if (occurance.get(rep) == null) {
                occurance.put(rep,new ArrayList<>(Arrays.asList(str)));
            } else {
                occurance.get(rep).add(str);
            }
        }
        List<List<String>> ans = new ArrayList();
        occurance.values().forEach(x -> ans.add(x));
        return ans;
    }

    private int[] getListRep(String str) {
        int[] rep = new int[26];
        for (char c : str.toCharArray()) {
            int i = c - 'a';
            rep[i]++;
        }
        return rep;
    }
}
