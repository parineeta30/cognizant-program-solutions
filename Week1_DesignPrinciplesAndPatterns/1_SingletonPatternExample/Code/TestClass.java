public class TestClass {

        public static void main(String[] args) {
        Logger logger1 = Logger.getLogger();
        Logger logger2 = Logger.getLogger();

        System.out.println("Logger1 hashCode: " + logger1.hashCode());
        System.out.println("Logger2 hashCode: " + logger2.hashCode());
        System.out.println("Same instance? " + (logger1 == logger2));
    }

    
}
