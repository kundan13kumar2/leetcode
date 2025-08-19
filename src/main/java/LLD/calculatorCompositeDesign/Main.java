package LLD.calculatorCompositeDesign;

public class Main {
    public static void main(String[] args) {

        ArithmeticExpression two = new Number(2);
        ArithmeticExpression one = new Number(1);
        ArithmeticExpression seven = new Number(7);

        ArithmeticExpression additionExpression = new Expression(one, seven, Operation.ADD);
        ArithmeticExpression multiplyExpression = new Expression(two, additionExpression, Operation.SUBTRACT);

        System.out.println(multiplyExpression.evaluate());
    }
}
