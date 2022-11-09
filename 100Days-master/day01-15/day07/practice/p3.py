# -*- coding: utf-8 -*-
"""
@Time ： 2022/11/9 14:43
@Auth ： leah_ana
@File ：p3.py
@IDE ：PyCharm
@Motto：ABC(Always Be Coding)
"""
'''练习3：设计一个函数但会给定文件名的后缀名'''


def get_suffix(filename, has_dot=False):
    """
    获取文件名的后缀名
    :param filename: 文件名
    :param has_dot: 返回的后缀名是否需要节点
    :return: 文件的后缀名
    """
    pos = filename.rfind('.')
    if 0 < pos < len(filename) - 1:
        index = pos if has_dot else pos + 1
        return filename[index:]
    else:
        return ''


print(get_suffix('name.txt', True))

