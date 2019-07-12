package org.ducode.springcrud.repository;

import org.ducode.springcrud.models.Department;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class DepartmentRepository {
    @PersistenceContext
    private EntityManager em;

    public List<Department> getDepartments() {
        return em.createQuery("SELECT d FROM Department d").getResultList();
    }

    public boolean createDepartment(Department department) {
        this.em.persist(department);
        return this.em.contains(department);
    }
}
