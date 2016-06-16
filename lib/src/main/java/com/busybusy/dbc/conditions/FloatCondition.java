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
import com.busybusy.dbc.checks.FloatChecks;

import org.jetbrains.annotations.NonNls;

/**
 * Float implementation of number checks
 *
 * @author Trevor
 */
@NonNls
public class FloatCondition extends NumberCondition<Float> implements FloatChecks
{
	public FloatCondition(Float subject) { super(subject); }

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void isGreaterThan(Float number)
	{
		if (!(Float.compare(this.subject, number) > 0))
		{
			DbcAssertionException.throwNew(new IllegalArgumentException("Expected float <" + this.subject + "> to be greater than <" + number + ">"));
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void isGreaterThanOrEqual(Float number)
	{
		if (!(Float.compare(this.subject, number) >= 0))
		{
			DbcAssertionException.throwNew(new IllegalArgumentException("Expected float <" + this.subject + "> to be greater than or equal to <" + number + ">"));
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void isLessThan(Float number)
	{
		if (!(Float.compare(this.subject, number) < 0))
		{
			DbcAssertionException.throwNew(new IllegalArgumentException("Expected float <" + this.subject + "> to be less than <" + number + ">"));
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void isLessThanOrEqual(Float number)
	{
		if (!(Float.compare(this.subject, number) <= 0))
		{
			DbcAssertionException.throwNew(new IllegalArgumentException("Expected float <" + this.subject + "> to be less than or equal to <" + number + ">"));
		}
	}

	@Override
	public void isNear(Float floatingPointNumber)
	{

	}

	@Override
	public void isNear(Float floatingPointNumber, Float tolerance)
	{

	}

	@Override
	public void isNearZero()
	{

	}

	@Override
	public void isNearZero(Float tolerance)
	{

	}

	@Deprecated
	@Override
	public void isEqualTo(Float toCompare)
	{
		DbcAssertionException.throwNew(new RuntimeException("The is equal to method should be avoided on floating point numbers, use isNear instead"));
	}
}
