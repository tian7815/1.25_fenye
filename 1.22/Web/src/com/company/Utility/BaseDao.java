package com.company.Utility;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

import com.company.entity.User;

public class BaseDao {

	public void asd() throws Exception {
		Object queryData = queryData(User.class, "");
	}

	public Object queryData(Class clazz, String sql, Object... args)
			throws Exception {
		Connection conn = Utility.connMysql();
		PreparedStatement prepareStatement = conn.prepareStatement(sql);
		for (int i = 0; i < args.length; i++) {
			prepareStatement.setObject(i + 1, args[i]);
		}
		ResultSet rs = prepareStatement.executeQuery();
		
		ResultSetMetaData metaData = rs.getMetaData();
		int columnCount = metaData.getColumnCount();
		Object object2 = clazz.newInstance();
		if (rs.next()) {
			for (int j = 0; j < columnCount; j++) {
				Object object = rs.getObject(j + 1);
				String columnName = metaData.getColumnName(j + 1);
				Field declaredField = clazz.getDeclaredField(columnName);
				declaredField.setAccessible(true);
				declaredField.set(object2, object);
			}
			return object2;
		}
		return null;
	}
}
