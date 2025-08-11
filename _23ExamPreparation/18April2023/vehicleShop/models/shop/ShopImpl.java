package vehicleShop.models.shop;

import vehicleShop.models.tool.Tool;
import vehicleShop.models.vehicle.Vehicle;
import vehicleShop.models.worker.Worker;

public class ShopImpl implements Shop {


    @Override
    public void make(Vehicle vehicle, Worker worker) {

        for (Tool tool : worker.getTools()) {
            while (!tool.isUnfit() && worker.canWork() && !vehicle.reached()) {

                vehicle.making();
                tool.decreasesPower();
                worker.working();
            }

            if (vehicle.reached() || !worker.canWork()) {
                return;
                //break;
            }
        }
    }
}
