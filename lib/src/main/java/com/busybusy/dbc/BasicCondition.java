package com.busybusy.dbc;

/**
 * TODO: put some meaningful information about this class in the javadoc or delete it
 *
 * @author Trevor
 */

class BasicCondition<T> implements NullChecks<T>
{
	private final T subject;

	BasicCondition(T subject) {this.subject = subject;}

	@Override
	public T isNull()
	{
		if (this.subject == null)
		{
			return null;
		}
		else
		{
			throw new IllegalArgumentException("A null argument was required but was:" + this.subject.toString());
		}
	}

	@Override
	public T isNotNull()
	{
		if (this.subject != null)
		{
			return this.subject;
		}
		else
		{
			throw new NullPointerException("A non null argument was required but was null");
		}
	}
}
