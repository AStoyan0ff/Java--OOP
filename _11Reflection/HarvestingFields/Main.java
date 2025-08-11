package _11Reflection.HarvestingFields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		Class<RichSoilLand> clazz = RichSoilLand.class;
		Field[] fields = clazz.getDeclaredFields();

		while (true) {
			String command = scanner.nextLine();

			if ("HARVEST".equals(command)) {
				break;
			}

			switch (command) {

				case "private":
					printFieldsWithModifier(fields, Modifier.PRIVATE);
					break;

				case "protected":
					printFieldsWithModifier(fields, Modifier.PROTECTED);
					break;

				case "public":
					printFieldsWithModifier(fields, Modifier.PUBLIC);
					break;

				case "all":
					printAllFields(fields);
					break;

				default:
					System.out.println("Invalid command: " + command);
			}
		}
	}

	private static void printFieldsWithModifier(Field[] fields, int modifier) {
		for (Field field : fields) {

			if (Modifier.isPrivate(modifier) && Modifier.isPrivate(field.getModifiers())) {
				printField(field, "private");
			}
			else if (Modifier.isProtected(modifier) && Modifier.isProtected(field.getModifiers())) {
				printField(field, "protected");
			}
			else if (Modifier.isPublic(modifier) && Modifier.isPublic(field.getModifiers())) {
				printField(field, "public");
			}
		}
	}

	private static void printAllFields(Field[] fields) {

		for (Field field : fields) {
			String accessModifier;

			if (Modifier.isPrivate(field.getModifiers())) {
				accessModifier = "private";
			}
			else if (Modifier.isProtected(field.getModifiers())) {
				accessModifier = "protected";
			}
			else if (Modifier.isPublic(field.getModifiers())) {
				accessModifier = "public";
			}
			else {
				accessModifier = "default";
			}
			printField(field, accessModifier);
		}
	}

	private static void printField(Field field, String accessModifier) {

		System.out.printf("%s %s %s%n", accessModifier,
				field.getType().getSimpleName(),
				field.getName());

	}
}
