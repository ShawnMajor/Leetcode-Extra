public clase 244ShortestWordDistance2 {
  private Map<String, List<Integer>> map;
  public 244ShortestWordDistance2(String[] words) {
    map = new HashMap<String, List<Integer>>();
    for (int i = 0; i < words.length; i++) {
      if (map.containsKey(words[i])) {
        map.put(words[i], map.get(words[i]).add(i));
      } else {
        List<Integer> pos = new ArrayList<Integer>();
        pos.add(i);
        map.put(words[i], pos);
      }
    }
  }
  
  public int shortest(String word1, String word2) {
    List<Integer> pos1 = map.get(word1);
    List<Integer> pos2 = map.get(word2);
    
    int minDistance = Integer.MAX_VALUE;
    int i = 0, j = 0;
    while (i < pos1.size() && j < pos2.size()) {
      int a = pos1.get(i);
      int b = pos2.get(j);
      if (a < b) {
        minDistance = Math.min(minDistance, b - a);
        i++;
      } else {
        minDistance = Math.min(minDistance, a - b);
        j++;
      }
    }
    return minDistance;
  }
}
