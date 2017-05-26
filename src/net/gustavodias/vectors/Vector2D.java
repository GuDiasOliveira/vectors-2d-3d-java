package net.gustavodias.vectors;

public class Vector2D {
	
	public double x, y;
	
	public Vector2D() {
	}
	
	public Vector2D(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public Vector2D(Vector2D vector) {
		this.x = vector.x;
		this.y = vector.y;
	}
	
	public static Vector2D fromPolarCoords(double module, double angle) {
		Vector2D v = new Vector2D(1, 1);
		v.setModule(module);
		v.setAngle(angle);
		return v;
	}
	
	public Vector3D to3D() {
		return new Vector3D(x, y, 0);
	}
	
	public double getModule() {
		return Math.sqrt(x*x + y*y);
	}
	
	public void setModule(double module) {
		double multip = module / getModule();
		this.x *= multip;
		this.y *= multip;
	}
	
	public double getAngle() {
		return Math.atan2(y, x);
	}
	
	public void setAngle(double angle) {
		double module = getModule();
		this.x = module * Math.cos(angle);
		this.y = module * Math.sin(angle);
	}
	
	public Vector2D add(Vector2D vector) {
		return new Vector2D(this.x + vector.x, this.y + vector.y);
	}
	
	public Vector2D subtract(Vector2D vector) {
		return new Vector2D(this.x - vector.x, this.y - vector.y);
	}
	
	public Vector2D multiply(double value) {
		return new Vector2D(this.x * value, this.y * value);
	}
	
	public Vector2D divide(double value) {
		return new Vector2D(this.x / value, this.y / value);
	}
	
	public double dotProduct(Vector2D vector) {
		return this.x * vector.x + this.y * vector.y;
	}
	
	public double dotProduct(Vector3D vector) {
		return this.x * vector.x + this.y * vector.y;
	}
	
	public Vector3D crossProduct(Vector2D vector) {
		Vector3D res = new Vector3D();
		res.z = this.x * vector.y - vector.x * this.y;
		return res;
	}
	
	public Vector3D crossProduct(Vector3D vector) {
		Vector3D res = new Vector3D();
		res.x = this.y * vector.z;
		res.y = -this.x * vector.z;
		res.z = this.x * vector.y - vector.x * this.y;
		return res;
	}
	
	public Vector2D getUnit() {
		double module = getModule();
		return new Vector2D(this.x / module, this.y / module);
	}
	
	@Override
	public String toString() {
		return "(" + x + ", " + y + ")";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Vector2D) {
			Vector2D o = (Vector2D) obj;
			if (this.x != o.x)
				return false;
			if (this.y != o.y)
				return false;
			return true;
		} else {
			return false;
		}
	}
}