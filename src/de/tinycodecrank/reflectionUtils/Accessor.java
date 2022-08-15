package de.tinycodecrank.reflectionUtils;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Member;
import java.lang.reflect.Modifier;

public final class Accessor<E extends AccessibleObject & Member, Parent>
{
	private final Parent	parent;
	private final E			element;
	
	public Accessor(Parent parent, E element)
	{
		this.parent		= parent;
		this.element	= element;
	}
	
	public <Value> void applyObj(AccessConsumer<E, Parent, Value> action, Value value)
		throws IllegalArgumentException,
		IllegalAccessException
	{
		final boolean isAccessible = makeAccessible();
		try
		{
			action.accept(element, parent, value);
		}
		finally
		{
			revertAccess(isAccessible);
		}
	}
	
	public void applyBool(AccessBoolConsumer<E, Parent> action, boolean value)
		throws IllegalArgumentException,
		IllegalAccessException
	{
		final boolean isAccessible = makeAccessible();
		try
		{
			action.accept(element, parent, value);
		}
		finally
		{
			revertAccess(isAccessible);
		}
	}
	
	public void applyByte(AccessByteConsumer<E, Parent> action, byte value)
		throws IllegalArgumentException,
		IllegalAccessException
	{
		final boolean isAccessible = makeAccessible();
		try
		{
			action.accept(element, parent, value);
		}
		finally
		{
			revertAccess(isAccessible);
		}
	}
	
	public void applyShort(AccessShortConsumer<E, Parent> action, short value)
		throws IllegalArgumentException,
		IllegalAccessException
	{
		final boolean isAccessible = makeAccessible();
		try
		{
			action.accept(element, parent, value);
		}
		finally
		{
			revertAccess(isAccessible);
		}
	}
	
	public void applyChar(AccessCharConsumer<E, Parent> action, char value)
		throws IllegalArgumentException,
		IllegalAccessException
	{
		final boolean isAccessible = makeAccessible();
		try
		{
			action.accept(element, parent, value);
		}
		finally
		{
			revertAccess(isAccessible);
		}
	}
	
	public void applyInt(AccessIntConsumer<E, Parent> action, int value)
		throws IllegalArgumentException,
		IllegalAccessException
	{
		final boolean isAccessible = makeAccessible();
		try
		{
			action.accept(element, parent, value);
		}
		finally
		{
			revertAccess(isAccessible);
		}
	}
	
	public void applyLong(AccessLongConsumer<E, Parent> action, long value)
		throws IllegalArgumentException,
		IllegalAccessException
	{
		final boolean isAccessible = makeAccessible();
		try
		{
			action.accept(element, parent, value);
		}
		finally
		{
			revertAccess(isAccessible);
		}
	}
	
	public void applyFloat(AccessFloatConsumer<E, Parent> action, float value)
		throws IllegalArgumentException,
		IllegalAccessException
	{
		final boolean isAccessible = makeAccessible();
		try
		{
			action.accept(element, parent, value);
		}
		finally
		{
			revertAccess(isAccessible);
		}
	}
	
	public void applyDouble(AccessDoubleConsumer<E, Parent> action, double value)
		throws IllegalArgumentException,
		IllegalAccessException
	{
		final boolean isAccessible = makeAccessible();
		try
		{
			action.accept(element, parent, value);
		}
		finally
		{
			revertAccess(isAccessible);
		}
	}
	
	public <Return> Return perform(AccessSupplier<E, Parent, Return> action)
		throws IllegalArgumentException,
		IllegalAccessException
	{
		final boolean isAccessible = makeAccessible();
		try
		{
			return action.get(element, parent);
		}
		finally
		{
			revertAccess(isAccessible);
		}
	}
	
	public boolean performBool(AccessBoolSupplier<E, Parent> action)
		throws IllegalArgumentException,
		IllegalAccessException
	{
		final boolean isAccessible = makeAccessible();
		try
		{
			return action.get(element, parent);
		}
		finally
		{
			revertAccess(isAccessible);
		}
	}
	
	private boolean makeAccessible()
	{
		final boolean isAccessible;
		if (Modifier.isStatic(element.getModifiers()))
			isAccessible = element.canAccess(null);
		else
			isAccessible = element.canAccess(parent);
		element.setAccessible(true);
		return isAccessible;
	}
	
	private void revertAccess(boolean previous)
	{
		element.setAccessible(previous);
	}
	
	@FunctionalInterface
	public static interface AccessConsumer<AccObj, Parent, Value>
	{
		void accept(AccObj obj, Parent parent, Value value) throws IllegalArgumentException, IllegalAccessException;
	}
	
	@FunctionalInterface
	public static interface AccessBoolConsumer<AccObj, Parent>
	{
		void accept(AccObj obj, Parent parent, boolean value) throws IllegalArgumentException, IllegalAccessException;
	}
	
	@FunctionalInterface
	public static interface AccessByteConsumer<AccObj, Parent>
	{
		void accept(AccObj obj, Parent parent, byte value) throws IllegalArgumentException, IllegalAccessException;
	}
	
	@FunctionalInterface
	public static interface AccessShortConsumer<AccObj, Parent>
	{
		void accept(AccObj obj, Parent parent, short value) throws IllegalArgumentException, IllegalAccessException;
	}
	
	@FunctionalInterface
	public static interface AccessCharConsumer<AccObj, Parent>
	{
		void accept(AccObj obj, Parent parent, char value) throws IllegalArgumentException, IllegalAccessException;
	}
	
	@FunctionalInterface
	public static interface AccessIntConsumer<AccObj, Parent>
	{
		void accept(AccObj obj, Parent parent, int value) throws IllegalArgumentException, IllegalAccessException;
	}
	
	@FunctionalInterface
	public static interface AccessLongConsumer<AccObj, Parent>
	{
		void accept(AccObj obj, Parent parent, long value) throws IllegalArgumentException, IllegalAccessException;
	}
	
	@FunctionalInterface
	public static interface AccessFloatConsumer<AccObj, Parent>
	{
		void accept(AccObj obj, Parent parent, float value) throws IllegalArgumentException, IllegalAccessException;
	}
	
	@FunctionalInterface
	public static interface AccessDoubleConsumer<AccObj, Parent>
	{
		void accept(AccObj obj, Parent parent, double value) throws IllegalArgumentException, IllegalAccessException;
	}
	
	@FunctionalInterface
	public static interface AccessSupplier<AccObj, Parent, Return>
	{
		Return get(AccObj obj, Parent parent) throws IllegalArgumentException, IllegalAccessException;
	}
	
	@FunctionalInterface
	public static interface AccessBoolSupplier<AccObj, Parent>
	{
		boolean get(AccObj obj, Parent parent) throws IllegalArgumentException, IllegalAccessException;
	}
}