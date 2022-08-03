class MyCalendar {

  private TreeMap<Integer, Integer> calendar;
  
  public MyCalendar() {
    calendar = new TreeMap<>();    
  }
    
  public boolean book(int start, int end) {
    Integer left = calendar.floorKey(start);
    Integer right = calendar.ceilingKey(start);
    
    if ((left == null || calendar.get(left) <= start) && (right == null || end <= right)) {
      calendar.put(start, end);
      
      return true;
    }
    return false;
  }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */