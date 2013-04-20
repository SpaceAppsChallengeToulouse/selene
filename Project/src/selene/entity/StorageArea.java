package selene.entity;

import java.util.ArrayList;

public class StorageArea extends Building {
	protected ArrayList<String> storedResources;
	protected ArrayList<Double> storageCapabilities;
	protected ArrayList<Double> usedSpaces;
	
		
	public StorageArea(String name, int positionX, int positionY,
			double energyConsumption, ArrayList<Double> resourcesCosts,
			ArrayList<Double> partsCosts, double robotworkCost,
			double usuryLevel, int sizeX, int sizeY,
			ArrayList<String> storedResources,
			ArrayList<Double> storageCapabilities, ArrayList<Double> usedSpaces) {
		super(name, positionX, positionY, energyConsumption, resourcesCosts,
				partsCosts, robotworkCost, usuryLevel, sizeX, sizeY);
		this.storedResources = storedResources;
		this.storageCapabilities = storageCapabilities;
		this.usedSpaces = usedSpaces;
	}


	public ArrayList<String> getStoredResources() {
		return storedResources;
	}
	
	public void addStoredResource(String resourceName) {
		this.addStoredResource(resourceName,0,0);
	}
	
	public void addStoredResource(String resourceName, double storageCapability) {
		this.addStoredResource(resourceName, storageCapability, 0);
	}
	
	public void addStoredResource(String resourceName, double storageCapability, double usedSpace) {
		this.storedResources.add(resourceName);
		this.storageCapabilities.add(storageCapability);
		this.usedSpaces.add(usedSpace);
	}
	
	public void setStoredResources(ArrayList<String> storedResources) {
		this.storedResources = storedResources;
	}
	
	public ArrayList<Double> getStorageCapabilities() {
		return storageCapabilities;
	}
	
	public double getStorageCapability(String resourceName) {
		int id = storedResources.indexOf(resourceName);
		
		return storageCapabilities.get(id);
	}
	
	public void setStorageCapabilities(ArrayList<Double> storageCapabilities) {
		this.storageCapabilities = storageCapabilities;
	}
	
	public void setStorageCapability(String resourceName, double value) {
		int id = storedResources.indexOf(resourceName);
		
		this.storageCapabilities.set(id, value);
	}
	
	public ArrayList<Double> getUsedSpaces() {
		return usedSpaces;
	}
	
	public double getUsedSpace(String resourceName) {
		int id = storedResources.indexOf(resourceName);
		
		return usedSpaces.get(id);
	}
	
	public void setUsedSpaces(ArrayList<Double> usedSpaces) {
		this.usedSpaces = usedSpaces;
	}
	
	public void setUsedSpace(String resourceName, double value) {
		int id = storedResources.indexOf(resourceName);
		
		this.usedSpaces.set(id, value);
	}
	
	
	
	

}
