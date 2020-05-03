package cn.edu.zju.dao;

import cn.edu.zju.bean.User;
import cn.edu.zju.dbutils.DBUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao extends BaseDao {
    private static final Logger log = LoggerFactory.getLogger(UserDao.class);
    private Connection connection;

    public boolean existsById(String id) {
        return super.existsById(id, "userinfo");
    } //判断user信息是否已经被包含在里面

    public void registration(User user) {
        DBUtils.execSQL(connection -> {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement("insert into userinfo (id, username, password, email, phone) values    (?,?,?,?,?)");
                preparedStatement.setInt(1, user.getId());
                preparedStatement.setString(2, user.getUsername());
                preparedStatement.setString(3, user.getPassword());
                preparedStatement.setString(4, user.getEmail());
                preparedStatement.setString(5, user.getPhone());
                preparedStatement.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
    }


    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        DBUtils.execSQL(connection -> {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement("select id, username, password, email, phone from userinfo");
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String username = resultSet.getString("username");
                    String password = resultSet.getString("password");
                    String email = resultSet.getString("email");
                    String phone = resultSet.getString("phone)");
                    User user = new User(id, username, password, email, phone);
                    users.add(user);
                }
            } catch (SQLException e) {
                log.info("", e);
            }
        });
        return users;
    }

    public





}
