# -*- coding: utf-8 -*-
"""
@Time ： 2022/11/28 16:02
@Auth ： leah_ana
@File ：__init__.py.py
@IDE ：PyCharm
@Motto：ABC(Always Be Coding)
"""
"""
使用Pygame进行游戏开发

简介：
Pygame 是一个开源的python模块 ，专门用于多媒体应用(如电子游戏)的开发 ，其中 包含对图像，神兵，声音，事件，碰撞
等的支持。Pygame建立在SDL的基础上，SDL是一套跨平台的多媒体开发库，用C语言实现，被广泛应用于游戏，模拟器，播放器
等的开发。而Pygame让游戏开发这不再被底层语言舒服，可以更多的关注游戏的功能和逻辑。

"""

import pygame


def main():
    # 初始化导入的pygame中的模块
    pygame.init()
    # 初始化用于显示的窗口并设置窗口尺寸
    screen = pygame.display.set_mode((800, 600))
    # 设置当前窗口的标题
    pygame.display.set_caption('大球吃小球')
    running = True
    while running:
        # 从消息队列中获取事件并对事件进行粗粝
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                running = False


if __name__ == '__main__':
    main()
