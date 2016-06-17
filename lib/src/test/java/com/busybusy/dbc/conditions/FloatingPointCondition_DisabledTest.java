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

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * @author Trevor
 */
@RunWith(JUnit4.class)
public class FloatingPointCondition_DisabledTest
{
	@Test
	public void isNear() throws Exception
	{
		FloatingPointCondition_Disabled<Float> condition = new FloatingPointCondition_Disabled<>(2F);
		condition.isNear(2F);
		condition.isNear(7F);
	}

	@Test
	public void isNearWithTolerance() throws Exception
	{
		FloatingPointCondition_Disabled<Float> condition = new FloatingPointCondition_Disabled<>(2F);
		condition.isNearWithTolerance(2F, 1F);
		condition.isNearWithTolerance(7F, 1F);
	}

	@Test
	public void isNearZero() throws Exception
	{
		FloatingPointCondition_Disabled<Float> condition = new FloatingPointCondition_Disabled<>(0.19e-07F);
		condition.isNearZero();

		FloatingPointCondition_Disabled<Float> badCondition = new FloatingPointCondition_Disabled<>(2F);
		badCondition.isNearZero();
	}

	@Test
	public void isNearZeroWithTolerance() throws Exception
	{
		FloatingPointCondition_Disabled<Float> condition = new FloatingPointCondition_Disabled<>(1F);
		condition.isNearZeroWithTolerance(1.5F);

		FloatingPointCondition_Disabled<Float> badCondition = new FloatingPointCondition_Disabled<>(2F);
		badCondition.isNearZeroWithTolerance(1F);
	}

	@Test
	public void isEqualTo() throws Exception
	{
		FloatingPointCondition_Disabled<Float> condition = new FloatingPointCondition_Disabled<>(1F);
		condition.isEqualTo(1F);
		condition.isEqualTo(1.5F);
	}

}