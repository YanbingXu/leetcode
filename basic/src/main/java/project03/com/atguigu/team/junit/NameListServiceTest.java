package project03.com.atguigu.team.junit;

import org.junit.Test;
import project03.com.atguigu.team.domain.Employee;
import project03.com.atguigu.team.service.NameListService;

/**
 * 对NameListService类的测试
 */
public class NameListServiceTest {
    @Test
    public void testGetAllEmployees(){
        NameListService service = new NameListService();
        Employee[] employees = service.getAllEmployees();
        for (int i = 0; i < employees.length; i++) {
            System.out.println(employees[i]);
        }
    }


}
