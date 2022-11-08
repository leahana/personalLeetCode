# -*- coding: utf-8 -*-
"""
@Time ： 2022/10/17 14:21
@Auth ： leah_ana
@File ：day06.py
@IDE ：PyCharm
@Motto：ABC(Always Be Coding)
"""


#
# def fac(num):
#     """求阶乘"""
#     result = 1
#     for i in range(1, num + 1):
#         result *= i
#     return result
#
#
# m = int(input('m = '))
# n = int(input('n = '))
#
# print(fac(m) // fac(n) // fac(m - n))

#
# fm = 1
#
# for num in range(1, m + 1):
#     fm *= num
#     fn = 1
# for num in range(1, n + 1):
#     fn *= num
# fm_n = 1
# for num in range(1, m - n + 1):
#     fm_n *= num
# print(fm // fn // fm_n)
# from random import randint
#
#
# def roll_dice(n=2):
#     """摇骰子"""
#     total = 0
#     for _ in range(n):
#         total += randint(1, 6)
#     return total
#
#
# def add(*args):
#     """数相加"""
#     sum = 0
#     for val in args:
#         sum += val
#
#     return sum
#
#
# # 如果没有指定参数那么使用默认值摇两颗骰子
# print(roll_dice())
#
# # 摇三颗骰子
# print(add())
# print(add(1))
# print(add(1, 2))
# print(add(1, 2, 3))
# print(add(1, 3, 5,7))
#
# # 传递参数时可以不按照规定的顺序传参
# import module1 as m1
# import module2 as m2
#
# m1.foo()
# m2.foo()
def gcd(x, y):
    """求最大公约数"""
    (x, y) = (y, x) if x > y else (x, y)
    for factor in range(x, 0, -1):
        if x % factor == 0 and y % factor == 0:
            return factor


def lcm(x, y):
    """求最小公倍数"""
    return x * y // gcd(x, y)
