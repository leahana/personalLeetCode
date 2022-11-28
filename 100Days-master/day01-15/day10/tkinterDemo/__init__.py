# -*- coding: utf-8 -*-
"""
@Time ： 2022/11/28 15:05
@Auth ： leah_ana
@File ：__init__.py.py
@IDE ：PyCharm
@Motto：ABC(Always Be Coding)
"""

import tkinter
import tkinter.messagebox


def main():
    flag = True

    """
    使用tkinter来开发GUI应用需要以下五个步骤
    1. 导入tkinter模块中我们需要的东西
    2. 创建一个顶层窗口对象并用它来承载整个GUI应用
    3. 在顶层窗口对象上添加GUI组件
    4. 通过代码将这些GUI组件的功能组合起来
    5. 进入主事件循环(main loop)
    """

    # 修改标签上的文字
    def change_label_text():
        nonlocal flag
        flag = not flag
        color, msg = ('red', 'Hello world!') \
            if flag else ('blue', 'Goodbye,world')
        label.config(text=msg, fg=color)

    def confirm_to_quit():
        if tkinter.messagebox.askokcancel('温馨提示', '确定要退出吗？'):
            top.quit()

    # 创建顶层窗口
    top = tkinter.Tk()

    # 设置窗口大小
    top.geometry('240x160')

    # 设置窗口标题
    top.title('小游戏')

    # 创建标签对象并添加到顶层窗口
    label = tkinter.Label(top, text='Hello, world', font='Arial -32', fg='red')
    label.pack(expand=1)

    # 创建一个装按钮的容器
    panel = tkinter.Frame(top)

    # 创建按钮对象 指定添加到哪个容器中 通过command 参数绑定事件回掉函数
    button1 = tkinter.Button(panel, text='修改', command=change_label_text)
    button1.pack(side='left')
    button2 = tkinter.Button(panel, text='退出', command=confirm_to_quit)
    button2.pack(side='right')
    panel.pack(side='bottom')

    # 开启主事件循环
    tkinter.mainloop()


if __name__ == '__main__':
    main()
