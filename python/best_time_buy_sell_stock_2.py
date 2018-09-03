# -*- encoding: utf-8 -*-

def best_time_buy_sell_stock(prices):
	 return sum(max(prices[i+1]-prices[i],0) for i in range(len(prices)-1))

a = best_time_buy_sell_stock([7, 1, 5, 3, 6, 4])

print(a)
