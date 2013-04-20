package selene.entity;

import java.util.ArrayList;

public class Refinery extends Building {
	
	protected ArrayList<String> inputResources;
	protected ArrayList<String> outputResources;
	
	protected ArrayList<Double> inputRatio;
	protected ArrayList<Double> outputRatio;
	
	protected double transformationRate;

	
	
	public Refinery(String name, int positionX, int positionY,
			double energyConsumption, ArrayList<Double> resourcesCosts,
			ArrayList<Double> partsCosts, double robotworkCost,
			double usuryLevel, int sizeX, int sizeY,
			ArrayList<String> inputResources,
			ArrayList<String> outputResources, ArrayList<Double> inputRatio,
			ArrayList<Double> outputRatio, double transformationRate) {
		super(name, positionX, positionY, energyConsumption, resourcesCosts,
				partsCosts, robotworkCost, usuryLevel, sizeX, sizeY);
		this.inputResources = inputResources;
		this.outputResources = outputResources;
		this.inputRatio = inputRatio;
		this.outputRatio = outputRatio;
		this.transformationRate = transformationRate;
	}

	public ArrayList<String> getInputResources() {
		return inputResources;
	}

	public void setInputResources(ArrayList<String> inputResources) {
		this.inputResources = inputResources;
	}
	
	public void addInputResource(String resourceName) {
		this.addInputResource(resourceName,0);
	}
	
	public void addInputResource(String resourceName, double value) {
		this.inputResources.add(resourceName);
		this.inputRatio.add(value);
	}

	public ArrayList<String> getOutputResources() {
		return outputResources;
	}

	public void setOutputResources(ArrayList<String> outputResources) {
		this.outputResources = outputResources;
	}

	public ArrayList<Double> getInputRatio() {
		return inputRatio;
	}
	
	public double getInputRatio(String resourceName) {
		int id = inputResources.indexOf(resourceName);
		
		return inputRatio.get(id);
	}

	public void setInputRatio(ArrayList<Double> inputRatio) {
		this.inputRatio = inputRatio;
	}
	
	public void setInputRatio(String resourceName, double value) {
		int id = inputResources.indexOf(resourceName);
		
		inputRatio.set(id, value);
	}

	public ArrayList<Double> getOutputRatio() {
		return outputRatio;
	}

	public double getOutputRatio(String resourceName) {
		int id = outputResources.indexOf(resourceName);
		
		return outputRatio.get(id);
	}

	public void addOutputResource(String resourceName) {
		this.addOutputResource(resourceName,0);
	}
	
	public void addOutputResource(String resourceName, double value) {
		this.outputResources.add(resourceName);
		this.outputRatio.add(value);
	}
	
	public void setOutputRatio(ArrayList<Double> outputRatio) {
		this.outputRatio = outputRatio;
	}
	
	public void setOutputRatio(String resourceName, double value) {
		int id = outputResources.indexOf(resourceName);
		
		outputRatio.set(id, value);
	}

	public double getTransformationRate() {
		return transformationRate;
	}

	public void setTransformationRate(double transformationRate) {
		this.transformationRate = transformationRate;
	}
	
}
