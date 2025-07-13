
# Hibernate Annotation Configuration - Hands-on 3

##  Hibernate Annotation Configuration :

###  1. Object-Relational Mapping (ORM) with Annotations :

Hibernate allows us to map Java classes to database tables using annotations in the **entity (model) class**, such as `Employee.java`.

---

### 📌 Annotation Breakdown

- **`@Entity`**  
  Marks the class as an entity to be persisted in a table.

- **`@Table(name = "employee")`**  
  Maps the class to the specific table name in the database.

- **`@Id`**  
  Marks the primary key field of the entity.

- **`@GeneratedValue`**  
  Specifies that the primary key is auto-generated.

- **`@Column(name = "name")`**  
  Maps the field to a specific column in the database.

---

### ⚙️ Hibernate Configuration (`hibernate.cfg.xml`)

This file is used to configure Hibernate's connection to the database.

```xml
<hibernate-configuration>
  <session-factory>

    <!-- JDBC Configuration -->
    <property name="hibernate.connection.driver_class">com.mysql.cj.jdbc.Driver</property>     <!-- Driver -->
    <property name="hibernate.connection.url">jdbc:mysql://localhost:3306/testdb</property>    <!-- Connection URL -->
    <property name="hibernate.connection.username">root</property>                             <!-- Username -->
    <property name="hibernate.connection.password">root</property>                             <!-- Password -->

    <!-- Hibernate Configuration -->
    <property name="hibernate.dialect">org.hibernate.dialect.MySQL8Dialect</property>          <!-- Dialect -->

    <!-- Mapping -->
    <mapping class="com.example.model.Employee"/>

  </session-factory>
</hibernate-configuration>
```

- `hibernate.dialect`: Specifies the SQL dialect Hibernate should use 
- `hibernate.connection.driver_class`: The JDBC driver class
- `hibernate.connection.url`: The JDBC URL to connect to the database
- `hibernate.connection.username`: database username
- `hibernate.connection.password`: database password.

