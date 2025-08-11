package _11Reflection.BarracksWarsFactory.factories;


import _11Reflection.BarracksWarsFactory.units.Unit;

public interface UnitFactory {

    Unit createUnit(String unitType) throws Exception;
}
