# -*- coding: utf-8 -*-
"""
@Time ： 2022/11/9 14:57
@Auth ： leah_ana
@File ：p4.py
@IDE ：PyCharm
@Motto：ABC(Always Be Coding)
"""
'''练习4：设计一个函数返回传入列表中最大的和第二大的元素的值'''


def max2(x):
    m1, m2 = (x[0], x[1]) if x[0] > x[1] else (x[1], x[0])
    for index in range(2, len(x)):
        if x[index] > m1:
            m2 = m1
            m1 = x[index]
        elif x[index] > m2:
            m2 = x[index]
    return m1, m2
