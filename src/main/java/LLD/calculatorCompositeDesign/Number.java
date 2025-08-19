package LLD.calculatorCompositeDesign;

import lombok.Data;

@Data
public class Number implements ArithmeticExpression {
    int value;

    Number(int value) {
        this.value = value;
    }

    @Override
    public int evaluate() {
        return value;
    }
}
