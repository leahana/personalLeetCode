package y2022.m7.day04.FactoryMethod.idcard;

import y2022.m7.day04.FactoryMethod.framework.Product;

/**
 * @Author: LeahAna
 * @Date: 2022/7/4 08:34
 * @Desc: 实现了use方法的类
 */

public class IDCard extends Product {
     private String owner;

     IDCard(String owner){
         System.out.println("制作"+owner+"的ID卡");
         this.owner=owner;
     }
     public void use(){
         System.out.println("使用"+owner+"的ID卡");
     }

    public String getOwner() {
        return owner;
    }
}
