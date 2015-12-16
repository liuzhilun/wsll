package com.hansy.frame.dao.impl;

import com.hansy.frame.dao.IDialect;

public class OracleDialect implements IDialect {
	private String ORACLE_PAGEDSQL_FORMATTER = "SELECT * FROM (SELECT A.*, ROWNUM RN FROM (@_z_#) A WHERE ROWNUM <= @_x_#) WHERE RN >= @_y_#";

	public String getPagedString(String sql, boolean hasOffset) {
		return null;
	}

	public String getPagedString(String sql, int offset, int limit) {
		offset++;
		int endset = offset + limit - 1;
		String rs = this.ORACLE_PAGEDSQL_FORMATTER.replaceFirst("@_y_#", String.valueOf(offset)).replaceFirst("@_x_#", String.valueOf(endset))
				.replaceFirst("@_z_#", sql);
		return rs;
	}

	public boolean supportsPaged() {
		return true;
	}
}
