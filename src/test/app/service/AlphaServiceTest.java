package app.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;


import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = "app/config/SmallConfig.java")
public class AlphaServiceTest {
//    @Autowired
//    AlphaService testee;

    @Test
    public void alphaTest() throws Exception {
        assertThat(1).isEqualTo(1);
    }
}