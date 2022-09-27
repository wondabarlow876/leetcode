# 448. Find All Numbers Disappeared in an Array
# python3

class Solution:
    def missingTwo(self, nums: List[int]) -> List[int]:
        return list(set(range(1, len(nums) + 3)) - set(nums))
    
    
class Solution:
    def misstingTwo(self, nums: List[int] -> List[int]:
        return list(set(range(1, len(nums) + 3)) - set(nums))