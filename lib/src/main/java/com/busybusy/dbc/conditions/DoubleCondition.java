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

import com.busybusy.dbc.DbcAssertionException;
import com.busybusy.dbc.checks.DoubleChecks;

import org.jetbrains.annotations.NonNls;

/**
 * Double implementation of number checks
 *
 * @author Trevor
 */
@NonNls
public class DoubleCondition extends NumberCondition<Double> implements DoubleChecks
{
	public DoubleCondition(Double subject) { super(subject); }

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void isGreaterThan(Double number)
	{
		if (!(Double.compare(this.subject, number) > 0))
		{
			DbcAssertionException.throwNew(new IllegalArgumentException("Expected double <" + this.subject + "> to be greater than <" + number + ">"));
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void isGreaterThanOrEqual(Double number)
	{
		if (!(Double.compare(this.subject, number) >= 0))
		{
			DbcAssertionException.throwNew(new IllegalArgumentException("Expected double <" + this.subject + "> to be greater than or equal to <" + number + ">"));
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void isLessThan(Double number)
	{
		if (!(Double.compare(this.subject, number) < 0))
		{
			DbcAssertionException.throwNew(new IllegalArgumentException("Expected double <" + this.subject + "> to be less than <" + number + ">"));
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void isLessThanOrEqual(Double number)
	{
		if (!(Double.compare(this.subject, number) <= 0))
		{
			DbcAssertionException.throwNew(new IllegalArgumentException("Expected double <" + this.subject + "> to be less than or equal to <" + number + ">"));
		}
	}

	@Override
	public void isNear(Double floatingPointNumber)
	{

	}

	@Override
	public void isNear(Double floatingPointNumber, Double tolerance)
	{

	}

	@Override
	public void isNearZero()
	{

	}

	@Override
	public void isNearZero(Double tolerance)
	{

	}

	@Deprecated
	@Override
	public void isEqualTo(Double toCompare)
	{
		DbcAssertionException.throwNew(new RuntimeException("The is equal to method should be avoided on floating point numbers, use isNear instead"));
	}
}
