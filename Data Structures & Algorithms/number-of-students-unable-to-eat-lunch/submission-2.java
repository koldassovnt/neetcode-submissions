class Solution {
    // public int countStudents(int[] students, int[] sandwiches) {
    //     Queue<Integer> studentQueue = new LinkedList<>();
    //     for (int student : students) {
    //         studentQueue.add(student);
    //     }

    //     int i = 0;
    //     int n = sandwiches.length;
    //     int loopCount = 0;

    //     while (i < n && loopCount != studentQueue.size()) {
    //         int student = studentQueue.poll();
    //         int sandwich = sandwiches[i];

    //         if (student != sandwich) {
    //             studentQueue.add(student);
    //             loopCount++;
    //         } else {
    //             i++;
    //             loopCount = 0;
    //         }
    //     }

    //     return studentQueue.size();
    // }
    public int countStudents(int[] students, int[] sandwiches) {
        int[] count = new int[2];
        for (int s : students) count[s]++;

        int eaten = 0;
        for (int s : sandwiches) {
            if (count[s] == 0) break;   // no one left wants this sandwich
            count[s]--;
            eaten++;
        }
        return students.length - eaten;
    }
}