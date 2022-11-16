# -*- coding: utf-8 -*-
"""
@Time ： 2022/11/11 16:18
@Auth ： leah_ana
@File ：Student.py
@IDE ：PyCharm
@Motto：ABC(Always Be Coding)
"""


class Student(object):
    # __init__方法是一个特殊方法用于在创建对象时进行初始化操作
    # 通过这个方法我们可以为学生对象绑定name 和age两种属性
    def __init__(self, name, age):
        self.name = name
        self.age = age

    def study(self, course_name):
        print('%s正在学习%s.' % (self.name, self.age))

    # PEP 8 要求标识符的名字用全小写多个单词用下划线连接
    # 但是大部分程序员和公司更倾向于使用驼峰命名法
    def watch_movie(self):
        if self.age < 18:
            print('%s只能观看《熊出没》.' % self.name)
        else:
            print("%s可以看看别的." % self.name)


def main():
    # 创建学生对象并指定姓名和年龄
    stu1 = Student('吉良', 33)
    # 给对象发study消息
    stu1.study('Python程序设计')
    # 给对象发watch_av消息
    stu1.watch_movie()

    stu2 = Student('大锤', 15)
    stu2.study('思想品德')
    stu2.watch_movie()


if __name__ == '__main__':
    main()
