# -*- coding: utf-8 -*-
"""
@Time ： 2022/12/9 09:19
@Auth ： leah_ana
@File ：__init__.py.py
@IDE ：PyCharm
@Motto：ABC(Always Be Coding)
"""
"""
快速排序 - 选择枢轴对元素进行划分，左边都比枢轴小，右边都比枢轴大

"""


def quick_sort(items, comp=lambda x, y: x <= y):
    items = list(items)[:]
    _quick_sort(items, 0, len(items) - 1, comp)
    return items


def _quick_sort(items, start, end, comp):
    if start < end:
        pos = _partition(items, start, end, comp)
        _quick_sort(items, start, pos - 1, comp)
        _quick_sort(items, pos + 1, end, comp)


def _partition(items, start, end, comp):
    pivot = items[end]
    i = start - 1
    for j in range(start, end):
        if comp(items[j], pivot):
            i += 1
            items[i], items[j] = items[j], items[i]
    items[i + 1], items[end] = items[end], items[i + 1]
    return i + 1


def main():
    items = [4, 2, 1, 33, 7, 8, 76, 22]
    res = quick_sort(items)
    print(res)


if __name__ == '__main__':
    main()
