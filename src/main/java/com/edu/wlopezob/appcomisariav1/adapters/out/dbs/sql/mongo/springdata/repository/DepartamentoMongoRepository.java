package com.edu.wlopezob.appcomisariav1.adapters.out.dbs.sql.mongo.springdata.repository;

import com.edu.wlopezob.appcomisariav1.adapters.out.dbs.sql.mongo.springdata.entity.DepartamentoDocument;
import com.edu.wlopezob.appcomisariav1.adapters.out.dbs.sql.mongo.springdata.repository.base.GenericMongoRepository;

public interface DepartamentoMongoRepository extends GenericMongoRepository<DepartamentoDocument, String> {
}
