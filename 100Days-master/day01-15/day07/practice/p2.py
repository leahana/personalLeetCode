# -*- coding: utf-8 -*-
"""
@Time ： 2022/11/9 10:54
@Auth ： leah_ana
@File ：p2.py
@IDE ：PyCharm
@Motto：ABC(Always Be Coding)
"""
'''练习2 设计一个函数产生指定长度的验证码，验证码有大小写字母和数字构成'''

import random


def generate_code(code_len=4):
    """
    生成指定长度的验证码

    :param code_len:验证码的长度（默认4个字符）
    :return: 由大小写和数字构成的随机验证码

    """

    all_chars = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ'
    last_pos = len(all_chars) - 1
    code = ''
    # 循环4次 不需要使用到 _ 变量
    for _ in range(code_len):
        index = random.randint(0, last_pos)
        code += all_chars[index]

    return code


print(generate_code())
