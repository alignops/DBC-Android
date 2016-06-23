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
import com.busybusy.dbc.checks.NumberChecks;

import org.jetbrains.annotations.NonNls;

/**
 * {@linkplain NumberChecks} integral implementation
 *
 * @author Trevor
 */
@NonNls
public class IntegralCondition<T extends Number> extends BasicCondition<T, IntegralCondition<T>> implements NumberChecks<T, IntegralCondition<T>>
{
	public IntegralCondition(T subject, boolean enabled) { super(subject, enabled); }

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IntegralCondition<T> isGreaterThan(T number)
	{
		if (this.enabled && !(this.subject.longValue() > number.longValue()))
		{
			DbcAssertionException.throwNew(new IllegalArgumentException("Expected integer <" + this.subject + "> to be greater than <" + number + ">"));
		}

		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IntegralCondition<T> isGreaterThanOrEqual(T number)
	{
		if (this.enabled && !(this.subject.longValue() >= number.longValue()))
		{
			DbcAssertionException.throwNew(new IllegalArgumentException("Expected integer <" + this.subject + "> to be greater than or equal to <" + number + ">"));
		}

		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IntegralCondition<T> isLessThan(T number)
	{
		if (this.enabled && !(this.subject.longValue() < number.longValue()))
		{
			DbcAssertionException.throwNew(new IllegalArgumentException("Expected integer <" + this.subject + "> to be less than <" + number + ">"));
		}

		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IntegralCondition<T> isLessThanOrEqual(T number)
	{
		if (this.enabled && !(this.subject.longValue() <= number.longValue()))
		{
			DbcAssertionException.throwNew(new IllegalArgumentException("Expected integer <" + this.subject + "> to be less than or equal to <" + number + ">"));
		}

		return this;
	}
}
