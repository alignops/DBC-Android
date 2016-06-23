/*
 * Copyright 2016 Busy, LLC
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package com.busybusy.dbc.checks;

/**
 * Checks designed for use with floating point number types {@linkplain Float} or {@linkplain Double}
 * <p>
 * Default epsilon values from <a href="https://en.wikipedia.org/wiki/Machine_epsilon#Values_for_standard_hardware_floating_point_arithmetics">Wikipedia.</a>
 * Recommended implementation logic from <a href="http://www.ibm.com/developerworks/java/library/j-jtp0114/#N10255">IBM developer works</a>
 *
 * @param <T> Type of number to check. Should be float or double. Enforced via object creation in {@linkplain com.busybusy.dbc.Dbc}
 * @author Trevor
 */
public interface FloatingPointChecks<T extends Number, Self extends FloatingPointChecks<T, Self>> extends NumberChecks<T, Self>
{
	Float DEFAULT_FLOAT_EPSILON = 1.19e-07F;

	Double DEFAULT_DOUBLE_EPSILON = 2.22e-16D;

	/**
	 * Assert that the subject value is near parameter within {@linkplain #DEFAULT_FLOAT_EPSILON} or {@linkplain #DEFAULT_DOUBLE_EPSILON}
	 *
	 * @param floatingPointNumber Value to compare against
	 */
	Self isNear(T floatingPointNumber);


	/**
	 * Assert that the subject value is near parameter within provided tolerance
	 *
	 * @param floatingPointNumber Value to compare against
	 * @param tolerance           Value to use as tolerance window
	 */
	Self isNearWithTolerance(T floatingPointNumber, T tolerance);

	/**
	 * Assert that the subject value is near zero within {@linkplain #DEFAULT_FLOAT_EPSILON} or {@linkplain #DEFAULT_DOUBLE_EPSILON}
	 */
	Self isNearZero();


	/**
	 * Assert that the subject value is near zero within provided tolerance
	 *
	 * @param tolerance Value to use as tolerance window
	 */
	Self isNearZeroWithTolerance(T tolerance);
}
