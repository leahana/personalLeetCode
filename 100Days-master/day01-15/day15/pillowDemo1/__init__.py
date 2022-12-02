# -*- coding: utf-8 -*-
"""
@Time ： 2022/12/2 15:21
@Auth ： leah_ana
@File ：__init__.py.py
@IDE ：PyCharm
@Motto：ABC(Always Be Coding)
"""

from PIL import Image,ImageFilter


def main():
    image = Image.open('./abi.png')
    # rect = 80, 20, 310, 360
    # image.format, image.mode = ('PNG', 'RGB')
    # crop 裁剪
    # image.crop(rect).show()
    size = 128, 128

    # 缩略图
    # image.thumbnail(size)

    # 缩放和裁剪图像
    # image1 = Image.open('IMG_0570.JPG')
    # image2 = Image.open('IMG_7215.JPG')
    #
    # rect = 80, 20, 310, 360
    # head = image1.crop(rect)
    # width, height = head.size
    # image2.paste(head.resize((int(width / 1.5),int(height/1.5))),(172,40))
    # image2.show()

    # 旋转和翻转
    # image = Image.open('./IMG_0570.JPG')
    # image.rotate(180).show()
    # image.transpose(Image.FLIP_LEFT_RIGHT).show()

    # 操作像素
    # image = Image.open('./IMG_0570.JPG')
    # for x in range(80, 200):
    #     for y in range(20, 210):
    #         image.putpixel((x, y), (128, 128, 128))
    # image.show()

    image= Image.open('./IMG_0570.JPG')
    image.filter(ImageFilter.CONTOUR).show()


if __name__ == '__main__':
    main()
