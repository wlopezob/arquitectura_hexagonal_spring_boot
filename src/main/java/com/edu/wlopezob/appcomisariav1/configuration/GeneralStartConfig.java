package com.edu.wlopezob.appcomisariav1.configuration;

import com.edu.wlopezob.appcomisariav1.adapters.out.apis.rest.httpclient.webclient.adapter.ComisariaWebClientAdapter;
import com.edu.wlopezob.appcomisariav1.adapters.out.apis.rest.httpclient.webclient.adapter.DepartamentoWebClientAdapter;
import com.edu.wlopezob.appcomisariav1.adapters.out.apis.rest.httpclient.webclient.adapter.DistritoWebClientAdapter;
import com.edu.wlopezob.appcomisariav1.adapters.out.apis.rest.httpclient.webclient.adapter.ProvinciaWebClientAdapter;
import com.edu.wlopezob.appcomisariav1.adapters.out.apis.rest.httpclient.webclient.client.comisaria.ComisariaWebClient;
import com.edu.wlopezob.appcomisariav1.adapters.out.apis.rest.httpclient.webclient.client.config.ApiProperties;
import com.edu.wlopezob.appcomisariav1.adapters.out.apis.rest.httpclient.webclient.client.departamento.DepartamentoWebClient;
import com.edu.wlopezob.appcomisariav1.adapters.out.apis.rest.httpclient.webclient.client.departamento.DepartamentoWebClientImpl;
import com.edu.wlopezob.appcomisariav1.adapters.out.apis.rest.httpclient.webclient.client.distrito.DistritoWebClient;
import com.edu.wlopezob.appcomisariav1.adapters.out.apis.rest.httpclient.webclient.client.provincia.ProvinciaWebClient;
import com.edu.wlopezob.appcomisariav1.adapters.out.apis.rest.httpclient.webclient.mappers.ComisariaWebClientMapper;
import com.edu.wlopezob.appcomisariav1.adapters.out.apis.rest.httpclient.webclient.mappers.DepartamentoWebClientMapper;
import com.edu.wlopezob.appcomisariav1.adapters.out.apis.rest.httpclient.webclient.mappers.DistritoWebClientMapper;
import com.edu.wlopezob.appcomisariav1.adapters.out.apis.rest.httpclient.webclient.mappers.ProvinciaWebClientMapper;
import com.edu.wlopezob.appcomisariav1.adapters.out.dbs.nosql.mongo.springdata.adapter.ComisariaMongoAdapter;
import com.edu.wlopezob.appcomisariav1.adapters.out.dbs.nosql.mongo.springdata.adapter.DepartamentoMongoAdapter;
import com.edu.wlopezob.appcomisariav1.adapters.out.dbs.nosql.mongo.springdata.adapter.DistritoMongoAdapter;
import com.edu.wlopezob.appcomisariav1.adapters.out.dbs.nosql.mongo.springdata.adapter.ProvinciaMongoAdapter;
import com.edu.wlopezob.appcomisariav1.adapters.out.dbs.nosql.mongo.springdata.mappers.*;
import com.edu.wlopezob.appcomisariav1.adapters.out.dbs.nosql.mongo.springdata.repository.ComisariaMongoRepository;
import com.edu.wlopezob.appcomisariav1.adapters.out.dbs.nosql.mongo.springdata.repository.DepartamentoMongoRepository;
import com.edu.wlopezob.appcomisariav1.adapters.out.dbs.nosql.mongo.springdata.repository.DistritoMongoRepository;
import com.edu.wlopezob.appcomisariav1.adapters.out.dbs.nosql.mongo.springdata.repository.ProvinciaMongoRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GeneralStartConfig {
  @Bean
  DepartamentoMongoAdapter departamentoMongoAdapter(DepartamentoMongoRepository departamentoMongoRepository,
                                                    DepartamentoMongoMapper departamentoMapper) {
    return new DepartamentoMongoAdapter(departamentoMongoRepository, departamentoMapper);
  }

  @Bean
  DepartamentoWebClientAdapter departamentoWebClientAdapter(DepartamentoWebClient departamentoWebClient,
                                                            DepartamentoWebClientMapper mapper) {
    return new DepartamentoWebClientAdapter(departamentoWebClient, mapper);
  }

  @Bean
  ProvinciaMongoAdapter provinciaMongoAdapter(ProvinciaMongoRepository provinciaMongoRepository,
                                              ProvinciaMongoMapper provinciaMongoMapper) {
    return new ProvinciaMongoAdapter(provinciaMongoRepository, provinciaMongoMapper);
  }

  @Bean
  ProvinciaWebClientAdapter provinciaWebClientAdapter(ProvinciaWebClient provinciaWebClient,
                                                      ProvinciaWebClientMapper mapper) {
    return new ProvinciaWebClientAdapter(provinciaWebClient, mapper);
  }

  @Bean
  DistritoMongoAdapter distritoMongoMapper(DistritoMongoRepository distritoMongoRepository,
                                           DistritoMongoMapper distritoMapper) {
    return new DistritoMongoAdapter(distritoMongoRepository, distritoMapper);
  }


  @Bean
  DistritoWebClientAdapter distritoWebClientAdapter(DistritoWebClient distritoWebClient,
                                                    DistritoWebClientMapper mapper) {
    return new DistritoWebClientAdapter(distritoWebClient, mapper);
  }

  @Bean
  ComisariaMongoAdapter comisariaMongoAdapter(ComisariaMongoRepository comisariaMongoRepository,
                                              ComisariaMongoMapper comisariaMongoMapper) {
    return new ComisariaMongoAdapter(comisariaMongoRepository, comisariaMongoMapper);
  }

  @Bean
  ComisariaWebClientAdapter comisariaWebClientAdapter(ComisariaWebClient comisariaWebClient,
                                                      ComisariaWebClientMapper mapper) {
    return new ComisariaWebClientAdapter(comisariaWebClient, mapper);
  }
}
