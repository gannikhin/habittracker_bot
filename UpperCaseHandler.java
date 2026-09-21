public class UpperCaseHandler implements TextHandler {
    @Override
    public String handle(String input) {
        if (input == null) return "";
        return input.toUpperCase();
    }
}