package _09Polymorphism.Word;

public class Initialization {

    public static CommandInterface buildCmdInterface(StringBuilder buff) {
        return new CommandImpl(buff);
    }
}
