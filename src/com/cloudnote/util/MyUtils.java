package com.cloudnote.util;

import javax.servlet.http.Cookie;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by loadi_000 on 2016/6/5.
 */
public class MyUtils
{
    // 通过名称查找cookies
    public static Cookie getCookieByName(Cookie [] cookies,String name){
        if(cookies == null){
            return null;
        }else {
            for (Cookie cookie : cookies){
                if(cookie.getName().equals(name)){
                    return cookie;
                }
            }
        }
        return null;
    }


    // 转list
    public static List ResultSetToList(ResultSet rs) throws SQLException {
        ResultSetMetaData md = rs.getMetaData();
        int num = md.getColumnCount();
        List listOfRows = new ArrayList();
        while (rs.next()) {
            Map mapOfColValues = new HashMap(num);
            for (int i = 1; i <= num; i++) {
                mapOfColValues.put(md.getColumnName(i), rs.getObject(i));
            }
            listOfRows.add(mapOfColValues);
        }
        return listOfRows;
    }
}
