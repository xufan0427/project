package com.fan.mybatis.typehandler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.joda.time.DateTime;

import java.sql.*;
import java.util.Date;

public class JodaDateTime2TimestampTypeHandler extends
        BaseTypeHandler<Object> {
	public void setNonNullParameter(PreparedStatement ps, int i,
			Object parameter, JdbcType jdbcType) throws SQLException {
		if(parameter instanceof DateTime){
			DateTime dateTime = (DateTime) parameter;
			ps.setTimestamp(i, new Timestamp(dateTime.getMillis()));
		}else if(parameter instanceof Date){

			Date dateTime = (Date) parameter;
			ps.setTimestamp(i, new Timestamp(dateTime.getTime()));
		}

	}

	public DateTime getNullableResult(ResultSet rs, String columnName)
			throws SQLException {
		DateTime dateTime = null;
		Timestamp timestamp = rs.getTimestamp(columnName);
		if (timestamp != null) {
			dateTime = new DateTime(timestamp.getTime());
		}
		return dateTime;
	}

	public DateTime getNullableResult(CallableStatement cs, int columnIndex)
			throws SQLException {
		DateTime dateTime = null;
		Timestamp timestamp = cs.getTimestamp(columnIndex);
		if (timestamp != null) {
			dateTime = new DateTime(timestamp.getTime());
		}
		return dateTime;
	}

	public DateTime getNullableResult(ResultSet rs, int columnIndex)
			throws SQLException {
		DateTime dateTime = null;
		Timestamp timestamp = rs.getTimestamp(columnIndex);
		if (timestamp != null) {
			dateTime = new DateTime(timestamp.getTime());
		}
		return dateTime;
	}
}
