import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

/**
 * 为了保持代码的逻辑清晰，将异常全部做了向上抛出的处理。
 */
public class Main {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        GoddessDao goddessDao = new GoddessDao();

        // 插入
//        Goddess insertGoddess = new Goddess();
//        insertGoddess.setId(1);
//        insertGoddess.setUser_name("名字");
//        insertGoddess.setSex(1);
//        insertGoddess.setAge(18);
//        insertGoddess.setBirthday(new Date(0));
//        insertGoddess.setEmail("5488@qq.com");
//        insertGoddess.setMobile("11111");
//        insertGoddess.setUpdate_user("liu");
//        insertGoddess.setCreate_user("liu");
//        insertGoddess.setIsDel(0);
//        goddessDao.addGoddess(insertGoddess);

        // 更新
//        Goddess updateGoddess = new Goddess();
//        updateGoddess.setId(0);
//        updateGoddess.setUser_name("stronger");
//        updateGoddess.setSex(1);
//        updateGoddess.setAge(24);
//        updateGoddess.setBirthday(new Date(0));
//        updateGoddess.setEmail("5488@qq.com");
//        updateGoddess.setMobile("11111");
//        updateGoddess.setUpdate_user("liu");
//        updateGoddess.setCreate_user("liu");
//        updateGoddess.setIsDel(0);
//        goddessDao.updateGoddess(updateGoddess);


        // 按照id查询
//        Goddess g = goddessDao.getByID(1);
//        System.out.println(g);

        // 全部查询
//        List<Goddess> gs = goddessDao.queryAll();
//        System.out.println(gs);

        // 按照ID删除
//        goddessDao.delGoddessByID(1);

    }

}
