# -*- coding: utf-8 -*-
"""
@Time ： 2022/12/1 09:39
@Auth ： leah_ana
@File ：__init__.py.py
@IDE ：PyCharm
@Motto：ABC(Always Be Coding)
"""

import time
import tkinter
import tkinter.messagebox


def download():
    # 模拟下载任务需要花费10秒钟事件
    time.sleep(10)
    tkinter.messagebox.showinfo('提示', '下载完成！')


def show_about():
    tkinter.messagebox.showinfo('关于', '测试(v1.0)')


def main():
    top = tkinter.Tk()
    top.title('单线程')
    top.geometry('200x150')
    top.wm_attributes('-topmost', True)

    panel = tkinter.Frame(top)
    button1 = tkinter.Button(panel, text='下载', command=download)
    button1.pack(side='left')
    button2 = tkinter.Button(panel, text='关于', command=show_about)
    button2.pack(side='right')
    panel.pack(side='bottom')
    tkinter.mainloop()

if __name__ == '__main__':
    main()