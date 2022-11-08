# -*- coding: utf-8 -*-
"""
@Time ： 2022/9/19 16:53
@Auth ： leah_ana
@File ：day05.py
@IDE ：PyCharm
@Motto：ABC(Always Be Coding)
"""

# for num in range(100, 1000):
#     low = num % 10
#     mid = num // 10 % 10
#     high = num // 100
#     if num == low ** 3 + mid ** 3 + high ** 3:
#         print(num)
# num = int(input('num = '))
# reversed_num = 0
#
# while num > 0:
#     reversed_num = reversed_num * 10 + num % 10
#     num //= 10
# print(reversed_num)

# 水仙花数
#
# for num in range(100, 1000):
#     low = num % 10
#     mid = num // 10 % 10
#     high = num // 100
#     if num == low ** 3 + mid ** 3 + high ** 3:
#         print(num)

# 正整数的反转
# 12345 -> 54321
# num = int(input('num='))
# reversed_num = 0
# while num > 0:
#     reversed_num = reversed_num * 10 + num % 10
#     num //= 10
# print(reversed_num)
#     reversed_num = 0+5
#     num  = 1234
#      ⬇️
#     reversed_num  = 50+ 4
#     num  =123
#      ⬇️
#    reversed num = 540+3
#    num = 12
#      ⬇️
#       reversed num  = 5430+ 2;
#       num  = 1

# 百鸡百钱
# for x in range(0, 20):
#     for y in range(0, 33):
#         z = 100 - x - y
#         if 5 * x + 3 * y + z / 3 == 100:
#             print('公鸡：%d ，母鸡：%d， 小鸡：%d只' % (x, y, z))
from random import randint

money = 1000

while money > 0:
    print('你的总资产为：', money)
    needs_go_on = False
    while True:
        debt = int(input('请下注：'))
        if 0 < debt <= money:
            break
    first = randint(1, 6) + randint(1, 6)
    print('玩家摇出了%d点' % first)
    if first == 7 or first == 11:
        print('玩家胜利！')
        money += debt
    elif first == 2 or first == 3 or first == 12:
        print('庄家胜利！')
        money -= debt
    else:
        needs_go_on = True
    while needs_go_on:
        needs_go_on = False
        current = randint(1, 6) + randint(1, 6)
        print('玩家摇出了%d点' % current)
        if current == 7:
            print('庄家胜利！')
            money -= debt
        elif current == first:
            print('玩家胜利！')
            money += debt
        else:
            needs_go_on = True
print("你破产了 游戏结束")
