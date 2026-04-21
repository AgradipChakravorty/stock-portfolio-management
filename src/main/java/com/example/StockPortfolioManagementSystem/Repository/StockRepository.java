package com.example.StockPortfolioManagementSystem.Repository;

import com.example.StockPortfolioManagementSystem.Entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends JpaRepository<Stock,Long> {
}
