package calculadora_api.controller;

import calculadora_api.dto.CalculationRequest;
import calculadora_api.dto.CalculationResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/calculator")
public class CalculatorController {
    @PostMapping("/calculate")
    public CalculationResponse calculate(
        @RequestBody CalculationRequest request
    ) {
        double result = 4.0;

        return new CalculationResponse(result);
    }
}
