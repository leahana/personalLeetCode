# -*- coding: utf-8 -*-
"""
@Time ： 2022/12/8 15:17
@Auth ： leah_ana
@File ：__init__.py.py
@IDE ：PyCharm
@Motto：ABC(Always Be Coding)
"""
"""
常用算法
"""


# 穷举法 - 又被称为暴力破解法， 对所有的可呢性进行验证，直到找到正确的答案
# 贪婪法 - 在对问题求解时，总是走出在当前看来最好的选择，不追求最优解，快速找到满意解
# 分治法 - 把一个复杂的问题分成两个或更多相同或相似的子问题，再把子问题分成更小的子问题，直到可以直接求解的程度，
#       最后将字问题的解进行合并得到原问题的解
# 回溯法 - 回溯法又被称为试探法，按选优条件向前搜索，当搜索到某一步发现原先选择并不优或达不到目标时，就退回一步重新选择
# 动态规划 - 基本思想也是将待求解问题分成若干个子问题，先求解并保存这些字问题的解，避免产生大量重复运算

# 穷举法例子

def method_01():
    """
    百元百鸡
    公鸡5元一只，母鸡3元一只，小鸡1元三只
    用100元买100只鸡， 问公鸡/母鸡/小鸡个多少只
    """
    for x in range(20):
        for y in range(33):
            z = 100 - x - y
            if 5 * x + 3 * y + z // 3 == 100 and z % 3 == 0:
                print(x, y, z)


def method_02():
    """五人分鱼
    ABCDE五人在某天夜里合伙捕鱼，最后疲惫不堪各自睡觉
    第二天A第一个醒来 他将鱼分为5份， 扔掉多余的一条， 拿走自己的一份
    B第二个醒来 也将鱼分为5份，扔掉多余的一条，拿走自己的一份
    然后CDE 依次醒来也按同样的方式分鱼，问他们至少捕了多少鱼
    """
    fish = 6
    while True:
        total = fish
        enough = True
        for _ in range(5):
            if (total - 1) % 5 == 0:
                total = (total - 1) // 5 * 4
            else:
                enough = False
                break
        if enough:
            print(fish)
            break
        fish += 5


def method_03():
    print()


def main():
    # method_01()
    method_02()


if __name__ == '__main__':
    main()
