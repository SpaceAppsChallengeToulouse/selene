package selene.entity;

import java.util.ArrayList;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.tiled.TiledMap;

public abstract class IEntity {
	
	protected String name;
	
	protected int positionX;
	protected int positionY;
	
	protected double energyConsumption;
	
	protected ArrayList<Double> resourcesCosts;
	protected ArrayList<Double> partsCosts;
	protected double robotworkCost;
	
	protected double usuryLevel;
	
	//Render-related state
	Image img;
	float srcX, srcY;
	float width, height;
	//end Render-relater
	

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
	
	//TODO: move these three outside, into a render-dedicated class ?
	//      (good luck with that and Java's stupid non multiple inheritance)
	
	private void drawSubImage(Graphics g, Image img, float x, float y){
		g.drawImage(img, x, y, x+width, y+height, srcX, srcY, srcX+width, srcY+height);
	}
	
	public void render(Graphics g, TiledMap map, double mapRenderX, double mapRenderY){
		drawSubImage(g, img,
				(float)(mapRenderX + positionX * map.getTileWidth() / 2 - positionY * map.getTileWidth() / 2),
				(float)(mapRenderY + positionX * map.getTileHeight() /2 + positionY * map.getTileHeight() /2 - map.getTileHeight()));
	}

	String imgName;

	public void setupRender(String imgName, float srcX, float srcY, float width, float height){
		this.imgName = imgName;
		this.srcX = srcX;
		this.srcY = srcY;
		this.width = width;
		this.height = height;
	}

	public String getImageName(){
		return imgName;
	}

	public void setImage(Image img){
		this.img = img;
	}

}
