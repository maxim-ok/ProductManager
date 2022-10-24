package ru.netology.domain;

public class ProductManager {

    private Product[] products = new Product[0];
    private ProductRepository repository;


    public ProductManager(ProductRepository repository) {
        this.repository = repository;
    }


    public Product[] searchBy(String text) {
        Product[] result = new Product[0]; // тут будем хранить подошедшие запросу продукты
        for (Product product : repository.findAll()) {
            if (matches(product, text)) {
                Product[] tmp = new Product[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = product;
                result = tmp;


                //System.arraycopy(result, 0, tmp, 0, result.length);
                //tmp[tmp.length - 1] = product;
            }
        }
        return result;
    }

    // метод определения соответствия товара product запросу search
    public boolean matches(Product product, String search) {
        return product.getName().contains(search);
    }
}



