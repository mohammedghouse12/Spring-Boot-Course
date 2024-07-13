package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Course;
import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetail;
import com.luv2code.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AppDAOImpl implements AppDAO{

    private EntityManager entityManager;

    @Autowired
    public AppDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Instructor instructor) {
        entityManager.persist(instructor);
    }

    @Override
    public Instructor findInstructorById(int id) {
        return entityManager.find(Instructor.class, id);
    }

    @Override
    @Transactional
    public void deleteInstructorById(int id) {
        Instructor instructor = entityManager.find(Instructor.class, id);
        entityManager.remove(instructor);
    }

    @Override
    public InstructorDetail findInstructorDetailById(int id) {
        return entityManager.find(InstructorDetail.class, id);
    }

    @Override
    @Transactional
    public void deleteInstructorDetailById(int id) {
        InstructorDetail instructorDetail = entityManager.find(InstructorDetail.class, id);
        instructorDetail.getInstructor().setInstructorDetail(null);
        entityManager.remove(instructorDetail);
    }

    @Override
    public List<Course> findCoursesByInstructorId(int id){
        TypedQuery query = entityManager.createQuery("from Course where instructor.id = :data", Course.class);
        query.setParameter("data", id);

        return query.getResultList();
    }

    @Override
    public Instructor findInstructorByIdJoinFetch(int id) {
        TypedQuery<Instructor> query = entityManager.createQuery("select i from Instructor i "
                                                                +"JOIN FETCH i.courses "
                                                                +"JOIN FETCH i.instructorDetail "
                                                                +"where i.id = :data", Instructor.class);
        query.setParameter("data", id);

        return query.getSingleResult();
    }

    @Override
    @Transactional
    public void updateInstructor(Instructor instructor) {
        entityManager.merge(instructor);
    }

    @Override
    @Transactional
    public void save(Course course){
        entityManager.persist(course);
    }

    @Override
    public Course findCourseById(int id) {
        TypedQuery<Course> query = entityManager.createQuery("from Course where id=:data", Course.class);
        query.setParameter("data", id);
        return query.getSingleResult();
    }

    @Override
    @Transactional
    public void updateCourse(Course course) {
        entityManager.merge(course);
    }

    @Override
    @Transactional
    public void deleteInstructor(int id) {
        Instructor instructor = entityManager.find(Instructor.class, id);

        List<Course> courses = instructor.getCourses();

        for(Course course: courses) course.setInstructor(null);

        entityManager.remove(instructor);
    }

    @Override
    @Transactional
    public void deleteCourse(int id) {
        Course course = entityManager.find(Course.class, id);
//        course.getInstructor().getCourses().remove(course);
        entityManager.remove(course);
    }

    @Override
    public Course findCourseAndStudentsByCourseId(int id) {
        TypedQuery<Course> query = entityManager.createQuery(
                                    "select i from Course i " +
                                            "JOIN FETCH i.students "+
                                            "where i.id = :data", Course.class);
        query.setParameter("data", id);
        return query.getSingleResult();
    }

    @Override
    public Student findStudentAndCoursesByStudentId(int id) {
        TypedQuery<Student> query = entityManager.createQuery(
                                        "select i from Student i "+
                                                "JOIN FETCH i.courses "+
                                                "where i.id = :data", Student.class);
        query.setParameter("data", id);
        return query.getSingleResult();
    }

    @Override
    @Transactional
    public void update(Student student) {
        entityManager.merge(student);
    }

    @Override
    @Transactional
    public void deleteStudentById(int id) {
        Student student = entityManager.find(Student.class, id);
        entityManager.remove(student);
    }
}