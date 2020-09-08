package com.itcrazy.alanmall.common.client.util;

import java.io.*;
import java.util.*;

/**
 * 集合工具类，一些常用的集合的工具方法
 * 
 * @author tom.cheng
 * @since version1.0 2015-08-04 17:17:45
 */
public abstract class CollectionUtils {

	/**
	 * 集合的深度复制
	 * 
	 * @param src
	 *            需要被复制的目标集合
	 * @return 返回复制出来的集合
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public static <T> List<T> deepCopy(List<T> src) throws IOException,
			ClassNotFoundException {
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(
				byteArrayOutputStream);

		objectOutputStream.writeObject(src);

		ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(
				byteArrayOutputStream.toByteArray());
		ObjectInputStream objectInputStream = new ObjectInputStream(
				byteArrayInputStream);

		@SuppressWarnings("unchecked")
		List<T> dest = (List<T>) objectInputStream.readObject();

		return dest;
	}

	/**
	 * 将对象数组转换成list集合
	 * 
	 * @param <T>
	 *            泛型参数
	 * @param ts
	 *            目标数组
	 * @return list集合
	 */
	public static <T> List<T> convertArray2List(final T[] ts) {
		if (isEmpty(ts))
			return Collections.emptyList();

		List<T> list = new ArrayList<T>();
		for (T t : ts) {
			list.add(t);
		}
		return list;
	}

	/**
	 * 将list集合转换成对象数组
	 * 
	 * @param <T>
	 *            泛型参数
	 * @param target
	 *            目标集合
	 * @return 数组
	 */
	@SuppressWarnings("unchecked")
	public static <T> T[] convertList2Array(final List<T> target) {
		if (isEmpty(target))
			return null;

		return (T[]) target.toArray();
	}

	/**
	 * 判断集合是否为空
	 * 
	 * @param <T>
	 *            泛型参数
	 * @param collection
	 *            目标集合
	 * @return 是否为空
	 */
	public static <T> boolean isEmpty(final Collection<T> collection) {
		return null == collection || collection.isEmpty();
	}

	/**
	 * 判断集合是否为空，包括集合中的元素是否为空，集合中只要有一个对象不为空，则集合不为空
	 * 
	 * @param <T>
	 *            泛型参数
	 * @param collection
	 *            目标集合
	 * @return 是否为空
	 */
	public static <T> boolean isEmpty(final Collection<T> collection,
			final EmptyChecker<T> checker) {
		if (isEmpty(collection)) {
			return true;
		}

		boolean isEmpty = true;
		for (T t : collection) {
			if (checker.isNotEmpty(t)) {
				isEmpty = false;
				break;
			}
		}

		return isEmpty;
	}

	/**
	 * 判断集合是否不为空，包括集合中的元素是否为空，集合中只要有一个对象不为空，则集合不为空
	 * 
	 * @param <T>
	 *            泛型参数
	 * @param collection
	 *            目标集合
	 * @return 是否为空
	 */
	public static <T> boolean isNotEmpty(final Collection<T> collection,
			final EmptyChecker<T> checker) {
		return !isEmpty(collection, checker);
	}

	/**
	 * 对象是否为空检查
	 * 
	 * @author boyce
	 * @version 2013-10-22
	 * @param <T>
	 */
	public static interface EmptyChecker<T> {
		public boolean isNotEmpty(T t);
	}

	/**
	 * 判断集合是否不为空
	 * 
	 * @param <T>
	 *            泛型参数
	 * @param collection
	 *            目标集合
	 * @return 是否不为空
	 */
	public static <T> boolean isNotEmpty(final Collection<T> collection) {
		return !isEmpty(collection);
	}

	/**
	 * 判断数组是否为空
	 * 
	 * @param <T>
	 *            泛型参数
	 * @param ts
	 *            目标数组
	 * @return 是否为空
	 */
	public static <T> boolean isEmpty(final T[] ts) {
		return null == ts || 0 == ts.length;
	}

	/**
	 * 判断一个数组中是否包含指定的元素
	 * 
	 * @param <T>
	 *            泛型参数
	 * @param ts
	 *            目标数组
	 * @param t
	 *            目标元素
	 * @return 是否包含指定元素
	 */
	public static <T> boolean contains(final T[] ts, final T t) {
		if (isEmpty(ts))
			return false;

		boolean isContains = false;
		for (int i = 0, l = ts.length; i < l; i++) {
			if (null == ts[i]) {
				if (null == t) {
					isContains = true;
					break;
				}
			} else if (ts[i].equals(t)) {
				isContains = true;
				break;
			}
		}

		return isContains;
	}

	/**
	 * 返回指定元素在数组中的下标位置
	 * 
	 * @param <T>
	 *            泛型参数
	 * @param ts
	 *            目标数组
	 * @param t
	 *            目标元素
	 * @return 下标位置，如果不存在返回 -1
	 */
	public static <T> int indexOf(final T[] ts, final T t) {
		if (isEmpty(ts))
			return -1;

		int index = -1;
		for (int i = 0, l = ts.length; i < l; i++) {
			if (null == ts[i]) {
				if (null == t) {
					index = i;
					break;
				}
			} else if (ts[i].equals(t)) {
				index = i;
				break;
			}
		}

		return index;
	}

	/**
	 * 返回指定元素是否与数组中某一个元素equals
	 * 
	 * @param <T>
	 *            泛型参数
	 * @param ts
	 *            目标数组
	 * @param t
	 *            目标元素
	 * @return 是否与数组中某一个元素equals，true/是；false/否。
	 */
	public static <T> boolean equalsOf(final T[] ts, final T t) {

		return indexOf(ts, t) != -1;
	}

	/**
	 * 将目标元素添加到目标数组末尾
	 * 
	 * @param <T>
	 *            泛型参数
	 * @param ts
	 *            目标数组
	 * @param t
	 *            目标元素
	 * @return 添加元素后的数组
	 */
	public static <T> T[] add(final T[] ts, final T t) {
		if (isEmpty(ts))
			return null;

		List<T> list = convertArray2List(ts);
		list.add(t);

		return convertList2Array(list);
	}

	/**
	 * 数组 toString
	 * 
	 * @param ts
	 *            目标数组
	 * @return 打印字符串
	 */
	public static <T> String toString(final T[] ts) {

		return Arrays.toString(ts);
	}

	/**
	 * Map排序
	 * 
	 * @param comparator
	 */
	public static <K, V> Map<K, V> sort(Map<K, V> map,
			Comparator<Map.Entry<K, V>> comparator) {
		List<Map.Entry<K, V>> arrayList = new ArrayList<Map.Entry<K, V>>(
				map.entrySet());
		Collections.sort(arrayList, comparator);

		Map<K, V> hashMap = new LinkedHashMap<K, V>();
		for (int i = 0; i < arrayList.size(); i++) {
			Map.Entry<K, V> entry = (Map.Entry<K, V>) arrayList.get(i);
			hashMap.put(entry.getKey(), entry.getValue());
		}
		return hashMap;
	}

	public static <T> List<T> compact(List<T> list) {
		if (isEmpty(list))
			return list;

		List<T> newlist = new ArrayList<T>();
		for (T t : list) {
			if (t != null)
				newlist.add(t);
		}
		return newlist;
	}
}
