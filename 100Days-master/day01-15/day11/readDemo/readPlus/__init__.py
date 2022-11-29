# -*- coding: utf-8 -*-
"""
@Time ： 2022/11/29 14:50
@Auth ： leah_ana
@File ：__init__.py.py
@IDE ：PyCharm
@Motto：ABC(Always Be Coding)
"""


def main():
    f = None
    try:
        f = open('测试.txt', 'r', encoding='utf-8')
        print(f.read())
    except FileNotFoundError:
        print('无法打开指定的文件')
    except LookupError:
        print('指定了未知的编码')
    except UnicodeDecodeError:
        print('读取文件时编码错误')
    finally:
        if f:
            f.close()


if __name__ == '__main__':
    main()
