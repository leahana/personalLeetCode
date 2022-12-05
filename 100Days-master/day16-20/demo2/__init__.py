# -*- coding: utf-8 -*-
"""
@Time ： 2022/12/5 14:14
@Auth ： leah_ana
@File ：__init__.py.py
@IDE ：PyCharm
@Motto：ABC(Always Be Coding)
"""
import datetime

"""排序算法"""


def select_sort(iteams, comp=lambda x, y: x < y):
    """简单选择排序"""
    iteams = iteams[:]
    for i in range(len(iteams) - 1):
        min_index = i
        for j in range(i + 1, len(iteams)):
            if comp(iteams[j], iteams[min_index]):
                min_index = j
                iteams[i], iteams[min_index] = iteams[min_index], iteams[i]
    return iteams


def bubble_sort(iteams, comp=lambda x, y: x > y):
    """冒泡排序"""
    iteams = iteams[:]
    for i in range(len(iteams) - 1):
        swapped = False
        for j in range(len(iteams) - 1 - i):
            if comp(iteams[j], iteams[j + 1]):
                iteams[j], iteams[j + 1] = iteams[j + 1], iteams[j]
                swapped = True
        if not swapped:
            break
    return iteams


def bubble_sort_plus(items, comp=lambda x, y: x > y):
    """搅拌排序（冒泡排序升级版）"""
    items = items[:]
    for i in range(len(items) - 1):
        swapped = False
        for j in range(len(items) - 1 - i):
            if comp(items[j], items[j + 1]):
                items[j], items[j + 1] = items[j + 1], items[j]
                swapped = True
        if swapped:
            swapped = False
            for j in range(len(items) - 2 - i, -1):
                if comp(items[j - 1], items[j]):
                    items[j], items[j - 1] = items[j - 1], items[j]
                    swapped = True
        if not swapped:
            break
    return items


def main():
    list1 = [5, 3, 21, 55, 6, 2, 11]
    start_time = datetime.datetime.now()
    for _ in range(100000):
        item = bubble_sort_plus(list1)
    end_time = datetime.datetime.now()
    print(list1)
    print(item)
    print(end_time - start_time)


if __name__ == '__main__':
    main()
