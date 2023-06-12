class Solution {
  public List<String> summaryRanges(int[] nums) {
    List<String> answer = new ArrayList<>();
    List<Integer> subList = new ArrayList<>();
    
    for (int num : nums) {
      if (isConsecutive(subList, num)) {
        subList.add(num);
      } else {
        makeAnswer(answer, subList, num);
      }
    }
    
    makeAnswer(answer, subList, 0);
    
    return answer;
  }
  
  private boolean isConsecutive(List<Integer> list, int num) {
    if (list.isEmpty()) return false;
    return list.get(list.size() - 1) + 1 == num;  
  }
  
  private void makeAnswer(List<String> answer, List<Integer> list, int num) {
    StringBuilder sb = new StringBuilder();
    if (list.size() == 1) {
      answer.add(String.valueOf(list.get(0)));
    } else if (list.size() > 1) {
      answer.add(sb.append(String.valueOf(list.get(0))).append("->").append(String.valueOf(list.get(list.size() - 1))).toString());
    }
    
    list.clear();
    list.add(num);
  }

}