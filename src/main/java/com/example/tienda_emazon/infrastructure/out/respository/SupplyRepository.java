package com.example.tienda_emazon.infrastructure.out.respository;

import com.example.tienda_emazon.domain.model.SupplyModel;
import com.example.tienda_emazon.infrastructure.out.entity.SupplyEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SupplyRepository {
    SupplyModel saveSupply(SupplyModel supplyModel);
    Page<SupplyModel> findAllPaginated(Pageable pageable);
    SupplyEntity save(SupplyEntity supplyEntity);
}
