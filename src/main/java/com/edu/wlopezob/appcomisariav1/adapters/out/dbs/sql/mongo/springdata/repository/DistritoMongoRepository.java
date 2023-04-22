package com.edu.wlopezob.appcomisariav1.adapters.out.dbs.sql.mongo.springdata.repository;

import com.edu.wlopezob.appcomisariav1.adapters.out.dbs.sql.mongo.springdata.entity.DistritoDocument;
import com.edu.wlopezob.appcomisariav1.adapters.out.dbs.sql.mongo.springdata.entity.ProvinciaDocument;
import com.edu.wlopezob.appcomisariav1.adapters.out.dbs.sql.mongo.springdata.repository.base.GenericMongoRepository;

public interface DistritoMongoRepository extends GenericMongoRepository<DistritoDocument, String> {
}
