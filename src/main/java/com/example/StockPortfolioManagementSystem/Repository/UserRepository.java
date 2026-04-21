package com.example.StockPortfolioManagementSystem.Repository;

import com.example.StockPortfolioManagementSystem.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{

}
