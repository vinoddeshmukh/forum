package com.forum.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Repository;

import com.forum.dao.ForumDAO;
import com.forum.jdbc.ConnectionUtil;
import com.forum.model.ForumProcessKeyMap;
import com.forum.model.TableColumnJSONMapping;

@Repository("forumDAO")
public class ForumDAOImpl implements ForumDAO {

	@Override
	public JSONObject processRequest(String processKey) {
		System.out.println("ForumDAO | processRequest | Start | processKey:"+processKey);
		ForumProcessKeyMap processDetails = getProcessDetails(processKey);
		JSONObject mainObject = new JSONObject();
		try {
			mainObject.put("header", "Header");
		} catch (JSONException e1) {
			e1.printStackTrace();
		}
		ResultSet executeQuery = null;
		try {
			executeQuery = ConnectionUtil.executeQuery(createSQLQuery(processDetails));
			JSONArray array = new JSONArray();
			if(executeQuery!=null){
				List<TableColumnJSONMapping> tableJSONMapping = getTableJSONMapping(processDetails.getTableName());
				while (executeQuery.next()) {
					JSONObject object = new JSONObject();
					//List<TableColumnJSONMapping> tableJSONMapping = getTableJSONMapping(processDetails.getTableName());
					//ResultSetMetaData metaData = executeQuery.getMetaData();
					for (TableColumnJSONMapping tableColumnJSONMapping : tableJSONMapping) {
						String columnName = tableColumnJSONMapping.getColumnName();
						System.out.println("columnName:"+columnName);
						try {
							object.put(tableColumnJSONMapping.getJsonKey(), executeQuery.getString(tableColumnJSONMapping.getColumnName()));
						} catch (JSONException e) {
							e.printStackTrace();
						}
					}
					array.put(object);
				}
			}
			//return array;
			System.out.println("FINAL JSON :"+array.toString());
			mainObject.put("dataList", array);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.closeResultSet(null, executeQuery);
		}
		System.out.println("ForumDAO | processRequest | End | processKey:"+processKey);
		return mainObject;
	}

	private ForumProcessKeyMap getProcessDetails(String processKey) {
		System.out.println("ForumDAO | getProcessDetails | Start | processKey:"+processKey);
		Session session = null;
		ForumProcessKeyMap forumProcessKeyMap = null;
		try {
			session = ConnectionUtil.getSession();
			session.beginTransaction();
			forumProcessKeyMap = (ForumProcessKeyMap) session.createCriteria(
					ForumProcessKeyMap.class).add(
					Restrictions.eq("processKey", processKey)).uniqueResult();
		} finally {
			if (session != null && session.isOpen())
				session.close();
		}
		System.out.println("ForumDAO | getProcessDetails | End | processKey:"+processKey);
		return forumProcessKeyMap;
	}
	
	@SuppressWarnings("unchecked")
	private List<TableColumnJSONMapping> getTableJSONMapping(String tableName) {
		System.out.println("ForumDAO | getTableJSONMapping | Start | tableName:"+tableName);
		Session session = null;
		List<TableColumnJSONMapping> tableColumnJSONMappingList = null;
		try {
			session = ConnectionUtil.getSession();
			session.beginTransaction();
			tableColumnJSONMappingList = session.createCriteria(
					TableColumnJSONMapping.class).add(
					Restrictions.eq("tableName", tableName)).list();
			/*tableColumnJSONMappingList = session.createCriteria(
					TableColumnJSONMapping.class).add(
					Restrictions.eq("tableName", tableName)).list();*/
		} finally {
			if (session != null && session.isOpen())
				session.close();
		}
		System.out.println("ForumDAO | getTableJSONMapping | End | processKey:"+tableName);
		return tableColumnJSONMappingList;
	}
	
	private String createSQLQuery(ForumProcessKeyMap processDetails){
		System.out.println("ForumDAO | createSQLQuery | Start");
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("SELECT * FROM ");
		stringBuilder.append(processDetails.getTableName());
		if(processDetails.getCondition()!=null && processDetails.getCondition().length()>0){
			stringBuilder.append(" WHERE "+processDetails.getCondition());
		}
		System.out.println("ForumDAO | createSQLQuery | End | "+stringBuilder.toString());
		return stringBuilder.toString();
	}
}
