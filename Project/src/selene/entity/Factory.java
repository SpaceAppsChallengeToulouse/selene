package selene.entity;

import java.util.ArrayList;

public class Factory extends Building {

	protected double changeProductionTime;
	protected ArrayList<String> productibleParts;//change to part
	protected ArrayList<Double> productionTimes;

	public Factory(String name, int positionX, int positionY,
			double energyConsumption, ArrayList<Double> resourcesCosts,
			ArrayList<Double> partsCosts, double robotworkCost,
			double usuryLevel, int sizeX, int sizeY,
			double changeProductionTime, ArrayList<String> productibleParts,
			ArrayList<Double> productionTimes) {
		super(name, positionX, positionY, energyConsumption, resourcesCosts,
				partsCosts, robotworkCost, usuryLevel, sizeX, sizeY);
		this.changeProductionTime = changeProductionTime;
		this.productibleParts = productibleParts;
		this.productionTimes = productionTimes;
	}

	public double getChangeProductionTime() {
		return changeProductionTime;
	}

	public void setChangeProductionTime(double changeProductionTime) {
		this.changeProductionTime = changeProductionTime;
	}

	public ArrayList<String> getProductibleParts() {
		return productibleParts;
	}
	
	public void addProductiblePart(String partName) {
		
	}
	
	public void setProductibleParts(ArrayList<String> productibleParts) {
		this.productibleParts = productibleParts;
	}
	
	public ArrayList<Double> getProductionTimes() {
		return productionTimes;
	}
	
	public void setProductionTimes(ArrayList<Double> productionTimes) {
		this.productionTimes = productionTimes;
	}
	
}
