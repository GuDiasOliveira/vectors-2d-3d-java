package net.gustavodias.vectors;

import static org.junit.Assert.*;

import org.junit.Test;

public class VectorTests {
	
	@Test
	public void test2DPolar() {
		Vector2D v;
		
		v = new Vector2D(1, 3);
		assertEquals(3.162, v.getModule(), 1e-3);
		assertEquals(Math.toRadians(71.565), v.getAngle(), 1e-3);
		
		v = new Vector2D(12, 56);
		assertEquals(57.271, v.getModule(), 1e-3);
		assertEquals(Math.toRadians(77.905), v.getAngle(), 1e-3);
		
		v = new Vector2D(-12, -56);
		assertEquals(57.271, v.getModule(), 1e-3);
		assertEquals(Math.toRadians(-102.094), v.getAngle(), 1e-3);
		
//		v = new Vector2D(1, 1);
//		v.setModule(23.1);
//		v.setAngle(Math.toRadians(12.85));
		v = Vector2D.fromPolarCoords(23.1, Math.toRadians(12.85));
		assertEquals(22.521, v.x, 1e-3);
		assertEquals(5.137, v.y, 1e-3);
		
		v = new Vector2D(1, 1);
		v.setAngle(Math.toRadians(-78.96));
		v.setModule(-10);
		assertEquals(-1.914, v.x, 1e-3);
		assertEquals(9.814, v.y, 1e-3);
	}
	
	@Test
	public void test2DAddSum() {
		Vector2D v1, v2, res;
		
		v1 = new Vector2D(3, -4);
		v2 = new Vector2D(-9, 5);
		
		res = v1.add(v2);
		assertEquals(-6, res.x, 1e-3);
		assertEquals(1, res.y, 1e-3);
		
		res = v1.subtract(v2);
		assertEquals(12, res.x, 1e-3);
		assertEquals(-9, res.y, 1e-3);
	}
	
	@Test
	public void test2DMulDiv() {
		Vector2D v1, v2, res;
		
		v1 = new Vector2D(3, -4);
		v2 = new Vector2D(-9, 5);
		
		res = v1.multiply(3);
		assertEquals(9, res.x, 1e-3);
		assertEquals(-12, res.y, 1e-3);
		
		res = v2.multiply(-2);
		assertEquals(18, res.x, 1e-3);
		assertEquals(-10, res.y, 1e-3);
		
		res = v1.divide(4);
		assertEquals(0.75, res.x, 1e-3);
		assertEquals(-1, res.y, 1e-3);
		
		res = v2.divide(-5);
		assertEquals(1.8, res.x, 1e-3);
		assertEquals(-1, res.y, 1e-3);
	}
	
	@Test
	public void test2DProd() {
		Vector2D v1, v2;
		Vector3D v3, res;
		
		v1 = new Vector2D(3, -4);
		v2 = new Vector2D(-9, 5);
		v3 = new Vector3D(-2, 5, 7.5);
		
		assertEquals(-47, v1.dotProduct(v2), 1e-3);
		assertEquals(-26, v1.dotProduct(v3), 1e-3);
		
		res = v1.crossProduct(v2);
		assertEquals(0, res.x, 1e-3);
		assertEquals(0, res.y, 1e-3);
		assertEquals(-21, res.z, 1e-3);
		
		res = v1.crossProduct(v3);
		assertEquals(-30, res.x, 1e-3);
		assertEquals(-22.5, res.y, 1e-3);
		assertEquals(7, res.z, 1e-3);
	}
	
	@Test
	public void test2DUnit() {
		Vector2D v1, v2, res;
		
		v1 = new Vector2D(3, -4);
		v2 = new Vector2D(-9, 5);
		
		res = v1.getUnit();
		assertEquals(3.0/5, res.x, 1e-3);
		assertEquals(-4.0/5, res.y, 1e-3);
		assertEquals(1.0, res.getModule(), 1e-3);
		
		res = v2.getUnit();
		assertEquals(-9/Math.sqrt(106), res.x, 1e-3);
		assertEquals(5/Math.sqrt(106), res.y, 1e-3);
		assertEquals(1.0, res.getModule(), 1e-3);
	}
	
