class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> studentQueue = new LinkedList<>();
        for (int student : students) {
            studentQueue.add(student);
        }

        int i = 0;
        int n = sandwiches.length;
        int loopCount = 0;

        while (i < n && loopCount != studentQueue.size()) {
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
}