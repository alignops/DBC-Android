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
import com.busybusy.dbc.DbcBlock;
import com.busybusy.dbc.checks.BasicChecks;

import org.jetbrains.annotations.NonNls;

import java.util.Comparator;
import java.util.concurrent.Callable;

import static com.busybusy.dbc.Dbc.require;

/**
 * {@linkplain BasicChecks} primary implementation
 *
 * @param <T> type of object
 * @author Trevor
 */
@NonNls
public abstract class BasicCondition<T, Self extends BasicCondition<T, Self>> implements BasicChecks<T, Self>
{
	protected       Message message;
	protected final T       subject;

	public BasicCondition(T subject)
	{
		this.subject = subject;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Self message(@NonNull String message)
	{
		require(message).isValid();

		this.message = new Message(message);

		//noinspection unchecked
		return (Self) this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Self message(@NonNull Callable<String> lazyMessage)
	{
		require(lazyMessage).isNotNull();

		this.message = new Message(lazyMessage);

		//noinspection unchecked
		return (Self) this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Self isNull()
	{
		if (this.subject != null)
		{
			DbcAssertionError.throwNew(new IllegalArgumentException("A null argument was required but was:" + this.subject), this.message);
		}

		return result();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Self isNotNull()
	{
		if (this.subject == null)
		{
			DbcAssertionError.throwNew(new NullPointerException("A non null argument was required but was null"), this.message);
		}

		return result();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Self passes(@NonNull DbcBlock<T> testBlock)
	{
		require(this.subject).isNotNull();
		require(testBlock).isNotNull();

		if (!testBlock.checkState(this.subject))
		{
			DbcAssertionError.throwNew(new IllegalArgumentException("Assertion in <" + testBlock + "> failed on subject: " + this.subject), this.message);
		}

		return result();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Self fails(@NonNull DbcBlock<T> testBlock)
	{
		require(this.subject).isNotNull();
		require(testBlock).isNotNull();

		if (testBlock.checkState(this.subject))
		{
			DbcAssertionError.throwNew(new IllegalArgumentException("Assertion in <" + testBlock + "> failed on subject:" + this.subject), this.message);
		}

		return result();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Self isEqualTo(T toCompare)
	{
		require(this.subject).isNotNull();
		require(toCompare).isNotNull();

		if (!subject.equals(toCompare))
		{
			DbcAssertionError.throwNew(new IllegalArgumentException("Equality test failed on subject: " + this.subject), this.message);
		}

		return result();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Self isEqualTo(T toCompare, @NonNull Comparator<T> customComparator)
	{
		require(this.subject).isNotNull();
		require(toCompare).isNotNull();
		require(customComparator).isNotNull();

		if (customComparator.compare(this.subject, toCompare) != 0)
		{
			DbcAssertionError.throwNew(new IllegalArgumentException("Equality test <" + customComparator + "> failed on subject: " + this.subject), this.message);
		}

		return result();
	}

	protected Self result()
	{
		this.message = null;

		//noinspection unchecked
		return (Self) this;
	}
}
