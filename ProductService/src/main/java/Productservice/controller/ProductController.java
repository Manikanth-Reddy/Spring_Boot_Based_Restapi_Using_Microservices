package org.mani.Productservice.controller;

import java.util.List;

import org.mani.Productservice.entity.ProductEntity;
import org.mani.Productservice.serviceimp.ProductServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
	@Autowired
	private ProductServiceImp imp;
	@PostMapping(value = "/saveProduct")
	public @ResponseBody ProductEntity saveProduct(@RequestBody ProductEntity entity) {
		return imp.saveProduct(entity);
	}


	@GetMapping(value = "/findProductById/{altkey}")
	public @ResponseBody ProductEntity findProductById(@PathVariable("altkey") long id) {
		return imp.findProductById(id);
	}

	@GetMapping(value = "/findAllProducts")
	public @ResponseBody List<ProductEntity> findAllProducts() {
		System.out.println(imp.findAllProducts());
		return imp.findAllProducts();
	}

	@GetMapping(value = "/findProductQuantityById/{altkey}")
	public Integer findProductQuantityById(@PathVariable("altkey") long id) {
		return imp.findProductQuantityById(id);
	}

	@GetMapping(value = "/deleteProductById/{altkey}")
	public @ResponseBody ProductEntity deleteProductById(@PathVariable("altkey") long id) {
		return imp.deleteProductById(id);
	}

	@PostMapping(value = "/updateProduct")
	public @ResponseBody ProductEntity updateProduct(@RequestBody ProductEntity entity) {
		return imp.updateProduct(entity);
	}

	@GetMapping(value = "/findAllProductSortedByName")
	public @ResponseBody List<ProductEntity> findAllProductSortedByName() {
		return imp.findAllProductSortedByName();
	}
	@GetMapping(value = "/getProductByName")
	public List<ProductEntity> getProductByName(@RequestParam String name) {
		return imp.getProductByName(name);
	}
	@GetMapping(value = "/findProductsInRange")
	public List<ProductEntity> findProductsInRange(@RequestParam("lowprice") long lowprice,@RequestParam("highprice") long highprice){
		return imp.findProductsInRange(lowprice, highprice);
	}
	@GetMapping(value = "/findProductPriceById/{productid}")
	public long findProductPriceById(@PathVariable("productid") long id) {
		return imp.findProductPriceById(id);
	}
}
