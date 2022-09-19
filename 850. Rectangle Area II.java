
// Title:  850. Rectangle Area II
// Idea:   Array/Segment tree/Line Sweep/Ordered Set
// Complexity: Sort and search with two points O(n) and O(1) space
// Language: Java
// Author:  Kaili Yang


class Solution {
	
	class node implements Comparable<node> {
		long l,r,h;
		int d;
		public node(long l,long r,long h,int d) {
			this.l=l;
			this.r=r;
			this.h=h;
			this.d=d;
		}
		@Override
		public int compareTo(node o) {
			// TODO 自动生成的方法存根
			if(h==o.h) return 0;
			return h<o.h?-1:1;
		}
	}
	
	private int[] cnt;
	private long[] x;
	private node[] nodes;
	private long[] sum;
	
	private static int maxn=205;
	private static int mod=1000000007;
	
    public int rectangleArea(int[][] rectangles) {
    	
    	int len1=0,len2=0;
    	cnt=new int[maxn*4];
    	x=new long[maxn*4];
    	sum=new long[maxn*4];
    	nodes=new node[maxn*2+1];
    	int n=rectangles.length;
    	
    	for(int i=0;i<n;i++) {
    		x[++len1]=rectangles[i][0];
    		x[++len1]=rectangles[i][2];
    		nodes[++len2]=new node(rectangles[i][0],rectangles[i][2],rectangles[i][1],1);
    		nodes[++len2]=new node(rectangles[i][0],rectangles[i][2],rectangles[i][3],-1);
    	}
    	
    	Arrays.parallelSort(x,1,len1+1);
    	Arrays.parallelSort(nodes,1,len2+1);
    	
    	int k=1;
    	for(int i=2;i<=len1;i++)
    		if(x[i]!=x[i-1])
    			x[++k]=x[i];
    	
    	build(1,1,k-1); //k个不同的x坐标，构成了k-1个区域
    	
    	long ans=0;
    	for(int i=1;i<len2;i++) {
    		int l=find(nodes[i].l,k);
    		int r=find(nodes[i].r,k)-1;
    		if(l<=r) update(l,r,nodes[i].d,1,1,k-1);
    		ans=(ans+(long)(sum[1]*(nodes[i+1].h-nodes[i].h))%mod)%mod;
    	}
    	
    	return (int)ans;
    }
    
    private void update(int ls,int rs,int v,int id,int l,int r) {
    	
    	if(ls<=l && rs>=r) {
    		if(cnt[id]!=-1) {
    			cnt[id]+=v;	
    			sum[id]=(cnt[id]!=0?(x[r+1]-x[l]):0);
    			return;
    		}
    	}
    	
    	pushdown(id,l,r);
    	
    	int m=(l+r)/2;
    	if(ls<=m)
    		update(ls,rs,v,id*2,l,m);
    	if(rs>m)
    		update(ls,rs,v,id*2+1,m+1,r);
    	
    	pushup(id,l,r);
    	
    }
    
    private void pushdown(int id,int l,int r) {
    	
    	int m=(l+r)/2;
    	if(cnt[id]!=-1) {
    		cnt[id*2]=cnt[id*2+1]=cnt[id];
    		sum[id*2]=(cnt[id]!=0?(x[m+1]-x[l]):0);
    		sum[id*2+1]=(cnt[id]!=0?(x[r+1]-x[m+1]):0);
    	}
    	
    }
    
    private int find(double key,int n) {
    	
    	int l=1,r=n;
    	while(l<=r) {
    		int m=(l+r)/2;
    		if(x[m]==key)
    			return m;
    		else if(x[m]>key)
    			r=m-1;
    		else
    			l=m+1;
    	}
    	
    	return -1;
    	
    }
    
    private void build(int id,int l,int r) {
    	
    	if(l==r) {
    		cnt[id]=0;
    		sum[id]=0;
    		return;
    	}
    	int m=(l+r)/2;
    	build(id*2,l,m);
    	build(id*2+1,m+1,r);
    	pushup(id,l,r);
    	
    }
    
    private void pushup(int id,int l,int r) {
    	
    	if(cnt[id*2]==-1 || cnt[id*2+1]==-1)
    		cnt[id]=-1;
    	else if(cnt[id*2]!=cnt[id*2+1])
    		cnt[id]=-1;
    	else
    		cnt[id]=cnt[id*2];
    	sum[id]=sum[id*2]+sum[id*2+1];
    	
    }
}