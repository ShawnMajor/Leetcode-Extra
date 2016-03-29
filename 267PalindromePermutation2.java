public class 267PalindromePermutation {
    public List<String> generatePalindromes(String s) {
        List<String> results = new ArrayList<String>();
        if (s == null || s.length() == 0)
            return results;
            
        Map<Character, Integer> d = new HashMap<Character, Integer>();
        
        for (int i = 0; i < s.length(); i++) {
            if(d.containsKey(s.charAt(i)))
                d.put(s.charAt(i), d.get(s.charAt(i)) + 1);
            else
                d.put(s.charAt(i), 1);
        }
        
        StringBuilder candidate = new StringBuilder();
        char single = '\0';
        boolean oddCount = false;
        
        for (Character c : d.keySet()) {
            if (d.get(c) % 2 != 0) {
                if (oddCount)
                    return results;
                else {
                    oddCount = true;
                    single = c;
                }
            for(int i = 0; i < d.get(c) / 2; i++)
                candidate.append(c);
            }
        }
        
        if (candidate.length() == 0 && oddCount) {
            results.add(String.valueOf(single));
            return results;
        }
        
        permutation(cadidate.toString.toCharArray, 0, results);
        
        for (int i = 0; i < results.size(); i++) {
            str = results.get(i);
            StringBuilder sb = new StringBuilder(str);
            if (oddCount)
                sb.append(single);
            for (int j = str.length() - 1; j >= 0; j--) {
                sb.append(str.charAt(j));
            }
            results.set(i, sb.toString());
        }
        return results;
    }

    private void permutation(char[] s, int start, List<String> result) {
        if (start >= s.length) {
            result.add(new String(s));
            return;
        }
         
        for (int i = start; i < s.length; i++) {
            if (!containsDuplicate(s, start, i)) {
                swap(s, i, start);
                permutation(s, start + 1, result);
                swap(s, i, start);
            }
        }
    }
     
    private void swap(char[] s, int i, int j) {
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }
     
    private boolean containsDuplicate(char[] s, int start, int end) {
        for (int i = start; i < end; i++) {
            if (s[i] == s[end]) {
                return true;
            }
        }
        return false;
    }

}
    
    
    
    

