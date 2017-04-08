package app;

import app.config.SmallConfig;
import app.model.Break;
import app.model.BreakRepo;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class OfflineStart {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx =
                new AnnotationConfigApplicationContext(SmallConfig.class);
        BreakRepo repo = ctx.getBean(BreakRepo.class);
        for(Break b : repo.findAll()) {
            System.out.println(b);
        }
        ctx.close();
    }
}
