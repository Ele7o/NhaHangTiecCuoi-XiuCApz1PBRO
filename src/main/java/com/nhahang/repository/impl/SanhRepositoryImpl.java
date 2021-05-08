/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhahang.repository.impl;

import com.nhahang.pojo.Sanh;
import com.nhahang.repository.SanhRepository;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author X_X
 */
@Repository
public class SanhRepositoryImpl implements SanhRepository {
    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    @Transactional
    public List<Sanh> getSanh() {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        Query q = s.createQuery("From Sanh");
        return q.getResultList();
    }

    @Override
    @Transactional
    public Sanh getSanhById(int idSanh) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        return s.get(Sanh.class, idSanh);
    }

    @Override
    @Transactional
    public boolean addOrUpdateSanh(Sanh sanh) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        try{
            if(sanh.getIdSanh() > 0){
                s.update(sanh);
            }
            else{
                s.save(sanh);
            }
        }catch(HibernateException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    @Transactional
    public boolean deleteSanh(int idSanh) {
        try{
            Session s = this.sessionFactory.getObject().getCurrentSession();
            s.delete(s.get(Sanh.class, idSanh));
            
            return true;
        }catch(HibernateException e){
            e.printStackTrace();
        }
        return false;
    }    
}
