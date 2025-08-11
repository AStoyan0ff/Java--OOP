package _11Reflection.BarracksWarsFactory.factories;


import _11Reflection.BarracksWarsFactory.units.Unit;

public class UnitFactoryImpl implements UnitFactory {

    private static final String UNITS_PACKAGE_NAME = "barracks.units.";

    @Override
    public Unit createUnit(String unitType) throws ReflectiveOperationException {

        Class<?> unitClass = Class.forName(UNITS_PACKAGE_NAME + unitType);
        return (Unit) unitClass.getDeclaredConstructor().newInstance();
    }
}
