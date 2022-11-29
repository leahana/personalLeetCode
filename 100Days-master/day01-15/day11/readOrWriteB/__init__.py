# -*- coding: utf-8 -*-
"""
@Time ： 2022/11/29 15:44
@Auth ： leah_ana
@File ：__init__.py.py
@IDE ：PyCharm
@Motto：ABC(Always Be Coding)
"""
"""读写二进制文件"""


def main():
    try:
        with open('IMG_7215.JPG', 'rb') as fs1:
            data = fs1.read()
            print(type(data))  # <class 'bytes'>
        with open('向生活投降.JPG', 'wb') as fs2:
            fs2.write(data)
    except FileNotFoundError as e:
        print('指定文件无法打开')
    except IOError as e:
        print('读写文件发生错误')
    print('程序执行结束')


if __name__ == '__main__':
    main()
