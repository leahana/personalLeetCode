# -*- coding: utf-8 -*-
"""
@Time ： 2022/11/9 10:00
@Auth ： leah_ana
@File ：scores_demo.py
@IDE ：PyCharm
@Motto：ABC(Always Be Coding)
"""
'''字典'''
# 创建字典的字面量语法
scores = {'key1': 98, 'key2': 95, 'key3': 32}
print(scores)

# 创建字典的构造器语法
items1 = dict(one=1, two=2, three=3, four=4)
# 通过zip函数将两个序列压成字典
items2 = dict(zip(['a', 'b', 'c'], '123'))
# 创建字典的推导式语法
items3 = {num: num ** 2 for num in range(1, 10)}
print(items1, items2, items3)
# 通过键可以获字典中对应的值
print(scores['key1'])
print(scores['key2'])

# 对字典中所有键值对进行遍历
for key in scores:
    print(f'{key}:{scores[key]}')
# 更新字典中的元素
scores['key1'] = 11
scores['key2'] = 22
scores.update(冷面=22, 热干面=11)
print(scores)
if '牛肉面' in scores:
    print(scores['牛肉面'])

# get方法也是通过健获取对应的值，但是可以设置默认值
print(scores.get('牛肉面', 30))

# 删除字典中的元素
print('scores:', scores)
print(scores.popitem())
print(scores.popitem())
print(scores.pop('key1', 1000))
print('scores', scores)
scores.clear()
print(scores)
