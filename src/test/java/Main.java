import by.levkovets.banklist.service.impl.ServiceImpl;
import org.junit.Test;

public class Main {

    @Test
    public static void main(String[] args) {
        ServiceImpl service = new ServiceImpl();
        System.out.println(service.getRichestUser());
        System.out.println(service.getSumAllAccounts());
    }

}
