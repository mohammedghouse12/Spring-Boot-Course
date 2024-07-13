package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {

    //define field for entity manager
    private EntityManager entityManager;

    //injecting entity manager via constructor injection
    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    //implement save method
    @Override
    @Transactional
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        //creating query
        TypedQuery<Student> theQuery = entityManager.createQuery("SELECT s FROM Student s", Student.class);

        //return query results
        return theQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String theLastName) {
        TypedQuery<Student> theQuery = entityManager.createQuery(
                                    "select s from Student s where s.lastName=:data", Student.class);
        theQuery.setParameter("data", theLastName);
        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public void update(Student theStudent) {
        entityManager.merge(theStudent);
    }

    @Override
    @Transactional
    public int updateAll(String theLastName) {
        return entityManager.createQuery("update Student set lastName=:data")
                .setParameter("data", theLastName)
                .executeUpdate();
    }

    @Override
    @Transactional
    public void delete(Integer theId) {
        //retrieve the student
        Student student = entityManager.find(Student.class, theId);

        //delete the student
        entityManager.remove(student);
    }

    @Override
    @Transactional
    public int deleteAll() {
        int rowsDeleted = entityManager.createQuery("delete from Student").executeUpdate();
        return rowsDeleted;
    }
}
