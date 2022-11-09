# -*- coding: utf-8 -*-
"""
@Time ： 2022/11/9 10:46
@Auth ： leah_ana
@File ：p1.py
@IDE ：PyCharm
@Motto：ABC(Always Be Coding)
"""
'''屏幕显示跑马灯'''

import os
import time



def mian():
    content = 'title......'
    while True:
        # 清理屏幕上的输出
        # os.system('cls')
        os.system('clear')
        print(content)
        # 休眠200毫秒
        time.sleep(0.2)
        content = content[1:] + content[0]


if __name__ == '__main__':
    mian()
