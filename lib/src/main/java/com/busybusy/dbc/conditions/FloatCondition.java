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

import com.busybusy.dbc.DbcAssertionError;
import com.busybusy.dbc.checks.FloatingPointChecks;

import static com.busybusy.dbc.Dbc.require;

/**
 * {@linkplain FloatingPointChecks} {@linkplain Float} type implementation
 *
 * @author Trevor
 */
public final class FloatCondition extends BasicCondition<Float, FloatCondition> implements FloatingPointChecks<Float, FloatCondition>
{
	public FloatCondition(Float subject) { super(subject); }

	/**
	 * {@inheritDoc}
	 */
	@Override
	public FloatCondition isGreaterThan(Float number)
	{
		require(this.subject).isNotNull();
		require(number).isNotNull();

		if (!(Float.compare(this.subject, number) > 0))
		{
			DbcAssertionError.throwNew(new IllegalArgumentException("Expected float <" + this.subject + "> to be greater than <" + number + ">"), this.message);
		}

		return result();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public FloatCondition isGreaterThanOrEqual(Float number)
	{
		require(this.subject).isNotNull();
		require(number).isNotNull();

		if (!(Float.compare(this.subject, number) >= 0))
		{
			DbcAssertionError.throwNew(new IllegalArgumentException("Expected float <" + this.subject + "> to be greater than or equal to <" + number + ">"), this.message);
		}

		return result();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public FloatCondition isLessThan(Float number)
	{
		require(this.subject).isNotNull();
		require(number).isNotNull();

		if (!(Float.compare(this.subject, number) < 0))
		{
			DbcAssertionError.throwNew(new IllegalArgumentException("Expected float <" + this.subject + "> to be less than <" + number + ">"), this.message);
		}

		return result();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public FloatCondition isLessThanOrEqual(Float number)
	{
		require(this.subject).isNotNull();
		require(number).isNotNull();

		if (!(Float.compare(this.subject, number) <= 0))
		{
			DbcAssertionError.throwNew(new IllegalArgumentException("Expected float <" + this.subject + "> to be less than or equal to <" + number + ">"), this.message);
		}

		return result();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public FloatCondition isNear(Float floatingPointNumber)
	{
		require(this.subject).isNotNull();
		require(floatingPointNumber).isNotNull();

		if (!(Math.abs(this.subject - floatingPointNumber) < DEFAULT_DOUBLE_EPSILON))
		{
			DbcAssertionError.throwNew(new IllegalArgumentException("Expected float <" + this.subject + "> to be near <" + floatingPointNumber + "> with epsilon <" + DEFAULT_DOUBLE_EPSILON + ">"), this.message);
		}

		return result();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public FloatCondition isNearWithTolerance(Float floatingPointNumber, Float tolerance)
	{
		require(this.subject).isNotNull();
		require(floatingPointNumber).isNotNull();
		require(tolerance).isNotNull();

		if (!(Math.abs(this.subject - floatingPointNumber) < tolerance))
		{
			DbcAssertionError.throwNew(new IllegalArgumentException("Expected float <" + this.subject + "> to be near <" + floatingPointNumber + "> with epsilon <" + tolerance + ">"), this.message);
		}

		return result();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public FloatCondition isNearZero()
	{
		require(this.subject).isNotNull();

		if (!(Math.abs(this.subject) < DEFAULT_FLOAT_EPSILON))
		{
			DbcAssertionError.throwNew(new IllegalArgumentException("Expected float <" + this.subject + "> to be near zero with epsilon <" + DEFAULT_FLOAT_EPSILON + ">"), this.message);
		}

		return result();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public FloatCondition isNearZeroWithTolerance(Float tolerance)
	{
		require(this.subject).isNotNull();
		require(tolerance).isNotNull();

		if (!(Math.abs(this.subject) < tolerance))
		{
			DbcAssertionError.throwNew(new IllegalArgumentException("Expected float <" + this.subject + "> to be near zero with epsilon <" + tolerance + ">"), this.message);
		}

		return result();
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
