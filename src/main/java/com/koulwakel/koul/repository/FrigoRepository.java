package com.koulwakel.koul.repository;

import com.koulwakel.koul.Entites.Frigo;
import com.koulwakel.koul.Entites.FrigoPk;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FrigoRepository extends JpaRepository<Frigo, FrigoPk> {
}
