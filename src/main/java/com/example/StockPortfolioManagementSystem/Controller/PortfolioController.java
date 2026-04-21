package com.example.StockPortfolioManagementSystem.Controller;

import com.example.StockPortfolioManagementSystem.DTO.PortfolioResponse;
import com.example.StockPortfolioManagementSystem.Entity.Holding;
import com.example.StockPortfolioManagementSystem.Service.PortfolioService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/portfolio")
public class PortfolioController {

    private final PortfolioService ps;

    public PortfolioController(PortfolioService ps) {
        this.ps = ps;
    }

    // GET
    @GetMapping
    public PortfolioResponse getPortfolio() {
        return ps.getPortfolio();
    }

    // ADD
    @PostMapping
    public String addHolding(@RequestBody Holding h) {
        ps.addPortfolio(h);
        return "Holding added";
    }

    // UPDATE
    @PutMapping("/{userId}")
    public String updateHolding(@PathVariable Long userId,
                                @RequestBody Holding h) {
        ps.updatePortfolio(userId, h);
        return "Updated successfully";
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String deleteHolding(@PathVariable Long id) {
        ps.deletePortfolio(id);
        return "Deleted successfully";
    }
}