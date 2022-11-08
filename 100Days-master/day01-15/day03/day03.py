# -*- coding: utf-8 -*-
"""
@Time ： 2022/8/30 12:10
@Auth ： leah_ana
@File ：day03.py
@IDE ：PyCharm
@Motto：ABC(Always Be Coding)
"""

# username = str(input('username = '))
# password = str(input('password = '))
#
# if username == 'admin' and password == '123456':
#     print('登录成功')
# else:
#     print("登陆失败")

"""
分段函数求值

        3x - 5  (x > 1)
f(x) =  x + 2   (-1 <= x <= 1)
        5x + 3  (x < -1)
"""
x = float(input('x = '))
if x > 1:
    y = 3 * x - 5
elif x > 1:
    y = 5 * x + 3
else:
    y = x + 2
# f'{a:.1f}华氏度 = {b:.1f}摄氏度'
print('f(%.2f)=%.2f' % (x, y))

# 英制单位音痴和公制单位厘米互换
# value = float(input('请输入长度：'))
# unit = input('请输入单位：')
# if unit == 'in' or unit == '英寸':
#     print('%f英寸=%f厘米' % (value, value * 2.54))
# elif unit == 'cm' or unit == '厘米':
#     print('%f厘米=%f英寸' % (value, value / 2.54))
# else:
#     print('请输入有效单位')
# 练习2：百分制成绩转换为等级制成绩。
# **要求**：如果输入的成绩在90分以上（含90分）输出A；80分-90分（不含90分）
# 输出B；70分-80分（不含80分）输出C；60分-70分（不含70分）输出D；60分以下输出E。
# score = float(input('请输入成绩:'))
# if score >= 90:
#     grade = 'A'
# elif score >= 80:
#     grade = 'B'
# elif score >= 70:
#     grade = 'C'
# elif score >= 60:
#     grade = 'D'
# else:
#     grade = 'E'
# print('对应的等级是:', grade)

# 输入三边长 计算周长和面积

a = float(input('a='))
b = float(input('b='))
c = float(input('c='))
if a + b > c and b + c > a and a + c > b:
    print('周长:%f' % (a + b + c))
    p = (a + b + c) / 2
    area = (p * (p - a) * (p - b) * (p - c)) ** 0.5
    print('面积:%f' % area)
else:
    print('不能构成三角形')
