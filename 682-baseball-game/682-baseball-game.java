class Solution {
    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        
        for (String op : ops) {   
            switch (op) {
                case "C":
                    stack.pop();
                    break;
                case "D":
                    int top = stack.pop();
                    stack.push(top);
                    stack.push(top * 2);
                    break;
                case "+":
                    int first = stack.pop();
                    int second = stack.pop();
                    
                    stack.push(second);
                    stack.push(first);
                    stack.push(first + second);
                    
                    break;
                default:
                    stack.push(Integer.valueOf(op)); 
            }
        }
        
        return stack.stream().mapToInt(x -> x).sum();
    }
}