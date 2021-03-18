package gn.mabc;

import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MabcApplication implements CommandLineRunner{


    public static void main(String[] args) {
        SpringApplication.run(MabcApplication.class, args);
    }

    @Autowired
    EmployeRepos employeRepos;
    @Override
    public void run(String... args) throws Exception {
        for (int i = 0; i < 6; i++) {
            Employe employe = new Employe();
            employe.setName(RandomString.make(10));
            employe.setEmail(RandomString.make(10)+"@gmail.com");
            employe.setTel(RandomString.make(10));
            employe.setAdresse(RandomString.make(10));
            employeRepos.save(employe);

        }
    }
}
