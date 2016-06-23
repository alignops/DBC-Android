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
 * {@linkplain FloatingPointChecks} {@linkplain Float} type implementation
 *
 * @author Trevor
 */
@NonNls
public final class FloatCondition extends BasicCondition<Float, FloatCondition> implements FloatingPointChecks<Float, FloatCondition>
{
	public FloatCondition(Float subject, boolean enabled) { super(subject, enabled); }

	/**
	 * {@inheritDoc}
	 */
	@Override
	public FloatCondition isGreaterThan(Float number)
	{
		this.isNotNull();
		require(number).isNotNull();

		if (this.enabled && !(Float.compare(this.subject, number) > 0))
		{
			DbcAssertionException.throwNew(new IllegalArgumentException("Expected float <" + this.subject + "> to be greater than <" + number + ">"));
		}

		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public FloatCondition isGreaterThanOrEqual(Float number)
	{
		this.isNotNull();
		require(number).isNotNull();

		if (this.enabled && !(Float.compare(this.subject, number) >= 0))
		{
			DbcAssertionException.throwNew(new IllegalArgumentException("Expected float <" + this.subject + "> to be greater than or equal to <" + number + ">"));
		}

		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public FloatCondition isLessThan(Float number)
	{
		this.isNotNull();
		require(number).isNotNull();

		if (this.enabled && !(Float.compare(this.subject, number) < 0))
		{
			DbcAssertionException.throwNew(new IllegalArgumentException("Expected float <" + this.subject + "> to be less than <" + number + ">"));
		}

		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public FloatCondition isLessThanOrEqual(Float number)
	{
		this.isNotNull();
		require(number).isNotNull();

		if (this.enabled && !(Float.compare(this.subject, number) <= 0))
		{
			DbcAssertionException.throwNew(new IllegalArgumentException("Expected float <" + this.subject + "> to be less than or equal to <" + number + ">"));
		}

		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public FloatCondition isNear(Float floatingPointNumber)
	{
		this.isNotNull();
		require(floatingPointNumber).isNotNull();

		if (this.enabled && !(Math.abs(this.subject - floatingPointNumber) < DEFAULT_DOUBLE_EPSILON))
		{
			DbcAssertionException.throwNew(new IllegalArgumentException("Expected float <" + this.subject + "> to be near <" + floatingPointNumber + "> with epsilon <" + DEFAULT_DOUBLE_EPSILON + ">"));
		}

		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public FloatCondition isNearWithTolerance(Float floatingPointNumber, Float tolerance)
	{
		this.isNotNull();
		require(floatingPointNumber).isNotNull();
		require(tolerance).isNotNull();

		if (this.enabled && !(Math.abs(this.subject - floatingPointNumber) < tolerance))
		{
			DbcAssertionException.throwNew(new IllegalArgumentException("Expected float <" + this.subject + "> to be near <" + floatingPointNumber + "> with epsilon <" + tolerance + ">"));
		}

		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public FloatCondition isNearZero()
	{
		this.isNotNull();

		if (this.enabled && !(Math.abs(this.subject) < DEFAULT_FLOAT_EPSILON))
		{
			DbcAssertionException.throwNew(new IllegalArgumentException("Expected float <" + this.subject + "> to be near zero with epsilon <" + DEFAULT_FLOAT_EPSILON + ">"));
		}

		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public FloatCondition isNearZeroWithTolerance(Float tolerance)
	{
		this.isNotNull();
		require(tolerance).isNotNull();

		if (this.enabled && !(Math.abs(this.subject) < tolerance))
		{
			DbcAssertionException.throwNew(new IllegalArgumentException("Expected float <" + this.subject + "> to be near zero with epsilon <" + tolerance + ">"));
		}

		return this;
	}

	/**
	 * Use {@linkplain #isNear(Float)} instead
	 * <p>
	 * {@inheritDoc}
	 */
	@Deprecated
	@Override
	public FloatCondition isEqualTo(Float toCompare) { return isNear(toCompare); }
}
