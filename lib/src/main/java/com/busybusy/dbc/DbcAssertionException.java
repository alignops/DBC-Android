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

package com.busybusy.dbc;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.busybusy.dbc.conditions.Message;

import org.jetbrains.annotations.Contract;

/**
 * Exception type throw from DBC operations. It is used as a wrapper around the underlying issue
 *
 * @author Trevor
 */
public class DbcAssertionException extends RuntimeException
{
	public DbcAssertionException(Throwable cause)
	{
		super(cause);
	}

	public DbcAssertionException(String message, Throwable cause)
	{
		super(message, cause);
	}

	/**
	 * @param throwable the throwable to use as the cause of the new exception
	 */
	@Contract("_, _ -> fail")
	public static void throwNew(@NonNull Throwable throwable, @Nullable Message message)
	{
		if (message == null)
		{
			throw new DbcAssertionException(throwable);
		}
		else
		{
			throw new DbcAssertionException(message.toString(), throwable);
		}
	}
}
