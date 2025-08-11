package vehicleShop.models.tool;

import vehicleShop.common.ExceptionMessages;

public class ToolImpl implements Tool {

    private int power;

    public ToolImpl(int power) {
        setPower(power);
    }

    public void setPower(int power) {

        if (power < 0) {
            throw new IllegalArgumentException(ExceptionMessages.TOOL_POWER_LESS_THAN_ZERO);
        }
        this.power = power;
    }


    public int getPower() {
        return power;
    }


    public void decreasesPower() {
        this.power = Math.max(0, this.power - 5);

        /*if (this.power - 5 < 0) {
            this.power = 0;
        }
        else {
            this.power -= 5;
        }*/
    }


    public boolean isUnfit() {
        return this.power == 0;
    }
}
