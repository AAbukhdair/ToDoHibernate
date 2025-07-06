# ToDoHibernate

**ToDoHibernate** is a lightweight Java application showcasing Hibernate ORM for persisting a simple to-do list to your database. It demonstrates:

- JPA-style entity mapping (`@Entity`, `@Table`, `@Id`, etc.)
- SessionFactory setup via `hibernate.cfg.xml` (H2/MySQL/PostgreSQL)
- Basic CRUD operations in a `ToDoDao` (save, find, update, delete)
- Console- or servlet-based runner for listing and managing tasks

Built as an educational springboard, it’s designed to evolve into:

1. A Spring Boot + Spring Data JPA service  
2. A RESTful API layer for any front-end  
3. Validation with Hibernate Validator  
4. Pagination, filtering, and batch operations  
5. A modern UI (React/Vue/Angular)  

## Quickstart

```bash
# 1. Configure your DB in hibernate.cfg.xml
# 2. Build
mvn clean package

# 3. Run
java -jar target/todohibernate.jar
