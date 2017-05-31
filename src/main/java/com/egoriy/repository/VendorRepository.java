package com.egoriy.repository;

import com.egoriy.entity.Vendor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface VendorRepository extends PagingAndSortingRepository<Vendor, Long> {
}
