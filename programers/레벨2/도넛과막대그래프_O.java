package programers.레벨2;

class Solution {
    static int N = 1_000_000;

    public int[] solution(int[][] edges) {
        int[] ingoing = new int[N];
        int[] outgoing = new int[N];
        for(int[] edge : edges) {
            outgoing[edge[0]-1]++;
            ingoing[edge[1]-1]++;
        }
        int created = 0;
        int eight = 0;
        int stick = 0;
        for(int i=0; i<N; i++) {
            if(outgoing[i] >= 2) {
                if(ingoing[i] == 0) {
                    created = i;
                }else {
                    eight++;
                }
            }else if(outgoing[i] == 0 && ingoing[i] > 0){
                stick++;
            }
        }
        return new int[] {created+1,outgoing[created]-eight-stick,stick,eight};
    }
}
