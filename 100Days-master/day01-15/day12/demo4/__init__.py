# -*- coding: utf-8 -*-
"""
@Time ： 2022/11/30 15:30
@Auth ： leah_ana
@File ：__init__.py.py
@IDE ：PyCharm
@Motto：ABC(Always Be Coding)
"""

"""拆分长字符串"""

import re


def main():
    poem = '窗前明月光，疑是地上霜。举头望明月，低头思故乡'
    sentence_list = re.split(r'[，。,.]', poem)
    while '' in sentence_list:
        sentence_list.remove('')
    print(sentence_list) # ['窗前明月光', '疑是地上霜', '举头望明月', '低头思故乡']


if __name__ == '__main__':
    main()
