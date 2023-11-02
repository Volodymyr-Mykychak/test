package mate.academy.webintro.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jdk.jfr.Registered;
import lombok.RequiredArgsConstructor;
import mate.academy.webintro.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {
    private final EntityManagerFactory entityManagerFactory;

    @Override
    public Employee save(Employee employee) {
        EntityTransaction transaction = null;
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(employee);
            transaction.commit();
            return employee;
        } catch (RuntimeException e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            throw e;
        }
    }

    @Override
    public List<Employee> findAll() {
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            return entityManager.createQuery("SELECT e FROM Employee e", Employee.class).getResultList();
        }
    }
}
