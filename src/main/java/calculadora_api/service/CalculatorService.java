package calculadora_api.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
    
    public double calculate(String expression) {

        expression = expression.replace(" ", "");

        if (expression.contains("+")) {
            String[] parts = expression.split("\\+");

            double a = Double.parseDouble(parts[0]);
            double b = Double.parseDouble(parts[1]);

            return a + b;
        }

        throw new IllegalArgumentException("Operação não suportada.");
    }
}