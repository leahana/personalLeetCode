# -*- coding: utf-8 -*-
"""
@Time ： 2022/11/23 16:38
@Auth ： leah_ana
@File ：Pet.py
@IDE ：PyCharm
@Motto：ABC(Always Be Coding)
"""

from abc import ABCMeta, abstractmethod


class Pet(object, metaclass=ABCMeta):
    """宠物"""

    def __init__(self, nickname):
        self._nickname = nickname

    @abstractmethod
    def make_voice(self):
        """发出声音"""
        pass


class Dog(Pet):
    """狗"""

    def make_voice(self):
        print('%s:汪汪汪汪...' % self._nickname)


class Cat(Pet):
    """猫"""

    def make_voice(self):
        print('%s:喵喵喵喵...' % self._nickname)


def main():
    pets = [Dog('旺财'), Cat('小黑'), Dog('大黄')]
    for pet in pets:
        pet.make_voice()


if __name__ == '__main__':
    main()
