# -*- coding: utf-8 -*-
"""
@Time ： 2022/11/29 14:38
@Auth ： leah_ana
@File ：__init__.py.py
@IDE ：PyCharm
@Motto：ABC(Always Be Coding)
"""
def main():
    f = open('测试.txt', 'r', encoding='utf-8')
    print(f.read())
    f.close()

if __name__ == '__main__':
    main()