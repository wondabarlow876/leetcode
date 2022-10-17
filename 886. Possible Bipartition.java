/*
@可爱抱抱呀
执行用时：10 ms, 在所有 Java 提交中击败了99.14%的用户
内存消耗：48.4 MB, 在所有 Java 提交中击败了86.85%的用户
2022年4月29日 20:33
*/
class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        int group[]=new int[2005];
        Arrays.fill(group,-1);
        List<Integer>[] hate=new List[2005];
        for(int i=1;i<=2000;i++){hate[i]=new ArrayList<>();}
        for(int i=0;i<dislikes.length;i++){
            hate[dislikes[i][0]].add(dislikes[i][1]);
            hate[dislikes[i][1]].add(dislikes[i][0]);
        }
        Queue<int[]> q=new LinkedList<>();
        for(int i=1;i<=n;i++){
            if(group[i]!=-1){continue;}
            group[i]=0;
            q.add(new int[]{i,0});
            while(q.size()>0){
                int a[]=q.poll();
                for(int j=0;j<hate[a[0]].size();j++){
                    int b=hate[a[0]].get(j);
                    if(group[b]==a[1]){return false;}
                    if(group[b]==-1){
                        group[b]=1-a[1];
                        q.add(new int[]{b,group[b]});
                    }
                }
            }
        }
        return true;
    }
}