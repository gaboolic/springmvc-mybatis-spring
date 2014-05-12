package tk.gbl.gen;

import tk.gbl.bean.Project;
import tk.gbl.bean.Teacher;

import java.lang.reflect.Field;

/**
 * Date: 2014/4/18
 * Time: 17:15
 *
 * @author Tian.Dong
 */
public class Gen {
    public static void main(String[] args) {
        Class cls = Project.class;
        Field[] fields = cls.getDeclaredFields();
        System.out.println(fields);
        for (Field field : fields) {

            System.out.println("<input type=\"text\" name=\""
                    + field.getName()
                    + "\" value=\"${project."
                    + field.getName()
                    +"}\"/>"
            );
        }
    }

    public boolean test() {
        try {
            ttt();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void ttt() throws Exception {
        throw new Exception();
    }
}
