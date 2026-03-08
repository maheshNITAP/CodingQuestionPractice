package LLD.InterPreterDesignPattern;

public class Client {
    public static void main(String[] args) {
        Context context = new Context();
        context.setValue("a", 5);
        context.setValue("b", 10);
        context.setValue("c", 2);

        AbstractExpression expression = new MultiplyNonTerminalExpression(
                new MultiplyNonTerminalExpression(
                        new NumberTerminalExpression("a"),
                        new NumberTerminalExpression("b")
                ),
                new NumberTerminalExpression("c")
        );

        int result = expression.interpret(context);
        System.out.println("Result: " + result); // Output: Result: 30
    }
}
