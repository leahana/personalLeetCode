# -*- coding: utf-8 -*-
"""
@Time ： 2022/11/30 14:59
@Auth ： leah_ana
@File ：__init__.py.py
@IDE ：PyCharm
@Motto：ABC(Always Be Coding)
"""

"""正则表达式


验证输入用户名和QQ号是否有效并给出对应的提示信息
要求：用户名必须由字母，数字或下划线构成且长度在6-20个字符之间，QQ号是5-12的数字且首位不能为0


"""

import re


def main():
    username = input('请输入用户名：')
    qq = input('请输入QQ号：')
    # match函数的第一个参数是正则表达式的规则字符串，正则表达式对象
    # 第二个参数是需要匹配的字符串对象

    # 字符串前加了r,表示每个字符都是原始含义，\n之类的不会被识别为转义字符
    m1 = re.match(r'^[0-9a-zA-Z]{6,20}$', username)
    if not m1:
        print('请输入有效的用户名。')
    m2 = re.match(r'^[1-9]\d{4,11}', qq)
    if not m2:
        print('请输入有效的qq号。')
    if m1 and m2:
        print('验证成功')


if __name__ == '__main__':
    main()