
class Solution {
static class ArraySum {
    int[][] indices;
    int sum;

    ArraySum(int[][] indices, int sum) {
        this.indices = indices;
        this.sum = sum;
    }
}

public int kthSmallest(int[][] mat, int k) {

    int rows = mat.length;
    int cols = mat[0].length;

    PriorityQueue<ArraySum> minHeap =
        new PriorityQueue<>((a,b) -> a.sum - b.sum);

    HashSet<String> visited = new HashSet<>();

    int[][] initial = new int[rows][2];
    int initialSum = 0;

    for (int i = 0; i < rows; i++) {
        initial[i][0] = i;
        initial[i][1] = 0;
        initialSum += mat[i][0];
    }

    String initKey = Arrays.deepToString(initial);
    minHeap.offer(new ArraySum(initial, initialSum));
    visited.add(initKey);

    while (k-- > 1) {

        ArraySum curr = minHeap.poll();
        int[][] idx = curr.indices;

        for (int i = 0; i < rows; i++) {
            int col = idx[i][1];
            if (col + 1 >= cols) continue;

            int[][] newIdx = idx.clone();
            newIdx[i] = new int[]{i, col + 1};

            String key = Arrays.deepToString(newIdx);
            if (!visited.add(key)) continue;

            int newSum = curr.sum - mat[i][col] + mat[i][col + 1];
            minHeap.offer(new ArraySum(newIdx, newSum));
        }
    }

    return minHeap.peek().sum;
}
}