package selene.entity;

import java.util.ArrayList;

public class ReparationCenter extends Building {
	
	protected double reparationRate;
	
	public ReparationCenter(String name, int positionX, int positionY,
			double energyConsumption, ArrayList<Double> resourcesCosts,
			ArrayList<Double> partsCosts, double robotworkCost,
			double usuryLevel, int sizeX, int sizeY, double reparationRate) {
		super(name, positionX, positionY, energyConsumption, resourcesCosts,
				partsCosts, robotworkCost, usuryLevel, sizeX, sizeY);
		this.reparationRate = reparationRate;
	}

	public double getReparationRate() {
		return reparationRate;
	}

	public void setReparationRate(double reparationRate) {
		this.reparationRate = reparationRate;
	}

}
