# -*- coding: utf-8 -*-
"""
@Time ： 2022/11/16 14:08
@Auth ： leah_ana
@File ：Person.py
@IDE ：PyCharm
@Motto：ABC(Always Be Coding)
"""
"""_slots_魔法"""


class Person(object):
    # 限定Person对象只能绑定_name,_age和_gender属性
    __slots__ = ('_name', '_age', '_gender')

    def __init__(self, name, age):
        self._name = name
        self._age = age

    @property
    def name(self):
        return self._name

    @property
    def age(self):
        return self._age

    @age.setter
    def age(self, age):
        self._age = age

    def play(self):
        if self._age < 16:
            print('%s正在玩飞行棋' % self.name)
        else:
            print('%s正在玩斗地主' % self.name)


def main():
    person = Person('大锤', 22)
    person.play()
    person._gender = '男'


if __name__ == '__main__':
    main()
