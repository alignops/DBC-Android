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
 * Checks on number base objects
 *
 * @param <T> Number type object
 * @author Trevor
 */
public interface NumberChecks<T extends Number> extends BasicChecks<T>
{
	/**
	 * Assert that the subject value is greater than the provided value
	 *
	 * @param number Number to compare against subject
	 * @return subject of check
	 */
	T isGreaterThan(T number);

	/**
	 * Assert that the subject value is greater than or equal to the provided value
	 *
	 * @param number Number to compare against subject
	 * @return subject of check
	 */
	T isGreaterThanOrEqual(T number);

	/**
	 * Assert that the subject value is less than the provided value
	 *
	 * @param number Number to compare against subject
	 * @return subject of check
	 */
	T isLessThan(T number);

	/**
	 * Assert that the subject value is less than or equal to the provided value
	 *
	 * @param number Number to compare against subject
	 * @return subject of check
	 */
	T isLessThanOrEqual(T number);

	/*
	Intentionally omitting equals here, because this is designed for runtime checking the inclusion of a
	constant condition imply's that you should simply use a constant value rather than a variable one.
	*/
}
