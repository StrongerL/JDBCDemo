import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GoddessDao {

    // 添加
    public void addGoddess(Goddess g) throws SQLException, ClassNotFoundException {
        Connection connection = DBUtil.getConnection();
        String sql = "INSERT INTO imooc_goddess(id, user_name, sex, age, birthday, email, mobile," +
                "create_user, create_date, update_user, update_date, isdel)"
                + "values(" + "?,?,?,?,?,?,?,?,CURRENT_DATE(),?,CURRENT_DATE(),?)";

        //预编译SQL，减少sql执行
        PreparedStatement ptmt = connection.prepareStatement(sql);

        //传参
        ptmt.setInt(1, g.getId());
        ptmt.setString(2, g.getUser_name());
        ptmt.setInt(3, g.getSex());
        ptmt.setInt(4, g.getAge());
        ptmt.setDate(5, new java.sql.Date(g.getBirthday().getTime()));
        ptmt.setString(6, g.getEmail());
        ptmt.setString(7, g.getMobile());
        ptmt.setString(8, g.getCreate_user());
        ptmt.setString(9, g.getUpdate_user());
        ptmt.setInt(10, g.getIsDel());

        //执行
        ptmt.execute();
        connection.close();
    }

    // 更新
    public void updateGoddess(Goddess g) throws SQLException, ClassNotFoundException {
        Connection connection = DBUtil.getConnection();
        String sql = "UPDATE imooc_goddess" +
                " set user_name=?, sex=?, age=?, birthday=?, email=?, mobile=?," +
                " update_user=?, update_date=CURRENT_DATE(), isdel=? " +
                " where id=?";
        //预编译SQL，减少sql执行
        PreparedStatement ptmt = connection.prepareStatement(sql);

        // 传参
        ptmt.setString(1, g.getUser_name());
        ptmt.setInt(2, g.getSex());
        ptmt.setInt(3, g.getAge());
        ptmt.setDate(4, new java.sql.Date(g.getBirthday().getTime()));
        ptmt.setString(5, g.getEmail());
        ptmt.setString(6, g.getMobile());
        ptmt.setString(7, g.getUpdate_user());
        ptmt.setInt(8, g.getIsDel());
        ptmt.setInt(9, g.getId());

        // 执行
        ptmt.execute();
    }

    // 按照ID查询
    public Goddess getByID(int id) throws SQLException, ClassNotFoundException {
        Goddess g = null;
        Connection conn = DBUtil.getConnection();
        String sql = "select * from  imooc_goddess where id=?";
        // 预编译
        PreparedStatement ptmt = conn.prepareStatement(sql);

        // 传参
        ptmt.setInt(1, id);

        // 查询
        ResultSet rs = ptmt.executeQuery();
        while (rs.next()) {
            g = new Goddess();
            g.setId(rs.getInt("id"));
            g.setUser_name(rs.getString("user_name"));
            g.setAge(rs.getInt("age"));
            g.setSex(rs.getInt("sex"));
            g.setBirthday(rs.getDate("birthday"));
            g.setEmail(rs.getString("email"));
            g.setMobile(rs.getString("mobile"));
            g.setCreate_date(rs.getDate("create_date"));
            g.setCreate_user(rs.getString("create_user"));
            g.setUpdate_date(rs.getDate("update_date"));
            g.setUpdate_user(rs.getString("update_user"));
            g.setIsDel(rs.getInt("isdel"));
        }
        return g;
    }

    // 查询全部
    public List<Goddess> queryAll() throws SQLException, ClassNotFoundException {
        Connection conn = DBUtil.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT user_name, age FROM imooc_goddess");

        List<Goddess> gs = new ArrayList<>();
        while(rs.next()){
            Goddess g = new Goddess();
            g.setUser_name(rs.getString("user_name"));
            g.setAge(rs.getInt("age"));
            gs.add(g);
        }
        return gs;
    }

    // 按照ID删除
    public void delGoddessByID(int id) throws SQLException, ClassNotFoundException {
        Connection conn = DBUtil.getConnection();
        String sql = "delete from imooc_goddess where id=?";
        //预编译SQL，减少sql执行
        PreparedStatement ptmt = conn.prepareStatement(sql);

        //传参
        ptmt.setInt(1, id);

        //执行
        ptmt.execute();
    }

}
