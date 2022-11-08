# -*- coding: utf-8 -*-
"""
@Time ： 2022/10/18 15:30
@Auth ： leah_ana
@File ：day07.py
@IDE ：PyCharm
@Motto：ABC(Always Be Coding)
"""

# s1 = 'hello ,world'
# s2 = "hello, world"
# s3 = """
# hello,
# world!
# """
# print(s1, s2, s3, end='')
# print('ll' in s1)
# print('good' in s1)
'''字符串切割'''
# str3 = 'abc123456'
# print(str3[2:5])  # c12  索引2到索引5不包含5
# print(str3[2:])  # c123456  从索引2到结束
# print(str3[:5])  # abc12 到索引5不包含索引5
# print(str3[2::2])  # c246  索引2 每个间隔2个
# print(str3[::2])  # ac246  间隔两个
# print(str3[::-1])  # 654321cba 反转
# print(str3[-3:-1])  # 从索引 -1 到 -3
#
'''字符串处理'''
str1 = 'hello, world!'
# # 通过内置函数len 计算字符串长度
# print(len(str1))  # 13
#
# # 获得字符串首字母大写的拷贝
# print(str1.capitalize())  # Hello, world!
#
# # 获得字符串每个单词首字母大写后的拷贝
# print(str1.title())  # Hello, World!
#
# # 获得字符串大写后的拷贝
# print(str1.upper())  # HELLO,WORLD!
#
# # 从字符串中查找子串所在位置
# print(str1.find('or'))  # 8
# print(str1.find('shit'))  # -1
#
# # 与find类似但找不到子串时会引发异常
# print(str1.index('or'))
# # print(str1.index('shit'))
#
# # 检查字符串是否一指定的字符串开头
# print(str1.startswith('He'))  # False
# print(str1.startswith('hel'))  # True
#
# # 检查字符串是否以指定的字符串结尾
# print(str1.endswith('!'))  # True
#
# # 将字符串以指定的宽度居中并在两侧填充指定字符
# print(str1.center(50, '*'))
#
# # 将字符串以指定的宽度靠右放置左侧填充指定的字符
# print(str1.rjust(50, ' '))
#
# str2 = 'abc123456'
# # 检查字符串是否由数字构成
# print(str2.isdigit())  # False
# # 检查字符串是否以`c字母构成
# print(str2.isalpha())  # False
# # 检查字符串是否由数字和字母构成
# print(str2.isalnum())  # True
# str3 = '   abcd12345 '
# print(str3)
# # 获得字符串修建前后两侧空格之后的拷贝
# print(str3.strip())


a, b = 5, 10
print('%d * %d = %d' % (a, b, a * b))

'''字符串提供的方法来完成字符串的格式'''
a, b = 5, 10
print('{0} *{1} = {2}'.format(a, b, a * b))

'''Python 3.6 之后 字符串更简介的书写方式， 就是在字符串前加上字母f，我们可以使用下面语法糖来简化上面的代码'''
a, b = 5, 10
print(f'{a}*{b}={a*b}')












