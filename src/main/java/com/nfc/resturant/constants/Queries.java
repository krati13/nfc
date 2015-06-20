package com.nfc.resturant.constants;

public interface Queries {
	public interface Prototype {
		String GET_TABLES = "SELECT UPPER(TABLE_NAME) FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_TYPE = 'BASE TABLE' AND TABLE_SCHEMA='nfc'";
		String GET_COLUMNS = "SELECT GROUP_CONCAT(COLUMN_NAME) FROM INFORMATION_SCHEMA.COLUMNS CC WHERE CC.TABLE_SCHEMA = 'nfc' AND CC.TABLE_NAME = ? AND EXTRA <> 'AUTO_INCREMENT'";
		String GET_MERCHANT= "SELECT * FROM MERCHANT";
	}
	
	public interface ResturantQueries {
		String GET_MENU_BY_ID = "SELECT * FROM MENU WHERE ID IN (P1) AND MERCHANT_ID = ?";
		String GET_ORDERS_BY_TABLE_ID = "SELECT * FROM ORDERS WHERE TABLE_ID = ? AND STATUS = 'ACTIVE' AND CREATED_ON > CURRENT_TIMESTAMP - INTERVAL 1 DAY ORDER BY CREATED_ON DESC LIMIT 1";
		String SUM_TXN_AMOUNT = "SELECT SUM(AMOUNT) FROM ORDERS WHERE ORDER_ID = ? AND MERCHANT_ID = ?";
		String GET_MENU = "SELECT * FROM MENU WHERE MERCHANT_ID = ? ORDER BY SORTORDER";
		String GET_DOD = "SELECT * FROM MENU WHERE MERCHANT_ID = ? AND SORTORDER LIKE '99%' ORDER BY SORTORDER";
		String GET_CATEGORY_BY_ID="SELECT * FROM CATEGORY WHERE ID = ?";
		
		String UPDATE_TXNHISTORY = "INSERT INTO TXNHISTORY(ORDER_ID, TAX_AMT, SHIPPING_AMT, ORDER_AMT, TOTAL_AMT, BANK_TXN_ID, STATUS, CREATED_ON, CREATED_BY, MERCHANT_ID) VALUES(?,?,?,?,?,?,?,?,?,?)";
		String INSERT_INTO_FEEDBACK="INSERT INTO MERCHANT_FEEDBACK(FIRSTNAME,LASTNAME,MOBILE,EMAIL,RATING,EATOUTINDEX,COMMENT,DOB,"
		    + "ANNIVERSARY,MERCHANT_ID,USER_ID,CREATED_ON) VALUES(?,?,?,?,?,?,?,?,?,?,?,CURRENT_TIMESTAMP)";
		
	}
	public interface SocialQueries {
      String INSERT_INTO_SOCIAL_USER = "INSERT INTO SOCIAL_USER(SOCIAL_ID,FIRST_NAME,LAST_NAME,GENDER,EMAIL,"
          + "PLATFORM,TOKEN,LINK,CREATED_ON,CREATED_BY,MODIFIED_ON,MODIFIED_BY,EXPIRE_DATE) "
          + "VALUES(?,?,?,?,?,?,?,?,CURRENT_TIMESTAMP,1001,CURRENT_TIMESTAMP,1001,?)";
      
      String IS_PRESENT_SOCIAL_USER="SELECT COUNT(1) AS CNT,EXPIRE_DATE AS EDATE FROM SOCIAL_USER WHERE SOCIAL_ID=?";
      String UPDATE_SOCIAL_USER="UPDATE SOCIAL_USER SET TOKEN=?,EXPIRE_DATE=?,MODIFIED_ON=CURRENT_TIMESTAMP WHERE SOCIAL_ID=?";
      
  }
}