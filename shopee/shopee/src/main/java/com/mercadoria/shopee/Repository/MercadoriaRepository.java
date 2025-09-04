package com.mercadoria.shopee.Repository;

import com.mercadoria.shopee.Entity.Mercadoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface MercadoriaRepository extends JpaRepository<Mercadoria, UUID>{
}
