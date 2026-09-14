class Solution:
    def isRectangleOverlap(self, rec1, rec2):
        
        # Check if one rectangle is completely away from the other
        
        if rec1[2] <= rec2[0]:
            return False
        
        if rec2[2] <= rec1[0]:
            return False
        
        if rec1[3] <= rec2[1]:
            return False
        
        if rec2[3] <= rec1[1]:
            return False
        
        return True