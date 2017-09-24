public class Switch {
    public static void main(String[] args) {
        String local = "1";
        switch (local) {
            case "12":
                System.exit(1);
            default:
                System.exit(0);
        }
    }
}
