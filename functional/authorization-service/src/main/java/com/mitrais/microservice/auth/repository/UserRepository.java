package com.mitrais.microservice.auth.repository;

import com.mitrais.microservice.auth.domain.User;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepository extends PagingAndSortingRepository<User, String>{
}
