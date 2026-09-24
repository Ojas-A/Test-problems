class Solution {

    public String encode(List<String> strs) {
        // count delimiter chars delimiter
        String delimiter = ";";
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str.length() + delimiter + str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        String delimiter = ";";
        List<String> ans = new ArrayList<>();
        int i =0;
        while(i < str.length()) {
            int j = i;
            while (str.charAt(j) != ';') {
                j ++;
            }
            System.out.println(str.substring(i, j));
            int count = Integer.valueOf(str.substring(i, j));
            ans.add(str.substring(j+1, j+count+1));
            i = j + count+1;
        }
        return ans;
    }
}
