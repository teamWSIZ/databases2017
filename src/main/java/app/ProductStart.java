package app;

import app.config.SmallConfig;
import app.model.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.List;


public class ProductStart {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx =
                new AnnotationConfigApplicationContext(SmallConfig.class);
        ProductRepo repo = ctx.getBean(ProductRepo.class);

        for(Product p : repo.findAll()) {
            System.out.println(p);
        }

        ctx.close();
    }


}
