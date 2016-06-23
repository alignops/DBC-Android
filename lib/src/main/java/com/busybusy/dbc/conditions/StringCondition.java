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
 * {@linkplain StringChecks} primary implementation
 *
 * @author Trevor
 */
@NonNls
public final class StringCondition extends BasicCondition<String, StringCondition> implements StringChecks<StringCondition>
{
	public StringCondition(String subject, boolean enabled) { super(subject, enabled); }

	/**
	 * {@inheritDoc}
	 */
	@Override
	public StringCondition isValid()
	{
		this.isNotNull();

		if (this.enabled && this.subject.trim().length() == 0)
		{
			DbcAssertionException.throwNew(new IllegalArgumentException("The provided String is empty"));
		}

		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public StringCondition isValidUUID()
	{
		this.isNotNull();

		if (this.enabled && !this.subject.matches(StringChecks.UUID_PATTERN))
		{
			DbcAssertionException.throwNew(new IllegalArgumentException("The provided String is not a valid UUID: " + this.subject));
		}

		return this;
	}
}
