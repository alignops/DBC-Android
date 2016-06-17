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
import com.busybusy.dbc.checks.FloatingPointChecks;

import org.jetbrains.annotations.NonNls;

import static com.busybusy.dbc.Dbc.require;

/**
 * {@linkplain FloatingPointChecks} {@linkplain Double} type implementation
 *
 * @author Trevor
 */
@NonNls
public class DoubleCondition extends BasicCondition<Double> implements FloatingPointChecks<Double>
{
	public DoubleCondition(Double subject) { super(subject); }

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void isGreaterThan(Double number)
	{
		this.isNotNull();
		require(number).isNotNull();

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
		this.isNotNull();
		require(number).isNotNull();

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
		this.isNotNull();
		require(number).isNotNull();

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
		this.isNotNull();
		require(number).isNotNull();

		if (!(Double.compare(this.subject, number) <= 0))
		{
			DbcAssertionException.throwNew(new IllegalArgumentException("Expected double <" + this.subject + "> to be less than or equal to <" + number + ">"));
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void isNear(Double floatingPointNumber)
	{
		this.isNotNull();
		require(floatingPointNumber).isNotNull();

		if (!(Math.abs(this.subject - floatingPointNumber) < DEFAULT_DOUBLE_EPSILON))
		{
			DbcAssertionException.throwNew(new IllegalArgumentException("Expected double <" + this.subject + "> to be near <" + floatingPointNumber + "> with epsilon <" + DEFAULT_DOUBLE_EPSILON + ">"));
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void isNearWithTolerance(Double floatingPointNumber, Double tolerance)
	{
		this.isNotNull();
		require(floatingPointNumber).isNotNull();

		if (!(Math.abs(this.subject - floatingPointNumber) < tolerance))
		{
			DbcAssertionException.throwNew(new IllegalArgumentException("Expected double <" + this.subject + "> to be near <" + floatingPointNumber + "> with epsilon <" + tolerance + ">"));
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void isNearZero()
	{
		this.isNotNull();

		if (!(Math.abs(this.subject) < DEFAULT_DOUBLE_EPSILON))
		{
			DbcAssertionException.throwNew(new IllegalArgumentException("Expected double <" + this.subject + "> to be near zero with epsilon <" + DEFAULT_DOUBLE_EPSILON + ">"));
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void isNearZeroWithTolerance(Double tolerance)
	{
		this.isNotNull();
		require(tolerance).isNotNull();

		if (!(Math.abs(this.subject) < tolerance))
		{
			DbcAssertionException.throwNew(new IllegalArgumentException("Expected double <" + this.subject + "> to be near zero with epsilon <" + tolerance + ">"));
		}
	}

	/**
	 * Use {@linkplain #isNear(Double)} instead
	 * {@inheritDoc}
	 */
	@Deprecated
	@Override
	public void isEqualTo(Double toCompare) { isNear(toCompare); }
}
