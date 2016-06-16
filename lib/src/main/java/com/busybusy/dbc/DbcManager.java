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

/**
 * @author Trevor
 */

public class DbcManager
{
	private static DbcManager instance;

	private DbcManager() {}

	public static DbcManager getInstance()
	{
		DbcManager result = instance;
		if (result == null)
		{
			synchronized (DbcManager.class)
			{
				result = instance;
				if (result == null)
				{
					instance = new DbcManager();
					result = instance;
				}
			}
		}

		return result;
	}

	private boolean require = true;
	private boolean check   = true;
	private boolean ensure  = true;

	public DbcManager setConfig(boolean require, boolean check, boolean ensure)
	{
		this.require = require;
		this.check = check;
		this.ensure = ensure;
		return this;
	}

	public boolean requireEnabled()
	{
		return this.require;
	}

	public boolean checkEnabled()
	{
		return this.check;
	}

	public boolean ensureEnabled()
	{
		return this.ensure;
	}
}
