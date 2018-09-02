# -*- encoding: utf-8 -*-

def get_pascal_triangle(numrows):

    if numrows == 0:
        return []

    res = [[1]]
    for i in range(1,numrows+1):
        # lambda map
        # python2
        # res.append(map(lambda x,y:x+y,res[-1]+[0],[0]+res[-1]))
        res.append(list(map(lambda x,y:x+y,res[-1]+[0],[0]+res[-1])))
    return res[-1]

print(get_pascal_triangle(3))

