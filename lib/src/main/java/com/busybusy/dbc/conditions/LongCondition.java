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

import org.jetbrains.annotations.NonNls;

/**
 * Long implementation of number checks
 *
 * @author Trevor
 */
@NonNls
public class LongCondition extends NumberCondition<Long>
{
	public LongCondition(Long subject) { super(subject); }

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Long isGreaterThan(Long number)
	{
		if (!(this.subject > number))
		{
			DbcAssertionException.throwNew(new IllegalArgumentException("Expected long <" + this.subject + "> to be greater than <" + number + ">"));
		}

		return this.subject;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Long isGreaterThanOrEqual(Long number)
	{
		if (!(this.subject >= number))
		{
			DbcAssertionException.throwNew(new IllegalArgumentException("Expected long <" + this.subject + "> to be greater than or equal to <" + number + ">"));
		}

		return this.subject;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Long isLessThan(Long number)
	{
		if (!(this.subject < number))
		{
			DbcAssertionException.throwNew(new IllegalArgumentException("Expected long <" + this.subject + "> to be less than <" + number + ">"));
		}

		return this.subject;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Long isLessThanOrEqual(Long number)
	{
		if (!(this.subject <= number))
		{
			DbcAssertionException.throwNew(new IllegalArgumentException("Expected long <" + this.subject + "> to be less than or equal to <" + number + ">"));
		}

		return this.subject;
	}
}
