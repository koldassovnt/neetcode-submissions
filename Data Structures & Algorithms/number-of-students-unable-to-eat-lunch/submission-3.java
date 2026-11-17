class Solution {
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