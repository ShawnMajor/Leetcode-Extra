public class 245ShortestWordDistance3 {
  public int shortestWordDistance(String[] words, String word1, String word2) {
    int index1 = -1, index2 = -1, minDistance = Integer.MAX_VALUE;
    for (int i = 0; i < words.length; i++) {
      if (words[i].equals(word1)) {
        index1 = i;
      } else if (words[i].equals(word2)) {
        index2 = i;
      }
      if (index1 != -1 && index2 != -1 && index1 != index2) {
        minDistance = Math.min(minDistance, Math.abs(index1 - index2));
      }
      if (word1.equals(words2)) {
        index2 = index1;
      }
    }
    return minDistance;
  }
}
