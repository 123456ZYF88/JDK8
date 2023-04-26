package org.exampleUtils01.exception;


/**
 * 自定义异常
 * 
 * @author
 * @version 1.0
 */
public class CustomException extends Exception
{
	private static final long serialVersionUID = 3642149887998012492L;

	public CustomException(String code, String message)
	{
		super(message);
		this.setCode(code);
	}

	private String code; // 错误编码

	public String getCode()
	{
		return code;
	}

	public void setCode(String code)
	{
		this.code = code;
	}
}
