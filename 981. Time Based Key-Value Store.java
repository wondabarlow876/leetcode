class TimeMap {
    // 构建一个内部类，用于存储 时间戳-值 的键值对
    // 当然也可以使用HashMap，但是在get的时候需要顺序查值，还是用数组更好
    class Pair {
        String k, v; 
        int t;
        Pair (String _k, String _v, int _t) {
            k = _k; v = _v; t = _t;
        }
    }
    
    // 定义一个数据结构：hash套数组，因为一个hash主键可能有多个值，那么则使用List将那些值存起来
    Map<String, List<Pair>> map = new HashMap<>();

    // set操作
    public void set(String k, String v, int t) {
        // 寻找是否已经存在Hash主键，没有就创建一个
        List<Pair> list = map.getOrDefault(k, new ArrayList<>());
        // 值添加进list
        list.add(new Pair(k, v, t));
        // list添加进map
        map.put(k, list);
    }
    
    // get操作
    public String get(String k, int t) {
        // 首先判断是否存在HashMap主键
        List<Pair> list = map.getOrDefault(k, new ArrayList<>());
        if (list.isEmpty()){
            return "";
        }

        // 使用二分法找到，最接近 t 的 [time-value]
        int n = list.size();
        int l = 0, r = n - 1;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (list.get(mid).t <= t) {
                l = mid;
            }
            else {
                r = mid - 1;
            }
        }
        // 判断是否存在 [time-value]
        return list.get(r).t <= t ? list.get(r).v : "";
    }
}

// 作者：livorth-u
// 链接：https://leetcode.cn/problems/time-based-key-value-store/solution/981-ji-yu-shi-jian-de-jian-zhi-cun-chu-g-ehvm/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。