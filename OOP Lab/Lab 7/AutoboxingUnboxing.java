public class AutoboxingUnboxing{
    public static void main(String[] args) {
        int intPrimitive = 10;
        Integer intWrapper = intPrimitive;  
        System.out.println("Autoboxing int: " + intWrapper);
        Integer intWrapper2 = 25;
        int intPrimitive2 = intWrapper2; 
        System.out.println("Unboxing Integer: " + intPrimitive2);

        double doublePrimitive = 20.5;
        Double doubleWrapper = doublePrimitive;
        System.out.println("Autoboxing double: " + doubleWrapper);
        Double doubleWrapper2 = 30.75;
        double doublePrimitive2 = doubleWrapper2; 
        System.out.println("Unboxing Double: " + doublePrimitive2);

        char charPrimitive = 'A';
        Character charWrapper = charPrimitive;
        System.out.println("Autoboxing char: " + charWrapper);
        Character charWrapper2 = 'Z';
        char charPrimitive2 = charWrapper2; 
        System.out.println("Unboxing Character: " + charPrimitive2);

        boolean booleanPrimitive = true;
        Boolean booleanWrapper = booleanPrimitive;
        System.out.println("Autoboxing boolean: " + booleanWrapper);
        Boolean booleanWrapper2 = false;
        boolean booleanPrimitive2 = booleanWrapper2; 
        System.out.println("Unboxing Boolean: " + booleanPrimitive2);

        byte bytePrimitive = 5;
        Byte byteWrapper = bytePrimitive;
        System.out.println("Autoboxing byte: " + byteWrapper);
        byte bytePrimitive2 = byteWrapper; 
        System.out.println("Unboxing Byte: " + bytePrimitive2);

        short shortPrimitive = 1000;
        Short shortWrapper = shortPrimitive;
        System.out.println("Autoboxing short: " + shortWrapper);
        short shortPrimitive2 = shortWrapper; 
        System.out.println("Unboxing Short: " + shortPrimitive2);

        long longPrimitive = 100000L;
        Long longWrapper = longPrimitive;
        System.out.println("Autoboxing long: " + longWrapper);
        long longPrimitive2 = longWrapper; 
        System.out.println("Unboxing Long: " + longPrimitive2);

        float floatPrimitive = 5.5f;
        Float floatWrapper = floatPrimitive;
        System.out.println("Autoboxing float: " + floatWrapper);
        float floatPrimitive2 = floatWrapper; 
        System.out.println("Unboxing Float: " + floatPrimitive2);
    }
}
