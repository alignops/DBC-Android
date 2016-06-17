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

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * @author Trevor
 */
@RunWith(JUnit4.class)
public class DoubleConditionTest
{
	@Test
	public void isGreaterThan() throws Exception
	{
		DoubleCondition condition = new DoubleCondition(2.0D);
		condition.isGreaterThan(1D);

		assertThatThrownBy(() -> condition.isGreaterThan(3D))
				.isInstanceOf(DbcAssertionException.class)
				.hasCauseInstanceOf(IllegalArgumentException.class);
	}

	@Test
	public void isGreaterThanOrEqual() throws Exception
	{
		DoubleCondition condition = new DoubleCondition(2.0D);
		condition.isGreaterThanOrEqual(2D);

		assertThatThrownBy(() -> condition.isGreaterThanOrEqual(3D))
				.isInstanceOf(DbcAssertionException.class)
				.hasCauseInstanceOf(IllegalArgumentException.class);
	}

	@Test
	public void isLessThan() throws Exception
	{
		DoubleCondition condition = new DoubleCondition(2.0D);
		condition.isLessThan(3D);

		assertThatThrownBy(() -> condition.isLessThan(1D))
				.isInstanceOf(DbcAssertionException.class)
				.hasCauseInstanceOf(IllegalArgumentException.class);
	}

	@Test
	public void isLessThanOrEqual() throws Exception
	{
		DoubleCondition condition = new DoubleCondition(2.0D);
		condition.isLessThanOrEqual(2D);

		assertThatThrownBy(() -> condition.isLessThanOrEqual(1D))
				.isInstanceOf(DbcAssertionException.class)
				.hasCauseInstanceOf(IllegalArgumentException.class);
	}

	@Test
	public void isNear() throws Exception
	{
		DoubleCondition condition = new DoubleCondition(2.0D);
		condition.isNear(2D);

		assertThatThrownBy(() -> condition.isNear(1D))
				.isInstanceOf(DbcAssertionException.class)
				.hasCauseInstanceOf(IllegalArgumentException.class);
	}

	@Test
	public void isNearCustomTolerance() throws Exception
	{
		DoubleCondition condition = new DoubleCondition(2.0D);
		condition.isNearWithTolerance(3D, 2.5D);

		assertThatThrownBy(() -> condition.isNearWithTolerance(1D, .5D))
				.isInstanceOf(DbcAssertionException.class)
				.hasCauseInstanceOf(IllegalArgumentException.class);
	}

	@Test
	public void isNearZero() throws Exception
	{
		DoubleCondition condition = new DoubleCondition(0.22E-16);
		condition.isNearZero();

		DoubleCondition badCondition = new DoubleCondition(2D);
		assertThatThrownBy(badCondition::isNearZero)
				.isInstanceOf(DbcAssertionException.class)
				.hasCauseInstanceOf(IllegalArgumentException.class);
	}

	@Test
	public void isNearZeroCustomTolerance() throws Exception
	{
		DoubleCondition condition = new DoubleCondition(1D);
		condition.isNearZeroWithTolerance(1.5D);

		DoubleCondition badCondition = new DoubleCondition(2D);
		assertThatThrownBy(() -> badCondition.isNearZeroWithTolerance(1.5D))
				.isInstanceOf(DbcAssertionException.class)
				.hasCauseInstanceOf(IllegalArgumentException.class);
	}

	@Test
	public void isEqualTo() throws Exception
	{
		DoubleCondition condition = new DoubleCondition(2.0D);
		condition.isEqualTo(2D);

		assertThatThrownBy(() -> condition.isEqualTo(1D))
				.isInstanceOf(DbcAssertionException.class)
				.hasCauseInstanceOf(IllegalArgumentException.class);
	}
}