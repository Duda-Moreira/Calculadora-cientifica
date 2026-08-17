package calculadora_api.service;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
    public double calculate(String expression) {
        Expression exp = new ExpressionBuilder(expression)
            .build();
        
            return exp.evaluate();
    }
}