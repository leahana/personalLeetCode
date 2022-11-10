# -*- coding: utf-8 -*-
"""
@Time ： 2022/11/10 09:22
@Auth ： leah_ana
@File ：p6.py
@IDE ：PyCharm
@Motto：ABC(Always Be Coding)
"""


def main():
    num = int(input('Number of rows :'))
    yh = [[]] * num
    for row in range(len(yh)):
        yh[row] = [None] * (row + 1)
        for col in range(len(yh[row])):
            if col == 0 or col == row:
                yh[row][col] = 1
            else:
                yh[row][col] = yh[row - 1][col] + yh[row - 1][col - 1]
            print(yh[row][col], end='\t')
        print()


if __name__ == '__main__':
    main()
