class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> studentQueue = new LinkedList<>();
        for (int student : students) {
            studentQueue.add(student);
        }

        int i = 0;
        int n = sandwiches.length;
        int loopCount = 0;

        while (i < n && loopCount != (n - i + 1)) {
            int student = studentQueue.poll();
            int sandwich = sandwiches[i];

            if (student != sandwich) {
                studentQueue.add(student);
                loopCount++;
            } else {
                i++;
                loopCount = 0;
            }
        }

        return studentQueue.size();
    }

    //students = [1,1,1,0,0,1], sandwiches = [1,0,0,0,1,1]
    //i=0 -> st = [1,1,0,0,1], san = [0,0,0,1,1]
    //i=1 -> st = [1,0,0,1,1], san = [0,0,0,1,1]
    //i=2 -> st = [0,0,1,1,1], san = [0,0,0,1,1]
    //i=3 -> st = [0,1,1,1], san = [0,0,1,1]
    //i=4 -> st = [1,1,1], san = [0,1,1]
    //deadlock
}