package resources;
import java.awt.Graphics;

public abstract class Resource{

    public int getAmount(){
	return 0;
    }

    public static void incrementBy(int amount){
    }

    public void tick(){
    }

    public void render(Graphics g){
    }
}
