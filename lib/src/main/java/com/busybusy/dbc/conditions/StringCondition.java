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
import com.busybusy.dbc.checks.StringChecks;

import org.jetbrains.annotations.NonNls;

/**
 * Implementation of string checks
 *
 * @author Trevor
 */
@NonNls
public class StringCondition extends BasicCondition<String> implements StringChecks
{
	private static final String UUID_PATTERN = "[0-9a-f]{8}-[0-9a-f]{4}-[1-5][0-9a-f]{3}-[89ab][0-9a-f]{3}-[0-9a-f]{12}";

	public StringCondition(String subject) { super(subject); }

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String isValid()
	{
		String result = this.isNotNull();

		if (result.trim().length() == 0)
		{
			DbcAssertionException.throwNew(new IllegalArgumentException("The provided String is empty"));
		}

		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String isValidUUID()
	{
		String result = this.isNotNull();

		if (!result.matches(UUID_PATTERN))
		{
			DbcAssertionException.throwNew(new IllegalArgumentException("The provided String is not a valid UUID: " + result));
		}

		return result;
	}
}
