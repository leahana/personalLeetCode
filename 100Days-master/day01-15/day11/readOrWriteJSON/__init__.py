# -*- coding: utf-8 -*-
"""
@Time ： 2022/11/29 15:44
@Auth ： leah_ana
@File ：__init__.py.py
@IDE ：PyCharm
@Motto：ABC(Always Be Coding)
"""
"""读写JSON文件

json模块的四个重要函数
dump - 将Python对象按照JSON格式序列化到文件中
dumps - 将Python对象处理成JSON格式的字符串
load - 将文件中的JSON数据反序列化成对象
loads - 将字符串的内容反序列化成Python对象

序列化：serialization
    将数据结构或对象状态转换为可以储存或传输的形式
    这样在需要的时候能够恢复到原先的状态，而且通过反序列化的数据重新获取字节时，
    可以利用这些字节来产生元史对象的副本（拷贝）。
反序列化：deserialization
    整个过程相反的动作，即从一系列字节中提取数据结构的操作，就是反序列化


"""

import json


def main():
    dict_demo = {
        'name': '张三',
        'age': 24,
        'id': 9527,
        'friends': ['李四', '王二'],
        'cars': [
            {'brand': 'BYD', 'max_speed': 180},
            {'brand': 'Audi', 'max_speed': 280},
            {'brand': 'Benz', 'max_speed': 320}
        ]
    }

    try:
        with open('data.json', 'w', encoding='utf-8') as fs:
            json.dump(dict_demo, fs)
    except IOError as e:
        print(e)
    print('数据保存完成！')



if __name__ == '__main__':
    main()

