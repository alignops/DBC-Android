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

import android.support.annotation.NonNull;

import java.util.concurrent.Callable;

import static com.busybusy.dbc.Dbc.require;

/**
 * Value type to represent a message for a failed assertion
 *
 * @author Trevor
 */
public final class Message
{
	final String           message;
	final Callable<String> lazyMessage;

	public Message(@NonNull String message)
	{
		require(message).isValid();

		this.message = message;
		this.lazyMessage = null;
	}

	public Message(@NonNull Callable<String> lazyMessage)
	{
		require(lazyMessage).isNotNull();

		this.message = null;
		this.lazyMessage = lazyMessage;
	}

	@Override
	public String toString()
	{
		if (this.message != null)
		{
			return "Message{" + this.message + "}";
		}

		try
		{
			return "Message{" + this.lazyMessage.call() + "}";
		}
		catch (Exception e)
		{
			throw new RuntimeException(e);
		}
	}

}
