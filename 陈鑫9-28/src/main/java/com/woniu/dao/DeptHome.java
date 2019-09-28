package com.woniu.dao;
// Generated 2019-9-27 17:22:53 by Hibernate Tools 4.3.5.Final

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.woniu.pojo.Dept;

import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class Dept.
 * @see com.woniu.pojo.Dept
 * @author Hibernate Tools
 */
public class DeptHome {

	private static final Log log = LogFactory.getLog(DeptHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new Configuration().configure().buildSessionFactory();
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(Dept transientInstance) {
		log.debug("persisting Dept instance");
		Session session = sessionFactory.openSession();
		Transaction trans=session.beginTransaction();
		try {
			session.persist(transientInstance);
			trans.commit();
			log.debug("persist successful");
		} catch (RuntimeException re) {
			trans.rollback();
			log.error("persist failed", re);		
			throw re;
		}
	}

	public void attachDirty(Dept instance) {
		log.debug("attaching dirty Dept instance");	
		Session session = sessionFactory.openSession();
		Transaction trans=session.beginTransaction();
		try {
			session.saveOrUpdate(instance);
			trans.commit();
			log.debug("attach successful");
		} catch (RuntimeException re) {
			trans.rollback();
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Dept instance) {
		log.debug("attaching clean Dept instance");
		try {
			Session session = sessionFactory.openSession();
			session.lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Integer deptno) {
		log.debug("deleting Dept instance");
		Session session = sessionFactory.openSession();
		Transaction trans=session.beginTransaction();
		try {
			Dept dept=new DeptHome().findById(deptno);
			session.delete(dept);
			trans.commit();
			log.debug("delete successful");
		} catch (RuntimeException re) {
			trans.rollback();
			log.error("delete failed", re);
			throw re;
		}
	}

	public Dept merge(Dept detachedInstance) {
		log.debug("merging Dept instance");
		try {
			Session session = sessionFactory.openSession();
			Dept result = (Dept) session.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Dept findById(java.lang.Integer id) {
		log.debug("getting Dept instance with id: " + id);
		try {
			Session session = sessionFactory.openSession();
			Dept instance = (Dept) session.get("com.woniu.pojo.Dept", id);
			if (instance == null) {
				log.debug("get successful, no instance found");
			} else {
				log.debug("get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Dept> findByExample(Dept instance) {
		log.debug("finding Dept instance by example");
		try {
			Session session = sessionFactory.openSession();
			List<Dept> results = (List<Dept>) session.createCriteria("com.woniu.pojo.Dept").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
