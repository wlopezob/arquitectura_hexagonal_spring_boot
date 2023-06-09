package com.edu.wlopezob.appcomisariav1.adapters.out.dbs.nosql.mongo.springdata.mappers;

import java.util.List;

public interface GenericMongoMapper<D, E> {
  D toDominio(E e);

  E toEntity(D d);

  List<D> toListDominio(List<E> list);

  List<E> toListEntity(List<D> list);
}
