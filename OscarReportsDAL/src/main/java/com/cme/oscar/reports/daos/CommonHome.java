package com.cme.oscar.reports.daos;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

public abstract class CommonHome implements Serializable{

    private static final Logger logger = LoggerFactory.getLogger(CommonHome.class.getCanonicalName());

    /** The single instance of hibernate configuration */
    private static final Configuration cfg = new Configuration();

    /** The single instance of hibernate SessionFactory */
    private static SessionFactory sessionFactory;

    private static String CONFIG_FILE_LOCATION = "hibernate/hibernate.cfg.xml";

    /**
     * Retrieves the session factory from JNDI if it has not already
     * been retrieved or set.
     *
     * @return The session factory used to obtain sessions to the database.
     */
    public static SessionFactory getSessionFactory()
    {
        logger.debug("getSessionFactory: Loading instance of hibernate");

        if (sessionFactory == null)
        {
            try
            {
                initSessionFactory();
            }
            catch(Exception e)
            {
                String msg = "getSessionFactory: Hibernate startup error : " + e;
                logger.error(msg);
                throw new HibernateException(msg, e);
            }
        }

        return sessionFactory;
    }

    /**
     * Returns the ThreadLocal Session instance. Lazy initialize the
     * <code>SessionFactory</code> if needed.
     *
     * @return Session
     * @throws HibernateException
     */
    public Session openSession()
    {
        return sessionFactory.getCurrentSession();
    }

    /**
     * The behavior of this method depends on the session context you have
     * configured. This factory is intended to be used with a hibernate.cfg.xml
     * including the following property <property
     * name="current_session_context_class">thread</property> This would return
     * the current open session or if this does not exist, will create a new
     * session
     *
     * @return Session
     */
    public Session getCurrentSession()
    {
        return sessionFactory.getCurrentSession();
    }

    /**
     * initializes the sessionfactory in a safe way even if more than one thread
     * tries to build a sessionFactory
     */
    private static synchronized void initSessionFactory()
    {
        if (sessionFactory == null)
        {
            try
            {
                cfg.configure(CONFIG_FILE_LOCATION);

                sessionFactory =  cfg.buildSessionFactory();
            }
            catch (Exception e)
            {
                logger.error("initSessionFactory: Exception Observed {}",e);
                e.printStackTrace();
                throw new HibernateException(
                        "Could not initialize the Hibernate configuration - " + e.getLocalizedMessage());
            }
        }
    }
}
