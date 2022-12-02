# -*- coding: utf-8 -*-
"""
@Time ： 2022/12/2 14:25
@Auth ： leah_ana
@File ：__init__.py.py
@IDE ：PyCharm
@Motto：ABC(Always Be Coding)
"""
"""
发送电子邮件
"""

from smtplib import SMTP

from email.header import Header

from email.mime.text import MIMEText


def main():
    sender = 'anshengyo@aliyun.com'
    receivers = ['865578847@qq.com']
    message = MIMEText('python发送邮件实例代码', 'plain', 'utf-8')
    message['From'] = Header('fromName', 'utf-8')
    message['To'] = Header('toName', 'utf-8')
    message['Subject'] = Header('实例代码邮件', 'utf-8')
    smtpd = SMTP('smtp.126.com')
    # 修改登陆口令
    smtpd.login(sender, '----secretpass-----')
    smtpd.sendmail(sender, receivers, message.as_string())
    print('发送完成')
