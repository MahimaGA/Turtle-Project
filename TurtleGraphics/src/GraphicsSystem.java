

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import uk.ac.leedsbeckett.oop.LBUGraphics;


public class GraphicsSystem extends LBUGraphics
{
	//declaring variables
	private File file;
    private File txt;
    boolean fillshape = false;
    boolean isNotSaved = true;


    

    public void run() {
   	
    	//creating frame to display turtle panel on
        JFrame mainFrame = new JFrame(); 
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLayout(new FlowLayout());
        mainFrame.add(this);
        mainFrame.pack();
        mainFrame.setVisible(true);

        
        
        int i=0;
        while (true)
        {
                try
                {
                	//creating file
                        File newfile = new File("File"+i+".txt");
                        if(newfile.createNewFile())
                        {
                                displayMessage("File Created.");
                                txt = newfile;
                                break;
                        }
                        i++;
                }
                catch(Exception e)
                {
                        displayMessage("Error while creating file!");
                }
        }
}
             
        public void myname() {
        	
            forward (150);
            turnRight(90);
            forward(200);
            turnRight(90);
            
            penDown();
            
            //M
            
            forward(80);
            turnRight(135);
            forward(50);
            turnLeft(90);
            forward(50);
            turnRight(135);
            forward(80);
            penUp();
            
            turnLeft(90);
            forward(30);
            
            //A
            
            penDown();
            turnLeft(70);
            forward(95);
            turnRight(140);
            forward(95);
            turnRight(180);
            forward(30);
            turnLeft(70);
            forward(20);
            penDown();
            forward(25);
            
            penUp();
            turnRight(180);
            
            forward(90);
            
            turnRight(90);
            forward(30);
            
            turnRight(180);
            
            //H
            penDown();
            forward(80);
            forward(-40);
            turnRight(90);
            forward(50);
            turnLeft(90);
            forward(40);
            forward(-80);
            penUp();
            
            turnRight(90);
            forward(30);
            
            //I

            penDown();
            forward(40);
            forward(-20);
            turnLeft(90);
            forward(80);
            turnLeft(90);
            forward(20);
            forward (-40);
            penUp();

            turnRight(180);
            forward(30);
            turnRight(90);
            forward(80);
            
            //M
            penDown();
            turnRight(180);
            forward(80);
            turnRight(135);
            forward(50);
            turnLeft(90);
            forward(50);
            turnRight(135);
            forward(80);
            penUp();
            
            turnLeft(90);
            forward(30);
            
            //A
            
            penDown();
            turnLeft(70);
            forward(95);
            turnRight(140);
            forward(95);
            turnRight(180);
            forward(30);
            turnLeft(70);
            forward(20);
            penDown();
            forward(25);
            
            
            reset();
            
        
            
            
        }
        
        @Override
        public void about() {
        	super.about();
            displayMessage("Mahima");
            myname();

        	
        }
        
