
class Solution {
    public boolean canTransform(String start, String end) {
        char c1[]=start.toCharArray(),c2[]=end.toCharArray();
        int p1=0,p2=0;
        while(p1<c1.length&&p2<c1.length){
            while(p1<c1.length&&c1[p1]=='X'){p1++;}
            while(p2<c1.length&&c2[p2]=='X'){p2++;}
            if(p1==p2&&p1==c1.length){return true;}
            if(p1==c1.length||p2==c2.length||c1[p1]!=c2[p2]){return false;}
            if(c1[p1]=='L'){if(p1<p2){return false;}}
            else if(p1>p2){return false;}
            p1++;
            p2++;
        }
        for(int i=p1;i<c1.length;i++){if(c1[i]!='X'){return false;}}
        for(int i=p2;i<c1.length;i++){if(c2[i]!='X'){return false;}}
        return true;
    }
}