# -*- coding: utf-8 -*-
"""
@Time ： 2022/11/29 15:14
@Auth ： leah_ana
@File ：__init__.py.py
@IDE ：PyCharm
@Motto：ABC(Always Be Coding)
"""

"""
for-in循环逐行读取或用readlines方法将文件按行读取到一个列表容器中
"""

import time


def main():
    # 一次性读取整个文件内容
    with open('测试.txt', 'r', encoding='utf-8') as f:
        print(f.read())

    # 通过for-in循环读取
    with open('测试.txt', mode='r') as f:
        for line in f:
            print(line, end='')
            time.sleep(0.5)
    print()

    # 读取文件到列表中
    with open('测试.txt') as f:
        lines = f.readlines()
    print(lines)
    print('----')
    print(lines[0])
    print(lines[1])

if __name__ == '__main__':
    main()
