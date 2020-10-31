package com.zxc.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.zxc.jdbc.SqlSrvDBConn;
import com.zxc.model.vo.UserTable;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class MainAction extends ActionSupport {
    private UserTable user;

    public String execute() {
        String usr = user.getUsername();
        String pwd = user.getPassword();
        boolean validated = false;
        SqlSrvDBConn sqlsrvdb = new SqlSrvDBConn();
        ActionContext context = ActionContext.getContext();
        Map session = context.getSession();
        UserTable user1 = null;

        user1 = (UserTable) session.get("user");

        if (user1 == null) {
            String sql = "select * from userTable";
            ResultSet rs = sqlsrvdb.executeQuery(sql);
            try {
                while (rs.next()) {
                    if ((rs.getString("username").trim().compareTo(usr) == 0) && (rs.getString("password").compareTo(pwd) == 0)) {
                        user1 = new UserTable();
                        user1.setId(rs.getInt(1));
                        user1.setUsername(rs.getString(2));
                        user1.setPassword(rs.getString(3));
                        session.put("user", user1);
                        validated = true;
                    }
                }
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            sqlsrvdb.closeStmt();
            sqlsrvdb.closeConn();
        } else {
            validated = true;
        }
        if (validated) {
            return "success";
        } else {
            return "error";
        }

    }

    public void validate() {
        if (user.getUsername() == null || user.getUsername().trim().equals(""))
            addFieldError("user.username", "用户名必须填写！");
    }

    public UserTable getUser() {
        return user;
    }

    public void setUser(UserTable user) {
        this.user = user;
    }
}