        @Override
        public void processCommand(String command) {
        	command = command.toLowerCase();
        	
            try 
            {
            		penDown();
                    savecommands(command);
                    displayMessage(" ");
                    
                    
                    if ( command.equalsIgnoreCase("about"))
                    {
                    	about(); 
                    }
                    
                    

                    
                    else if ( command.equalsIgnoreCase("spiral"))
                    {
                        spiral();
                    }
                    
                    else if ( command.equalsIgnoreCase("star"))
                    	
                    {
						penDown();
						for (int i = 0; i < 5; i++) {
				            forward(100);
				            turnRight(144);
				        }


                    }
                    
                    else if ( command.equalsIgnoreCase("bug"))
                    	
                    {
                        displayMessage("Bug");

                        setTurtleImage("bug.png");
                        forward(0);


                    }
                    
                    /*
                    else if ( command.equalsIgnoreCase("wave"))
                    {	
                    	Wave wave = new Wave();
            			setPenColour(Color.cyan);
                    	penDown();
                    
                    		wave.drawWave(200,4);
                    	    turnRight(60);
                    	
                    }
                    */
                    
					
                    
                    
                    else if ( command.equalsIgnoreCase("mandela2"))
                    {
                    	mandela2();
                        displayMessage("Mandela 2");

                    	
                    }
                    
                    else if ( command.equalsIgnoreCase("mandela"))
                    {
                    	mandela();
                        displayMessage("Mandela 1");

                    }
                    
                    else if ( command.equalsIgnoreCase("myname"))
                    {
                            myname();
                            displayMessage("Writing My Name");

                    }
                    else if (command.equalsIgnoreCase("penup"))
                    {
                            penUp();
                            displayMessage("Pen is Up");

                    }
                    else if (command.equalsIgnoreCase("pendown"))
                    {
                            penDown();
                            displayMessage("Pen is Down");

                    }
                    
                   
                    
                    else if(command.contains("read")) {
                    	String[] command_arr = command.split(" ");
                        
                        if (command_arr.length < 2) {
                            displayMessage("File Not Found");
                        }
                        else {
                        	String fileloc = command_arr[1]+".txt";
                            try
                            {
                                    displayMessage("File Loaded.");
                                    BufferedReader reader = new BufferedReader(new FileReader(fileloc));
                                    
                                    while ((command = reader.readLine()) != null) {
                                        // executing the commands
                                    	processCommand(command);
                                        System.out.println("Executing Command: " + command);
                                    }
                            }
                            catch (IOException e)
                            {
                                    displayMessage("Failed to read file: "+e.getMessage());
                            }

                        }
                    }
                    
                    else if(command.contains("shape")){
                        String[] command_arr = command.split(" ");

                        if (command_arr[0].equalsIgnoreCase("shape") && isInteger(command_arr[1])){
                                int value = Integer.parseInt(command_arr[1]);

                                if(value < 0){
                                        displayMessage("Negative Parameter!!!");
                                }

                                else if(value == 0){
                                        displayMessage("Zero Parameter!!!");
                                }

                                else{
                                	
                                	penDown();
                                	for (int i = 0; i < value; i++) {
                                	    forward(50);
                                	    turnRight(360/value);
                                	}                                        
                                	displayMessage("Shape with "+value+" Sides Is Made");

                                }
                        }

                        else{
                                displayMessage("Parameter Wasn't a Number!!!");
                                
                        }
        
                }
                    
                    else if(command.contains("turnleft")){
                            String[] command_arr = command.split(" ");

                            if (command_arr[0].equalsIgnoreCase("turnleft") && isInteger(command_arr[1])){
                                    int value = Integer.parseInt(command_arr[1]);

                                    if(value < 0){
                                            displayMessage("Negative Parameter!!!");
                                    }

                                    else if(value == 0){
                                            displayMessage("Zero Parameter!!!");
                                    }

                                    else{
                                            turnLeft(value);
                                            displayMessage("Turning Left "+value+" Degrees Angle");

                                    }
                            }

                            else{
                                    displayMessage("Parameter Wasn't a Number!!!");
                                    
                            }
            
                    }
                    
                    else if(command.contains("turnright")){
                            String[] command_arr = command.split(" ");

                            if (command_arr[0].equalsIgnoreCase("turnright") && isInteger(command_arr[1])){
                                    int value = Integer.parseInt(command_arr[1]);

                                    if(value < 0){
                                            displayMessage("Negative Parameter!!!");
                                    }

                                    else if(value == 0){
                                            displayMessage("Zero Parameter!!!");
                                    }

                                    else{
                                            turnRight(value);
                                            displayMessage("Turning Right "+value+" Degrees Angle");

                                    }
                            }

                            else{
                                    displayMessage("Invalid Parameter!!!");
                            }
            
                    }
                    else if(command.contains("forward")){
                            String[] command_arr = command.split(" ");

                            if (command_arr[0].equalsIgnoreCase("forward") && isInteger(command_arr[1])){
                                    int value = Integer.parseInt(command_arr[1]);
                                    
                                    

                                    if(value < 0){
                                            displayMessage("Negative Parameter!!!");
                                    }

                                    else if(value == 0){
                                            displayMessage("Zero Parameter!!!");
                                    }
                                    
                                    else{
                                    	                                    	
                                    	int a = getxPos();
                                        int b = getyPos();
                                        double newX = a + value * Math.cos(Math.toRadians(getDirection()));
                                        double newY = b + value * Math.sin(Math.toRadians(getDirection()));
                                        
                                    	System.out.println(newX+" , "+newY);

                                    	//for bounds
                                        if(newX < 0 || newX > 800 || newY < 0 || newY > 400) {
                                        	
                                            displayMessage("Out of Screen Command");
                                            return;
                                        }
                                        
                                        forward (value);
                                        displayMessage("Moving Forward "+value+" Pixels");

                                                                       	
                                    }
                            }

                            else{
                                    displayMessage("Invalid Parameter!!!");
                            }
            
                    }
                    else if(command.contains("backward")){
                            String[] command_arr = command.split(" ");

                            if (command_arr[0].equalsIgnoreCase("backward") && isInteger(command_arr[1])){
                                    int value = Integer.parseInt(command_arr[1]);

                                    if(value < 0){
                                            displayMessage("Negative Parameter!!!");
                                    }

                                    else if(value == 0){
                                            displayMessage("Zero Parameter!!!");
                                    }

                                    else{
                                    	
                                    	int a = getxPos();
                                        int b = getyPos();
                                        double newX = a - value * Math.cos(Math.toRadians(getDirection()));
                                        double newY = b - value * Math.sin(Math.toRadians(getDirection()));
                                        
                                    	System.out.println(newX+" , "+newY);

                                    	
                                        if(newX < 0 || newX > 800 || newY < 0 || newY > 400) {
                                        	
                                            displayMessage("Out of Screen Command");
                                            return;
                                        }
                                       
                                        forward (-value);
                                        displayMessage("Moving Backward "+value+" Pixels");

                                    }
                            }

                            else{
                                    displayMessage("Invalid Parameter!!!");
                            }
            
                    }
                    
                    else if(command.contains("pencolour")){
                        String[] command_arr = command.split(" ");

                        if (command_arr[0].equalsIgnoreCase("pencolour")
                        		&& isInteger(command_arr[1])
                        		&& isInteger(command_arr[2])
                        		&& isInteger(command_arr[3])){
                        	int value1 = Integer.parseInt(command_arr[1]);
                        	int value2 = Integer.parseInt(command_arr[2]);
                        	int value3 = Integer.parseInt(command_arr[3]);
                        	pen(value1,value2,value3);
                        }
                        
                    }


                    else if(command.contains("square")){
                            String[] command_arr = command.split(" ");

                            if (command_arr[0].equalsIgnoreCase("square") && isInteger(command_arr[1])){
                                    int value = Integer.parseInt(command_arr[1]);

                                    if(value < 0){
                                            displayMessage("Negative Parameter!!!");
                                    }

                                    else if(value == 0){
                                            displayMessage("Zero Parameter!!!");
                                    }

                                    else{
                                    	penUp();
                                    	penDown();
                                        square(value);
                                    }
                            }

                            else{
                                    displayMessage("Parameter Wasn't a Number!!!");
                                    
                            }
            
                    }
                    
                    else if(command.contains("triangle")){
                        String[] command_arr = command.split(" ");

                        if (command_arr[0].equalsIgnoreCase("triangle") && isInteger(command_arr[1])){
                               int value = Integer.parseInt(command_arr[1]);

                                if(value < 0){
                                        displayMessage("Negative Parameter!!!");
                                }

                                else if(value == 0){
                                        displayMessage("Zero Parameter!!!");
                                }

                                else{
                                        triangle(value);
                                }
                        }
                    }
                       
                    
                        
                     else if(command.contains("flower")){
                            String[] command_arr = command.split(" ");

                            if (command_arr[0].equalsIgnoreCase("flower") && isInteger(command_arr[1])){
                                   int value = Integer.parseInt(command_arr[1]);

                                    if(value < 0){
                                            displayMessage("Negative Parameter!!!");
                                    }

                                    else if(value == 0){
                                            displayMessage("Zero Parameter!!!");
                                    }

                                    else{
                                            flower(value);
                                			setPenColour(Color.green);
                                            forward(value*2);
                                            
                                    }
                            }
                            
                            else{
                        		displayMessage("Parameter Wasn't a Number!!!");
                             
                     		}
                     }
                        
                    else if(command.contains("triangle")) {
                        String[] command_arr = command.split(" ");

                        if (command_arr[0].equalsIgnoreCase("triangle") && isInteger(command_arr[1])&& isInteger(command_arr[2])&& isInteger(command_arr[3])) 
                        {
	                        
	                        	int value1 = Integer.parseInt(command_arr[1]);
	                        	int value2 = Integer.parseInt(command_arr[2]);
	                        	int value3 = Integer.parseInt(command_arr[3]);
	
	                            if(value1 < 0 && value2 < 0 && value3 < 0){
	                                    displayMessage("Negative Parameter!!!");
	                            }
	
	                            else if(value1 == 0 && value2 == 0 && value3 == 0){
	                                    displayMessage("Zero Parameter!!!");
	                            }
	
	                            else{
	                                    triangleSide(value1, value2, value3);
	                            }
                        	}
	                        

                        	else{
                                displayMessage("Parameter Wasn't a Number!!!");
                                
                        		}
                        
                    	}
                    
                    else if(command.contains("penwidth")){
                        String[] command_arr = command.split(" ");

                        if (command_arr[0].equalsIgnoreCase("penwidth") && isInteger(command_arr[1])){
                        	
                                int value = Integer.parseInt(command_arr[1]);

                                if(value < 0){
                                        displayMessage("Negative Parameter!!!");
                                }

                                else if(value == 0){
                                        displayMessage("Zero Parameter!!!");
                                }

                                else{

                                        setStroke(value);
                                        displayMessage("Penwidth changed to: "+ value);

                                }
                        }

                        else{
                                displayMessage("Parameter Wasn't a Number!!!");
                                
                        }
                    }

                        else if(command.contains("rectangle")){
                            String[] command_arr = command.split(" ");

                    	 
                        	if(command_arr[0].equalsIgnoreCase("rectangle") && isInteger(command_arr[1])&& isInteger(command_arr[2])) 
                        	{
                    		 
                    	 
	                    		 int value1 = Integer.parseInt(command_arr[1]);
	                    		 int value2 = Integer.parseInt(command_arr[2]);
	
	                    		 if(value1 < 0 && value2 < 0){
		                                 displayMessage("Negative Parameter!!!");
		                         }
		
		                         else if(value1 == 0 && value2 == 0){
		                                 displayMessage("Zero Parameter!!!");
		                         }
		
		                         else{
		                                 rectangle(value1, value2);
		                         	}
		                    	 }
	                    
	
                        	else{
                        		displayMessage("Parameter Wasn't a Number!!!");
                             
                     		}
                        }
     
            
                    else if (command.equalsIgnoreCase("black")) {
            			setPenColour(Color.black);}
                    
                    else if (command.equalsIgnoreCase("blue")) {
            			setPenColour(Color.blue);}
                    
                    else if (command.equalsIgnoreCase("green")) {
            			setPenColour(Color.green);}
            		
                    else if (command.equalsIgnoreCase("red")) {
            			setPenColour(Color.red);}
            		
                    else if (command.equalsIgnoreCase("white")) {
            			setPenColour(Color.white);}
            		
                    else if (command.equalsIgnoreCase("pink")) {
            			setPenColour(Color.pink);}
                    
                    else if (command.contains("color"))
                    {
                            String[] command_arr = command.split(" ");

                            int r= Integer.parseInt(command_arr[1]);
                            int g= Integer.parseInt(command_arr[2]);
                            int b= Integer.parseInt(command_arr[3]);

                            pen(r,g,b);

                    }
                    
                    else if (command.equalsIgnoreCase("wave")) {
            			wave();
                        displayMessage("Wave");
                    }
                    
                    else if (command.equalsIgnoreCase("reset"))
                    {
                            reset();
                            setStroke(1);
                            setPenColour(Color.red);
                            penUp();
                            setTurtleImage("turtle90.png");
                            forward(0);

                            
                    }
                    else if (command.equalsIgnoreCase("clear"))
                    {
                    	
                        if (isNotSaved) {
                            int answer = JOptionPane.showConfirmDialog(null,
                            		"The current image is not saved. Do you want to save changes?", "Warning", 
                            		JOptionPane.YES_NO_CANCEL_OPTION);
                            
                            if (answer == JOptionPane.YES_OPTION) {
                                save();
                                isNotSaved=true;
                                
                            } 

                            else if (answer == JOptionPane.CANCEL_OPTION) {
                                return;
                            }
                        }

                       
                           displayMessage("Cleared");
                           clear();
                    }
                    
                    else if(command.contains("circle")){
                        String[] command_arr = command.split(" ");

                        if (command_arr[0].equalsIgnoreCase("circle") && isInteger(command_arr[1])){
                                int value = Integer.parseInt(command_arr[1]);

                                if(value < 0){
                                        displayMessage("Negative Parameter!!!");
                                }

                                else if(value == 0){
                                        displayMessage("Zero Parameter!!!");
                                }

                                else{
                                        circle(value);
                                }
                        }

                        else{
                                displayMessage("Parameter Wasn't a Number!!!");
                                
                        }
        
                }

                    else if (command.equalsIgnoreCase("save"))
                    {
                    	save();
                            
                    }
                    
                    else if (command.equalsIgnoreCase("load2"))
                    {
                        String[] command_arr = command.split(" ");

                    	
                        if (isNotSaved) {
                            int answer = JOptionPane.showConfirmDialog(null,
                            		"The current image is not saved. Do you want to save changes?", "Warning", 
                            		JOptionPane.YES_NO_CANCEL_OPTION);
                            
                            if (answer == JOptionPane.YES_OPTION) {
                                isNotSaved=true;

                            	if (command_arr.length < 2) {
                                    displayMessage("File Not Found");
                                }
                                else {
                                	String fileloc = command_arr[1]+".png";
                                    try
                                    {
                                            displayMessage("Image Loaded.");
                                            BufferedImage image = ImageIO.read(new File(fileloc));
                                            setBufferedImage(image);
                                    }
                                    catch (IOException e)
                                    {
                                            displayMessage("Image Loaded Failed");
                                    }
                                }
                                
                            } 

                            else if (answer == JOptionPane.CANCEL_OPTION) {
                                return;
                            }
                        }

                       
                           displayMessage("Cleared");
                           clear();
                    }
                                            
                    else if (command.contains("load"))
                    {
                            String[] command_arr = command.split(" ");
                            
                            if (command_arr.length < 2) {
                                displayMessage("File Not Found");
                            }
                            else {
                            	String fileloc = command_arr[1]+".png";
                                try
                                {
                                        displayMessage("Image Loaded.");
                                        BufferedImage image = ImageIO.read(new File(fileloc));
                                        setBufferedImage(image);
                                }
                                catch (IOException e)
                                {
                                        displayMessage("Image Loaded Failed");
                                }
                            }
                             
                    }
                    
                    else
                    {                             
                    	displayMessage("Invalid Command!!!");
                    }
            }
            catch(Exception e)
            {
                    if(e instanceof ArrayIndexOutOfBoundsException)
                    {
                            displayMessage("Missing Parameter!!!");
                    }
                    
                    else {
                        displayMessage("Invalid Command!!!");

                    }
            }

    }

