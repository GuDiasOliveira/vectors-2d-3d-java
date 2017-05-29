package net.gustavodias.vectors;

public class Vector3D {
	
	public double x, y, z;
	
	public Vector3D() {
	}
	
	public Vector3D(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public Vector3D(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public Vector3D(Vector3D vector) {
		this.x = vector.x;
		this.y = vector.y;
		this.z = vector.z;
	}
	
	public Vector3D(Vector2D vector) {
		this.x = vector.x;
		this.y = vector.y;
	}
	
	public static Vector3D fromSphericalCoords(double module, double theta, double phi) {
//		Vector3D v = new Vector3D(1, 1, 1);
//		v.setModule(module);
//		v.setTheta(theta);
//		v.setPhi(phi);
		Vector3D v = new Vector3D();
		v.x = module * Math.sin(phi) * Math.cos(theta);
		v.y = module * Math.sin(phi) * Math.sin(theta);
		v.z = module * Math.cos(phi);
		return v;
	}
	
	public double getModule() {
		return Math.sqrt(x*x + y*y + z*z);
	}
	
	public void setModule(double module) {
		double multip = module / getModule();
		this.x *= multip;
		this.y *= multip;
		this.z *= multip;
	}
	
	public double getTheta() {
		return Math.atan2(y, x);
	}
	
	public void setTheta(double theta) {
		double module = getModule();
		double phi = getPhi();
		this.x = module * Math.sin(phi) * Math.cos(theta);
		this.y = module * Math.sin(phi) * Math.sin(theta);
		this.z = module * Math.cos(phi);
	}
	
	public double getPhi() {
		return Math.acos(this.z / getModule());
	}
	
	public void setPhi(double phi) {
		double module = getModule();
		double theta = getTheta();
		this.x = module * Math.sin(phi) * Math.cos(theta);
		this.y = module * Math.sin(phi) * Math.sin(theta);
		this.z = module * Math.cos(phi);
	}
	
	public Vector3D add(Vector3D vector) {
		return new Vector3D(this.x + vector.x, this.y + vector.y, this.z + vector.z);
	}
	
	public Vector3D add(Vector2D vector) {
		return new Vector3D(this.x + vector.x, this.y + vector.y, this.z);
	}
	
	public Vector3D subtract(Vector3D vector) {
		return new Vector3D(this.x - vector.x, this.y - vector.y, this.z - vector.z);
	}
	
	public Vector3D subtract(Vector2D vector) {
		return new Vector3D(this.x - vector.x, this.y - vector.y, this.z);
	}
	
	public Vector3D multiply(double value) {
		return new Vector3D(this.x * value, this.y * value, this.z * value);
	}
	
	public Vector3D divide(double value) {
		return new Vector3D(this.x / value, this.y / value, this.z / value);
	}
	
	public double dotProduct(Vector3D vector) {
		return this.x * vector.x + this.y * vector.y + this.z * vector.z;
	}
	
	public double dotProduct(Vector2D vector) {
		return this.x * vector.x + this.y * vector.y;
	}
	
	public Vector3D crossProduct(Vector3D vector) {
		Vector3D res = new Vector3D();
		res.x = this.y * vector.z - vector.y * this.z;
		res.y = vector.x * this.z - this.x * vector.z;
		res.z = this.x * vector.y - vector.x * this.y;
		return res;
	}
	
	public Vector3D crossProduct(Vector2D vector) {
		Vector3D res = new Vector3D();
		res.x = -vector.y * this.z;
		res.y = vector.x * this.z;
		res.z = this.x * vector.y - vector.x * this.y;
		return res;
	}
	
	public Vector3D getUnit() {
		double module = getModule();
		return new Vector3D(this.x / module, this.y / module, this.z / module);
	}
	
	@Override
	public String toString() {
		return "(" + x + ", " + y + ", " + z + ")";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Vector3D) {
			Vector3D o = (Vector3D) obj;
			if (this.x != o.x)
				return false;
			if (this.y != o.y)
				return false;
			if (this.z != o.z)
				return false;
			return true;
		} else {
			return false;
		}
	}
}
