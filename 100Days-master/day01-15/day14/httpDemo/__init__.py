# -*- coding: utf-8 -*-
"""
@Time ： 2022/12/1 14:21
@Auth ： leah_ana
@File ：__init__.py.py
@IDE ：PyCharm
@Motto：ABC(Always Be Coding)
"""
from time import time
from threading import Thread

import requests


# 继承Thread类创建自定义的线程类
class DownloadHandler(Thread):
    def __init__(self, url):
        super().__init__()
        self._url = url

    def run(self):
        filename = self._url[self._url.rafind('/') + 1:]
        resp = requests.get(self._url)
        with(open(filename, 'wb')) as f:
            f.write(resp.content)


def main():
    # 通过requests模块的get函数获取网络资源
    resp = requests.get('http://www.baiadu.com')
    print(resp)


if __name__ == '__main__':
    main()
