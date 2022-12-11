package fr.univ.rouen.fullStack.GestShop.controller;

import fr.univ.rouen.fullStack.GestShop.service.BoutiqueService;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(ControlleurBoutique.class)
public class ControlleurBoutiqueUnitTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private BoutiqueService boutiqueService ;
    @InjectMocks
    private ControlleurBoutique controlleurBoutique ;
    @Before
    public  void  setup() throws Exception{
        MockitoAnnotations.initMocks(this);
    }

}
