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

import com.busybusy.dbc.checks.MapChecks;

import java.util.Map;

/**
 * {@linkplain MapChecks} disabled implementation
 *
 * @author Trevor
 */
public class MapCondition_Disabled<T extends Map<K, V>, K, V> extends BasicCondition_Disabled<T> implements MapChecks<T, K, V>
{
	public MapCondition_Disabled(T subject) { super(subject); }

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void isNotEmpty() { }

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void hasSize(int size) { }

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void hasSizeBetween(int startInclusive, int endInclusive) { }

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void containsKey(K key) { }
}
