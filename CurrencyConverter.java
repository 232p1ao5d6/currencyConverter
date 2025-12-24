import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CurrencyConverter {

    // ANSI colors for console beauty
    private static final String RESET = "\u001B[0m";
    private static final String BLUE = "\u001B[34m";
    private static final String GREEN = "\u001B[32m";
    private static final String RED = "\u001B[31m";
    private static final String CYAN = "\u001B[36m";
    private static final String YELLOW = "\u001B[33m";

    // Simulated currency rates (Base: USD)
    private static Map<String, Double> loadRates() {
        Map<String, Double> rates = new HashMap<>();
        rates.put("USD", 1.0);
        rates.put("INR", 83.20);
        rates.put("EUR", 0.92);
        rates.put("GBP", 0.78);
        rates.put("JPY", 151.30);
        return rates;
    }

    // Currency symbols
    private static String symbol(String currency) {
        switch (currency) {
            case "USD": return "$";
            case "INR": return "₹";
            case "EUR": return "€";
            case "GBP": return "£";
            case "JPY": return "¥";
            default: return "";
        }
    }

    // Conversion logic
    private static double convert(double amount, double fromRate, double toRate) {
        return (amount / fromRate) * toRate;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Map<String, Double> rates = loadRates();

        // Header
        System.out.println(BLUE + "══════════════════════════════════════");
        System.out.println("        💱 CURRENCY CONVERTER 💱       ");
        System.out.println("══════════════════════════════════════" + RESET);

        System.out.println(CYAN + "Available Currencies ➜ USD | INR | EUR | GBP | JPY" + RESET);

        // Inputs
        System.out.print(YELLOW + "\nEnter Base Currency    : " + RESET);
        String base = sc.next().toUpperCase();

        System.out.print(YELLOW + "Enter Target Currency  : " + RESET);
        String target = sc.next().toUpperCase();

        // Validation
        if (!rates.containsKey(base) || !rates.containsKey(target)) {
            System.out.println(RED + "\n❌ Invalid currency selection!" + RESET);
            sc.close();
            return;
        }

        System.out.print(YELLOW + "Enter Amount           : " + RESET);
        double amount = sc.nextDouble();

        if (amount <= 0) {
            System.out.println(RED + "\n❌ Amount must be greater than zero!" + RESET);
            sc.close();
            return;
        }

        // Conversion
        double result = convert(amount, rates.get(base), rates.get(target));

        // Output
        System.out.println(GREEN + "\n✅ Conversion Successful!");
        System.out.println("──────────────────────────────────────");
        System.out.printf(
                "%s%.2f %s  ➜  %s%.2f %s%n",
                symbol(base), amount, base,
                symbol(target), result, target
        );
        System.out.println("──────────────────────────────────────" + RESET);

        // Footer
        System.out.println(BLUE + "✨ Thank you for using Currency Converter ✨");
        System.out.println("══════════════════════════════════════" + RESET);

        sc.close();
    }
}