	@Test
	public void test3DSpherical() {
		Vector3D v;
		
		v = new Vector3D(2, 3.8, 6);
		assertEquals(7.378, v.getModule(), 1e-3);
		assertEquals(Math.toRadians(62.241), v.getTheta(), 1e-3);
		assertEquals(Math.toRadians(35.591), v.getPhi(), 1e-3);
		
		v = new Vector3D(-2, 3.8, 6);
		assertEquals(7.378, v.getModule(), 1e-3);
		assertEquals(Math.toRadians(180-62.241), v.getTheta(), 1e-3);
		assertEquals(Math.toRadians(35.591), v.getPhi(), 1e-3);
		
		v = new Vector3D(2, -3.8, 6);
		assertEquals(7.378, v.getModule(), 1e-3);
		assertEquals(Math.toRadians(-62.241), v.getTheta(), 1e-3);
		assertEquals(Math.toRadians(35.591), v.getPhi(), 1e-3);
		
		v = new Vector3D(2, 3.8, -6);
		assertEquals(7.378, v.getModule(), 1e-3);
		assertEquals(Math.toRadians(62.241), v.getTheta(), 1e-3);
		assertEquals(Math.toRadians(144.408), v.getPhi(), 1e-3);
		
		v = Vector3D.fromSphericalCoords(21.1, Math.toRadians(50), Math.toRadians(75));
		assertEquals(13.100, v.x, 1e-3);
		assertEquals(15.612, v.y, 1e-3);
		assertEquals(5.461, v.z, 1e-3);
		
		v = Vector3D.fromSphericalCoords(21.1, Math.toRadians(50), Math.toRadians(-75));
		assertEquals(-13.100, v.x, 1e-3);
		assertEquals(-15.612, v.y, 1e-3);
		assertEquals(5.461, v.z, 1e-3);
		
		v = Vector3D.fromSphericalCoords(21.1, Math.toRadians(-50), Math.toRadians(75));
		assertEquals(13.100, v.x, 1e-3);
		assertEquals(-15.612, v.y, 1e-3);
		assertEquals(5.461, v.z, 1e-3);
	}
	
	@Test
	public void test3DProd() {
		Vector3D v1, v2, res;
		Vector2D v3;
		
		v1 = new Vector3D(3, -4, 3);
		v2 = new Vector3D(-9, 5, 1);
		v3 = new Vector2D(-2, 5);
		
		assertEquals(-44, v1.dotProduct(v2), 1e-3);
		assertEquals(-26, v1.dotProduct(v3), 1e-3);
		
		res = v1.crossProduct(v2);
		assertEquals(-19, res.x, 1e-3);
		assertEquals(-30, res.y, 1e-3);
		assertEquals(-21, res.z, 1e-3);
		
		res = v1.crossProduct(v3);
		assertEquals(-15, res.x, 1e-3);
		assertEquals(-6, res.y, 1e-3);
		assertEquals(7, res.z, 1e-3);
	}
	
	@Test
	public void test3DUnit() {
		Vector3D v1, v2, res;
		
		v1 = new Vector3D(3, -4, 0);
		v2 = new Vector3D(-9, 5, 7.9);
		
		res = v1.getUnit();
		assertEquals(3.0/5, res.x, 1e-3);
		assertEquals(-4.0/5, res.y, 1e-3);
		assertEquals(0, res.z, 1e-3);
		assertEquals(1.0, res.getModule(), 1e-3);
		
		res = v2.getUnit();
		assertEquals(-0.693, res.x, 1e-3);
		assertEquals(0.385, res.y, 1e-3);
		assertEquals(0.608, res.z, 1e-3);
		assertEquals(1.0, res.getModule(), 1e-3);
	}

}