# -*- coding: utf-8 -*-
"""
@Time ： 2022/11/30 15:24
@Auth ： leah_ana
@File ：__init__.py.py
@IDE ：PyCharm
@Motto：ABC(Always Be Coding)
"""
"""
替换字符串的不良内容
"""
import re


def main():
    sentence = '你是傻比吗？我草你md。Fuck you'
    purified = re.sub('[操草艹肏]|fuck|shit|傻[比屄逼叉缺吊屌]|煞笔|tmd|md',
                      '*', sentence, flags=re.IGNORECASE)
    print(purified)


if __name__ == '__main__':
    main()