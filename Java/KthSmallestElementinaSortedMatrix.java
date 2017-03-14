public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return -1;

        PriorityQueue<PQNode> heap = new PriorityQueue<PQNode>(k, new Comparator<PQNode>(){
                @Override
                public int compare(PQNode nodeA, PQNode nodeB){
                    if(nodeA.value < nodeB.value){
                        return -1;
                    }
                    else if(nodeA.value > nodeB.value){
                        return 1;
                    }
                    else return 0;
                }
            }
        );


        // build min heap for the first row
        for(int i = 0 ; i < matrix[0].length; i++){
            heap.offer(new PQNode(matrix[0][i], 0, i));
        }

        // get min element and extract it by k times
        int i = 0;
        PQNode minNode = null;
        while(i < k){
            minNode = heap.poll();
            int row = minNode.row + 1;
            int col = minNode.col;
            if(row < matrix.length)
                heap.offer(new PQNode(matrix[row][col], row, col));
            i++;
        }

        return minNode.value;

    }


    public static class PQNode{
        int value;
        int row;
        int col;

        PQNode(int value, int row, int col){
            this.value = value;
            this.row = row;
            this.col = col;
        }

    }

}
