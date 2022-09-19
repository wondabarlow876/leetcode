// Title:  609. Find Duplicate File in System
// Idea:   O(n)/O(n+C)
// Complexity: 时间复杂度：O(N)O(N)，其中 NN 是文件的总数。这里认为每个文件名的长度是常数级别的。
// 空间复杂度：O(N)O(N)。
// Language: Java
// Author:  Kaili Yang
public class Solution {
    public List < List < String >> findDuplicate(String[] paths) {
        HashMap < String, List < String >> map = new HashMap < > ();
        for (String path: paths) {
            String[] values = path.split(" ");
            for (int i = 1; i < values.length; i++) {
                String[] name_cont = values[i].split("\\(");
                name_cont[1] = name_cont[1].replace(")", "");
                List < String > list = map.getOrDefault(name_cont[1], new ArrayList < String > ());
                list.add(values[0] + "/" + name_cont[0]);
                map.put(name_cont[1], list);
            }
        }
        List < List < String >> res = new ArrayList < > ();
        for (String key: map.keySet()) {
            if (map.get(key).size() > 1)
                res.add(map.get(key));
        }
        return res;
    }
}

// 作者：LeetCode
// 链接：https://leetcode.cn/problems/find-duplicate-file-in-system/solution/zai-xi-tong-zhong-cha-zhao-zhong-fu-wen-jian-by-le/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
