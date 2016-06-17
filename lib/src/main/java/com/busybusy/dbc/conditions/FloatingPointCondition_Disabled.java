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

package com.busybusy.dbc.conditions;

import com.busybusy.dbc.checks.FloatingPointChecks;

/**
 * {@linkplain FloatingPointChecks} disabled implementation
 *
 * @author Trevor
 */

public class FloatingPointCondition_Disabled<T extends Number> extends NumberCondition_Disabled<T> implements FloatingPointChecks<T>
{
	public FloatingPointCondition_Disabled(T subject) { super(subject); }

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void isNear(T floatingPointNumber) { }

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void isNearWithTolerance(T floatingPointNumber, T tolerance) { }

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void isNearZero() { }

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void isNearZeroWithTolerance(T tolerance) { }

	/**
	 * {@inheritDoc}
	 */
	@Deprecated
	@Override
	public void isEqualTo(T toCompare) { }
}
