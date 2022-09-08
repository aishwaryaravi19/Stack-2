// Time Complexity: O(n + m), where m is the number of logs, and n is the number of functions
// Space Complexity : O(m/2) = O(m), as we are pushing and popping from the stack
// Did this code successfully run on Leetcode: Yes
// Any problem you faced while coding this: No

//If the function type is start, update the stack peek(prev function id) with its value (end - start  i.e., curr -prev)
//and push the current function id to the stack, update previous to current

//If the function type is end, pop the function id from the stack and update its value (curr + 1 - prev) since it's an end function
//update previous to current + 1, since it's end function

class ExclusiveTimeFunctions {
    public int[] exclusiveTime(int n, List<String> logs) {
        if(n == 0) return new int[]{};

        Stack<Integer> s = new Stack<>();
        int[] result = new int[n];
        int prev = 0, curr = 0;

        for(String log: logs) {

            String[] splitArray = log.split(":");
            String functionType = splitArray[1];
            curr =  Integer.parseInt(splitArray[2]);

            if(functionType.equals("start")) {

                int functionId = Integer.parseInt(splitArray[0]);
                if(!s.isEmpty()) {
                    result[s.peek()] += curr - prev;
                }
                s.push(functionId);
                prev = curr;

            } else {
                result[s.pop()] += curr + 1 - prev;
                prev = curr + 1;
            }
        }
        return result;

    }
}