	public void spiral() {
    	penDown();
    	int length=10;
        for(int i = 0; i < 40; i++){
        	double a=Math.random()*(255-0+1)+0;
        	double b=Math.random()*(255-0+1)+0;
        	double c=Math.random()*(255-0+1)+0;
        	
        	int x = (int)a;
        	int y = (int)b;
        	int z = (int)c;
        	
        	
        	pen(x,y,z);

          forward(length);
          turnRight(60);
          length += 5;
		}
    }

	public void square(int value) {
    	
    	forward(value);
		turnRight(90);
		forward(value);
		turnRight(90);
		forward(value);
		turnRight(90);
		forward(value);
		turnRight(90);
		
		}

    public void mandela() {
    	penDown();
    	int numCircles = 5;   
        int radiusStep = 30;
    
    	for (int i = numCircles; i > 0; i--) {
            int radius = (i + 1) * radiusStep;
           
            reset();
			setPenColour(Color.pink);
            flower(radius);
            setPenColour(Color.red);
            circle(radius);

    		}
			
		}

    public void mandela2() {
    	penUp();
    	turnRight(72);
    	forward(40);
    	penDown();
    	circle(40);
    	reset();
    	
        turnRight(144);
    	forward(40);
    	penDown();
    	circle(40);
    	reset();
    	
        turnRight(216);
    	forward(40);
    	penDown();
    	circle(40);
    	reset();
    	
    	turnRight(288);
    	forward(40);
    	penDown();
    	circle(40);
    	reset();
    	
    	forward(40);
    	penDown();
    	circle(40);
    	reset();
    	
		setPenColour(Color.yellow);
		penDown();
		circle(80);

			
		}

