package calculadora_api.dto;

public class FavoriteRequest {
    private String expression;
    private double result;

    public String getExpression() {
        return expression;
    }

    public void setExpression(
        String expression
    ) {
        this.expression = expression;
    }

    public double getResult() {
        return result;
    }

    public void setResult(
        double result
    ) {
        this.result = result;
    }
}
