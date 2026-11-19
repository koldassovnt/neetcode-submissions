class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>();

        for (String str : strs) {
            String sorted = sort(str);
            groups.computeIfAbsent(sorted, k -> new ArrayList<>()).add(str);
        }

        return groups.values().stream().toList();
    }

    private String sort(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
