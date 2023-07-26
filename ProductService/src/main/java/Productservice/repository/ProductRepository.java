package org.mani.Productservice.repository;

import java.util.List;

import org.mani.Productservice.entity.ProductEntity;

public interface ProductRepository {
	public ProductEntity saveProduct(ProductEntity entity);

	public ProductEntity findProductById(long id);

	public List<ProductEntity> findAllProducts();

	public Integer findProductQuantityById(long id);

	public ProductEntity deleteProductById(long id);

	public ProductEntity updateProduct(ProductEntity entity);

	public List<ProductEntity> getProductByName(String name);

	public long findProductPriceById(long id);
}
