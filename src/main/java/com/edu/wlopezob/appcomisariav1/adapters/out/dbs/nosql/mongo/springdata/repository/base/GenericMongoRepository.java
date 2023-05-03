package com.edu.wlopezob.appcomisariav1.adapters.out.dbs.nosql.mongo.springdata.repository.base;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface GenericMongoRepository<T,ID> extends ReactiveMongoRepository<T, ID> {
}
