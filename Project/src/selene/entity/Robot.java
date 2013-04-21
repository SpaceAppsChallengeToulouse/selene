package selene.entity;

import java.util.ArrayList;

public class Robot extends IEntity {
	protected double velocity;
	protected double velocityMax;
	
	protected double range;
	
	protected double energyLevel;
	protected double energyLevelMax;
	
	protected String currentOccupation;
	
	protected ArrayList<String> capabilities;
	protected ArrayList<Double> levelsOfExpertise;
	
	public Robot(String name, int positionX, int positionY,
			double energyConsumption, ArrayList<Double> resourcesCosts,
			ArrayList<Double> partsCosts, double robotworkCost,
			double usuryLevel, double velocity, double velocityMax,
			double range, double energyLevel, double energyLevelMax,
			String currentOccupation, ArrayList<String> capabilities,
			ArrayList<Double> levelsOfExpertise) {
		super(name, positionX, positionY, energyConsumption, resourcesCosts,
				partsCosts, robotworkCost, usuryLevel);
		this.velocity = velocity;
		this.velocityMax = velocityMax;
		this.range = range;
		this.energyLevel = energyLevel;
		this.energyLevelMax = energyLevelMax;
		this.currentOccupation = currentOccupation;
		this.capabilities = capabilities;
		this.levelsOfExpertise = levelsOfExpertise;
	}

	public double getVelocity() {
		return velocity;
	}
	
	public void setVelocity(double velocity) {

		this.velocity =(velocity>this.velocityMax)?this.velocityMax : velocity;
	}
	
	public double getVelocityMax() {
		return velocityMax;
	}
	
	public void setVelocityMax(double velocityMax) {
		this.velocityMax = velocityMax;
	}
	
	public double getRange() {
		return range;
	}
	
	public void setRange(double range) {
		this.range = range;
	}
	
	public double getEnergyLevel() {
		return energyLevel;
	}
	
	public void setEnergyLevel(double energyLevel) {
		this.energyLevel = (energyLevel>this.energyLevelMax)?this.energyLevelMax:energyLevel;
	}
	
	public double getEnergyLevelMax() {
		return energyLevelMax;
	}
	
	public void setEnergyLevelMax(double energyLevelMax) {
		this.energyLevelMax = energyLevelMax;
	}
	
	public String getCurrentOccupation() {
		return currentOccupation;
	}
	
	public void setCurrentOccupation(String currentOccupation) {
		this.currentOccupation = currentOccupation;
	}
	
	public ArrayList<String> getCapabilities() {
		return capabilities;
	}
	
	public void addCapability(String capabilityName) {
		this.addCapability(capabilityName,0);
	}

	public void addCapability(String capabilityName, double level) {
		this.capabilities.add(capabilityName);
		this.levelsOfExpertise.add(level);
	}
	
	public void setCapabilities(ArrayList<String> capabilities) {
		this.capabilities = capabilities;
	}
	
	public ArrayList<Double> getLevelsOfExpertise() {
		return levelsOfExpertise;
	}
	
	public void setLevelsOfExpertise(ArrayList<Double> levelsOfExpertise) {
		this.levelsOfExpertise = levelsOfExpertise;
	}
	
	public void setLevelOfExpertise(String capabilityName, double level) {
		int id = capabilities.indexOf(capabilityName);
		
		this.levelsOfExpertise.set(id, level);
	}
	
	

}
