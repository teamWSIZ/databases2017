package app.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = "app/config/SmallConfig.java")
//@ContextConfiguration({"classpath:/wsiz-config/our-config.xml"})
public class AlphaServiceTest {
//    @Autowired
    AlphaService testee;

    @Before
    public void setUp() throws Exception {
        testee = new AlphaService();
    }

    @Test
    public void alphaTest() throws Exception {
        assertThat(1).isEqualTo(1);
    }

    @Test
    public void pierwszyTest() {
        assertThat(testee.add(2, 5)).isEqualTo(7);
        assertThat(testee.add(-2, 2)).isEqualTo(0);
    }
}