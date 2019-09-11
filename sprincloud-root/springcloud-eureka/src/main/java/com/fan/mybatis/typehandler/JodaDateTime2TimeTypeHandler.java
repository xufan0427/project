package com.fan.mybatis.typehandler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.joda.time.DateTime;

import java.sql.*;

public class JodaDateTime2TimeTypeHandler extends BaseTypeHandler<Object> {
	public void setNonNullParameter(PreparedStatement ps, int i,
			Object parameter, JdbcType jdbcType) throws SQLException {
//		DateTime dateTime = parameter;
//		ps.setTime(i, new Time(dateTime.getMillis()));


		if(parameter instanceof DateTime){
			DateTime dateTime = (DateTime) parameter;
			ps.setTime(i, new Time(dateTime.getMillis()));
		}else if(parameter instanceof java.util.Date){
			java.util.Date dateTime = (java.util.Date) parameter;
			ps.setTime(i, new Time(dateTime.getTime()));
		}

	}

	public DateTime getNullableResult(ResultSet rs, String columnName)
			throws SQLException {
		DateTime dateTime = null;
		Time time = rs.getTime(columnName);
		if (time != null) {
			dateTime = new DateTime(time.getTime());
		}
		return dateTime;
	}

	public DateTime getNullableResult(CallableStatement cs, int columnIndex)
			throws SQLException {
		DateTime dateTime = null;
		Time time = cs.getTime(columnIndex);
		if (time != null) {
			dateTime = new DateTime(time.getTime());
		}
		return dateTime;
	}

	public DateTime getNullableResult(ResultSet rs, int columnIndex)
			throws SQLException {
		DateTime dateTime = null;
		Time time = rs.getTime(columnIndex);
		if (time != null) {
			dateTime = new DateTime(time.getTime());
		}
		return dateTime;
	}
}
