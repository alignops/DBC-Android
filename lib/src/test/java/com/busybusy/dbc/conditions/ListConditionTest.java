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

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;

/**
 * @author Trevor
 */
@RunWith(JUnit4.class)
public class ListConditionTest
{
	ArrayList<String> input;

	@Before
	public void setUp() throws Exception
	{
		this.input = new ArrayList<>();
		this.input.add("One");
		this.input.add("Two");
		this.input.add("Three");
	}

	@Test
	public void isNotEmpty_enabled() throws Exception
	{
		ListCondition<ArrayList<String>, String> condition = new ListCondition<>(this.input, true);
		condition.isNotEmpty();

		ListCondition<ArrayList<String>, String> badCondition = new ListCondition<>(new ArrayList<>(), true);
		Assertions.assertThatThrownBy(badCondition::isNotEmpty)
		          .isInstanceOf(DbcAssertionException.class)
		          .hasCauseInstanceOf(IllegalArgumentException.class);
	}

	@Test
	public void isNotEmpty_disabled() throws Exception
	{
		ListCondition<ArrayList<String>, String> condition = new ListCondition<>(this.input, false);
		condition.isNotEmpty();

		ListCondition<ArrayList<String>, String> badCondition = new ListCondition<>(new ArrayList<>(), false);
		badCondition.isNotEmpty();
	}

	@Test
	public void hasSize_enabled() throws Exception
	{
		ListCondition<ArrayList<String>, String> condition = new ListCondition<>(this.input, true);
		condition.hasSize(3);

		Assertions.assertThatThrownBy(() -> condition.hasSize(4))
		          .isInstanceOf(DbcAssertionException.class)
		          .hasCauseInstanceOf(IllegalArgumentException.class);
	}

	@Test
	public void hasSize_disabled() throws Exception
	{
		ListCondition<ArrayList<String>, String> condition = new ListCondition<>(this.input, false);
		condition.hasSize(3).hasSize(4);
	}

	@Test
	public void hasSizeBetween_enabled() throws Exception
	{
		ListCondition<ArrayList<String>, String> condition = new ListCondition<>(this.input, true);
		condition.hasSizeBetween(2, 4);

		Assertions.assertThatThrownBy(() -> condition.hasSizeBetween(4, 7))
		          .isInstanceOf(DbcAssertionException.class)
		          .hasCauseInstanceOf(IllegalArgumentException.class);
	}

	@Test
	public void hasSizeBetween_disabled() throws Exception
	{
		ListCondition<ArrayList<String>, String> condition = new ListCondition<>(this.input, false);
		condition.hasSizeBetween(2, 4).hasSizeBetween(4, 7);
	}

}