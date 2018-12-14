package com.spring.dao;
import java.util.ArrayList;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.Transactional;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.spring.model.User;
@Component
public class UserDao
{
	@Autowired
	SessionFactory sessionFactory;

	@Transactional()
	public void addUser(User u)
	{
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(u);
		tx.commit();
		session.close();
		System.out.println("user details: "+u);

	}

	@SuppressWarnings("unchecked")
	public ArrayList<User>listUser()
	{
		Session session= sessionFactory.openSession();
		Query query = session.createQuery("FROM User");
//		List<User> u = query.list();
//		for (User ee : u)
//		{
//			System.out.println("Person List::" + ee);
//		}
		return (ArrayList<User>)query.list();
		

	}
	@Transactional()
	public void deleteEmp(int id) throws RollbackException, HeuristicMixedException, HeuristicRollbackException, SystemException{
	 	Session session= sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		User u = new User();
		u.setId(id);
		session.delete(u);	             
		tx.commit();
		session.close();
	}
	
	@Transactional()
	public User getById(int id)
	{
		System.out.println(sessionFactory.openSession().get(User.class, id));
		return (User)sessionFactory.openSession().get(User.class, id);
	
	}

	public void update(User user)
	{
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(user);
		tx.commit();
		 session.close();
	}

}
