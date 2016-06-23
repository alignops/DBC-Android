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
	public void isGreaterThan_enabled() throws Exception
	{
		DoubleCondition condition = new DoubleCondition(2.0D, true);
		condition.isGreaterThan(1D);

		assertThatThrownBy(() -> condition.isGreaterThan(3D))
				.isInstanceOf(DbcAssertionException.class)
				.hasCauseInstanceOf(IllegalArgumentException.class);
	}

	@Test
	public void isGreaterThan_disabled() throws Exception
	{
		DoubleCondition condition = new DoubleCondition(2.0D, false);
		condition.isGreaterThan(1D).isGreaterThan(3D);
	}

	@Test
	public void isGreaterThanOrEqual_enabled() throws Exception
	{
		DoubleCondition condition = new DoubleCondition(2.0D, true);
		condition.isGreaterThanOrEqual(2D);

		assertThatThrownBy(() -> condition.isGreaterThanOrEqual(3D))
				.isInstanceOf(DbcAssertionException.class)
				.hasCauseInstanceOf(IllegalArgumentException.class);
	}

	@Test
	public void isGreaterThanOrEqual_disabled() throws Exception
	{
		DoubleCondition condition = new DoubleCondition(2.0D, false);
		condition.isGreaterThanOrEqual(2D).isGreaterThanOrEqual(3D);
	}

	@Test
	public void isLessThan_enabled() throws Exception
	{
		DoubleCondition condition = new DoubleCondition(2.0D, true);
		condition.isLessThan(3D);

		assertThatThrownBy(() -> condition.isLessThan(1D))
				.isInstanceOf(DbcAssertionException.class)
				.hasCauseInstanceOf(IllegalArgumentException.class);
	}

	@Test
	public void isLessThan_disabled() throws Exception
	{
		DoubleCondition condition = new DoubleCondition(2.0D, false);
		condition.isLessThan(3D).isLessThan(1D);
	}

	@Test
	public void isLessThanOrEqual_enabled() throws Exception
	{
		DoubleCondition condition = new DoubleCondition(2.0D, true);
		condition.isLessThanOrEqual(2D);

		assertThatThrownBy(() -> condition.isLessThanOrEqual(1D))
				.isInstanceOf(DbcAssertionException.class)
				.hasCauseInstanceOf(IllegalArgumentException.class);
	}

	@Test
	public void isLessThanOrEqual_disabled() throws Exception
	{
		DoubleCondition condition = new DoubleCondition(2.0D, false);
		condition.isLessThanOrEqual(2D).isLessThanOrEqual(1D);
	}

	@Test
	public void isNear_enabled() throws Exception
	{
		DoubleCondition condition = new DoubleCondition(2.0D, true);
		condition.isNear(2D);

		assertThatThrownBy(() -> condition.isNear(1D))
				.isInstanceOf(DbcAssertionException.class)
				.hasCauseInstanceOf(IllegalArgumentException.class);
	}

	@Test
	public void isNear_disabled() throws Exception
	{
		DoubleCondition condition = new DoubleCondition(2.0D, false);
		condition.isNear(2D).isNear(1D);
	}

	@Test
	public void isNearCustomTolerance_enabled() throws Exception
	{
		DoubleCondition condition = new DoubleCondition(2.0D, true);
		condition.isNearWithTolerance(3D, 2.5D);

		assertThatThrownBy(() -> condition.isNearWithTolerance(1D, .5D))
				.isInstanceOf(DbcAssertionException.class)
				.hasCauseInstanceOf(IllegalArgumentException.class);
	}

	@Test
	public void isNearCustomTolerance_disabled() throws Exception
	{
		DoubleCondition condition = new DoubleCondition(2.0D, false);
		condition.isNearWithTolerance(3D, 2.5D).isNearWithTolerance(1D, .5D);
	}

	@Test
	public void isNearZero_enabled() throws Exception
	{
		DoubleCondition condition = new DoubleCondition(0.22E-16, true);
		condition.isNearZero();

		DoubleCondition badCondition = new DoubleCondition(2D, true);
		assertThatThrownBy(badCondition::isNearZero)
				.isInstanceOf(DbcAssertionException.class)
				.hasCauseInstanceOf(IllegalArgumentException.class);
	}

	@Test
	public void isNearZero_disabled() throws Exception
	{
		DoubleCondition condition = new DoubleCondition(0.22E-16, false);
		condition.isNearZero();

		DoubleCondition badCondition = new DoubleCondition(2D, false);
		badCondition.isNearZero();
	}

	@Test
	public void isNearZeroCustomTolerance_enabled() throws Exception
	{
		DoubleCondition condition = new DoubleCondition(1D, true);
		condition.isNearZeroWithTolerance(1.5D);

		DoubleCondition badCondition = new DoubleCondition(2D, true);
		assertThatThrownBy(() -> badCondition.isNearZeroWithTolerance(1.5D))
				.isInstanceOf(DbcAssertionException.class)
				.hasCauseInstanceOf(IllegalArgumentException.class);
	}

	@Test
	public void isNearZeroCustomTolerance_disabled() throws Exception
	{
		DoubleCondition condition = new DoubleCondition(1D, false);
		condition.isNearZeroWithTolerance(1.5D);

		DoubleCondition badCondition = new DoubleCondition(2D, false);
		badCondition.isNearZeroWithTolerance(1.5D);
	}

	@Test
	public void isEqualTo_enabled() throws Exception
	{
		DoubleCondition condition = new DoubleCondition(2.0D, true);
		condition.isEqualTo(2D);

		assertThatThrownBy(() -> condition.isEqualTo(1D))
				.isInstanceOf(DbcAssertionException.class)
				.hasCauseInstanceOf(IllegalArgumentException.class);
	}

	@Test
	public void isEqualTo_disabled() throws Exception
	{
		DoubleCondition condition = new DoubleCondition(2.0D, false);
		condition.isEqualTo(2D).isEqualTo(1D);
	}
}