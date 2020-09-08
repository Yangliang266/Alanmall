package com.itcrazy.alanmall.common.client.util;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ShellUtil {

	/**
	 * Executes the specified string command in a separate process with the
	 * specified working directory.
	 * 
	 * @param cmd
	 *            - a specified system command.
	 */
	public static void exec(String cmd) throws Exception {
		Process p = null;
		try {
			p = Runtime.getRuntime().exec(cmd);
			p.waitFor();
		} catch (Exception ex) {
			log.error(ex.getMessage());
			throw new Exception(ex.getMessage());
		} finally {
			if (p != null) {
				try {
					p.getErrorStream().close();
					p.getInputStream().close();
					p.getOutputStream().close();
					p.destroy();
				} catch (Exception e) {
				}
			}
		}
	}

	/**
	 * Executes the specified string command in a separate process with the
	 * specified working directory.
	 * 
	 * @param cmd
	 *            - a specified system command.
	 */
	public static void exec(String[] cmd) throws Exception {
		Process p = null;
		try {
			p = Runtime.getRuntime().exec(cmd);
			p.waitFor();
		} catch (Exception ex) {
			log.error(ex.getMessage());
			throw new Exception(ex.getMessage());
		} finally {
			if (p != null) {
				try {
					p.getErrorStream().close();
					p.getInputStream().close();
					p.getOutputStream().close();
					p.destroy();
				} catch (Exception e) {
				}
			}
		}
	}
}
