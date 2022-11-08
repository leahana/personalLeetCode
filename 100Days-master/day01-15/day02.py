# a = 100
# b = 12.345
# c = 1 + 5j
# d = 'hello, world'
# e = True
#
# print(type(a))
# print(type(b))
# print(type(c))
# print(type(d))
# print(type(e))
#
# a = int(input('a = '))
# b = int(input('b = '))
# print('%d + %d = %d' % (a, b, a + b))
# print('%d - %d = %d' % (a, b, a - b))
# print('%d * %d = %d' % (a, b, a * b))
# print('%d / %d = %f' % (a, b, a / b))
# print('%d // %d = %d' % (a, b, a // b))
# print('%d %% %d = %d' % (a, b, a % b))
# print('%d ** %d = %d' % (a, b, a ** b))

# print('请输入温度')
# a = float(input(' a= '))
# b = (a - 32) / 1.8
# print('%.1f华氏度，%d摄氏度' % (a, b))
# print(f'{a:.1f}华氏度 = {b:.1f}摄氏度')

# print('请输入圆的半径')
# r = float(input(' r= '))
# d = 2 * 3.14 * r
# ar = 3.14 * r * r
# print(f'{ d:.2f}cm周长')
# print(f'{ ar:.2f}平方厘米面积')

print('请输入年份:')
y = int(input(' y = '))
is_leap = y % 4 == 0 and y % 100 != 0 or y % 400 == 0
print(is_leap)


