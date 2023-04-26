package org.exampleUtils01.exception;


import org.exampleUtils01.type.RESULT_CODE;

/**
 * 验证异常
 * 
 * @author wumenghua
 * @version 1.0
 */
public class ValidatorException extends CustomException
{
	private static final long serialVersionUID = 3315764959657040681L;

	public ValidatorException(String message)
	{
		super(RESULT_CODE.FAIL.getValue(), message);
	}

	public ValidatorException(String code, String message)
	{
		super(code, message);
	}
}