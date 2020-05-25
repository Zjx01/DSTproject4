package cn.edu.zju.dao;

import cn.edu.zju.bean.DrugLabel;
import cn.edu.zju.bean.User;
import cn.edu.zju.dbutils.DBUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserDao extends BaseDao {
    private static final Logger log = LoggerFactory.getLogger(UserDao.class);
    private Connection connection;

    public UserDao() {
    }

    public boolean existsByuserId(int id) {
        return super.existsByuserId(id, "userinfo");
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
            log.info("user registered");
        });
    }


    public boolean[] Search(User user) {
        boolean[] pos =new boolean[2];
        pos[0] =false;
        pos[1] =false;//来判断密码是否符合
        DBUtils.execSQL(connection -> {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement("select username, password from userinfo where username= ?;");
                preparedStatement.setString(1,user.getUsername());
                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    pos[0]=true;
                    String password = resultSet.getString("password");
                    if (user.getPassword().equals(password)){
                        pos[1]=true;
                    }
                }
                resultSet.close();
            } catch (SQLException e) {
                log.info("", e);
            }
        });
        log.info("search user");
        return pos;
    }
    public List<DrugLabel> searchdrug(String query){
        List<DrugLabel> druginfo = new ArrayList<>();
        DBUtils.execSQL(connection -> {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement("select * from drug_label where (name = ?) or (drug_id = ?) ");
                preparedStatement.setString(1, query);
                preparedStatement.setString(2, query);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    Boolean alternateDrugAvailable = resultSet.getBoolean("alternate_drug_available");
                    String source = resultSet.getString("source");
                    String prescribingMarkdown = resultSet.getString("prescribing_markdown");
                    String name=resultSet.getString("name");
                    String drugId =resultSet.getString("drug_id");
                    Boolean dosingInformation=resultSet.getBoolean("dosing_information");
                    DrugLabel drugInfo = new DrugLabel(name, alternateDrugAvailable, dosingInformation, prescribingMarkdown, source,drugId);
                    druginfo.add(drugInfo);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
        return druginfo;
    }
    public void deleteByName(String name){
        DBUtils.execSQL(connection -> {
            try {
                connection.createStatement().execute("DELETE FROM userinfo WHERE username='" + name +"';");
            } catch (SQLException e) {
                e.printStackTrace();
            }});
        log.info("deleted");
    }

}
