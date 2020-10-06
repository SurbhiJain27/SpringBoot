package com.egen.repository;

import com.egen.entity.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends CrudRepository<Address, Integer> {
    //#TODO - Its for future's validation/implementation purpose
}
