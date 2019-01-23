

/**
 * Celestial Body class for NBody
 * @author ola
 *
 */
public class CelestialBody {

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
		// TODO: complete constructor
	}

	/**
	 * Copy constructor: copy instance variables from one
	 * body to this body
	 * @param b used to initialize this body
	 */
	public CelestialBody(CelestialBody b){
		// TODO: complete constructor
	}

	public double getX() {
		// TODO: complete method
		return 0.0;
	}
	public double getY() {
		// TODO: complete method
		return 0.0;
	}
	public double getXVel() {
		// TODO: complete method
		return 0.0;
	}
	/**
	 * Return y-velocity of this Body.
	 * @return value of y-velocity.
	 */
	public double getYVel() {
		// TODO: complete method
		return 0.0;
	}
	
	public double getMass() {
		// TODO: complete method
		return 0.0;
	}
	public String getName() {
		// TODO: complete method
		return "no name";
	}

	/**
	 * Return the distance between this body and another
	 * @param b the other body to which distance is calculated
	 * @return distance between this body and b
	 */
	public double calcDistance(CelestialBody b) {
		// TODO: complete method
		return 0.0;
	}

	public double calcForceExertedBy(CelestialBody p) {
		// TODO: complete method
		return 0.0;
	}

	public double calcForceExertedByX(CelestialBody p) {
		// TODO: complete method
		return 0.0;
	}
	public double calcForceExertedByY(CelestialBody p) {
		// TODO: complete method
		return 0.0;
	}

	public double calcNetForceExertedByX(CelestialBody[] bodies) {
		// TODO: complete method
		return 0.0;
	}

	public double calcNetForceExertedByY(CelestialBody[] bodies) {
		// TODO: complete method
		return 0.0;
	}

	public void update(double deltaT, 
			           double xforce, double yforce) {
		// TODO: complete method
	}

	public void draw() {
		// TODO: complete method
	}
}
