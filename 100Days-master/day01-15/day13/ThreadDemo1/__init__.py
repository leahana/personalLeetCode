# -*- coding: utf-8 -*-
"""
@Time ： 2022/11/30 15:40
@Auth ： leah_ana
@File ：__init__.py.py
@IDE ：PyCharm
@Motto：ABC(Always Be Coding)
"""
from multiprocessing import Process
import multiprocessing

from time import sleep

counter = 0


def main():
    #  queue = multiprocessing.queues.Queue(20)
    Process(target=sub_task, args=('Ping',)).start()
    Process(target=sub_task, args=('Pong',)).start()


def sub_task(string):
    global counter
    while counter < 10:
        print(string, end='', flush=True)
        counter += 1
        sleep(0.01)


if __name__ == '__main__':
    main()
