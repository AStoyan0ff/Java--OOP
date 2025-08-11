package _07InterfacesAbstraction.Telephony;
import java.util.List;

public class Smartphone implements Callable, Browsable {

    private List<String> numberList;
    private List<String> urlsList;

    public Smartphone(List<String> numberList, List<String> urlsList) {

        this.numberList = numberList;
        this.urlsList = urlsList;
    }

    @Override
    public String call() {
        StringBuilder buff = new StringBuilder();

        for (String num : numberList) {

            if (!num.matches("\\d+")) {
                buff.append("Invalid number!").append(System.lineSeparator());
            }
            else {
                buff.append("Calling... ").append(num).append(System.lineSeparator());
            }
        }
        return buff.toString();
    }

    @Override
    public String browse() {
        StringBuilder buff = new StringBuilder();

        for (String url : urlsList) {

            if (isValid(url)) {
                buff.append("Invalid URL!").append(System.lineSeparator());
            }
            else {
                buff.append("Browsing: ").append(url).append("!").append(System.lineSeparator());
            }
        }
        return buff.toString();
    }

    private boolean isValid(String url) {
        for (char c : url.toCharArray()) {

            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }
}
