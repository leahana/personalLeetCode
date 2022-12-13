# -*- coding: utf-8 -*-
"""
@Time ： 2022/12/12 15:06
@Auth ： leah_ana
@File ：__init__.py.py
@IDE ：PyCharm
@Motto：ABC(Always Be Coding)
"""
import time

"""
输出函数执行事件的装饰器
"""

from functools import wraps
from time import time


#
# def record_time(func):
#     """自定义装饰函数的装饰器"""
#
#     @wraps(func)
#     def wrapper(*args, **kwargs):
#         start = time()
#         result = func(*args, **kwargs)
#         print(f'{func.__name__}: {time() - start}秒')
#         return result
#
#     return wrapper
#
# def main ():
#     record_time(print('1111'))
#
# def record(output):
#     """可以参数化的装饰器"""
#
#     def decorate(func):
#         @wraps(func)
#         def wrapper(*args, **kwargs):
#             start = time()
#             result = func(*args, **kwargs)
#             output(func.__name__, time() - start)
#             return result
#
#         return wrapper
#
#     return decorate
#

def deco_msg(fn):
    def message_service(name, x):
        print(name, '正要办理业务')
        fn(name, x)
        print('正在给', name, '发送短信..')

    return message_service


@deco_msg
def savemoney(name, x):
    print(name, '存钱', x, '元')


def withraw(name, x):
    print(name, '取钱', x, '元')


def main():
    savemoney('小张', 200)
    savemoney('小赵', 500)
    withraw('小李', 2000)


if __name__ == '__main__':
    main()
