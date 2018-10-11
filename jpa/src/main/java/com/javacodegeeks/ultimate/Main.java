package com.javacodegeeks.ultimate;

import com.javacodegeeks.ultimate.objects.Geek;
import com.javacodegeeks.ultimate.objects.Person;

import javax.persistence.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    private static final Logger LOGGER = Logger.getLogger("JPA");

    public static void main(String[] args ) {
        Main main = new Main();
        main.run();
    }

    private void run() {
        EntityManagerFactory factory = null;
        EntityManager entityManager = null;

        try {
            factory = Persistence.createEntityManagerFactory("PersistenceUnit");
            entityManager = factory.createEntityManager();
            persistPerson(entityManager);
            persistGeek(entityManager);
            executeQuerry(entityManager);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, e.getMessage(), e);
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
            if (factory != null) {
                factory.close();
            }
        }
    }

    private void persistPerson(EntityManager entityManager) {
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            Person person = new Person();
            person.setFirstName("Homer");
            person.setLastName("Simpson");
            entityManager.persist(person);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
        }
    }

    private void persistGeek(EntityManager entityManager) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Geek geek = new Geek();
        geek.setFirstName("Gavin");
        geek.setLastName("Coffee");
        geek.setFavouriteProgrammingLanguage("Java");
        entityManager.persist(geek);
        geek = new Geek();
        geek.setFirstName("Thomas");
        geek.setLastName("Micro");
        geek.setFavouriteProgrammingLanguage("C#");
        entityManager.persist(geek);
        geek = new Geek();
        geek.setFirstName("Christian");
        geek.setLastName("Cup");
        geek.setFavouriteProgrammingLanguage("Java");
        entityManager.persist(geek);
        transaction.commit();
    }

    private void executeQuerry(EntityManager entityManager) {
        TypedQuery<Person> query = entityManager.createQuery("from Person", Person.class);
        List<Person> resultList = query.getResultList();
        for (Person person : resultList) {
            StringBuilder sb = new StringBuilder();
            sb.append(person.getFirstName()).append(" ").append(person.getLastName());
            if (person instanceof Geek) {
                Geek geek = (Geek)person;
                sb.append(" ").append(geek.getFavouriteProgrammingLanguage());
            }
            LOGGER.info(sb.toString());
        }
    }
}
