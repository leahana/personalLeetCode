# -*- coding: utf-8 -*-
"""
@Time ： 2022/11/8 15:14
@Auth ： leah_ana
@File ：tuple_demo.py
@IDE ：PyCharm
@Motto：ABC(Always Be Coding)
"""
import sys

'''元组'''
# 定义元组
t = ('Quin', 33, True, '台湾南昌')
print(t)

# 获取元组中的元素
print(t[0])
print(t[3])

# 遍历元组中的元素
for member in t:
    print(member)

# 重新给元组赋值
# t[0] = '吉良'  # TypeError
t = ('大锤', 30, True, '云南昆明')
print(t)

# 将元组转换成列表
print('person')
person = list(t)
print(person)

# 列表是可以修改他的元素的
person[0] = '李小龙'
person[1] = 25
print(person)

# 将列表转换成元组
fruits_list = ['apple', 'banana', 'orange']
fruits_tuple = tuple(fruits_list)
print(fruits_tuple)
# 1 元组中的元素师无法修改的，事实上我们在仙姑中尤其是多线程环境中更喜欢用的是那些不变的对象
# （一方面因为对象状态不能修改，所以可以避免因此引起的不必要的程序错误，简单说就是一个不变的对象要比
#  可变的对象更加容易维护；另一方面因为没有任何一个线程能够修改不变对象的内部状态， 一个不变对西那个自动就是
#  线程安全的，这样就可以省掉处理同步化的开小。一个不变的对象可以方便的被共享访问）
#  结论： 如果不需要对元素进行添加，删除，修改的时候， 可以考虑使用元组。当然如果一个方法需要返回多个值，
#        使用元组也是不错的选择
# 2 元组在创建时间，和占用空间上都优于 列表。我们可以使用sys模块的getsizeof函数来检查储存同样元素的元组和列表
# 各占用了多少内存
list_m = [1, 2, 3, 4, 5]
tuple_m = (1, 2, 3, 4, 5)
print("list_m", sys.getsizeof(list_m))
print("tuple_m", sys.getsizeof(tuple_m))
