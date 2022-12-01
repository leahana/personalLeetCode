# -*- coding: utf-8 -*-
"""
@Time ： 2022/12/1 10:13
@Auth ： leah_ana
@File ：__init__.py.py
@IDE ：PyCharm
@Motto：ABC(Always Be Coding)
"""
from time import time


def main():
    total = 0
    number_list = [x for x in range(1, 100000001)]
    start = time()
    for num in number_list:
        total += num
    print(total)
    end = time()
    print('Execution time : %.3fs' % (end - start))


if __name__ == '__main__':
    main()
