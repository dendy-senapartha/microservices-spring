package com.mitrais.microservice.auth.repository;

import com.mitrais.microservice.auth.domain.UserProfile;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserProfileRepository extends PagingAndSortingRepository<UserProfile, String>{
}
