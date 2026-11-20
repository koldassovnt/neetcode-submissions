class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int freq = freqMap.getOrDefault(nums[i], 0);
            freq++;
            freqMap.put(nums[i], freq);
        }

        Queue<Integer> pq = new PriorityQueue<>((a, b) -> freqMap.get(a) - freqMap.get(b));

        for (int num : freqMap.keySet()) {
            pq.offer(num);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        int[] topK = new int[pq.size()];
        int i = 0;
        while(!pq.isEmpty()) {
            topK[i] = pq.poll();
            i++;
        }

        return topK;
    }
}
