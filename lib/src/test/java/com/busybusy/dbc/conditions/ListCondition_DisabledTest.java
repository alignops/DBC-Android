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

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;

/**
 * @author Trevor
 */
@RunWith(JUnit4.class)
public class ListCondition_DisabledTest
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
	public void isNotEmpty() throws Exception
	{
		ListCondition_Disabled<ArrayList<String>, String> condition = new ListCondition_Disabled<>(this.input);
		condition.isNotEmpty();

		ListCondition_Disabled<ArrayList<String>, String> badCondition = new ListCondition_Disabled<>(new ArrayList<>());
		badCondition.isNotEmpty();
	}

	@Test
	public void hasSize() throws Exception
	{
		ListCondition_Disabled<ArrayList<String>, String> condition = new ListCondition_Disabled<>(this.input);
		condition.hasSize(3);
		condition.hasSize(42);
	}

	@Test
	public void hasSizeBetween() throws Exception
	{
		ListCondition_Disabled<ArrayList<String>, String> condition = new ListCondition_Disabled<>(this.input);
		condition.hasSizeBetween(2, 4);
		condition.hasSizeBetween(7, 4);
	}
}