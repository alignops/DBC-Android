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

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author Trevor
 */
@RunWith(JUnit4.class)
public class SetConditionTest
{
	Set<String> input;

	@Before
	public void setUp() throws Exception
	{
		input = new LinkedHashSet<>();
		input.add("One");
		input.add("Two");
		input.add("Three");
	}

	@Test
	public void isNotEmpty() throws Exception
	{
		SetCondition<Set<String>, String> condition = new SetCondition<>(this.input);
		condition.isNotEmpty();

		SetCondition<Set<String>, String> badCondition = new SetCondition<>(new LinkedHashSet<>());
		Assertions.assertThatThrownBy(badCondition::isNotEmpty)
		          .isInstanceOf(DbcAssertionError.class)
		          .hasCauseInstanceOf(IllegalArgumentException.class);
	}

	@Test
	public void hasSize() throws Exception
	{
		SetCondition<Set<String>, String> condition = new SetCondition<>(this.input);
		condition.hasSize(3);

		SetCondition<Set<String>, String> badCondition = new SetCondition<>(this.input);
		Assertions.assertThatThrownBy(() -> badCondition.hasSize(1))
		          .isInstanceOf(DbcAssertionError.class)
		          .hasCauseInstanceOf(IllegalArgumentException.class);
	}

	@Test
	public void hasSizeBetween() throws Exception
	{
		SetCondition<Set<String>, String> condition = new SetCondition<>(this.input);
		condition.hasSizeBetween(2, 4);

		SetCondition<Set<String>, String> badCondition = new SetCondition<>(this.input);
		Assertions.assertThatThrownBy(() -> badCondition.hasSizeBetween(1, 2))
		          .isInstanceOf(DbcAssertionError.class)
		          .hasCauseInstanceOf(IllegalArgumentException.class);
	}

	@Test
	public void hasSizeGreaterThan() throws Exception
	{
		SetCondition<Set<String>, String> condition = new SetCondition<>(this.input);
		condition.hasSizeGreaterThan(2);

		SetCondition<Set<String>, String> badCondition = new SetCondition<>(this.input);
		Assertions.assertThatThrownBy(() -> badCondition.hasSizeGreaterThan(3))
		          .isInstanceOf(DbcAssertionError.class)
		          .hasCauseInstanceOf(IllegalStateException.class);
	}

	@Test
	public void hasSizeGreaterThanOrEqual() throws Exception
	{
		SetCondition<Set<String>, String> condition = new SetCondition<>(this.input);
		condition.hasSizeGreaterThanOrEqual(3);

		SetCondition<Set<String>, String> badCondition = new SetCondition<>(this.input);
		Assertions.assertThatThrownBy(() -> badCondition.hasSizeGreaterThanOrEqual(4))
		          .isInstanceOf(DbcAssertionError.class)
		          .hasCauseInstanceOf(IllegalStateException.class);
	}

	@Test
	public void hasSizeLessThan() throws Exception
	{
		SetCondition<Set<String>, String> condition = new SetCondition<>(this.input);
		condition.hasSizeLessThan(4);

		SetCondition<Set<String>, String> badCondition = new SetCondition<>(this.input);
		Assertions.assertThatThrownBy(() -> badCondition.hasSizeLessThan(1))
		          .isInstanceOf(DbcAssertionError.class)
		          .hasCauseInstanceOf(IllegalStateException.class);
	}

	@Test
	public void hasSizeLessThanOrEqual() throws Exception
	{
		SetCondition<Set<String>, String> condition = new SetCondition<>(this.input);
		condition.hasSizeLessThanOrEqual(3);

		SetCondition<Set<String>, String> badCondition = new SetCondition<>(this.input);
		Assertions.assertThatThrownBy(() -> badCondition.hasSizeLessThanOrEqual(1))
		          .isInstanceOf(DbcAssertionError.class)
		          .hasCauseInstanceOf(IllegalStateException.class);
	}

	@Test
	public void contains() throws Exception
	{
		SetCondition<Set<String>, String> condition = new SetCondition<>(this.input);
		condition.contains("One");

		SetCondition<Set<String>, String> badCondition = new SetCondition<>(this.input);
		Assertions.assertThatThrownBy(() -> badCondition.contains("Fail"))
		          .isInstanceOf(DbcAssertionError.class)
		          .hasCauseInstanceOf(IllegalArgumentException.class);
	}
}