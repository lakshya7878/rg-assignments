package Week2;

public class Question1 {
    public static void main(String[] args) {
        System.out.println(TaxUtil.calculateTax(50000, 0.15));
    }

    public static class TaxUtil {
        public static double calculateTax(double amount, double rate) {
            return amount * rate;
        }
    }
}
