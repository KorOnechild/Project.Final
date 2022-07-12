package com.project.cafesns.repository;

import com.project.cafesns.model.entitiy.Cafe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CafeRepository extends JpaRepository<Cafe, Long> {
    boolean existsCafeByAddressAndCafename(String address, String cafename);

    Cafe findByCafename(String businessname);
    boolean existsByAddressAndCafename(String Address,String Cafename);

}
