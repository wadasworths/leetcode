# -*- encoding: utf-8 -*-

def best_buy_sell_stock(nums):
	cur_profit = max_profit = 0
	for i in range(1,len(nums)):
		cur_profit = max(0,cur_profit+nums[i]-nums[i-1])
		max_profit = max(cur_profit, max_profit)
	return max_profit

a = best_buy_sell_stock([7, 1, 5, 3, 6, 4])

print(a)
		
