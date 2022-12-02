# -*- coding: utf-8 -*-
"""
@Time ： 2022/12/1 14:55
@Auth ： leah_ana
@File ：clintDemo.py
@IDE ：PyCharm
@Motto：ABC(Always Be Coding)
"""
from socket import socket


def main():
    # 1.创建套接字对象默认使用IPv4和TCP协议
    client = socket()
    # 2.连接到服务器（需要指定IP地址和端口）
    client.connect(('127.0.0.1', 6789))
    # 3.从服务器接收数据
    # print(client.recv(1024).decode('utf-8'))
    client.connect()

if __name__ == '__main__':
    main()
