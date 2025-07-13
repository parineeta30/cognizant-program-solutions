# Hands-on 2: Hibernate XML Configuration Implementation Walkthrough

---
# 1.Explain how object to relational database mapping done in hibernate xml configuration file :
Hibernate XML Configuration –
Hibernate uses hibernate.cfg.xml and *.hbm.xml files to configure database connections and map Java classes to database tables.

```
*.hbm.xml is used to define class-to-table mapping.
<!-- Employee.hbm.xml -->
<hibernate-mapping>
  <class name="Employee" table="employee">
    <id name="id" column="id"><generator class="native"/></id>
    <property name="name" column="name"/>
    <property name="salary" column="salary"/>
  </class>
</hibernate-mapping>

```
hibernate.cfg.xml connects Hibernate to MySQL and includes the mapping file.

<hibernate-configuration>
  <session-factory>
    <property name="hibernate.connection.url">jdbc:mysql://localhost:3306/testdb</property>
    <property name="hibernate.connection.username">root</property>
    <property name="hibernate.connection.password">root</property>
    <property name="hibernate.dialect">org.hibernate.dialect.MySQL8Dialect</property>
    <mapping resource="Employee.hbm.xml"/>
  </session-factory>
</hibernate-configuration>

``` 
Some Hibernate key components :

// SessionFactory: Singleton object to create sessions
SessionFactory factory = new Configuration().configure().buildSessionFactory();

// Session: Represents a DB connection
Session session = factory.openSession();

// Transaction: Manages DB operations atomically
Transaction tx = session.beginTransaction();

Employee emp = new Employee();
emp.setName("Ava");
emp.setSalary(60000);

// Save object to DB
session.save(emp);

// Commit transaction
tx.commit();
session.close(); 
```

## 2.Explain about following aspects of implementing the end to end operations in Hibernate :

1. SessionFactory - It is a thread-safe, heavyweight object that is used to create and manage Session objects.  It is created once using the configuration file (hibernate.cfg.xml) that contains database connection and mapping information. Acts as a factory for Session instances, encapsulating all configuration details.
```
SessionFactory factory = new Configuration().configure().buildSessionFactory();

```
2. Session - Represents a single unit of work with the database and wraps a JDBC connection.  All CRUD operations are done through a session object. Sessions are not thread-safe and should be closed after use.

```
Session session = factory.openSession();

```
3. Transaction - A logical unit of work that groups one or more operations into a single operation. Ensures ACID (Atomicity, Consistency, Isolation, Durability) properties while interacting with the database.

4. beginTransaction() - Starts a new transaction. Used to initiate a database operation group that can later be committed or rolled back.

```
Transaction tx = session.beginTransaction();

```
5. commit() - Commits all changes made in the current transaction to the database permanently. It is  called when all operations are successfully completed.

```
tx.commit();

```
6. rollback() - Rolls back all changes made during the current transaction. It is useful in exception handling to revert to a stable database state.
```
tx.rollback();

```
7. session.save() - Persists a new instance of an entity class to the database. An INSERT statement is triggered.
```
session.save(employee);

```
8. session.createQuery().list() - Creates and executes an HQL (Hibernate Query Language) query and retrieves results as a list.

```
List<Employee> empList = session.createQuery("from Employee").list();

```
9. session.get() - Fetches an entity from the database by its primary key. The object if found, or null otherwise. 
```
Employee emp = session.get(Employee.class, 101);

```
10. session.delete() - Deletes the specified entity from the database. Triggers a DELETE statement.
```
session.delete(emp);

```
