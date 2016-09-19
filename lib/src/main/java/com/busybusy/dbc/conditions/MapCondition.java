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
import com.busybusy.dbc.checks.MapChecks;

import java.util.Map;

import static com.busybusy.dbc.Dbc.require;

/**
 * {@linkplain MapChecks} primary implementation
 *
 * @author Trevor
 */
public final class MapCondition<T extends Map<K, V>, K, V> extends BasicCondition<T, MapCondition<T, K, V>> implements MapChecks<T, K, V, MapCondition<T, K, V>>
{
	public MapCondition(T subject) { super(subject); }

	/**
	 * {@inheritDoc}
	 */
	@Override
	public MapCondition<T, K, V> isNotEmpty()
	{
		require(this.subject).isNotNull();

		if (this.subject.isEmpty())
		{
			DbcAssertionError.throwNew(new IllegalArgumentException("Expected non empty map"), this.message);
		}

		return result();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public MapCondition<T, K, V> hasSize(int size)
	{
		require(this.subject).isNotNull();

		if (!(this.subject.size() == size))
		{
			DbcAssertionError.throwNew(new IllegalArgumentException("Expected map size to be <" + size + "> but was <" + this.subject.size() + ">"), this.message);
		}

		return result();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public MapCondition<T, K, V> hasSizeBetween(int startInclusive, int endInclusive)
	{
		require(this.subject).isNotNull();

		int mapSize = this.subject.size();
		if (!((mapSize >= startInclusive && mapSize <= endInclusive) || (mapSize <= startInclusive && mapSize >= endInclusive)))
		{
			DbcAssertionError.throwNew(new IllegalArgumentException("Expected map size to be between <" + startInclusive + "> and < " + endInclusive + "> but was <" + mapSize + ">"), this.message);
		}

		return result();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public MapCondition<T, K, V> containsKey(K key)
	{
		require(this.subject).isNotNull();

		if (!this.subject.containsKey(key))
		{
			DbcAssertionError.throwNew(new IllegalArgumentException("Expected map to contain key: " + key), this.message);
		}

		return result();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public MapCondition<T, K, V> containsValue(V value)
	{
		require(this.subject).isNotNull();

		if (!this.subject.containsValue(value))
		{
			DbcAssertionError.throwNew(new IllegalArgumentException("Expected map to contain value: " + value), this.message);
		}

		return result();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public MapCondition<T, K, V> hasSizeGreaterThan(int minSizeExclusive)
	{
		require(this.subject).isNotNull();

		if (!(this.subject.size() > minSizeExclusive))
		{
			DbcAssertionError.throwNew(new IllegalStateException("Expected map size to be greater than <" + minSizeExclusive + "> but was <" + this.subject.size() + ">"), this.message);
		}
		return result();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public MapCondition<T, K, V> hasSizeGreaterThanOrEqual(int minSize)
	{
		require(this.subject).isNotNull();

		if (!(this.subject.size() >= minSize))
		{
			DbcAssertionError.throwNew(new IllegalStateException("Expected map size to be greater than or equal <" + minSize + "> but was <" + this.subject.size() + ">"), this.message);
		}
		return result();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public MapCondition<T, K, V> hasSizeLessThan(int maxSizeExclusive)
	{
		require(this.subject).isNotNull();

		if (!(this.subject.size() < maxSizeExclusive))
		{
			DbcAssertionError.throwNew(new IllegalStateException("Expected map size to be less than <" + maxSizeExclusive + "> but was <" + this.subject.size() + ">"), this.message);
		}
		return result();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public MapCondition<T, K, V> hasSizeLessThanOrEqual(int maxSize)
	{
		require(this.subject).isNotNull();

		if (!(this.subject.size() <= maxSize))
		{
			DbcAssertionError.throwNew(new IllegalStateException("Expected map size to be less than or equal <" + maxSize + "> but was <" + this.subject.size() + ">"), this.message);
		}
		return result();
	}
}
