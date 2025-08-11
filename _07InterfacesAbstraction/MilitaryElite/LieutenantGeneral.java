package _07InterfacesAbstraction.MilitaryElite;

public interface LieutenantGeneral extends Private {

    void addPrivate(Private p);
    Iterable<Private> getPrivates();
}
