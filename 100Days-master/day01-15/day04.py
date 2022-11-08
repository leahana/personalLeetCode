# -*- coding: utf-8 -*-
"""
@Time ： 2022/8/30 15:10
@Auth ： leah_ana
@File ：day04.py
@IDE ：PyCharm
@Motto：ABC(Always Be Coding)
"""
# for循环实现1-100求和

# sum = 0
# for x in range(101):
#     sum += x
#     print(sum)
#
# import random
#
# answer = random.randint(1, 100)
# count = 0
#
# while True:
#     count += 1
#     number = int(input('请输入:'))
#     if number < answer:
#         print('大一点')
#     elif number > answer:
#         print('小一点')
#     else:
#         print('猜对了')
#         break
# print('你总共猜了%d次' % count)
# if count > 7:
#     print("您的智商余额不足")


'''
输入两个正整数 计算他们的最大公约数和最小公倍数
'''
# x = int(input('x='))
# y = int(input('y='))
#
# if x > y:
#     x, y = y, x
#
# # 从两个数中较小的数字开始做递减循环
#
# for factor in range(x, 0, -1):
#     if x % factor == 0 and y % factor == 0:
#         print('%d和%d的最大公约数是%d' % (x, y, factor))
#         print('%d和%d的最小公倍数是%d' % (x, y, x * y // factor))
#         break
'''
打印三角图案
'''
row = int(input('请输入行数:'))
# for i in range(row):
#     for _ in range(i + 1):
#         print('*', end='')
#     print()

for i in range(row):
    for j in range(row):
        if j < row - i - 1:
            print(' ', end='')
        else:
            print('*', end='')
    print()

for i in range(row):
    for _ in range(row - i - 1):
        print(' ', end='')
    for _ in range(2 * i + 1):
        print("*", end='')
    print()


# import os
# import numpy as np
# import time
# import pandas as pd

# path = "/Users/anshengyo/Library/Containers/com.tencent.xinWeChat/Data/Library/Application Support/com.tencent.xinWeChat/2.0b4.0.9/70044106a5788ec990586d42ea0ea157/Message/MessageTemp/30970685c11c0d3806099461e9db817a/File/1/recv"
# files = os.listdir(path)
# i = 0
# for file in files:
#     old = path + os.sep + files[i]
#     file.replace()
#     new = path + os.sep + file.replace('&', '-')
#     os.rename(old, new)
#     i += 1
# def timeStamp (timeNum):
#     """
#     Description:
#         unix 时间戳(13位)转化为datetime
#     -----------
#     Parameters:
#         timeNum : 时间戳
#     -----------
#     Returns:
#        otherStyleTime : datetime
#     """
#     if timeNum == 0:
#         otherStyleTime = np.nan
#     else:
#         timestamp = float(timeNum / 1000)
#         timeArray = time.localtime(timestamp)
#         otherStyleTime = time.strftime("%Y-%m-%d %H:%M:%S", timeArray)
#     return otherStyleTime

#
# file_path = '/Users/anshengyo/Downloads/1/recv'
# all_txt_data = pd.DataFrame()
# file_num = 1
# for file in os.listdir(file_path):
#     if file.endswith(".txt"):
#         file_new = int(file.split('.')[0])
#         name = str(timeStamp(file_new))
#         name = name.replace(' ', '-').replace(':', '-')
#         print('运行的文件数量,名称：', file_num, file)
#         with open(file_path + '/' + file, 'r', encoding='UTF8') as f:
#             str_data = f.read()
#         with open(file_path + '/a/' + name + '.txt', "w", encoding='utf-8') as f:
#             f.write(str(str_data))
#             f.close()
