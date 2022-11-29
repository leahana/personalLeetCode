# -*- coding: utf-8 -*-
"""
@Time ： 2022/11/29 15:02
@Auth ： leah_ana
@File ：__init__.py.py
@IDE ：PyCharm
@Motto：ABC(Always Be Coding)
"""
"""
python异常处理机制
调用了sys模块的exit函数退出python环境也会执行finally
exit函数实质是引发了SystemExit异常

如果不愿意在finally代码块中国呢关闭文件对象释放资源，
可以使用上下文语法 通过with关键字指定文件对象的上下文环境并在
离开上下文环境时自动释放文件资源
"""


def main():
    try:
        with open('测试.txt', 'r', encoding='utf-8') as f:
            print(f.read())
    except FileNotFoundError:
        print('无法打开指定的文件!')
    except LookupError:
        print('指定了未知的编码!')
    except UnicodeDecodeError:
        print('读取文件时解码错误!')


if __name__ == '__main__':
    main()
