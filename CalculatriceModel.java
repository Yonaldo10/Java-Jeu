package model;

public class CalculatriceModel {
    public double calculer(double a, double b, String operateur) {
        switch (operateur) {
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            case "/": 
                if (b == 0) throw new ArithmeticException("Division par zéro");
                return a / b;
            default: return 0;
        }
    }
}