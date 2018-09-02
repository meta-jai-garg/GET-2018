package com.soap;

import javax.jws.WebService;

@WebService
public class Triangle {

	/**
	 * This method calculates area of triangle using Heron's Formula.
	 * 
	 * @param sideA
	 *            of Triangle
	 * @param sideB
	 *            of Triangle
	 * @param sideC
	 *            of Triangle
	 * @return area of Triangle
	 */
	public double area(double sideA, double sideB, double sideC) {
		double perimeter = (sideA + sideB + sideC) / 2;
		return Math.sqrt(perimeter * (perimeter - sideA) * (perimeter - sideB) * (perimeter - sideC));
	}
}
