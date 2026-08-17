package calculadora_api.model;

import java.time.LocalDateTime;

public class Calculation {
    private String expression;
    private double result;
    private LocalDateTime timestamp;

    public Calculation(
            String expression,
            double result,
            LocalDateTime timestamp

    ) {
        this.expression = expression;
        this.result = result;
        this.timestamp = timestamp; 
    }

    public String getExpression() {
        return expression;
    }

    public double getResult() {
        return result;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}
