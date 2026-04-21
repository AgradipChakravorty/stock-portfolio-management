package com.example.StockPortfolioManagementSystem.Service;

import com.example.StockPortfolioManagementSystem.DTO.HoldingResponse;
import com.example.StockPortfolioManagementSystem.DTO.PortfolioResponse;
import com.example.StockPortfolioManagementSystem.Entity.Holding;
import com.example.StockPortfolioManagementSystem.Repository.HoldingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PortfolioService {

    @Autowired
    private HoldingRepository holdingRepository;

    // GET PORTFOLIO
    public PortfolioResponse getPortfolio() {

        List<Holding> holdings = holdingRepository.findAll();

        List<HoldingResponse> responseList = new ArrayList<>();

        double totalInvestment = 0;
        double totalValue = 0;

        for (Holding h : holdings) {

            // ✅ SAFETY CHECK (prevents 500 error)
            if (h == null || h.getStock() == null || h.getUser() == null) {
                continue;
            }

            HoldingResponse res = new HoldingResponse();

            // stock name
            res.setStockName(h.getStock().getSymbol());

            // quantity & buy price
            res.setQuantity(h.getQuantity());
            res.setBuyPrice(h.getBuyPrice());

            // current price (safe access)
            double currentPrice = h.getStock().getCurrentPrice();
            res.setCurrentPrice(currentPrice);

            // calculations
            double investment = h.getBuyPrice() * h.getQuantity();
            double value = currentPrice * h.getQuantity();
            double profit = value - investment;

            res.setProfit(profit);

            totalInvestment += investment;
            totalValue += value;

            responseList.add(res);
        }

        PortfolioResponse response = new PortfolioResponse();
        response.setHoldings(responseList);
        response.setTotalInvestment(totalInvestment);
        response.setTotalValue(totalValue);
        response.setTotalProfit(totalValue - totalInvestment);

        return response;
    }
    // ADD
    public void addPortfolio(Holding h) {
        holdingRepository.save(h);
    }

    // DELETE
    public void deletePortfolio(Long id) {
        holdingRepository.deleteById(id);
    }

    // UPDATE
    public void updatePortfolio(Long userId, Holding updatedHolding) {

        List<Holding> holdings = holdingRepository.findByUserId(userId);

        Holding existing = null;

        for (Holding h : holdings) {
            if (h.getStock().getId().equals(updatedHolding.getStock().getId())) {
                existing = h;
                break;
            }
        }

        if (existing == null) {
            throw new RuntimeException("Holding not found");
        }

        existing.setQuantity(updatedHolding.getQuantity());
        existing.setBuyPrice(updatedHolding.getBuyPrice());

        holdingRepository.save(existing);
    }
}