# Title:  1636. Sort Array by Increasing Frequency
# Idea:   O(n)/O(n+C)
# Complexity: O(n)/O(n+C)
# Language:Python
# Author:  Kaili Yang

# Solution1
# Python2
class Solution(object):
    def frequencySort(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        # 将列表转换成集合去重
        nums_set = set(nums)

        # 定义空字典和集合
        my_dict = {}
        my_list = []
        for item in nums_set:
            # 统计列表中每个元素出现的次数
            c = nums.count(item)

            # 将列表中的元素作为key,出现次数作为value,存到字典中
            my_dict[item] = c
        # 将字典按照value的大小升序排序,如果有多个值相同,按照key本身降序排序
        my_dict = sorted(my_dict.items(), key=lambda x: (x[1], x[0] * (-1)))
        for i in my_dict:
            for j in range(i[1]):
                # 将nums按照每个值的频率升序排序,如果有多个值的频率相同,按照数值本身将它们降序排序
                my_list.append(i[0])
        return my_list


# Solution2
# Python3
class Solution:
    def frequencySort(self, nums: List[int]) -> List[int]:
        return sorted(nums, key=lambda x:(mp[x], -x)) if (mp := Counter(nums)) else nums

