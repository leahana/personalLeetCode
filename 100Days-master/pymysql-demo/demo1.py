# -*- coding: utf-8 -*-
"""
@Time ： 2023/2/15 14:18
@Auth ： leah_ana
@File ：demo1.py
@IDE ：PyCharm
@Motto：ABC(Always Be Coding)
"""
import pymysql.cursors

# Connect to the database


connection = pymysql.connect(
    host='localhost',
    port=3307,
    user='root',
    password='2788',
    database='pymysql_demo',
    charset='utf8mb4',
    cursorclass=pymysql.cursors.DictCursor
)

with connection:
    with connection.cursor() as cursor:
        # Create a new record
        sql = "insert into `users`(`email`,`password`)values(%s,%s)"
        cursor.execute(sql, ('1145555@email.com', '28872887'))
        # connection is not autocommit by default. So you must commit to save
        # your changes.
        connection.commit()
    with connection.cursor() as cursor:
        # 读一行
        sql = "select`id`,`password`,`password` from `users` "
        cursor.execute(sql)
        result = cursor.fetchall()
        print(result)
        print(type(result))
