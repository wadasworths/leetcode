# -*- encoding: utf-8 -*-

_dict = dict()

def twosum(nums,target):
	for key,value in enumerate(nums):
		if target - value in _dict:
			return _dict[target-value],key
		_dict[value]=key

if __name__ == '__main__':
	nums = [2, 7, 12, 17]
	target = 9
	
	res = twosum(nums, target)
	print(res)
	# return (0,1)
