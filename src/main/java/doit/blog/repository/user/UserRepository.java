package doit.blog.repository.user;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository  {
    @PersistenceContext
    private EntityManager em;

    public void save(User user) {
        em.persist(user);
    }

    public User findById(Long id) {
        return em.find(User.class, id);
    }
    public List<User> findByUserLoginId(String userLoginId) {
        return em.createQuery("select u from User u where u.userLoginId = :userLoginId", User.class)
                .setParameter("userLoginId", userLoginId)
                .getResultList();
    }

    public List<User> findAll() {
        return em.createQuery("select u from User u", User.class).getResultList();
    }
}
