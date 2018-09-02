# -*- encoding: utf-8 -*-

def maxSubArray(nums):
	maxSum = curSum = nums[0]
	for i in range(1, len(nums)):
		curSum = max(nums[i],curSum+nums[i])
		maxSum = max(maxSum, curSum)
	return maxSum

print(maxSubArray([-2,1,-3,4,-1,2,1,-5,4]))
