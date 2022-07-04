package y2022.m7.day04.FactoryMethod.idcard;

import y2022.m7.day04.FactoryMethod.framework.Factory;
import y2022.m7.day04.FactoryMethod.framework.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: LeahAna
 * @Date: 2022/7/4 08:35
 * @Desc: 实现了createProduct、registerProduct 方法的类
 */

public class IDCardFactory extends Factory {
    private List owners = new ArrayList();

    protected Product createProduct(String owner) {
        return new IDCard(owner);
    }

    protected void registerProduct(Product product) {
        owners.add(((IDCard) product).getOwner());
    }

    public List getOwners() {
        return owners;
    }
}
