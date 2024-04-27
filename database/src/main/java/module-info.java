open module pricer.db {
    requires spring.context;
    requires spring.data.jpa;
    requires jakarta.persistence;
    requires jakarta.validation;
    requires org.hibernate.orm.core;

    exports com.dan232.pricer.postgresql;
    exports com.dan232.pricer.postgresql.entity;
}