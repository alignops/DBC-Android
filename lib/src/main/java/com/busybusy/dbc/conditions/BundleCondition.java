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

import android.os.Bundle;
import android.support.annotation.NonNull;

import com.busybusy.dbc.DbcAssertionError;
import com.busybusy.dbc.checks.BundleChecks;

import static com.busybusy.dbc.Dbc.check;
import static com.busybusy.dbc.Dbc.require;

/**
 * @author Tjones
 */
public final class BundleCondition extends BasicCondition<Bundle, BundleCondition> implements BundleChecks<BundleCondition>
{
	public BundleCondition(Bundle subject) { super(subject); }

	/**
	 * {@inheritDoc}
	 */
	@NonNull
	@Override
	public BundleCondition containsKey(@NonNull String key)
	{
		require(subject).isNotNull();

		if (!subject.containsKey(key))
		{
			DbcAssertionError.throwNew(new IllegalStateException("Expected bundle to contain key<" + key + ">"), this.message);
		}

		return result();
	}

	/**
	 * {@inheritDoc}
	 */
	@NonNull
	@Override
	public BundleCondition valueIsOfType(@NonNull String key, @NonNull Class<?> type)
	{
		require(subject).containsKey(key);

		Object intermediateSubject = subject.get(key);
		check(intermediateSubject).isNotNull();

		//noinspection ConstantConditions
		if (!type.isAssignableFrom(intermediateSubject.getClass()))
		{
			DbcAssertionError.throwNew(new IllegalStateException("Expected bundle to contain value of type <" + type + "> with key <" + key + ">"), this.message);
		}

		return result();
	}
}
