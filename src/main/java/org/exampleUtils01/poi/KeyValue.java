package org.exampleUtils01.poi;

/**
 * 
 * 键值对
 * 
 */
public class KeyValue<K, V>
{
    private K key;  // key

    private V value; // value

    /**
     * 
     * 无参数初始化
     * 
     * @since Mar 9, 2014
     */
    public KeyValue()
    {
    }

    /**
     * 
     * 初始化填入key与value
     * 
     * @since Mar 9, 2014
     * @param key
     * @param value
     */
    public KeyValue(K key, V value)
    {
        this.key = key;
        this.value = value;
    }

    public K getKey()
    {
        return this.key;
    }

    public V getValue()
    {
        return this.value;
    }

    public void setKey(K key)
    {
        this.key = key;
    }

    public void setValue(V value)
    {
        this.value = value;
    }

}