

import uk.ac.leedsbeckett.oop.LBUGraphics;

public class MainClass extends LBUGraphics{

	/*
    public static void main(String[] args)
    {
            new run(); //create instance of class that extends LBUGraphics (could be separate class without main), gets out of static context
    }
    */
	
	public static void main(String[] args) {
		//new MainClass();
		
        GraphicsSystem graphicsSystem = new GraphicsSystem();
        graphicsSystem.run();
        

	}

}