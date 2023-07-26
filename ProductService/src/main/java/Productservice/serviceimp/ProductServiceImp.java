package org.mani.Productservice.serviceimp;

import java.util.List;
import java.util.stream.Collectors;

import org.mani.Productservice.entity.ProductEntity;
import org.mani.Productservice.repositoryImp.ProductRepositoryImp;
import org.mani.Productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ProductServiceImp implements ProductService {
	@Autowired
	private ProductRepositoryImp imp;
	@Override
	public ProductEntity saveProduct(ProductEntity entity) {
		return imp.saveProduct(entity);
	}

	@Override
	public ProductEntity findProductById(long id) {
		return imp.findProductById(id);
	}

	@Override
	public List<ProductEntity> findAllProducts() {
		return imp.findAllProducts();
	}

	@Override
	public Integer findProductQuantityById(long id) {
		return imp.findProductQuantityById(id);
	}

	@Override
	public ProductEntity deleteProductById(long id) {
		// TODO Auto-generated method stub
		return imp.deleteProductById(id);
	}

	@Override
	public ProductEntity updateProduct(ProductEntity entity) {
		return imp.updateProduct(entity);
	}


	@Override
	public List<ProductEntity> findAllProductSortedByName() {
			List<ProductEntity> list = findAllProducts();
			return list.stream().sorted((e1,e2)->e1.getName().compareToIgnoreCase(e2.getName())).collect(Collectors.toList());
	}

	@Override
	public List<ProductEntity> getProductByName(String name) {
		return imp.getProductByName(name);
	}
	public List<ProductEntity> findProductsInRange(long lowprice,long highprice){
		return imp.findProductsInRange(lowprice, highprice);
	}

	@Override
	public long findProductPriceById(long id) {
		return imp.findProductPriceById(id);
	}
}
