package selene.entity;

import java.util.ArrayList;

public class Mine extends Building {
	protected ArrayList<String> extractedResources;
	
	protected ArrayList<Double> extractionRate;

	public Mine(String name, int positionX, int positionY,
			double energyConsumption, ArrayList<Double> resourcesCosts,
			ArrayList<Double> partsCosts, double robotworkCost,
			double usuryLevel, int sizeX, int sizeY,
			ArrayList<String> extractedResources,
			ArrayList<Double> extractionRate) {
		super(name, positionX, positionY, energyConsumption, resourcesCosts,
				partsCosts, robotworkCost, usuryLevel, sizeX, sizeY);
		this.extractedResources = extractedResources;
		this.extractionRate = extractionRate;
	}

	public ArrayList<String> getExtractedResources() {
		return extractedResources;
	}

	public void setExtractedResources(ArrayList<String> extractedResources) {
		this.extractedResources = extractedResources;
	}
	
	public void addExtractedResource(String resourceName) {
		this.addExtractedResource(resourceName, 0);
		
	}
	
	public void addExtractedResource(String resourceName, double value ) {
		this.extractedResources.add(resourceName);
		this.extractionRate.add(value);
	}

	public ArrayList<Double> getExtractionRate() {
		return extractionRate;
	}
	
	public double getExtractionRate(String resourceName) {
		int id = extractedResources.indexOf(resourceName);
		
		return extractionRate.get(id);
	}

	public void setExtractionRate(ArrayList<Double> extractionRate) {
		this.extractionRate = extractionRate;
	}
	
	public void setExtractionRate(String resourceName, double value) {
		int id = extractedResources.indexOf(resourceName);
		
		this.extractionRate.set(id, value);
	}
	
	
}
