package calculadora_api.controller;

import calculadora_api.dto.CalculationRequest;
import calculadora_api.dto.CalculationResponse;
import calculadora_api.service.CalculatorService;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/calculator")
public class CalculatorController {
   private final CalculatorService calculatorService;

   public CalculatorController(CalculatorService calculatorService) {
    this.calculatorService = calculatorService;
   }

   @PostMapping("/calculate")
   public CalculationResponse calculate(
    @RequestBody CalculationRequest request
    ) {
        double result = 
        calculatorService.calculate(
            request.getExpression()
        );

        return new CalculationResponse(result);
    }
}