package selene.entity;

import java.util.ArrayList;

public abstract class IEntity {
	
	protected String name;
	
	protected int positionX;
	protected int positionY;
	
	protected double energyConsumption;
	
	protected ArrayList<Double> resourcesCosts;
	protected ArrayList<Double> partsCosts;
	protected double robotworkCost;
	
	protected double usuryLevel;

	public IEntity(String name, int positionX, int positionY,
			double energyConsumption, ArrayList<Double> resourcesCosts,
			ArrayList<Double> partsCosts, double robotworkCost,
			double usuryLevel) {
		super();
		this.name = name;
		this.positionX = positionX;
		this.positionY = positionY;
		this.energyConsumption = energyConsumption;
		this.resourcesCosts = resourcesCosts;
		this.partsCosts = partsCosts;
		this.robotworkCost = robotworkCost;
		this.usuryLevel = usuryLevel;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPositionX() {
		return positionX;
	}

	public void setPositionX(int positionX) { //limit
		this.positionX = positionX;
	}

	public int getPositionY() {
		return positionY;
	}

	public void setPositionY(int positionY) { //limit
		this.positionY = positionY;
	}

	public double getEnergyConsumption() {
		return energyConsumption;
	}

	public void setEnergyConsumption(double energyConsumption) {
		this.energyConsumption = energyConsumption;
	}

	public ArrayList<Double> getResourcesCosts() {
		return resourcesCosts;
	}

	public void setResourcesCosts(ArrayList<Double> resourcesCosts) {
		this.resourcesCosts = resourcesCosts;
	}

	public ArrayList<Double> getPartsCosts() {
		return partsCosts;
	}

	public void setPartsCosts(ArrayList<Double> partsCosts) {
		this.partsCosts = partsCosts;
	}

	public double getRobotworkCost() {
		return robotworkCost;
	}

	public void setRobotworkCost(double robotworkCost) {
		this.robotworkCost = robotworkCost;
	}

	public double getUsuryLevel() {
		return usuryLevel;
	}

	public void setUsuryLevel(double usuryLevel) {
		this.usuryLevel = usuryLevel;
	}
	

}
