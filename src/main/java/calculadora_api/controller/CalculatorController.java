package calculadora_api.controller;

import calculadora_api.dto.CalculationRequest;
import calculadora_api.dto.CalculationResponse;
import calculadora_api.service.CalculatorService;
import calculadora_api.model.Calculation;
import calculadora_api.service.HistoryService;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/calculator")
public class CalculatorController {
    private final CalculatorService calculatorService;
    private final HistoryService historyService;

    public CalculatorController(
        CalculatorService calculatorService,
        HistoryService historyService
    ) {
        this.calculatorService = calculatorService;
        this.historyService = historyService;
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
}