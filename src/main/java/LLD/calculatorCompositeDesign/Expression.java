package LLD.calculatorCompositeDesign;

import lombok.Data;

@Data
public class Expression implements ArithmeticExpression {
    ArithmeticExpression leftExpression;
    ArithmeticExpression rightExpression;
    Operation operation;

    Expression(ArithmeticExpression leftExpression, ArithmeticExpression rightExpression, Operation operation) {
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
        this.operation = operation;
    }


    @Override
    public int evaluate() {
        switch (operation) {
            case ADD:
                return leftExpression.evaluate() + rightExpression.evaluate();
            case MULTIPLY:
                return leftExpression.evaluate() * rightExpression.evaluate();
            case SUBTRACT:
                return leftExpression.evaluate() - rightExpression.evaluate();
        }
        return 0;
    }
}