	public void wave() {
        	int numWaves = 3;       
        	int waveLength = 5;     
        	int amplitude = 3;      
        	int turnAngle = 30;     
        	int value=20;
        	
        	/*
        	for (int wave = 0; wave < numWaves; wave++) {
        	    // Move forward for waveLength steps
        	    for (int i = 0; i < waveLength; i++) {
        	        forward(value);
        	    }

        	    // Turn right by turnAngle degrees
        	    turnRight(turnAngle);

        	    // Move upward (backward) for amplitude steps
        	    for (int i = 0; i < amplitude; i++) {
        	        forward(-value);
        	    }

        	    // Turn left by twice the turnAngle degrees to return to the original direction
        	    turnLeft(2 * turnAngle);

        	    // Move downward (forward) for amplitude steps
        	    for (int i = 0; i < amplitude; i++) {
        	        forward(value);
        	    }

        	    // Turn right by turnAngle degrees to prepare for the next wave
        	    turnRight(turnAngle); 
        	}
*/
        }
        
    public class Wave {
    	
    	public void drawHexagon(int size)
    	{
    	    for (int i = 0; i < 2; i++) {
    	      forward(size);
    	      turnRight(60);
    	    }
    	 }
    
    	  
    	  public void drawWave(int size, int levels) {
    	    if (levels == 0) {
    	    	drawHexagon(size);
    	    	return;
    	    }
    	    
    	    drawHexagon(levels-1);
    	    
    	    turnRight(60);
    	    drawHexagon(levels-1);
    	    
    	    turnRight(-120);
    	    drawHexagon(levels-1);
    	    
    	    turnRight(60);
    	    drawHexagon(levels-1);
    	  }
    }

