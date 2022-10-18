    // 排序+二分
    class Solution {
        public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
            Arrays.sort(arr2);
            int ans = 0;
            for (int i1 : arr1) {
                int low = i1 - d;
                int high = i1 + d;
                // 这里用 Arrays.binarySearch 有点作弊了
                int index1 = Arrays.binarySearch(arr2, low);
                int index2 = Arrays.binarySearch(arr2, high);
                if (index1 < 0 && index1 == index2) {
                    ans++;
                }
            }
            return ans;
        }
    }

// 方法2
// 把arr2排序，然后找到arr2中最接近arr1[i]的值
class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);
        int ans = 0;
        for (int num1 : arr1) {
            int low = num1 - d;
            int high = num1 + d;
            if (!binarySearch(arr2, low, high)) {
                ans++;
            }
        }

        return ans;
    }

    public static boolean binarySearch(int[] arr, int low, int high) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] >= low && arr[mid] <= high) {
                return true;
            } else if (arr[mid] < low) {
                left = mid + 1;
            } else if (arr[mid] > high) {
                right = mid - 1;
            }
        }

        return false;
    }
}

// 作者：longluo
// 链接：https://leetcode.cn/problems/find-the-distance-value-between-two-arrays/solution/by-longluo-19pr/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。