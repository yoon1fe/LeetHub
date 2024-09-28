class MyCalendar {
  
  private Map<Integer, Integer> calendar;
  
  public MyCalendar() {
    calendar = new TreeMap<>();
  }
  
  public boolean book(int start, int end) {
    for (Integer s : calendar.keySet()) {
      int e = calendar.get(s);

      if (start <= s && (s < end && end < e)) {
        return false;
      }

      if ((s <= start && start < e) || (s < end && end <= e)) {
        return false;
      }

      if (start <= s && e < end) {
        return false;
      }
  
    }

    calendar.put(start, end);
    return true;
  }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */