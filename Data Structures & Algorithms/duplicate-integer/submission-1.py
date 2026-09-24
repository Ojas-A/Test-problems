class Solution:
    def hasDuplicate(self, nums: List[int]) -> bool:
        checkMap = {};
        for num in nums :
            if num in checkMap:
                return True;
            checkMap[num] = True;    
        return False;        


        