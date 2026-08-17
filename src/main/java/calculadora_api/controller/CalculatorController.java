package calculadora_api.controller;

import calculadora_api.dto.CalculationRequest;
import calculadora_api.dto.CalculationResponse;
import calculadora_api.service.CalculatorService;
import calculadora_api.model.Calculation;
import calculadora_api.service.HistoryService;
import calculadora_api.dto.FavoriteRequest;
import calculadora_api.model.FavoriteCalculation;
import calculadora_api.service.FavoriteService;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/calculator")
public class CalculatorController {
    private final CalculatorService calculatorService;
    private final HistoryService historyService;
    private final FavoriteService favoriteService;

    public CalculatorController(
        CalculatorService calculatorService,
        HistoryService historyService,
        FavoriteService favoriteService
    ) {
        this.calculatorService = calculatorService;
        this.historyService = historyService;
        this.favoriteService = favoriteService;
    }

    @PostMapping("/calculate")
    public CalculationResponse calculate(
        @RequestBody CalculationRequest request
    ) {
        double result = 
            calculatorService.calculate(
                request.getExpression()
            );
        
        historyService.add(
            new Calculation(
                request.getExpression(),
                result,
                LocalDateTime.now()
            )
        );

        return new CalculationResponse(result);
    }

    @GetMapping("/history")
    public List<Calculation> history() {
        return historyService.getHistory();
    }

    @PostMapping("/favorite")
    public void favorite(
        @RequestBody FavoriteRequest request
    ) {
        favoriteService.add(
            new FavoriteCalculation(
                request.getExpression(),
                request.getResult()
            )
        );
    }

    @GetMapping("/favorites")
    public List<FavoriteCalculation> favorites() {
        return favoriteService.getFavorites();
    }
}