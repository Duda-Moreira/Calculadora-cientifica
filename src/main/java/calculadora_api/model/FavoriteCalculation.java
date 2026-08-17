package calculadora_api.model;

public class FavoriteCalculation {
    private String expression;
    private double result;

    public FavoriteCalculation(
        String expression,
        double result
    ) {
        this.expression = expression;
        this.result = result;
    }

    public String getExpression() {
        return expression;
    }

    public double getResult() {
        return result;
    }
}
