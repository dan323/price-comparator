module comparator.exec {
    requires spring.boot.autoconfigure;
    requires spring.context;
    requires spring.boot;
    requires spring.beans;
    requires spring.core;
    requires java.sql;
    requires com.h2database;
    opens com.dan232.pricer to spring.core, spring.beans, spring.context;
    //V8G91H
}