	public void save() {
    	isNotSaved = false;
    	BufferedImage image = getBufferedImage();
        try 
        {       createimage();                         
                ImageIO.write(image, "png", file);
        } 
        catch (IOException e)
        {
                displayMessage("Image Saved Failed");
        }
        	
	}

	public static boolean isInteger(String str) {
	    try {
	        Integer.parseInt(str);
	        return true;
	    } catch (NumberFormatException e) {
	        return false;
	    }
	}

    public void pen(int r,int g,int b)
    {
    	 if (r < 0 || r > 255 || g < 0 || g > 255 || b < 0 || b > 255) {
    	        displayMessage("Invalid Parameter!!!");
    	        return;
    	    }

    	    Color colorpen = new Color(r, g, b);
    	    setPenColour(colorpen);
    }

    public void triangle(int x)
    {
    	int value=x;
    	penDown();
    	turnRight(120);
    	forward(value);
    	turnRight(120);
    	forward(value);
    	turnRight(120);
    	forward(value);
    	
            
    }
    
    public void flower(int x)
    {
		setPenColour(Color.pink);
    	int value=x;
    	triangle(value);
    	turnRight(90);
    	triangle(value);
    	turnRight(90);
    	triangle(value);
    	turnRight(90);
    	triangle(value);
    	turnRight(90);
		
            
    }
    
