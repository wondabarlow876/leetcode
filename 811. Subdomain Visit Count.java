class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String,Integer> map = new HashMap<>();
        List<String> res = new ArrayList<>();
        //遍历给我们的cpdomains数组
        for(String cpdomain : cpdomains){
            //取出每个cpdomain的次数count，转换成整型
            //1.先将cpdomain用空格号分割，分割后的数组为["次数"，"域名"]
            //2.将次数取出转换成int
            int count = Integer.valueOf(Arrays.asList(cpdomain.split(" ")).get(0));
            //把每个cpdomain中的域名部分取出来然后再用'.'号分割，装进数组里
            //1.先将cpdomain用空格号分割，分割后的数组为["次数"，"域名"]
            //2.再将字符串"域名"用'.'号分割，分割后的数组为["xxx","xxx","com"]
            String[] splited = Arrays.asList(cpdomain.split(" ")).get(1).split("\\.");
            //遍历分割后的数组，把所有可能组合成的域名和子域名拼接出来，再放进map
            //key是域名，value是出现的次数
            for(int i = 0; i < splited.length; i++){
                StringBuilder sb = new StringBuilder();
                sb.append(splited[i]);
                for(int j = i + 1; j < splited.length; j++){
                    sb.append(".").append(splited[j]);
                }
                String domain = sb.toString();
                map.put(domain,map.getOrDefault(domain,0) + count);
            }
        }
        //根据map拼接答案
        for(Map.Entry<String,Integer> entry : map.entrySet()){
            res.add(String.valueOf(entry.getValue()) + " " + entry.getKey());
        }
        return res;
    }
}