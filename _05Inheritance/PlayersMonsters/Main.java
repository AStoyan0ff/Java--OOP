package _05Inheritance.PlayersMonsters;

public class Main {
    public static void main(String[] args) {

        BladeKnight bladeKnight = new BladeKnight("Andrey", 100);
        DarkKnight darkKnight = new DarkKnight("Ramadan", 99);
        Knight knight = new Knight("Apolo", 98);
        SoulMaster soulMaster = new SoulMaster("Pantera", 97);
        DarkWizard darkWizard = new DarkWizard("Darkan", 80);
        Wizard wizard = new Wizard("Simeon", 70);
        MuseElf museElf = new MuseElf("Elf", 60);
        Elf elf = new Elf("Rooster", 20);

        System.out.println(bladeKnight);
        System.out.println(darkKnight);
        System.out.println(knight);
        System.out.println(soulMaster);
        System.out.println(darkWizard);
        System.out.println(wizard);
        System.out.println(museElf);
        System.out.println(elf);
    }
}
