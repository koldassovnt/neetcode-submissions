class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) {
            return List.of(List.of());
        }

        Map<String, List<String>> groups = new HashMap<>();

        for (String str : strs) {
            String sorted = sort(str);
            if (groups.containsKey(sorted)) {
                groups.get(sorted).add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                groups.put(sorted, list);
            }
        }

        return groups.values().stream().toList();
    }

    private String sort(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
