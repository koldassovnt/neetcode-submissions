class Solution {

    public String encode(List<String> strs) {
        if (strs == null || strs.isEmpty()) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str.length() + "#" + str);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> decoded = new ArrayList<>();
        if (str == null || str.isEmpty()) {
            return decoded;
        }

        int i = 0;
        while (i < str.length()) {
            int len = 0;
            while(str.charAt(i) != '#') {
                len = len * 10 + (str.charAt(i) - '0');
                i++;
            }//I am at '#'

            i++; //move over '#'

            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < len; j++) {
                sb.append(str.charAt(i++));
            }

            decoded.add(sb.toString());
        }

        return decoded;
    }
}