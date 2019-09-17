package project03.com.atguigu.team.junit;

import org.junit.Test;
import project03.com.atguigu.team.domain.Employee;
import project03.com.atguigu.team.service.NameListService;
import project03.com.atguigu.team.service.TeamException;

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

    @Test
    public void testGetEmployee(){
        NameListService service = new NameListService();
        int id = 1;
        id=101;

        try {
            Employee employee = service.getemployee(id);
            System.out.println(employee);
        } catch (TeamException e) {
            System.out.println(e.getMessage());
        }

    }


}
