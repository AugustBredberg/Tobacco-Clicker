package resources;


public class TobaccoLeaves extends Resource{

    private int amount;

    public TobaccoLeaves(int amount){
	this.amount = amount;
    }

    public int getAmount(){
	return this.amount;
    }

    public void incrementBy(int amount){
	this.amount += amount;
    }
    
}
