package leetcode;

class Solution_0820 {
    public int minimumLengthEncoding(String[] words) {

        for (int i = 0; i < words.length; i++) {
            if (words[i] != null) {
                for (int j = 0; j < words.length; j++) {
                    if (i == j)
                        continue;
                    if (words[j] == null)
                        continue;
                    if (words[i].endsWith(words[j]))
                        words[j] = null;
                }
            }
        }
        int result = 0;
        for (int i = 0; i < words.length; i++) {
            if (words[i] == null)
                continue;
            result = result + words[i].length() + 1;
        }
        return result - 1;
    }
}