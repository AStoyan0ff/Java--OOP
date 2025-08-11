package _11Reflection.BlackBoxInt;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException, NoSuchMethodException, ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);

        Class<?> clazz = Class.forName("blackBoxInt.BlackBoxInt");
        Constructor<?> ctor = clazz.getDeclaredConstructor();
        ctor.setAccessible(true);
        Object blackBox = ctor.newInstance();

        Field innerValueField = clazz.getDeclaredField("innerValue");
        innerValueField.setAccessible(true);

        while (true) {
            String input = scanner.nextLine();

            if ("END".equals(input)) {
                break;
            }

            String[] parts = input.split("_");

            String methodName = parts[0];
            int value = Integer.parseInt(parts[1]);

            Method method = clazz.getDeclaredMethod(methodName, int.class);
            method.setAccessible(true);
            method.invoke(blackBox, value);

            int currentValue = (int) innerValueField.get(blackBox);
            System.out.println(currentValue);
        }
    }
}
