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
 * Default epsilon values from <a href="https://en.wikipedia.org/wiki/Machine_epsilon#Values_for_standard_hardware_floating_point_arithmetics">Wikipedia.</a>
 * Recommended implementation logic from <a href="http://www.ibm.com/developerworks/java/library/j-jtp0114/#N10255">IBM developer works</a>
 *
 * @author Trevor
 */

public interface FloatingPointChecks<T extends Number> extends NumberChecks<T>
{
	Float DEFAULT_FLOAT_EPSILON = 1.19e-07F;

	Double DEFAULT_DELTA_TOLERANCE = 2.22e-16D;

	void isNear(T floatingPointNumber);

	void isNear(T floatingPointNumber, T tolerance);

	void isNearZero();

	void isNearZero(T tolerance);
}
