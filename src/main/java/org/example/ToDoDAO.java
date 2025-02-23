package org.example;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import java.util.List;

public class ToDoDAO {
    public void addToDo(String task) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        ToDoItem toDoItem = new ToDoItem(task, false);
        session.persist(toDoItem);
        transaction.commit();
        session.close();
    }

    public List<ToDoItem> getAllToDos() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<ToDoItem> query = session.createQuery("from ToDoItem", ToDoItem.class);
        List<ToDoItem> toDoList = query.getResultList();
        session.close();
        return toDoList;
    }

    public void deleteToDo(int id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            // Retrieve the task from DB
            ToDoItem item = session.get(ToDoItem.class, id);
            if (item != null) {
                session.remove(item); // ✅ Fix: Use `session.remove()` instead of `session.delete()`
                transaction.commit();
                System.out.println("Task deleted successfully.");
            } else {
                System.out.println("Task not found.");
            }
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }



}
