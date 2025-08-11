package _07InterfacesAbstraction.MilitaryElite;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class LieutenantGeneralImpl extends PrivateImpl implements LieutenantGeneral {

    private Set<Private> privateSet = new TreeSet<>(Comparator.comparingInt(Soldier::getId).reversed());

    public LieutenantGeneralImpl(int id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName, salary);
    }

    @Override
    public void addPrivate(Private p) {
        privateSet.add(p);
    }

    @Override
    public Iterable<Private> getPrivates() {
        return privateSet;
    }

    @Override
    public String toString() {

        StringBuilder buff = new StringBuilder(super.toString()).append(System.lineSeparator()).append("Privates:");

        for (Private p : privateSet) {
            buff.append(System.lineSeparator()).append("  ").append(p.toString());
        }
        return buff.toString();
    }
}
