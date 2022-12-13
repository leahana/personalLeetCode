# -*- coding: utf-8 -*-
"""
@Time ： 2022/12/12 10:30
@Auth ： leah_ana
@File ：__init__.py.py
@IDE ：PyCharm
@Motto：ABC(Always Be Coding)
"""
import pyasn1.type.tag

"""
😄将函数视为"一等公民"
    - 函数可以赋值给变量
    - 函数可以作为函数的参数
    - 函数可以作为函数的返回值
"""


def test01():
    """
    🤯高阶函数的用法(filter，map以及他们的替代品)
    """
    items1 = list(map(lambda x: x ** 2, filter(lambda x: x % 2, range(1, 10))))
    items2 = [x ** 2 for x in range(1, 10) if x % 2]
    return items1, items2





"""
位置参数，可变参数，关键字参数，命名关键字参数
参数的元信息（代码可读性的问题）
匿名函数和内联函数的用法（lambda函数）
闭包和作用域的问题
python搜索变量的LEGB顺序 Local>>>Embedded>>>Global>>>Built-in
global 和 nonlocal关键字的作用
global - 声明或定义全局变量（要么直接使用现有的全局作用域变量 ，要么定义一个变量放到全局作用域）
nonlocal - 生命使用嵌套作用域的变量（嵌套作用域必须存在该变量，否则报错）

"""
"""
装饰器函数（使用装饰器或取消装饰器）
装饰器是一个函数，主哟是作用是用来包装另一个函数或类
包装的目的是在不改变原函数名的情况下，改变被包装函数（对象）的行为
装饰器函数：指一个装饰器传入一个函数，返回的也是一个函数
装饰器本质上是一个Python函数，他可以让其他函数在不需要做任何代码变动的前提下增加额外功能，
装饰器的返回值是一个函数对象。他经常用于有切面需求的场景，比如：插入日志，性能测试，事务管理，
缓存校验等场景。有了装饰器，就可以抽离出大量与函数功能本身无关的雷同代码并继续重用

语法：
def 装饰器函数名（参数):
    函数块
    return 函数对象

带装饰器函数语法：
@装饰器函数名[(装饰器函数传参)<换行>]
def 函数名(参数列表)：
    语句快

例： 输出函数执行时间的装饰器
"""
import time


def check_time(fn):
    def myplay(t, f):
        n1 = time.time()
        fn(t, f)
        n2 = time.time()
        print("总共花费事件", n2 - n1)

    return myplay


@check_time
def play(Title, frame):
    print('正在播放', Title, "的", frame)
    time.sleep(2)


def main():
    # items1, items2 = test01()
    # print(items1)
    # print(items2)
    play("猫和老鼠",1)
    play("猫和老鼠",2)
    play("猫和老鼠",3)


if __name__ == '__main__':
    main()
