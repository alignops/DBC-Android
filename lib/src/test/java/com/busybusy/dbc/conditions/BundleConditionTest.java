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

import android.os.Bundle;

import com.busybusy.dbc.BuildConfig;
import com.busybusy.dbc.DbcAssertionError;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

/**
 * @author Tjones
 */
@RunWith(RobolectricTestRunner.class)
@Config(sdk = 23, constants = BuildConfig.class)
public class BundleConditionTest
{
	@Test
	public void containsKey() throws Exception
	{
		Bundle subject = new Bundle();
		subject.putString("KEY", "VALUE");

		BundleCondition condition = new BundleCondition(subject);
		condition.containsKey("KEY");

		Assertions.assertThatThrownBy(() -> condition.containsKey("FAIL"))
		          .isInstanceOf(DbcAssertionError.class)
		          .hasCauseInstanceOf(IllegalStateException.class);
	}

	@Test
	public void valueIsOfType() throws Exception
	{
		Bundle subject = new Bundle();
		subject.putString("KEY", "VALUE");

		BundleCondition condition = new BundleCondition(subject);
		condition.valueIsOfType("KEY", String.class);

		Assertions.assertThatThrownBy(() -> condition.valueIsOfType("KEY", Integer.class))
		          .isInstanceOf(DbcAssertionError.class)
		          .hasCauseInstanceOf(IllegalStateException.class);
	}
}