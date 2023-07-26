package org.mani.Productservice.service;

import java.util.List;

import org.mani.Productservice.entity.ProductEntity;

public interface ProductService {
	public ProductEntity saveProduct(ProductEntity entity);

	public ProductEntity findProductById(long id);

	public List<ProductEntity> findAllProducts();

	public Integer findProductQuantityById(long id);

	public ProductEntity deleteProductById(long id);

	public ProductEntity updateProduct(ProductEntity entity);

	public List<ProductEntity> findAllProductSortedByName();

	public List<ProductEntity> getProductByName(String name);
	
	public long findProductPriceById(long id);
}
