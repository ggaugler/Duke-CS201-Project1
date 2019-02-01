/**Celestial Body class for NBody
 * @author gg102
 */
public class CelestialBody {

	private double myXPos;
	private double myYPos;
	private double myXVel;
	private double myYVel;
	private double myMass;
	private String myFileName;
	/**
	 * Create a Body from parameters	
	 * @param xp initial x position
	 * @param yp initial y position
	 * @param xv initial x velocity
	 * @param yv initial y velocity
	 * @param mass of object
	 * @param filename of image for object animation
	 */
	public CelestialBody(double xp, double yp, double xv,
			             double yv, double mass, String filename){
		myXPos = xp;
		myYPos = yp;
		myXVel = xv;
		myYVel = yv;
		myMass = mass;
		myFileName = filename;
	}

	/**
	 * Copy constructor: copy instance variables from one
	 * body to this body
	 * @param b used to initialize this body
	 */
	public CelestialBody(CelestialBody b){
		this.myXPos = b.myXPos;
		this.myYPos = b.myYPos;
		this.myXVel = b.myXVel;
		this.myYVel = b.myYVel;
		this.myMass = b.myMass;
		this.myFileName = b.myFileName;
	}
	/**
	 * Getter method to return the value of myXPos.
	 * @return the X coordinate of a celestial body.
	 */
	public double getX() {
		// TODO: complete method
		return myXPos;
	}
	/**
	 * Getter method to return the value of myYpos.
	 * @return the Y coordinate of a celestial body.
	 */
	public double getY() {
		// TODO: complete method
		return myYPos;
	}
	/**
	 * Getter method to return the value of getXVel.
	 * @return the velocity in the X direction of a celestial body.
	 */
	public double getXVel() {
		// TODO: complete method
		return myXVel;
	}
	/**
	 * Getter method to return the value of myYVel.
	 * @return the velocity in the Y direction of a celestial body.
	 */
	public double getYVel() {
		// TODO: complete method
		return myYVel;
	}
	/**
	 * Getter method to return the value of myMass.
	 * @return the mass of a celestial body.
	 */
	public double getMass() {
		// TODO: complete method
		return myMass;
	}
	/**
	 * Getter method to return the value of myFileName.
	 * @return the filename the program is getting its celestial data from.
	 */
	public String getName() {
		// TODO: complete method
		return myFileName;
	}

	/**
	 * Return the distance between this body and another
	 * @param b the other body to which distance is calculated
	 * @return distance between this body and b
	 */
	public double calcDistance(CelestialBody b) {
		// TODO: complete method
		double distanceSquared = Math.pow(b.myXPos - myXPos, 2) + Math.pow(b.myYPos - myYPos, 2);
		return Math.sqrt(distanceSquared);
	}
	/**
	 * Calculate the force exerted by one body on another.
	 * @param p the body exerting the force
	 * @return the force exerted 
	 * on a body by the body specified as the parameter
	 */
	public double calcForceExertedBy(CelestialBody p) {
		// TODO: complete method
		return (6.67e-11) * (myMass * p.myMass) / (Math.pow(this.calcDistance(p), 2));
	}
	/**
	 * Calculate the force exterted by one body on another in the x direction.
	 * @param p the body exerting the force
	 * @return the force in the x-direction exerted 
	 * on a body by the body specified as the parameter
	 */
	public double calcForceExertedByX(CelestialBody p) {
		// TODO: complete method
		return this.calcForceExertedBy(p) * (p.myXPos- myXPos) / this.calcDistance(p);
	}
	/**
	 * Calculate the force exerted by one body on another in the y direction.
	 * @param p the body exerting the force
	 * @return the force in the y-direction exerted 
	 * on a body by the body specified as the parameter
	 */
	public double calcForceExertedByY(CelestialBody p) {
		// TODO: complete method
		return this.calcForceExertedBy(p) * (p.myYPos- myYPos) / this.calcDistance(p);
	}
	/**
	 * Calculates the net forced in the x-direction exerted on a body by all other bodies.
	 * @param bodies the array of bodies that are exerting force on a body
	 * @return the net force in the x-direction exerted on a body 
	 * by all the bodies in the array parameter except for body whose net force we're calculating.
	 */
	public double calcNetForceExertedByX(CelestialBody[] bodies) {
		// TODO: complete method
		double xNetForce = 0;
		for (int i = 0; i < bodies.length; i++)
		{
			if (!bodies[i].equals(this))
				xNetForce += this.calcForceExertedByX(bodies[i]);		
		}
		return xNetForce;
	}
	/**
	 * Calculates the net forced in the y-direction exerted on a body by all other bodies.
	 * @param bodies the array of bodies that are exerting force on a body
	 * @return the net force in the y-direction exerted on a body 
	 * by all the bodies in the array parameter except for body whose net force we're calculating.
	 */
	public double calcNetForceExertedByY(CelestialBody[] bodies) {
		// TODO: complete method
		double yNetForce = 0;
		for (int i = 0; i < bodies.length; i++)
		{
			if (!bodies[i].equals(this))
				yNetForce += this.calcForceExertedByY(bodies[i]);		
		}
		return yNetForce;
	}
	/**
	 * Updates the state/instance variables of the CelestialBody object on which it's called. 
	 * @param deltaT the time steps during which a body's position and velocity are updated
	 * @param xforce net x-direction forces exerted on a body by all other bodies 
	 * @param yforce net y-direction forces exerted on a body by all other bodies 
	 */
	public void update(double deltaT, 
			           double xforce, double yforce) {
		// TODO: complete method
		double Ax = xforce / this.myMass;
		double Ay = yforce/ this.myMass;
		double nvx = this.myXVel + Ax * deltaT;
		double nvy = this.myYVel + Ay * deltaT;
		double nx = this.myXPos + deltaT * nvx;
		double ny = this.myYPos + deltaT * nvy;
		this.myXPos = nx;
		this.myYPos = ny;
		this.myXVel = nvx;
		this.myYVel = nvy;		
	}
	/**
	 * Draws our simulation
	 */
	public void draw() {
		// TODO: complete method
		StdDraw.picture(myXPos, myYPos, "images/"+myFileName);
	}
}
