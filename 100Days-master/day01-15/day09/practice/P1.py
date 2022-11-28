# -*- coding: utf-8 -*-
"""
@Time ： 2022/11/24 09:13
@Auth ： leah_ana
@File ：P1.py
@IDE ：PyCharm
@Motto：ABC(Always Be Coding)
"""
from abc import ABCMeta, abstractmethod
from random import randint, randrange


class Fighter(object, metaclass=ABCMeta):
    """战斗者"""
    # 通过slots魔法先定对象可以绑定成员变量
    __slots__ = ('_name', '_hp')

    def __init__(self, name, hp):
        """
        初始化方法
        :param name: 名称
        :param hp: 生命值
        """
        self._name = name
        self._hp = hp

    @property
    def name(self):
        return self._name

    @property
    def hp(self):
        return self._hp

    @hp.setter
    def hp(self, hp):
        self._hp = hp if hp >= 0 else 0

    @property
    def alive(self):
        return self._hp > 0

    @abstractmethod
    def attack(self, other):
        """
        攻击
        :param other: 被攻击单位
        """
        pass


class Joker(Fighter):
    """周可儿"""

    __slots__ = ('_name', '_hp', '_mp')

    def __init__(self, name, hp, mp):
        """
        初始化方法
        :param name: 名字
        :param hp: 生命值
        :param mp: 魔法值
        """
        super().__init__(name, hp)
        self._mp = mp

    def attack(self, other):
        other.hp -= randint(15, 25)

    def huge_attack(self, other):
        """
        究极必杀技（打掉对方至少50或者四分之三的血量）
        :param other: 被攻击的对象
        :return: 使用成功返回True 否则返回False
        """
        if self._mp >= 50:
            self._mp -= 50
            injury = other.hp * 3 // 4
            injury = injury if injury >= 50 else 50
            other.hp -= injury
            return True
        else:
            self.attack(other)
            return False

    def magic_attack(self, others):
        """
        魔法攻击
        :param others : 群攻对象
        :return:  使用魔法成功发挥True 否则返回False

        """

        if self._mp > 20:
            self._mp -= 20
            for temp in others:
                temp.hp -= randint(10, 15)
        else:
            return False

    def resume(self):
        """贴贴大气功"""
        incr_point = randint(1, 10)
        self._mp += incr_point
        return incr_point

    def __str__(self):
        return '---%sjoker---\n' % self._name + \
               '生命值: %d\n' % self._hp + \
               '魔法值: %d\n' % self._mp


class Monster(Fighter):
    """怪物"""

    __slots__ = ('_name', '_hp')

    def __str__(self):
        return '~~~%s小怪兽~~~\n' % self._name + \
               '生命值: %d\n' % self._hp

    def attack(self, other):
        other.hp -= randint(10, 20)


def is_any_alive(monsters):
    """判断有没有小怪兽是活着的"""
    for monster in monsters:
        if monster.alive > 0:
            return True
        else:
            return False


def select_alive_one(monsters):
    """选中一只活着的阴影怪"""
    monsters_len = len(monsters)
    while True:
        index = randrange(monsters_len)
        monster = monsters[index]
        if monster.alive > 0:
            return monster


def display_info(joker, monsters):
    """显示奥特曼和小怪兽的信息"""
    print(joker)
    for monster in monsters:
        print(monster, end='')


def main():
    j = Joker('周可儿', 1000, 120)
    m1 = Monster('m1', 500)
    m2 = Monster('m2', 250)
    m3 = Monster('m3', 700)
    ms = [m1, m2, m3]
    fight_round = 1
    while j.alive and is_any_alive(ms):
        print('=========第%02d回合========' % fight_round)
        m = select_alive_one(ms)  # 选中一只小怪兽
        skill = randint(1, 10)  # 选择技能
        if skill <= 6:  # 60%的概率使用普通攻击
            print('%s使用普通攻击打了%s.' % (j.name, m.name))
            j.attack(m)
            print('%s的魔法值恢复了%d点.' % (j.name, j.resume()))
        elif skill <= 9:  ## 10%的概率使用魔法攻击（魔法值不足使用失败)
            if j.magic_attack(ms):
                print('%s使用了魔法攻击.' % j.name)
            else:
                print('%s使用魔法失败.' % j.name)
        else:  ## 10%的概率使用究极必杀（如果魔法值不足则使用普通攻击）
            if j.huge_attack(m):
                print('%s使用了究极必杀爆打了%s.' % (j.name, m.name))
            else:
                print('%s使用普通攻击打了%s.' % (j.name, m.name))
                # j.attack(m)
                print('%s的魔法值恢复了%d点.' % (j.name, j.resume()))
        if m.alive > 0:  ## 如果没死回击
            print('%s回击了%s.' % (m.name, j.name))
            m.attack(j)
        display_info(j, ms)  # 回合结束显示信息
        fight_round += 1
    print('\n=======战斗结束！======\n')
    if j.alive:
        print('%s战斗胜利' % j.name)
    else:
        print('输了')


if __name__ == '__main__':
    main()
