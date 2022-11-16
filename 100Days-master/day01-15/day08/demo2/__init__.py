# -*- coding: utf-8 -*-
"""
@Time ： 2022/11/16 09:12
@Auth ： leah_ana
@File ：__init__.py.py
@IDE ：PyCharm
@Motto：ABC(Always Be Coding)
"""

"""
Python 并没有从语法上严格保证私有属性或方法的私密性，它只是给给私有的属性和方法换了一个名字来妨碍对它们的访问
事实上如果你直到更换名字的规则 仍然可以访问到他们，下面的代码就可以验证这一点，之所以这样设定，可以用一句名言加以解释
'We are all consenting adults here' 大多数程序员都认为开放比封闭要好，而且程序员要自己对自己的行为负责，
阿里巴巴Java 开发手册 建议 类成员与方法访问控制从严 

如果不允许外部直接通过new来创建对象，那么构造方法必须是private。 
工具类不允许有public或default构造方法。
类非static成员变量并且与子类共享，必须是protected。
类非static成员变量并且仅在本类使用，必须是private。
类static成员变量如果仅在本类使用，必须是private。
若是static成员变量，必须考虑是否为final。
类成员方法只供类内部调用，必须是private。
类成员方法只对继承类公开，那么限制为protected。

"""

"""在实际开发中，并不建议将属性设置为私有的， 因为这回导致子类无访问 
大多数Python程序员会遵循一种命名惯例，就是让属性名以但下划线开头来表示属性是受保护的，
本类之外的代码在访问这样的属性时应该保持慎重。这种做法并不是语法上的规则， 外界仍可访问
更多时候它是由自重暗示和隐喻

"""
class Test:
    def __init__(self, foo):
        self.__foo = foo

    def __bar(self):
        print(self.__foo)
        print('__bar')


def main():
    test = Test('hello')
    test._Test__bar()
    print(test._Test__foo)


if __name__ == "__main__":
    main()
