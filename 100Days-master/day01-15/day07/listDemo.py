# -*- coding: utf-8 -*-
"""
@Time ： 2022/11/8 10:09
@Auth ： leah_ana
@File ：listDemo.py
@IDE ：PyCharm
@Motto：ABC(Always Be Coding)
"""
import sys

list1 = [1, 3, 5, 7, 100]
print(list1)  # [1, 3, 5, 7, 100]

# 乘号表示列表元素的重复
list2 = ['hello'] * 3
print(list2)  # ['hello', 'hello', 'hello']

# 计算列表长度 ,元素个数  java: list.size()  array.length()
print(len(list1))  # 5

# 索引运算
print(list1[0])  # 1
print(list1[4])  # 100
# print(list1(5))  # IndexError : list index out of range  索引越界
print(list1[-1])  # 100
print(list1[-3])  # 5

list1[2] = 300
print(list1)  # [1, 3, 300, 7, 100]

# 循环下标遍历元素
for index in range(len(list1)):
    print(list1[index])
# 通过for循环遍历列表元素
for elem in list1:
    print(elem)
# 通过enumerate函数处理列表后在遍历可以同时获取元素索引和值
for index, elem in enumerate(list1):
    print(index, elem)

# 向集合中添加元素以及移除元素
list1.append(200)  # 在最后添加
list1.insert(1, 400)  # 在指定索引处添加
print(list1)

# 合并两个列表
list1.extend([10000, 20000])
list1 += [100000, 200000]
print(list1)  # [1, 400, 3, 300, 7, 100, 200, 10000, 20000, 100000, 200000]
print(len(list1))  # 11

# 通过成员运算判断元素是否在列表中，如果存在就删除该元素
if 3 in list1:
    list1.remove(3)
if 1234 in list1:
    list1.remove(1234)
print(list1)

list1.pop(0)
list1.pop(len(list1) - 1)
print(list1)
# 清空列表元素
list1.clear()
print(list1)

fruits = ['grape', 'apple', 'strawberry', 'waxberry']
fruits += ['pitaya', 'pear', 'mango']
# 列表切片
fruits2 = fruits[1:4]
print(fruits2)  # ['apple', 'strawberry', 'waxberry']

# 可以通过完整切片操作来复制列表
fruits3 = fruits[:]
print(fruits3)  # ['grape', 'apple', 'strawberry', 'waxberry', 'pitaya', 'pear', 'mango']

fruits4 = fruits[-3:-1]
print(fruits4)  # ['pitaya', 'pear']

# 可以通过返回反向切片操作来获得倒转后列表的拷贝
fruits5 = fruits[::-1]
print(fruits5)  # ['mango', 'pear', 'pitaya', 'waxberry', 'strawberry', 'apple', 'grape']

'''排序'''
print('排序')
list1 = ['orange', 'apple', 'zoo', 'internationalization', 'blueberry']
list2 = sorted(list1)
# sorted函数返回列表排序后的拷贝不会修改传入的列表
# 函数的设计 就应该像sorted函数一样经可能不产生副作用
list3 = sorted(list1, reverse=True)
list4 = sorted(list1, key=len)

print(list1)
print(list2)
print(list3)
print(list4)
# 给列表对象发出排序消息直接在列表对象上进行排序
list1.sort(reverse=True)
print(list1)

''' 生成式和生成器'''
f = [x for x in range(1, 10)]
print(f)
f = [x + y for x in 'ABCDE' for y in '1234567']
print(f)
# 用列表的生成表达式语法创建列表容器
# 用这种语法创建列表之后元素已经准备就绪所以需哟啊耗费较多的内存空间
f = [x ** 2 for x in range(1, 1000)]
print(sys.getsizeof(f))  # 查看对象占用内存的字节数
print(f)
# 请注意下面的代码创建的不是一个列表而是一个生成器对象
# 通过生成其可以获取到数据但他不占用额外的空间储存数据
# 每次需要数据的时候就通过内部的运算得到数据（需要花费额外的时间）
f = (x ** 2 for x in range(1, 1000))
print(sys.getsizeof(f))
print(f)
for val in f:
    print(val)


def fib(n):
    a, b = 0, 1
    for _ in range(n):
        a, b = b, a + b
        yield a


def main():
    for val in fib(20):
        print(val)


if __name__ == '__main__':
    main()
