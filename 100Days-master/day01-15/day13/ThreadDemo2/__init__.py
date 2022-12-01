# -*- coding: utf-8 -*-
"""
@Time ： 2022/11/30 16:01
@Auth ： leah_ana
@File ：__init__.py.py
@IDE ：PyCharm
@Motto：ABC(Always Be Coding)
"""
"""线程安全队列"""

import multiprocessing, os


def song(num, a, que):
    # 打印进程号
    print('song进程：{}'.format(os.getpid()))
    for i in range(num):
        a = a + 1
        # 往队列中添加数据
        que.put(a)


def dance(num, a, que):
    # 打印进程号
    print('dance进程：{}'.format(os.getpid()))
    while True:
        # 从队列中取出数据
        a = que.get()
        print(a)
        # 当队列为空时que.empty()=True，结束取队列中取数据的操作
        if que.empty():
            print('结束队列')
            break


def main():
    a = 0
    # 创建一个队列，实现进程间通信
    que = multiprocessing.Queue(10)
    # 实例化两个进程，并启动
    # target指向函数，args后面跟元组格式的参数，当作实际参数传入函数中
    multiprocessing.Process(target=song, args=(10, a, que)).start()
    multiprocessing.Process(target=dance, args=(10, a, que)).start()
    # 打印进程号
    print('主进程：{}'.format(os.getpid()))
    que.close()


if __name__ == '__main__':
    main()
