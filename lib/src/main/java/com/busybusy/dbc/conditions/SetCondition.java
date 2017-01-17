/*
 * Copyright 2017 Busy, LLC
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
import com.busybusy.dbc.checks.SetChecks;

import java.util.Set;

import static com.busybusy.dbc.Dbc.require;

/**
 * @author Trevor
 */
public final class SetCondition<T extends Set<E>, E> extends BasicCondition<T, SetCondition<T, E>> implements SetChecks<T, E, SetCondition<T, E>>
{
	public SetCondition(T subject)
	{
		super(subject);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public SetCondition<T, E> isNotEmpty()
	{
		require(this.subject).isNotNull();

		if (this.subject.isEmpty())
		{
			DbcAssertionError.throwNew(new IllegalArgumentException("Expected non empty set"), this.message);
		}

		return result();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public SetCondition<T, E> hasSize(int size)
	{
		require(this.subject).isNotNull();

		if (!(this.subject.size() == size))
		{
			DbcAssertionError.throwNew(new IllegalArgumentException("Expected set size to be <" + size + "> but was <" + this.subject.size() + ">"), this.message);
		}

		return result();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public SetCondition<T, E> hasSizeBetween(int startInclusive, int endInclusive)
	{
		require(this.subject).isNotNull();

		int setSize = this.subject.size();
		if (!((setSize >= startInclusive && setSize <= endInclusive) || (setSize <= startInclusive && setSize >= endInclusive)))
		{
			DbcAssertionError.throwNew(new IllegalArgumentException("Expected set size to be between <" + startInclusive + "> and < " + endInclusive + "> but was <" + setSize + ">"), this.message);
		}

		return result();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public SetCondition<T, E> hasSizeGreaterThan(int minSizeExclusive)
	{
		require(this.subject).isNotNull();

		if (!(this.subject.size() > minSizeExclusive))
		{
			DbcAssertionError.throwNew(new IllegalStateException("Expected set size to be greater than <" + minSizeExclusive + "> but was <" + this.subject.size() + ">"), this.message);
		}

		return result();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public SetCondition<T, E> hasSizeGreaterThanOrEqual(int minSize)
	{
		require(this.subject).isNotNull();

		if (!(this.subject.size() >= minSize))
		{
			DbcAssertionError.throwNew(new IllegalStateException("Expected set size to be greater than or equal <" + minSize + "> but was <" + this.subject.size() + ">"), this.message);
		}

		return result();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public SetCondition<T, E> hasSizeLessThan(int maxSizeExclusive)
	{
		require(this.subject).isNotNull();

		if (!(this.subject.size() < maxSizeExclusive))
		{
			DbcAssertionError.throwNew(new IllegalStateException("Expected set size to be less than <" + maxSizeExclusive + "> but was <" + this.subject.size() + ">"), this.message);
		}

		return result();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public SetCondition<T, E> hasSizeLessThanOrEqual(int maxSize)
	{
		require(this.subject).isNotNull();

		if (!(this.subject.size() <= maxSize))
		{
			DbcAssertionError.throwNew(new IllegalStateException("Expected set size to be less than or equal <" + maxSize + "> but was <" + this.subject.size() + ">"), this.message);
		}

		return result();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public SetCondition<T, E> contains(E value)
	{
		require(this.subject).isNotNull();

		if (!this.subject.contains(value))
		{
			DbcAssertionError.throwNew(new IllegalArgumentException("Expected set to contain value: " + value), this.message);
		}

		return result();
	}
}
