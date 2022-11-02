package org.exampleUtils01.type;

/**
 * 错误代码 -1 表示错误结果编码,0 表示正确结果编码, -99 登录验证失败 , -98 强制升级错误代码
 * 
 * @author wumenghua
 * @version 1.0
 */
public enum RESULT_CODE
{
	FAIL("-1"), SUCCESS("0"), LOGIN_FAIL("-99"), FORCED_UPGRADE("-98"),NO_PUSH_DX("-10");

	String value;

	RESULT_CODE(String value)
	{
		this.setValue(value);
	}

	public String getValue()
	{
		return value;
	}

	public void setValue(String value)
	{
		this.value = value;
	}
}