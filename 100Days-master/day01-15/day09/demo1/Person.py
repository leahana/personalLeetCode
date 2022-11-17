# -*- coding: utf-8 -*-
"""
@Time ： 2022/11/16 10:50
@Auth ： leah_ana
@File ：Person.py
@IDE ：PyCharm
@Motto：ABC(Always Be Coding)
"""
"""面向对象进阶"""


class Person(object):
    def __init__(self, name, age):
        self._name = name
        self._age = age

    # 访问器 - getter方法
    @property
    def name(self):
        return self._name

    # 访问器 -  getter方法
    @property
    def age(self):
        return self._age

    # 修改器 - setter方法
    @age.setter
    def age(self, age):
        self._age = age

    def play(self):
        if self._age <= 16:
            print('%s正在玩飞行棋.' % self._name)
        else:
            print('%s正在玩斗地主' % self._name)


def main():
    person = Person('大锤', 13)
    person.play()
    person.age = 22
    person.play()
    # person.name='小锤' AttributeError: can't set attribute 没有找到setter方法


if __name__ == '__main__':
    main()
