package org.mani.Orderservice.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.mani.Orderservice.entity.OrderEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class OrderRepository {
	@Autowired
	private SessionFactory factory;
	public void saveOrder(OrderEntity entity) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		session.merge(entity);
		transaction.commit();
	}
}
