package com.mamaevas.KASDemoBackend.repositories;

import com.mamaevas.KASDemoBackend.entity.Church;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface ChurchRepository extends JpaRepository<Church, Long> {

 Church findByChurchName(@Param("churchName") String churchName);


}
