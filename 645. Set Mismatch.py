class Solution:
    def findErrorNums(self, nums):
        ln, total = len(nums), sum(set(nums))
        return [sum(nums) - total, (1 + ln) * ln // 2 - total]