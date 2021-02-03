package springBoot.demoSpringBoot.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import springBoot.demoSpringBoot.models.UserRole;

@Repository
@Transactional
public class RoleDaoImpl {
	
	@Autowired
    private EntityManager entityManager;
	
	public List<String> getRoleNames(Long userId) {
        String sql = "Select ur.role.nameRole from " + UserRole.class.getName() + " ur " //
                + " where ur.user.id = :userId ";
 
        Query query = this.entityManager.createQuery(sql, String.class); 
        query.setParameter("userId", userId);
        return query.getResultList();
    }

	/**
	 * @return the entityManager
	 */
	public EntityManager getEntityManager() {
		return entityManager;
	}

	/**
	 * @param entityManager the entityManager to set
	 */
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public RoleDaoImpl() {
		// TODO Auto-generated constructor stub
	}

}
