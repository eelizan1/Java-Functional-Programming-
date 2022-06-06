package functionalinterface;

import java.util.List;
import java.util.function.Supplier;

public class _Supplier {
    public static void main(String[] args) {
        System.out.println(getDBConnectionUrl());
        System.out.println(getDBConnectionUrlsSupplier.get());
    }

    // old way
    static String getDBConnectionUrl() {
        return "jdbc://localhost:5432/users";
    }

    // supplier way
    static Supplier<String> getDbConnectionUrlSupplier1 = () -> "jdbc://localhost:5432/users";

    // supplier that stores items in a list collection
    static Supplier<List<String>> getDBConnectionUrlsSupplier = ()
        -> List.of(
        "jdbc://localhost:5432/users",
        "jdbc://localhost:5432/customer");
}
