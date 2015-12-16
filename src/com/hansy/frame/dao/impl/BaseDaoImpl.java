package com.hansy.frame.dao.impl;

import java.util.Collection;
import java.util.List;

import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.orm.ibatis.SqlMapClientTemplate;

import com.hansy.frame.dao.IBaseDao;
import com.hansy.frame.exception.ServiceException;

public class BaseDaoImpl extends HibernateDaoSupport implements IBaseDao {
	private SqlMapClientTemplate sqlMapClientTemplate;

	public Object queryById(Class<?> clz, String id) throws ServiceException {
		try {
			return getHibernateTemplate().get(clz, id);
		} catch (Exception re) {
			re.printStackTrace();
			throw new ServiceException(re.getMessage());
		}
		
	}

	public List<?> queryByValue(Class obj, String condition, String value)
			throws ServiceException {
		try {
			return getHibernateTemplate().find(
					"from " + obj.getSimpleName() + " where " + condition
							+ " ='" + value + "'");
		} catch (Exception re) {
			re.printStackTrace();
			throw new ServiceException(re.getMessage());
		}
	}

	public List<?> queryByHSql(String hsql) throws ServiceException {
		try {
			return getHibernateTemplate().find(hsql);
		} catch (Exception re) {
			re.printStackTrace();
			throw new ServiceException(re.getMessage());
		}
	}

	public void save(Object o) throws ServiceException {
		try {
			getHibernateTemplate().save(o);
		} catch (Exception re) {
			re.printStackTrace();
			throw new ServiceException(re.getMessage());
		}
	}

	public void save(String type, Object o) throws ServiceException {
		try {
			getHibernateTemplate().save(type, o);
		} catch (Exception re) {
			re.printStackTrace();
			throw new ServiceException(re.getMessage());
		}
	}

	public void update(Object o) throws ServiceException {
		try {
			getHibernateTemplate().update(o);
		} catch (Exception re) {
			re.printStackTrace();
			throw new ServiceException(re.getMessage());
		}
	}

	public void saveOrUpdateObj(Object o) throws ServiceException {
		try {
			getHibernateTemplate().saveOrUpdate(o);
		} catch (Exception re) {
			re.printStackTrace();
			throw new ServiceException(re.getMessage());
		}
	}

	public void saveOrUpdate(Collection<?> c) throws ServiceException {
		try {
			getHibernateTemplate().saveOrUpdateAll(c);
		} catch (Exception re) {
			re.printStackTrace();
			throw new ServiceException(re.getMessage());
		}
	}

	public void remove(Object o) throws ServiceException {
		try {
			getHibernateTemplate().delete(o);
		} catch (Exception re) {
			re.printStackTrace();
			throw new ServiceException(re.getMessage());
		}
	}

	public void remove(String id, Object o) throws ServiceException {
		try {
			getHibernateTemplate().delete(id, o);
		} catch (Exception re) {
			re.printStackTrace();
			throw new ServiceException(re.getMessage());
		}
	}

	public int remove(String key, String value, Class o)
			throws ServiceException {
		int count = 0;
		try {
			String hsql = "delete from " + o.getSimpleName() + " where " + key
					+ " = '" + value + "'";
			count = getHibernateTemplate().bulkUpdate(hsql);
		} catch (Exception re) {
			re.printStackTrace();
			throw new ServiceException(re.getMessage());
		}
		return count;
	}

	public void remove(Collection<?> list) throws ServiceException {
		try {
			getHibernateTemplate().deleteAll(list);
		} catch (Exception re) {
			re.printStackTrace();
			throw new ServiceException(re.getMessage());
		}
	}

	public Object queryByIBatis(String statementId, Object o)
			throws ServiceException {
		try {
			return this.sqlMapClientTemplate.queryForObject(statementId, o);
		} catch (Exception re) {
			re.printStackTrace();
			throw new ServiceException(re.getMessage());
		}
	}

	public List<?> queryListByIBatis(String statementId)
			throws ServiceException {
		try {
			return this.sqlMapClientTemplate.queryForList(statementId);
		} catch (Exception re) {
			re.printStackTrace();
			throw new ServiceException(re.getMessage());
		}
	}

	public List<?> queryListByIBatis(String statementId, Object o)
			throws ServiceException {
		try {
			return this.sqlMapClientTemplate.queryForList(statementId, o);
		} catch (Exception re) {
			re.printStackTrace();
			throw new ServiceException(re.getMessage());
		}
	}

	public int queryIntByIBatis(String statementId, Object o)
			throws ServiceException {
		try {
			return ((Integer) this.sqlMapClientTemplate.queryForObject(
					statementId, o)).intValue();
		} catch (Exception re) {
			re.printStackTrace();
			throw new ServiceException(re.getMessage());
		}
	}

	public void saveByIBatis(String statementId, Object o)
			throws ServiceException {
		try {
			this.sqlMapClientTemplate.insert(statementId, o);
		} catch (Exception re) {
			re.printStackTrace();
			throw new ServiceException(re.getMessage());
		}
	}

	public int updateByIBatis(String statementId, Object o)
			throws ServiceException {
		int count = 0;
		try {
			count = this.sqlMapClientTemplate.update(statementId, o);
		} catch (Exception re) {
			re.printStackTrace();
			throw new ServiceException(re.getMessage());
		}
		return count;
	}

	public int deleteByIBatis(String statementId, Object o)
			throws ServiceException {
		int count = 0;
		try {
			count = this.sqlMapClientTemplate.delete(statementId, o);
		} catch (Exception re) {
			re.printStackTrace();
			throw new ServiceException(re.getMessage());
		}
		return count;
	}

	public SqlMapClientTemplate getSqlMapClientTemplate() {
		return this.sqlMapClientTemplate;
	}

	public void setSqlMapClientTemplate(
			SqlMapClientTemplate sqlMapClientTemplate) {
		this.sqlMapClientTemplate = sqlMapClientTemplate;
	}

	public List<?> queryListByIBatis(String statementId, Object o,
			int startRows, int maxRu) throws ServiceException {
		try {
			return this.sqlMapClientTemplate.queryForList(statementId, o,
					startRows, maxRu);
		} catch (Exception re) {
			re.printStackTrace();
			throw new ServiceException(re.getMessage());
		}
	}

	public Session getSessionTwo() {
		return getSession();
	}
}
