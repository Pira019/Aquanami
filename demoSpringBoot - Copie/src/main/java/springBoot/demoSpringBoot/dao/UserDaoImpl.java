package springBoot.demoSpringBoot.dao;
 

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import springBoot.demoSpringBoot.models.User;

@Repository
@Transactional
public class UserDaoImpl {
	
	@Autowired
	private EntityManager entityManager;
	
	public User findUserAccount(String userName) {
		try {
			
			String sql= "Select e from "+ User.class.getName() + "e"
					+ "where e.login = :login";
			
			Query query = entityManager.createQuery(sql,User.class);
				query.setParameter("login", userName);
				
				return (User) query.getSingleResult();
			
		} catch (NoResultException e) {
			
			return null;
		}
	}

	public UserDaoImpl() {
		super();
	}

	 

}
