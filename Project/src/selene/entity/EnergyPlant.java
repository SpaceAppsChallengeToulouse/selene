package selene.entity;

import java.util.ArrayList;

public class EnergyPlant extends Building {

	public EnergyPlant(String name, int positionX, int positionY,
			double energyConsumption, ArrayList<Double> resourcesCosts,
			ArrayList<Double> partsCosts, double robotworkCost,
			double usuryLevel, int sizeX, int sizeY) {
		super(name, positionX, positionY, energyConsumption, resourcesCosts,
				partsCosts, robotworkCost, usuryLevel, sizeX, sizeY);
		// TODO Auto-generated constructor stub
	}

}
