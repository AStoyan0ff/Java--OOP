package _07InterfacesAbstraction.MilitaryElite;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<Integer, Private> privateMap = new HashMap<>();
        List<Soldier> soldierList = new ArrayList<>();

        while (true) {
            String line = scanner.nextLine();
            if ("End".equals(line)) break;

            String[] data = line.split("\\s+");

            String type = data[0];
            int id = Integer.parseInt(data[1]);
            String firstName = data[2];
            String lastName = data[3];

            switch (type) {
                case "Private" -> {
                    double salary = Double.parseDouble(data[4]);

                    PrivateImpl p = new PrivateImpl(id, firstName, lastName, salary);
                    privateMap.put(id, p);
                    soldierList.add(p);
                }
                case "LieutenantGeneral" -> {
                    double salary = Double.parseDouble(data[4]);

                    LieutenantGeneralImpl general = new LieutenantGeneralImpl(id, firstName, lastName, salary);

                    for (int pos = 5; pos < data.length; pos++) {

                        int pId = Integer.parseInt(data[pos]);
                        if (privateMap.containsKey(pId)) general.addPrivate(privateMap.get(pId));
                    }
                    soldierList.add(general);
                }
                case "Engineer" -> {

                    double salary = Double.parseDouble(data[4]);
                    String corpsStr = data[5];

                    Corps corps;

                    try {
                        corps = Corps.valueOf(corpsStr);
                    }
                    catch (IllegalArgumentException e) {
                        continue;
                    }
                    EngineerImpl engineer = new EngineerImpl(id, firstName, lastName, salary, corps);

                    for (int pos = 6; pos < data.length; pos += 2) {

                        String part = data[pos];
                        int hours = Integer.parseInt(data[pos + 1]);
                        engineer.addRepairs(new RepairImpl(part, hours));
                    }
                    soldierList.add(engineer);
                }
                case "Commando" -> {

                    double salary = Double.parseDouble(data[4]);
                    String corpsStr = data[5];
                    Corps corps;

                    try {
                        corps = Corps.valueOf(corpsStr);
                    }
                    catch (IllegalArgumentException e) {
                        continue;
                    }
                    CommandoImpl commando = new CommandoImpl(id, firstName, lastName, salary, corps) {
                        @Override
                        public Iterable<Mission> getMission() {
                            return null;
                        }
                    };

                    for (int pos = 6; pos < data.length; pos += 2) {

                        String code = data[pos];
                        String state = data[pos + 1];

                        if (!state.equals("inProgress") && !state.equals("finished")) continue;
                        commando.addMission(new MissionImpl(code, state));
                    }
                    soldierList.add(commando);
                }
                case "Spy" -> {

                    String codeNumber = data[4];
                    soldierList.add(new SpyImpl(id, firstName, lastName, codeNumber));
                }
            }
        }
        soldierList.forEach(s -> System.out.println(s));
    }
}
