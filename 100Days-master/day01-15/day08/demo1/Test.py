# -*- coding: utf-8 -*-
"""
@Time ： 2022/11/15 16:30
@Auth ： leah_ana
@File ：Test.py
@IDE ：PyCharm
@Motto：ABC(Always Be Coding)
"""
"""Python中 属性和方法的访问全县只有两种，公开的和私有的，
如果希望属性时私有的，在给属性命名的时可以使用两个下划线作为开头"""


class Test:
    def __init__(self, foo):
        self.__foo = foo

    def __bar(self):
        print(self.__foo)
        print('__bar')


def main():
    test = Test('hello')

    # AttributeError: 'Test' object has no attribute '__bar'
    # test.__bar()
    # AttributeError: 'Test' object has no attribute '__foo'
    # print(test.__foo)


if __name__ == "__main__":
    main()
