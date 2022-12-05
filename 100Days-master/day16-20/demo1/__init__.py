# -*- coding: utf-8 -*-
"""
@Time ： 2022/12/5 09:19
@Auth ： leah_ana
@File ：__init__.py.py
@IDE ：PyCharm
@Motto：ABC(Always Be Coding)
"""


def test1():
    """
    生成式，推导式
    """
    prices = {
        'A': 10.22,
        'B': 22.33,
        'C': 33.44,
        'D': 44.55,
        'E': 55.66,
        'F': 66.77
    }
    # 用价格高于44的构造一个新的字典
    prices2 = {
        key: value for key, value in prices.items() if value > 44
    }
    # lambda？警觉
    print('prices', prices)
    print('prices2', prices2)


def test2():
    """
    嵌套列表的坑
    """
    names = ['关羽', '张飞', '赵云', '马超', '黄忠']
    courses = ['语文', '数学', '英语']

    #  录入五个学生的三门成绩
    scores = [[None] * len(courses)] * len(names)
    scores = [[None] * len(courses) for _ in range(len(names))]
    for row, name in enumerate(names):
        for col, course in enumerate(courses):
            scores[row][col] = float(input(f'请输入{name}的{course}成绩: '))
            print(scores)


import heapq


def test_heapq():
    """
    从列表中找出最大的或最小的N个元素
    堆结构（ 大根堆/小根堆 ）
    """
    list1 = [34, 25, 12, 99, 87, 63, 58, 78, 88, 92]
    list2 = [
        {'name': 'IBM', 'shares': 100, 'price': 91.1},
        {'name': 'AAPL', 'shares': 50, 'price': 543.22},
        {'name': 'FB', 'shares': 200, 'price': 21.09},
        {'name': 'HPQ', 'shares': 35, 'price': 31.75},
        {'name': 'YHOO', 'shares': 45, 'price': 16.35},
        {'name': 'ACME', 'shares': 75, 'price': 115.65}
    ]
    print(heapq.nlargest(3, list1))
    print(heapq.nsmallest(3, list1))
    print(heapq.nlargest(2, list2, key=lambda x: x['price']))
    print(heapq.nsmallest(2, list2, key=lambda x: x['shares']))
    # java stream.compare


import itertools


def test_itertools():
    """
    迭代工具模块
    """
    # 产生ABCD的全排列
    d1 = itertools.permutations('ABCD')
    # 产生ABCDE的五选三组合
    d2 = itertools.combinations('ABCDE', 3)
    # 产生ABCD和123的笛卡尔积
    d3 = itertools.product('ABCD', '123')
    # 产生ABC的无限循环序列
    d4 = itertools.cycle(('A', 'B', 'C'))
    # print(d1.__str__())
    # print(d2)
    # print(d3)
    # print(d4)
    print('----d1----')
    for item in d1:
        print(item)

    print('----d2----')
    for item in d2:
        print(item)

    print('----d3----')
    for item in d3:
        print(item)

    print('----d4----')
    for item in d4:
        print(item)


import collections

"""
常用的工具类
·namedtuple: 命名元组,它是一个类工厂，接收类型和名称和属性列表来创建一个类
·deque: 双端队列，是列表的替代实现，Python中的列表底层是基于数组来实现的，而deque底层是双向链表
        因此当你需要在头尾添加和删除元素时，deque会表现更好的性能，渐进时间复杂度为O(1)
·Counter : dict的子类，键时元素，值时元素的计数，他的most_common()方法可以帮助我们获取出频率最高的元素。
·OrderDict: dict的子类，它记录了键值对插入的顺序，看起来既有字典的行为，也有链表的行为。
·default-dict: 类似于字典类型，但是可以通过默认的工厂函数来获得键对应的默认值，相比字典中的setdefault()方法，
        这个更好？

"""

from collections import Counter


def test_collections():
    words = [
        'look', 'into', 'my', 'eyes', 'look', 'into', 'my', 'eyes',
        'the', 'eyes', 'the', 'eyes', 'the', 'eyes', 'not', 'around',
        'the', 'eyes', "don't", 'look', 'around', 'the', 'eyes',
        'look', 'into', 'my', 'eyes', "you're", 'under'
    ]
    counter = Counter(words)
    print(counter.most_common(3))




if __name__ == '__main__':
    # test1()
    # test2()
    # test_heapq()
    # test_itertools()
     test_collections()
