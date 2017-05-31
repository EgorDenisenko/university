package com.egoriy.repository;

import com.egoriy.entity.Model;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ModelRepository extends PagingAndSortingRepository<Model, Long> {
}
