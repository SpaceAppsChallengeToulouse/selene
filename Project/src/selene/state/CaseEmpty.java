package selene.state;

public class CaseEmpty implements CaseState {
	
	public static CaseState getInstance(){
		return new CaseEmpty();
	}

}
