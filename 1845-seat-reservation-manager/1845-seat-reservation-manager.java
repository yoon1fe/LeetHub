class SeatManager {
  private PriorityQueue<Integer> availableSeats;

  public SeatManager(int n) {
    this.availableSeats = new PriorityQueue<>();
    
    for (int i = 1; i <= n; i++) {
      availableSeats.add(i);
    }
  }
    
  public int reserve() {
    return availableSeats.poll();        
  }
    
  public void unreserve(int seatNumber) {
    availableSeats.add(seatNumber);
  }
}

/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */