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

import android.support.annotation.NonNull;

import com.busybusy.dbc.DbcAssertionError;
import com.busybusy.dbc.checks.BooleanChecks;

import static com.busybusy.dbc.Dbc.require;

/**
 * @author Trevor
 */
public class BooleanCondition extends BasicCondition<Boolean, BooleanCondition> implements BooleanChecks<BooleanCondition>
{
	public BooleanCondition(Boolean subject) { super(subject); }

	@NonNull
	@Override
	public BooleanCondition isTrue()
	{
		require(this.subject).isNotNull();

		if (!this.subject)
		{
			DbcAssertionError.throwNew(new IllegalStateException("Expected subject to be true but was false"), this.message);
		}

		return this;
	}

	@NonNull
	@Override
	public BooleanCondition isFalse()
	{

		require(this.subject).isNotNull();

		if (this.subject)
		{
			DbcAssertionError.throwNew(new IllegalStateException("Expected subject to be false but was true"), this.message);
		}

		return this;
	}
}
