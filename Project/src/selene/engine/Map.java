package selene.engine;

public class Map {
	
	private Case[][] map;
	private int height;
	private int width;
	
	public Map(int height, int width) {
		this.height = height;
		this.width = width;
		this.map = new Case[height][width];
		for(int i=0; i<this.height; i++){
			for(int j=0; j<this.width; j++){
				this.map[i][j] = new Case(i, j);
			}
		}
	}
	
	public int getHeight() {
		return this.height;
	}
	
	public int getWidth(){
		return this.width;
	}
	
	public Case getCase(int x, int y) {
		return this.map[x][y];
	}

}
