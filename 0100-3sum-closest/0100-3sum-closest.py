class Solution:
    # @return an integer
    def threeSumClosest(self, num, target):
        if num == None or len(num) < 3 or target == None:
            return -1
        num = sorted(num)
        minMargin = sum(num[0:3]) - target
        currMargin = 0
        for i in range(len(num) - 2):
            j = i + 1
            k = len(num) - 1
            while j < k:
                currMargin = num[i] + num[j] + num[k] - target
                if currMargin == 0:
                    return target
                if abs(currMargin) < abs(minMargin):
                    minMargin = currMargin
                if currMargin < 0:
                    j += 1
                else:
                    k -= 1
        return target + minMargin