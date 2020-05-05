create table rezos_common.customer (
   id BIGINT NOT NULL AUTO_INCREMENT,
   name VARCHAR(30) NOT NULL,
   age  INTEGER NOT NULL,
   salary REAL NOT NULL,
   status VARCHAR(1) NOT NULL,
   PRIMARY KEY (id)
);