    private void rectangle(int width,int height)
    {
    	int a=width;
    	int b=height;
    	
    	forward(a);
    	turnRight(90);
    	forward(b);
    	turnRight(90);
    	forward(a);
    	turnRight(90);
    	forward(b);
    	turnRight(90);
    	
            
    }

    public void triangleSide(int p1, int p2, int p3)
    {
    	int side1=p1;
    	int side2=p2;
    	int side3=p3;
    	
    	double a1 = Math.toDegrees(Math.acos((side2 * side2 + side3 * side3 - side1 * side1) / (2 * side2 * side3)));
        double a2 = Math.toDegrees(Math.acos((side1 * side1 + side3 * side3 - side2 * side2) / (2 * side1 * side3)));
        double a3 = Math.toDegrees(Math.acos((side1 * side1 + side2 * side2 - side3 * side3) / (2 * side1 * side2)));
        
        int angle1= (int)a1;
        int angle2= (int)a2;
        int angle3= (int)a3;
        
        
        turnRight(angle1);
        forward(side1);
        turnRight(angle2);
        forward(side2);
        turnRight(angle3);
        forward(side3);
        penUp();
        

    }

    public void savecommands(String command)
    {
            if(!command.contains("read") && !command.contains("load") 
            		&& !command.contains("save") && !command.contains("clear") 
            		&& !command.contains("reset") ) //easier when using read
            {
            try {
            	//writing input
                    FileWriter myWriter = new FileWriter(txt,true);
                    myWriter.write(command+"\n");
                    myWriter.close();
                }
                catch (IOException e) {
                    System.out.println("Error "+e);
                }
            }
    }

    public void createimage()
    {
            int i=0;
            while (true) //for infinite loop
            {
                    try
                    {
                            File fileobject = new File("Image"+i+".png");
                            if(fileobject.createNewFile())
                            {
                                    displayMessage("Image Saved.");
                                    file = fileobject;
                                    break; //to break infinite loop
                            }
                            i++;
                    }
                    catch(Exception e)
                    {
                            displayMessage("Couldn't Get Image!!!");
                    }
            }
            
    }

        
}
        	
        
