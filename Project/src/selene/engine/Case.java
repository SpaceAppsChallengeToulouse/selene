package selene.engine;

import selene.state.CaseEmpty;
import selene.state.CaseState;

public class Case {
	
	private int posX;
	private int posY;
	private CaseState state;
	
	public Case(int x, int y){
		this.posX = x;
		this.posY = y;
		this.state = CaseEmpty.getInstance();
	}
	
	public CaseState getState(){
		return this.state;
	}
}
