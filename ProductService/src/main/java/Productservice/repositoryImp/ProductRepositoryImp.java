package org.mani.Productservice.repositoryImp;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.mani.Productservice.entity.ProductEntity;
import org.mani.Productservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@SuppressWarnings("unchecked")
public class ProductRepositoryImp implements ProductRepository {
	@Autowired
	private SessionFactory factory;

	@Override
	public ProductEntity saveProduct(ProductEntity entity) {
		Session session = factory.openSession();
		Transaction beginTransaction = session.beginTransaction();
		ProductEntity merge = (ProductEntity) session.merge(entity);
		beginTransaction.commit();
		return merge;
	}

	@Override
	public ProductEntity findProductById(long id) {
		StringBuilder s = new StringBuilder();
		s.append("from ProductEntity where altkey =" + id);
		Session openSession = factory.openSession();
		Query<ProductEntity> query = openSession.createQuery(s.toString());
		return query.getSingleResult();

	}

	@Override
	public List<ProductEntity> findAllProducts() {
		StringBuilder s = new StringBuilder();
		s.append("from ProductEntity");
		Session session = factory.openSession();
		@SuppressWarnings("rawtypes")
		Query createQuery = session.createQuery(s.toString());
		return createQuery.getResultList();
	}

	@Override
	public Integer findProductQuantityById(long id) {
		StringBuilder s = new StringBuilder();
		s.append("from ProductEntity where altkey =" + id);
		Session session = factory.openSession();
		Query<ProductEntity> query = session.createQuery(s.toString());
		ProductEntity singleResult = query.getSingleResult();
		return singleResult.getQuantity();

	}

	@Override
	public ProductEntity deleteProductById(long id) {
		ProductEntity productById = findProductById(id);
		Session openSession = factory.openSession();
		StringBuilder s = new StringBuilder();
		s.append("delete ProductEntity where altkey =" + id);
		Transaction transaction = openSession.beginTransaction();
		Query<ProductEntity> query = openSession.createQuery(s.toString());
		query.executeUpdate();
		transaction.commit();
		return (ProductEntity) productById;
	}

	@Override
	public ProductEntity updateProduct(ProductEntity entity) {

		StringBuilder s = new StringBuilder();
		s.append("update ProductEntity set Price = : p where altkey =" + entity.getAltkey());
		Session session = factory.openSession();
		@SuppressWarnings("rawtypes")
		Query query = session.createQuery(s.toString());
		query.setParameter("p", entity.getPrice());
		query.executeUpdate();
		return entity;
	}

	@Override
	public List<ProductEntity> getProductByName(String name) {
			StringBuilder s=new StringBuilder();
			s.append("from ProductEntity where name = "+name);
			Session session = factory.openSession();
			@SuppressWarnings("rawtypes")
			Query query = session.createQuery(s.toString());
			 return query.getResultList();
		
	}
	public List<ProductEntity> findProductsInRange(long lowprice,long highprice){
			StringBuilder s= new StringBuilder();
			s.append("from ProductEntity where price between "+lowprice+"and "+highprice);
			Session session = factory.openSession();
			Query<ProductEntity> query = session.createQuery(s.toString());
			return query.getResultList();
	}

	@Override
	public long findProductPriceById(long id) {
		ProductEntity entity = findProductById(id);
		return entity.getPrice();
	}

}
