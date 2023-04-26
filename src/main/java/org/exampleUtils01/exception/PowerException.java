package org.exampleUtils01.exception;

public class PowerException extends CustomException
{
	PowerException(String code, String message)
	{
		super(code, message);
	}

	private static final long serialVersionUID = 6074173109888497008L;
}
