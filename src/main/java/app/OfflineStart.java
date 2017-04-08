package app;

import app.config.SmallConfig;
import app.model.Break;
import app.model.BreakRepo;
import app.model.UserDetail;
import app.model.UserDetailRepo;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class OfflineStart {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx =
                new AnnotationConfigApplicationContext(SmallConfig.class);
        BreakRepo repo = ctx.getBean(BreakRepo.class);
        for(Break b : repo.findAll()) {
            System.out.println(b);
        }

        System.out.println("-------------------------------");
        UserDetailRepo detale = ctx.getBean(UserDetailRepo.class);

        for(UserDetail d : detale.findAll()) {
            System.out.println(d);
        }


        ctx.close();
    }
}
