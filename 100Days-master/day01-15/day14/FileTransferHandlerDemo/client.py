# -*- coding: utf-8 -*-
"""
@Time ： 2022/12/2 14:05
@Auth ： leah_ana
@File ：client.py
@IDE ：PyCharm
@Motto：ABC(Always Be Coding)
"""

from socket import socket
from json import loads
from base64 import b64encode


def main():
    client = socket()
    client.connect(('127.0.0.1', 5566))
    # 定一个保存二进制数据的对象
    in_data =bytes()
    # 不知道服务器发送的数据有多大每次接收1024字节
    data = client.recv(1024)

    while data:
        # 将收到的数据拼接起来
        in_data +=data
        data= client.recv(1024)
    # 将收到的二进制数据解析成json字符串并转换成字典
    # loads函数的作用就是将JSON字符串转成字典对象
    my_dict = loads(in_data.decode('utf-8'))
    filename = my_dict['filename']
    filedata = my_dict['filedata'].encode('utf-8')
    with open(filename,'wb') as f:
        # 将base64格式的数据解码成二进制数据并写入文件
        f.write(b64encode(filedata))
    print('已保存')


if __name__ == '__main__':
    main()

